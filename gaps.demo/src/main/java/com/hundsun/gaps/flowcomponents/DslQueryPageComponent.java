package com.hundsun.gaps.flowcomponents;

import static com.hundsun.gaps.flowexecutor.factory.FactoryInfoSyncUtils.NODE_DEFINE;
import static com.hundsun.gaps.flowexecutor.factory.FactoryInfoSyncUtils.getInfo;
import static com.hundsun.gaps.flowexecutor.factory.postmodule.TinyDslSuportModule.getDslInstance;
import static com.hundsun.gaps.flowexecutor.factory.postmodule.TinyDslSuportModule.getMethod;
import static com.hundsun.gaps.flowexecutor.utils.GapsTypeUtils.cast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;

import com.alibaba.fastjson.parser.ParserConfig;
import com.hundsun.gaps.flowmodel.common.IOEntry;
import com.hundsun.gaps.flowmodel.tasks.ServiceTask;
import java.lang.Object;
import java.lang.String;
import java.lang.Exception;

/**
 * 分页查询组件
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年4月2日
 */
@Scope("prototype")
class DslQueryPageComponent {

	private static final String TABLE_NAME = "tableName";

	private static final String OPERATION_NAME = "queryPager";

	private Method method;

	private Object dslInstance;

	private Class<?> parameterType;

	private DslQueryPageComponent() {
		ServiceTask serviceTask = (ServiceTask) getInfo(NODE_DEFINE);
		List<IOEntry> inputs = serviceTask.getInputs();
		String tableName = null;
		for (IOEntry input : inputs) {
			if (TABLE_NAME.equals(input.getName())) {
				tableName = input.getValueContent().toUpperCase();
			}
		}
		dslInstance = getDslInstance(tableName);
		method = getMethod(tableName, OPERATION_NAME);
		method.setAccessible(true);
		Parameter[] parameters = method.getParameters();
		parameterType = parameters[2].getType();
	}

	/**
	 * 分页查询
	 * @param tableName
	 * 表名
	 * @param pageSize
	 * 分页大小
	 * @param pageNum
	 * 第几页
	 * @param parameter
	 * 传入参数
	 * @param orderBys
	 * 排序参数
	 * @return
	 */
	public Object queryPage(String tableName, int pageSize, int pageNum, Object parameter, OrderBy[] orderBys) throws Exception{
		try {
			Object[] args = new Object[4];
			args[0] = pageSize * (pageNum - 1);
			args[1] = pageSize;
			args[2] = cast(parameter, parameterType, ParserConfig.global);
			args[3] = orderBys;
			return method.invoke(dslInstance, args);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			throw e;
		} catch (InvocationTargetException e) {
			Throwable throwable = e.getTargetException();
			if (throwable instanceof Exception) {
				throw (Exception) throwable;
			}
			throw new Exception(throwable.getMessage(), throwable);
		}
	}

}
