
package com.hundsun.gaps.dsl.impl;

import static com.hundsun.gaps.dsl.inter.constant.TipsTransTable.TIPS_TRANS_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.tinygroup.commons.tools.CollectionUtil;
import org.tinygroup.jdbctemplatedslsession.callback.DeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.InsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamDeleteGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamInsertGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.NoParamUpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.SelectGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.callback.UpdateGenerateCallback;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.jdbctemplatedslsession.daosupport.TinyDslDaoSupport;
import org.tinygroup.jdbctemplatedslsession.util.TinyDSLUtil;
import org.tinygroup.tinysqldsl.Delete;
import org.tinygroup.tinysqldsl.Insert;
import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.tinysqldsl.Select;
import org.tinygroup.tinysqldsl.Update;
import org.tinygroup.tinysqldsl.expression.JdbcNamedParameter;

import com.hundsun.gaps.dsl.inter.TipsTransDao;
import com.hundsun.gaps.dsl.inter.pojo.TipsTrans;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以删除方法或者变量的注释@modifiable <!--
 * end-user-doc -->
 */
@Service
public class TipsTransDaoImpl extends TinyDslDaoSupport implements TipsTransDao {

	public static final String TABLE_NAME = "TIPS_TRANS";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTrans add(TipsTrans tipsTrans) {
		return getDslTemplate().insertAndReturnKey(tipsTrans, new InsertGenerateCallback<TipsTrans>() {
			public Insert generate(TipsTrans t) {
				Insert insert = insertInto(TIPS_TRANS_TABLE).values(TIPS_TRANS_TABLE.ID_NUM.value(t.getIdNum()),
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.value(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.value(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.value(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.value(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.value(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.value(t.getHashValue())

				);
				return insert;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int edit(TipsTrans tipsTrans) {
		if (tipsTrans == null || StringUtils.isBlank(tipsTrans.getIdNum())) {
			return 0;
		}
		return getDslTemplate().update(tipsTrans, new UpdateGenerateCallback<TipsTrans>() {
			public Update generate(TipsTrans t) {
				Update update = update(TIPS_TRANS_TABLE).set(TIPS_TRANS_TABLE.ACC_OPEN_DATE.value(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.value(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.value(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.value(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.value(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.value(t.getHashValue()))
						.where(TIPS_TRANS_TABLE.ID_NUM.eq(t.getIdNum()));
				return update;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int remove(TipsTrans tipsTrans) {
		if (tipsTrans == null) {
			return 0;
		}
		if (StringUtils.isBlank(tipsTrans.getIdNum()) && StringUtils.isBlank(String.valueOf(tipsTrans.getAccOpenDate()))
				&& StringUtils.isBlank(tipsTrans.getDueDate()) && StringUtils.isBlank(tipsTrans.getGrander())
				&& StringUtils.isBlank(String.valueOf(tipsTrans.getHostRecvNum()))
				&& StringUtils.isBlank(tipsTrans.getBillDeliveryWay())
				&& StringUtils.isBlank(String.valueOf(tipsTrans.getHashValue()))) {
			return 0;
		}
		return getDslTemplate().delete(new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_TRANS_TABLE).where(and(TIPS_TRANS_TABLE.ID_NUM.eq(tipsTrans.getIdNum()),
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.eq(tipsTrans.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.eq(tipsTrans.getDueDate()),
						TIPS_TRANS_TABLE.GRANDER.eq(tipsTrans.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.eq(tipsTrans.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.eq(tipsTrans.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.eq(tipsTrans.getHashValue())));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int deleteByKey(String pk) {

		if (StringUtils.isBlank(pk)) {
			return 0;
		}
		return getDslTemplate().deleteByKey(pk, new DeleteGenerateCallback<Serializable>() {
			public Delete generate(Serializable pk) {
				return delete(TIPS_TRANS_TABLE).where(TIPS_TRANS_TABLE.ID_NUM.eq(pk));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int deleteByKeys(String... pks) {
		if (pks == null || pks.length == 0) {
			return 0;
		}
		for (String pk : pks) {
			if (StringUtils.isBlank(pk)) {
				return 0;
			}
		}
		return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
			public Delete generate(Serializable[] t) {
				return delete(TIPS_TRANS_TABLE).where(TIPS_TRANS_TABLE.ID_NUM.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTrans getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TipsTrans.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(TIPS_TRANS_TABLE).where(TIPS_TRANS_TABLE.ID_NUM.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public List<TipsTrans> query(TipsTrans tipsTrans, final OrderBy... orderArgs) {
		if (tipsTrans == null) {
			tipsTrans = new TipsTrans();
		}
		return getDslTemplate().query(tipsTrans, new SelectGenerateCallback<TipsTrans>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TipsTrans t) {
				Select select = selectFrom(TIPS_TRANS_TABLE).where(and(TIPS_TRANS_TABLE.ID_NUM.eq(t.getIdNum()),
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.eq(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.eq(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.eq(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.eq(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.eq(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.eq(t.getHashValue())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Pager<TipsTrans> queryPager(int start, int limit, TipsTrans tipsTrans, final OrderBy... orderArgs) {
		if (tipsTrans == null) {
			tipsTrans = new TipsTrans();
		}
		return getDslTemplate().queryPager(start, limit, tipsTrans, false, new SelectGenerateCallback<TipsTrans>() {
			public Select generate(TipsTrans t) {
				Select select = Select.selectFrom(TIPS_TRANS_TABLE).where(and(TIPS_TRANS_TABLE.ID_NUM.eq(t.getIdNum()),
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.eq(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.eq(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.eq(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.eq(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.eq(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.eq(t.getHashValue())

				));
				return TinyDSLUtil.addOrderByElements(select, orderArgs);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchInsert(boolean autoGeneratedKeys, List<TipsTrans> tipsTrans) {
		if (CollectionUtil.isEmpty(tipsTrans)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsTrans, new InsertGenerateCallback<TipsTrans>() {

			public Insert generate(TipsTrans t) {
				return insertInto(TIPS_TRANS_TABLE).values(TIPS_TRANS_TABLE.ID_NUM.value(t.getIdNum()),
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.value(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.value(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.value(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.value(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.value(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.value(t.getHashValue())

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchInsert(List<TipsTrans> tipsTranss) {
		return batchInsert(false, tipsTranss);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchUpdate(List<TipsTrans> tipsTranss) {
		if (CollectionUtil.isEmpty(tipsTranss)) {
			return new int[0];
		}
		for (TipsTrans tipsTrans : tipsTranss) {
			if (StringUtils.isBlank(tipsTrans.getIdNum())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsTranss, new UpdateGenerateCallback<TipsTrans>() {
			public Update generate(TipsTrans t) {
				return update(TIPS_TRANS_TABLE).set(TIPS_TRANS_TABLE.ACC_OPEN_DATE.value(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.value(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.value(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.value(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.value(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.value(t.getHashValue())

				).where(TIPS_TRANS_TABLE.ID_NUM.eq(t.getIdNum()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchDelete(List<TipsTrans> tipsTranss) {
		if (CollectionUtil.isEmpty(tipsTranss)) {
			return new int[0];
		}
		for (TipsTrans tipsTrans : tipsTranss) {
			if (StringUtils.isBlank(tipsTrans.getIdNum())
					&& StringUtils.isBlank(String.valueOf(tipsTrans.getAccOpenDate()))
					&& StringUtils.isBlank(tipsTrans.getDueDate()) && StringUtils.isBlank(tipsTrans.getGrander())
					&& StringUtils.isBlank(String.valueOf(tipsTrans.getHostRecvNum()))
					&& StringUtils.isBlank(tipsTrans.getBillDeliveryWay())
					&& StringUtils.isBlank(String.valueOf(tipsTrans.getHashValue()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchDelete(tipsTranss, new DeleteGenerateCallback<TipsTrans>() {
			public Delete generate(TipsTrans t) {
				return delete(TIPS_TRANS_TABLE).where(and(TIPS_TRANS_TABLE.ID_NUM.eq(t.getIdNum()),
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.eq(t.getAccOpenDate()),
						TIPS_TRANS_TABLE.DUE_DATE.eq(t.getDueDate()), TIPS_TRANS_TABLE.GRANDER.eq(t.getGrander()),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.eq(t.getHostRecvNum()),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.eq(t.getBillDeliveryWay()),
						TIPS_TRANS_TABLE.HASH_VALUE.eq(t.getHashValue())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TipsTrans> tipsTrans) {
		if (CollectionUtil.isEmpty(tipsTrans)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsTrans, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(TIPS_TRANS_TABLE).values(
						TIPS_TRANS_TABLE.ACC_OPEN_DATE.value(new JdbcNamedParameter("accOpenDate")),
						TIPS_TRANS_TABLE.DUE_DATE.value(new JdbcNamedParameter("dueDate")),
						TIPS_TRANS_TABLE.GRANDER.value(new JdbcNamedParameter("grander")),
						TIPS_TRANS_TABLE.HOST_RECV_NUM.value(new JdbcNamedParameter("hostRecvNum")),
						TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.value(new JdbcNamedParameter("billDeliveryWay")),
						TIPS_TRANS_TABLE.HASH_VALUE.value(new JdbcNamedParameter("hashValue"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchUpdate(List<TipsTrans> tipsTranss) {
		if (CollectionUtil.isEmpty(tipsTranss)) {
			return new int[0];
		}

		for (TipsTrans tipsTrans : tipsTranss) {
			if (StringUtils.isBlank(tipsTrans.getIdNum())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsTranss, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(TIPS_TRANS_TABLE)
						.set(TIPS_TRANS_TABLE.ACC_OPEN_DATE.value(new JdbcNamedParameter("accOpenDate")),
								TIPS_TRANS_TABLE.DUE_DATE.value(new JdbcNamedParameter("dueDate")),
								TIPS_TRANS_TABLE.GRANDER.value(new JdbcNamedParameter("grander")),
								TIPS_TRANS_TABLE.HOST_RECV_NUM.value(new JdbcNamedParameter("hostRecvNum")),
								TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.value(new JdbcNamedParameter("billDeliveryWay")),
								TIPS_TRANS_TABLE.HASH_VALUE.value(new JdbcNamedParameter("hashValue"))

						).where(TIPS_TRANS_TABLE.ID_NUM.eq(new JdbcNamedParameter("idNum")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchDelete(List<TipsTrans> tipsTranss) {
		if (CollectionUtil.isEmpty(tipsTranss)) {
			return new int[0];
		}

		for (TipsTrans tipsTrans : tipsTranss) {
			if (StringUtils.isBlank(tipsTrans.getIdNum())
					&& StringUtils.isBlank(String.valueOf(tipsTrans.getAccOpenDate()))
					&& StringUtils.isBlank(tipsTrans.getDueDate()) && StringUtils.isBlank(tipsTrans.getGrander())
					&& StringUtils.isBlank(String.valueOf(tipsTrans.getHostRecvNum()))
					&& StringUtils.isBlank(tipsTrans.getBillDeliveryWay())
					&& StringUtils.isBlank(String.valueOf(tipsTrans.getHashValue()))) {
				return new int[0];
			}
		}

		return getDslTemplate().batchDelete(tipsTranss, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_TRANS_TABLE)
						.where(and(TIPS_TRANS_TABLE.ACC_OPEN_DATE.eq(new JdbcNamedParameter("accOpenDate")),
								TIPS_TRANS_TABLE.DUE_DATE.eq(new JdbcNamedParameter("dueDate")),
								TIPS_TRANS_TABLE.GRANDER.eq(new JdbcNamedParameter("grander")),
								TIPS_TRANS_TABLE.HOST_RECV_NUM.eq(new JdbcNamedParameter("hostRecvNum")),
								TIPS_TRANS_TABLE.BILL_DELIVERY_WAY.eq(new JdbcNamedParameter("billDeliveryWay")),
								TIPS_TRANS_TABLE.HASH_VALUE.eq(new JdbcNamedParameter("hashValue"))

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(List<TipsTrans> tipsTrans) {
		return preparedBatchInsert(false, tipsTrans);
	}

}
