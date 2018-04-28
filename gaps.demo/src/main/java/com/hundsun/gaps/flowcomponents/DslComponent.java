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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.parser.ParserConfig;
import com.hundsun.gaps.flowmodel.common.IOEntry;
import com.hundsun.gaps.flowmodel.tasks.ServiceTask;
import java.lang.Object;
import java.lang.String;
import java.lang.Exception;

/**
 * TinyDsl操作组件,这个组件只能在流程中使用,在代码中直接创建和使用将无法获得正确的结果,权限设置为默认
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年3月28日
 */
@Scope("prototype")
class DslComponent {

	@Autowired
	private TransactionComponent transActionComponent;

	private static final String TABLE_NAME = "tableName";

	private static final String OPERATION = "operation";

	private Object dslInstance;

	private Method method;

	private Class<?> parameterType;

	private int argsSize;

	private boolean needTransaction = true;

	private DslComponent() {
		ServiceTask serviceTask = (ServiceTask) getInfo(NODE_DEFINE);
		List<IOEntry> inputs = serviceTask.getInputs();
		String tableName = null;
		String operation = null;
		for (IOEntry input : inputs) {
			if (TABLE_NAME.equals(input.getName())) {
				tableName = input.getValueContent().toUpperCase();
			} else if (OPERATION.equals(input.getName())) {
				operation = input.getValueContent();
			}
		}
		dslInstance = getDslInstance(tableName);
		method = getMethod(tableName, operation);
		method.setAccessible(true);
		Parameter[] parameters = method.getParameters();
		argsSize = parameters.length;
		parameterType = parameters[0].getType();
		if ("query".equals(operation)) {
			needTransaction = false;
		}
	}

	public Object doOperation(String tableName, String operation, Object parameter) throws Exception {
		if (needTransaction) {
			transActionComponent.merge(tableName, operation, parameter);
		}
		try {
			Object[] args = new Object[argsSize];
			args[0] = cast(parameter, parameterType, ParserConfig.global);
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
