package com.hundsun.gaps.flowexecutor.factory.postmodule;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;

import com.hundsun.gaps.flowexecutor.enums.StaticTypeEnum;
import com.hundsun.gaps.flowexecutor.exceptions.GapsFlowInitializationException;
import com.hundsun.gaps.flowexecutor.factory.scanner.GapsTableDefineScanner;
import com.hundsun.gaps.flowexecutor.function.interfaces.IBeanPostProcessorModule;

/**
 * 用于支持tiny的dsl代码的后处理器,当运行环境中存在dsl依赖时自动生效,否则无效
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年3月27日
 */
public class TinyDslSuportModule implements IBeanPostProcessorModule {

	private static final Logger logger = LoggerFactory.getLogger(TinyDslSuportModule.class);

	private static final String DSL_BASE_CLASS_NAME = "org.tinygroup.jdbctemplatedslsession.daosupport.TinyDslDaoSupport";

	private static final String DSL_BASE_INTERFACE_NAME = "org.tinygroup.jdbctemplatedslsession.daosupport.BaseDao";

	private static final String DSL_ORDERBY_ARRAY_NAME = "org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy[]";

	private static final String TABLE_NAME_KEY = "TABLE_NAME";

	private static final String[] METHOD_NAMES = { "add", "remove", "edit", "query", "queryPager" };

	private static final Map<String, Object> TABLE_MAP = new ConcurrentHashMap<String, Object>();

	private static final Map<String, Method[]> TABLE_METHOD_MAP = new ConcurrentHashMap<String, Method[]>();

	private static Map<String, Function<Class<?>, Class<?>[]>> METHOD_TYPE_FUNCTIONS;

	private static Class<?> DSL_BASE_CLASS;

	private static Class<?> DSL_BASE_INTERFACE;

	private static Class<?> DSL_ORDERBY_ARRAY;

	private static boolean hasTiny;

	static {
		try {
			DSL_BASE_CLASS = StaticTypeEnum.getClassByName(DSL_BASE_CLASS_NAME);
			DSL_BASE_INTERFACE = StaticTypeEnum.getClassByName(DSL_BASE_INTERFACE_NAME);
			DSL_ORDERBY_ARRAY = StaticTypeEnum.getClassByName(DSL_ORDERBY_ARRAY_NAME);
			if (null == DSL_BASE_CLASS || null == DSL_BASE_INTERFACE || null == DSL_ORDERBY_ARRAY) {
				hasTiny = false;
				logger.debug("当前环境不存在TinyDsl相关依赖,Dsl相关组件将无法生效");
			} else {
				hasTiny = true;
				METHOD_TYPE_FUNCTIONS = new HashMap<>();
				METHOD_TYPE_FUNCTIONS.put("add", (type) -> new Class<?>[] { type });
				METHOD_TYPE_FUNCTIONS.put("remove", (type) -> new Class<?>[] { type });
				METHOD_TYPE_FUNCTIONS.put("edit", (type) -> new Class<?>[] { type });
				METHOD_TYPE_FUNCTIONS.put("query", (type) -> new Class<?>[] { type, DSL_ORDERBY_ARRAY });
				METHOD_TYPE_FUNCTIONS.put("queryPager",
						(type) -> new Class<?>[] { int.class, int.class, type, DSL_ORDERBY_ARRAY });
			}
		} catch (Exception e) {
			hasTiny = false;
			logger.debug("当前环境不存在TinyDsl相关依赖,Dsl相关组件将无法生效");
		}
	}

	@Override
	public boolean canProcess(Class<?> beanClass, String beanName) {
		if (hasTiny) {
			if (DSL_BASE_CLASS.isAssignableFrom(beanClass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		try {
			String tableName = (String) bean.getClass().getField(TABLE_NAME_KEY).get(bean);
			TABLE_MAP.put(tableName, bean);
		} catch (Exception e) {
			logger.warn("Dsl类[{}]没有关联到表,这个Dsl将无法被流程引擎使用", bean.getClass().toString());
		}
		return bean;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		return pvs;
	}

	public static Object getDslInstance(String tableName) {
		if (!TABLE_MAP.containsKey(tableName)) {
			throw new GapsFlowInitializationException(String.format("当前运行环境中数据库表[%s]的Dsl没有被建立", tableName));
		}
		if (GapsTableDefineScanner.checkTableName(tableName)) {
			return TABLE_MAP.get(tableName.toUpperCase());
		} else {
			throw new GapsFlowInitializationException(String.format("无法获取表[%s]对应的表定义", tableName));
		}
	}

	public static Method getMethod(String tableName, String operation) {
		if (!TABLE_MAP.containsKey(tableName)) {
			throw new GapsFlowInitializationException(String.format("当前运行环境中数据库表[%s]的Dsl没有被建立", tableName));
		}

		Method[] methods;
		if (!TABLE_METHOD_MAP.containsKey(tableName)) {
			methods = new Method[METHOD_NAMES.length];
			TABLE_METHOD_MAP.put(tableName, methods);
		} else {
			methods = TABLE_METHOD_MAP.get(tableName);
		}

		for (int i = 0; i < METHOD_NAMES.length; i++) {
			if (METHOD_NAMES[i].equals(operation)) {
				if (null != methods[i]) {
					return methods[i];
				} else {
					Object instance = TABLE_MAP.get(tableName);
					Class<?> clazz = instance.getClass();
					Class<?> dslInterface = null;
					for (Class<?> inter : clazz.getInterfaces()) {
						if (DSL_BASE_INTERFACE.isAssignableFrom(inter)) {
							dslInterface = inter;
							continue;
						}
					}

					ParameterizedType superType = (ParameterizedType) dslInterface.getGenericInterfaces()[0];
					Type pojoType = superType.getActualTypeArguments()[0];
					Class<?>[] parameterTypes = METHOD_TYPE_FUNCTIONS.get(operation).apply((Class<?>) pojoType);
					try {
						return clazz.getMethod(operation, parameterTypes);
					} catch (NoSuchMethodException | SecurityException e) {
						throw new GapsFlowInitializationException(
								String.format("无法获取表[%s]对应Dsl的[%s]方法", tableName, operation), e);
					}
				}
			}
		}
		throw new GapsFlowInitializationException(String.format("无法获取表[%s]对应Dsl的[%s]方法", tableName, operation));
	}
}
