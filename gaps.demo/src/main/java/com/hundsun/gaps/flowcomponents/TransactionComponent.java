package com.hundsun.gaps.flowcomponents;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.hundsun.gaps.flowcomponents.factory.TransactionModelFactory;
import com.hundsun.gaps.flowcomponents.factory.TransactionModelFactory.TransactionModel;
import com.hundsun.gaps.flowexecutor.manager.GapsThreadProcessor;

/**
 * 事务管理组件
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年3月30日
 */
@Service
@Scope("singleton")
public class TransactionComponent implements InitializingBean {

	private final static ThreadLocal<TransactionModel> localStatusModel = ThreadLocal
			.withInitial(TransactionModelFactory::getModel);

	public void merge(String tableName, String operation, Object obj) {
		TransactionModel statusModel = localStatusModel.get();
		statusModel.mergeSavePoint();
		statusModel.sign(tableName, operation, obj);
	}

	public void rollback() {
		localStatusModel.get().rollbackSavePoint();
	}

	public void commit() {
		localStatusModel.get().releaseSavePoint();
	}

	@Autowired
	public void setManager(DataSourceTransactionManager manager) {
		TransactionModelFactory.setManager(manager);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		GapsThreadProcessor.INSTANCE.addBeforeProcessor((t, r) -> {
			localStatusModel.get().pushStatus2Stack();
		});

		GapsThreadProcessor.INSTANCE.addAfterProcessor((t, r) -> {
			TransactionModel statusModel = localStatusModel.get();
			statusModel.rollbackSavePoint();
			statusModel.popStatus4Stack();
		});
	}
}
