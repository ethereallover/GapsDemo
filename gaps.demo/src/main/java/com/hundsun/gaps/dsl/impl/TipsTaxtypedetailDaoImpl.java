
package com.hundsun.gaps.dsl.impl;

import java.sql.Date;
import static com.hundsun.gaps.dsl.inter.constant.TipsTaxtypedetailTable.TIPS_TAXTYPEDETAIL_TABLE;
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

import com.hundsun.gaps.dsl.inter.TipsTaxtypedetailDao;
import com.hundsun.gaps.dsl.inter.pojo.TipsTaxtypedetail;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以删除方法或者变量的注释@modifiable <!--
 * end-user-doc -->
 */
@Service
public class TipsTaxtypedetailDaoImpl extends TinyDslDaoSupport implements TipsTaxtypedetailDao {

	public static final String TABLE_NAME = "TIPS_TAXTYPEDETAIL";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTaxtypedetail add(TipsTaxtypedetail tipsTaxtypedetail) {
		return getDslTemplate().insertAndReturnKey(tipsTaxtypedetail, new InsertGenerateCallback<TipsTaxtypedetail>() {
			public Insert generate(TipsTaxtypedetail t) {
				Insert insert = insertInto(TIPS_TAXTYPEDETAIL_TABLE).values(
						TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.value(t.getBusinessDate()),
						TIPS_TAXTYPEDETAIL_TABLE.SERIAL.value(t.getSerial()),
						TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.value(t.getOrderInfo()),
						TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.value(t.getDetailNum()),
						TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.value(t.getBillName()),
						TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt())

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
	public int edit(TipsTaxtypedetail tipsTaxtypedetail) {
		if (tipsTaxtypedetail == null || StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getBusinessDate()))) {
			return 0;
		}
		return getDslTemplate().update(tipsTaxtypedetail, new UpdateGenerateCallback<TipsTaxtypedetail>() {
			public Update generate(TipsTaxtypedetail t) {
				Update update = update(TIPS_TAXTYPEDETAIL_TABLE)
						.set(TIPS_TAXTYPEDETAIL_TABLE.SERIAL.value(t.getSerial()),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.value(t.getOrderInfo()),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.value(t.getDetailNum()),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.value(t.getBillName()),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt()))
						.where(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()));
				return update;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int remove(TipsTaxtypedetail tipsTaxtypedetail) {
		if (tipsTaxtypedetail == null) {
			return 0;
		}
		if (StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getBusinessDate()))
				&& StringUtils.isBlank(tipsTaxtypedetail.getSerial())
				&& StringUtils.isBlank(tipsTaxtypedetail.getOrderInfo())
				&& StringUtils.isBlank(tipsTaxtypedetail.getDetailNum())
				&& StringUtils.isBlank(tipsTaxtypedetail.getBillName())
				&& StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getPltTransAmt()))) {
			return 0;
		}
		return getDslTemplate().delete(new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_TAXTYPEDETAIL_TABLE)
						.where(and(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(tipsTaxtypedetail.getBusinessDate()),
								TIPS_TAXTYPEDETAIL_TABLE.SERIAL.eq(tipsTaxtypedetail.getSerial()),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.eq(tipsTaxtypedetail.getOrderInfo()),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.eq(tipsTaxtypedetail.getDetailNum()),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.eq(tipsTaxtypedetail.getBillName()),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.eq(tipsTaxtypedetail.getPltTransAmt())));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int deleteByKey(Date pk) {

		if (StringUtils.isBlank(String.valueOf(pk))) {
			return 0;
		}
		return getDslTemplate().deleteByKey(pk, new DeleteGenerateCallback<Serializable>() {
			public Delete generate(Serializable pk) {
				return delete(TIPS_TAXTYPEDETAIL_TABLE).where(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(pk));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int deleteByKeys(Date... pks) {
		if (pks == null || pks.length == 0) {
			return 0;
		}
		for (Date pk : pks) {
			if (StringUtils.isBlank(String.valueOf(pk))) {
				return 0;
			}
		}
		return getDslTemplate().deleteByKeys(new DeleteGenerateCallback<Serializable[]>() {
			public Delete generate(Serializable[] t) {
				return delete(TIPS_TAXTYPEDETAIL_TABLE).where(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTaxtypedetail getByKey(Date pk) {
		return getDslTemplate().getByKey(pk, TipsTaxtypedetail.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(TIPS_TAXTYPEDETAIL_TABLE).where(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public List<TipsTaxtypedetail> query(TipsTaxtypedetail tipsTaxtypedetail, final OrderBy... orderArgs) {
		if (tipsTaxtypedetail == null) {
			tipsTaxtypedetail = new TipsTaxtypedetail();
		}
		return getDslTemplate().query(tipsTaxtypedetail, new SelectGenerateCallback<TipsTaxtypedetail>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TipsTaxtypedetail t) {
				Select select = selectFrom(TIPS_TAXTYPEDETAIL_TABLE)
						.where(and(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()),
								TIPS_TAXTYPEDETAIL_TABLE.SERIAL.eq(t.getSerial()),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.eq(t.getOrderInfo()),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.eq(t.getDetailNum()),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.eq(t.getBillName()),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.eq(t.getPltTransAmt())

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
	public Pager<TipsTaxtypedetail> queryPager(int start, int limit, TipsTaxtypedetail tipsTaxtypedetail,
			final OrderBy... orderArgs) {
		if (tipsTaxtypedetail == null) {
			tipsTaxtypedetail = new TipsTaxtypedetail();
		}
		return getDslTemplate().queryPager(start, limit, tipsTaxtypedetail, false,
				new SelectGenerateCallback<TipsTaxtypedetail>() {
					public Select generate(TipsTaxtypedetail t) {
						Select select = Select.selectFrom(TIPS_TAXTYPEDETAIL_TABLE)
								.where(and(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()),
										TIPS_TAXTYPEDETAIL_TABLE.SERIAL.eq(t.getSerial()),
										TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.eq(t.getOrderInfo()),
										TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.eq(t.getDetailNum()),
										TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.eq(t.getBillName()),
										TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.eq(t.getPltTransAmt())

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
	public int[] batchInsert(boolean autoGeneratedKeys, List<TipsTaxtypedetail> tipsTaxtypedetail) {
		if (CollectionUtil.isEmpty(tipsTaxtypedetail)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsTaxtypedetail,
				new InsertGenerateCallback<TipsTaxtypedetail>() {

					public Insert generate(TipsTaxtypedetail t) {
						return insertInto(TIPS_TAXTYPEDETAIL_TABLE).values(
								TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.value(t.getBusinessDate()),
								TIPS_TAXTYPEDETAIL_TABLE.SERIAL.value(t.getSerial()),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.value(t.getOrderInfo()),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.value(t.getDetailNum()),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.value(t.getBillName()),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchInsert(List<TipsTaxtypedetail> tipsTaxtypedetails) {
		return batchInsert(false, tipsTaxtypedetails);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchUpdate(List<TipsTaxtypedetail> tipsTaxtypedetails) {
		if (CollectionUtil.isEmpty(tipsTaxtypedetails)) {
			return new int[0];
		}
		for (TipsTaxtypedetail tipsTaxtypedetail : tipsTaxtypedetails) {
			if (StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getBusinessDate()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsTaxtypedetails, new UpdateGenerateCallback<TipsTaxtypedetail>() {
			public Update generate(TipsTaxtypedetail t) {
				return update(TIPS_TAXTYPEDETAIL_TABLE).set(TIPS_TAXTYPEDETAIL_TABLE.SERIAL.value(t.getSerial()),
						TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.value(t.getOrderInfo()),
						TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.value(t.getDetailNum()),
						TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.value(t.getBillName()),
						TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt())

				).where(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchDelete(List<TipsTaxtypedetail> tipsTaxtypedetails) {
		if (CollectionUtil.isEmpty(tipsTaxtypedetails)) {
			return new int[0];
		}
		for (TipsTaxtypedetail tipsTaxtypedetail : tipsTaxtypedetails) {
			if (StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getBusinessDate()))
					&& StringUtils.isBlank(tipsTaxtypedetail.getSerial())
					&& StringUtils.isBlank(tipsTaxtypedetail.getOrderInfo())
					&& StringUtils.isBlank(tipsTaxtypedetail.getDetailNum())
					&& StringUtils.isBlank(tipsTaxtypedetail.getBillName())
					&& StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getPltTransAmt()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchDelete(tipsTaxtypedetails, new DeleteGenerateCallback<TipsTaxtypedetail>() {
			public Delete generate(TipsTaxtypedetail t) {
				return delete(TIPS_TAXTYPEDETAIL_TABLE)
						.where(and(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()),
								TIPS_TAXTYPEDETAIL_TABLE.SERIAL.eq(t.getSerial()),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.eq(t.getOrderInfo()),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.eq(t.getDetailNum()),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.eq(t.getBillName()),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.eq(t.getPltTransAmt())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TipsTaxtypedetail> tipsTaxtypedetail) {
		if (CollectionUtil.isEmpty(tipsTaxtypedetail)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsTaxtypedetail, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(TIPS_TAXTYPEDETAIL_TABLE).values(
						TIPS_TAXTYPEDETAIL_TABLE.SERIAL.value(new JdbcNamedParameter("serial")),
						TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.value(new JdbcNamedParameter("orderInfo")),
						TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.value(new JdbcNamedParameter("detailNum")),
						TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.value(new JdbcNamedParameter("billName")),
						TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.value(new JdbcNamedParameter("pltTransAmt"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchUpdate(List<TipsTaxtypedetail> tipsTaxtypedetails) {
		if (CollectionUtil.isEmpty(tipsTaxtypedetails)) {
			return new int[0];
		}

		for (TipsTaxtypedetail tipsTaxtypedetail : tipsTaxtypedetails) {
			if (StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getBusinessDate()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsTaxtypedetails, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(TIPS_TAXTYPEDETAIL_TABLE)
						.set(TIPS_TAXTYPEDETAIL_TABLE.SERIAL.value(new JdbcNamedParameter("serial")),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.value(new JdbcNamedParameter("orderInfo")),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.value(new JdbcNamedParameter("detailNum")),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.value(new JdbcNamedParameter("billName")),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.value(new JdbcNamedParameter("pltTransAmt"))

						).where(TIPS_TAXTYPEDETAIL_TABLE.BUSINESS_DATE.eq(new JdbcNamedParameter("businessDate")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchDelete(List<TipsTaxtypedetail> tipsTaxtypedetails) {
		if (CollectionUtil.isEmpty(tipsTaxtypedetails)) {
			return new int[0];
		}

		for (TipsTaxtypedetail tipsTaxtypedetail : tipsTaxtypedetails) {
			if (StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getBusinessDate()))
					&& StringUtils.isBlank(tipsTaxtypedetail.getSerial())
					&& StringUtils.isBlank(tipsTaxtypedetail.getOrderInfo())
					&& StringUtils.isBlank(tipsTaxtypedetail.getDetailNum())
					&& StringUtils.isBlank(tipsTaxtypedetail.getBillName())
					&& StringUtils.isBlank(String.valueOf(tipsTaxtypedetail.getPltTransAmt()))) {
				return new int[0];
			}
		}

		return getDslTemplate().batchDelete(tipsTaxtypedetails, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_TAXTYPEDETAIL_TABLE)
						.where(and(TIPS_TAXTYPEDETAIL_TABLE.SERIAL.eq(new JdbcNamedParameter("serial")),
								TIPS_TAXTYPEDETAIL_TABLE.ORDER_INFO.eq(new JdbcNamedParameter("orderInfo")),
								TIPS_TAXTYPEDETAIL_TABLE.DETAIL_NUM.eq(new JdbcNamedParameter("detailNum")),
								TIPS_TAXTYPEDETAIL_TABLE.BILL_NAME.eq(new JdbcNamedParameter("billName")),
								TIPS_TAXTYPEDETAIL_TABLE.PLT_TRANS_AMT.eq(new JdbcNamedParameter("pltTransAmt"))

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(List<TipsTaxtypedetail> tipsTaxtypedetail) {
		return preparedBatchInsert(false, tipsTaxtypedetail);
	}

}
