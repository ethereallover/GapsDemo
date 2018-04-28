package com.hundsun.gaps.flowcomponents.factory;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 事务操作模型工厂
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年4月9日
 */
public class TransactionModelFactory {
	private static DataSourceTransactionManager manager;

	public static TransactionModel getModel() {
		return new DefaultModel();
	}

	public static void setManager(DataSourceTransactionManager manager) {
		TransactionModelFactory.manager = manager;
	}

	public interface TransactionModel {

		void pushStatus2Stack();

		void rollbackSavePoint();

		void mergeSavePoint();

		void releaseSavePoint();

		void sign(String tableName, String operation, Object obj);

		void popStatus4Stack();

	}

	private static class DefaultModel implements TransactionModel {

		private final static Logger logger = LoggerFactory.getLogger(DefaultModel.class);

		protected int deep = 0;

		protected boolean statusFlag = false;

		protected boolean pointFlag = false;

		protected Object currSavePoint;

		protected TransactionStatus currStatus;

		protected List<Object> currSignObject;

		private LinkedList<Object> localSavePoint = new LinkedList<>();

		private LinkedList<List<Object>> localSignObject = new LinkedList<>();

		@Override
		public void sign(String tableName, String operation, Object obj) {
			currSignObject.add(new SignObjectModel(tableName, operation, obj));
		}

		@Override
		public void mergeSavePoint() {
			if (!pointFlag) {
				currSavePoint = currStatus.createSavepoint();
				currSignObject = new LinkedList<>();
				pointFlag = true;
			}
		}

		@Override
		public void releaseSavePoint() {
			if (pointFlag) {
				currStatus.releaseSavepoint(currSavePoint);
				currSavePoint = null;
				currSignObject = null;
				pointFlag = false;
			}
		}

		@Override
		public void rollbackSavePoint() {
			if (pointFlag) {
				currStatus.rollbackToSavepoint(currSavePoint);
				currStatus.releaseSavepoint(currSavePoint);
				logger.info("发生事务回滚");
				logger.info(currSignObject.toString());
				currSavePoint = null;
				currSignObject = null;
				pointFlag = false;
			}
		}

		@Override
		public void pushStatus2Stack() {
			deep++;
			if (!statusFlag) {
				TransactionDefinition td = new DefaultTransactionDefinition();
				currStatus = manager.getTransaction(td);
				statusFlag = true;
			}

			localSavePoint.addLast(currSavePoint);
			localSignObject.addLast(currSignObject);
			currSignObject = null;
			currSavePoint = null;
			pointFlag = false;
		}

		@Override
		public void popStatus4Stack() {
			deep--;
			if (0 == deep) {
				manager.commit(currStatus);
				localSavePoint.clear();
				localSignObject.clear();
				currSavePoint = null;
				currSignObject = null;
				currStatus = null;
				statusFlag = false;
				pointFlag = false;
				return;
			}

			currSavePoint = localSavePoint.removeLast();
			currSignObject = localSignObject.removeLast();
			if (null == currSavePoint) {
				pointFlag = false;
			} else {
				pointFlag = true;
			}
		}

		private static class SignObjectModel {
			private String tableName;
			private String operation;
			private Object obj;

			public SignObjectModel(String tableName, String operation, Object obj) {
				this.tableName = tableName;
				this.operation = operation;
				this.obj = obj;
			}

			@Override
			public String toString() {
				return new StringBuilder("\n对表[").append(tableName).append("]的操作[").append(operation)
						.append("]发生回滚,数据为").append(obj).toString();
			}
		}
	}

}
