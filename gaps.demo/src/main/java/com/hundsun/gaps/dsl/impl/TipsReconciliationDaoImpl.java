
package com.hundsun.gaps.dsl.impl;

import java.sql.Date;
import static com.hundsun.gaps.dsl.inter.constant.TipsReconciliationTable.TIPS_RECONCILIATION_TABLE;
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

import com.hundsun.gaps.dsl.inter.TipsReconciliationDao;
import com.hundsun.gaps.dsl.inter.pojo.TipsReconciliation;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以删除方法或者变量的注释@modifiable <!--
 * end-user-doc -->
 */
@Service
public class TipsReconciliationDaoImpl extends TinyDslDaoSupport implements TipsReconciliationDao {

	public static final String TABLE_NAME = "TIPS_RECONCILIATION";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsReconciliation add(TipsReconciliation tipsReconciliation) {
		return getDslTemplate().insertAndReturnKey(tipsReconciliation,
				new InsertGenerateCallback<TipsReconciliation>() {
					public Insert generate(TipsReconciliation t) {
						Insert insert = insertInto(TIPS_RECONCILIATION_TABLE).values(
								TIPS_RECONCILIATION_TABLE.CHECK_SIGN.value(t.getCheckSign()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.value(t.getDealHostDate()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.value(t.getDealHostSerial()),
								TIPS_RECONCILIATION_TABLE.OUT_ACCNO.value(t.getOutAccno()),
								TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt()),
								TIPS_RECONCILIATION_TABLE.HOST_DATE.value(t.getHostDate()),
								TIPS_RECONCILIATION_TABLE.PLT_SERIAL.value(t.getPltSerial()),
								TIPS_RECONCILIATION_TABLE.CHANNEL.value(t.getChannel()),
								TIPS_RECONCILIATION_TABLE.BRANCH.value(t.getBranch()),
								TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.value(t.getReverseTransSign())

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
	public int edit(TipsReconciliation tipsReconciliation) {
		if (tipsReconciliation == null || StringUtils.isBlank(String.valueOf(tipsReconciliation.getDealHostDate()))) {
			return 0;
		}
		return getDslTemplate().update(tipsReconciliation, new UpdateGenerateCallback<TipsReconciliation>() {
			public Update generate(TipsReconciliation t) {
				Update update = update(TIPS_RECONCILIATION_TABLE)
						.set(TIPS_RECONCILIATION_TABLE.CHECK_SIGN.value(t.getCheckSign()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.value(t.getDealHostSerial()),
								TIPS_RECONCILIATION_TABLE.OUT_ACCNO.value(t.getOutAccno()),
								TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt()),
								TIPS_RECONCILIATION_TABLE.HOST_DATE.value(t.getHostDate()),
								TIPS_RECONCILIATION_TABLE.PLT_SERIAL.value(t.getPltSerial()),
								TIPS_RECONCILIATION_TABLE.CHANNEL.value(t.getChannel()),
								TIPS_RECONCILIATION_TABLE.BRANCH.value(t.getBranch()),
								TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.value(t.getReverseTransSign()))
						.where(TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(t.getDealHostDate()));
				return update;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int remove(TipsReconciliation tipsReconciliation) {
		if (tipsReconciliation == null) {
			return 0;
		}
		if (StringUtils.isBlank(tipsReconciliation.getCheckSign())
				&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getDealHostDate()))
				&& StringUtils.isBlank(tipsReconciliation.getDealHostSerial())
				&& StringUtils.isBlank(tipsReconciliation.getOutAccno())
				&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getPltTransAmt()))
				&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getHostDate()))
				&& StringUtils.isBlank(tipsReconciliation.getPltSerial())
				&& StringUtils.isBlank(tipsReconciliation.getChannel())
				&& StringUtils.isBlank(tipsReconciliation.getBranch())
				&& StringUtils.isBlank(tipsReconciliation.getReverseTransSign())) {
			return 0;
		}
		return getDslTemplate().delete(new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_RECONCILIATION_TABLE).where(and(
						TIPS_RECONCILIATION_TABLE.CHECK_SIGN.eq(tipsReconciliation.getCheckSign()),
						TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(tipsReconciliation.getDealHostDate()),
						TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.eq(tipsReconciliation.getDealHostSerial()),
						TIPS_RECONCILIATION_TABLE.OUT_ACCNO.eq(tipsReconciliation.getOutAccno()),
						TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.eq(tipsReconciliation.getPltTransAmt()),
						TIPS_RECONCILIATION_TABLE.HOST_DATE.eq(tipsReconciliation.getHostDate()),
						TIPS_RECONCILIATION_TABLE.PLT_SERIAL.eq(tipsReconciliation.getPltSerial()),
						TIPS_RECONCILIATION_TABLE.CHANNEL.eq(tipsReconciliation.getChannel()),
						TIPS_RECONCILIATION_TABLE.BRANCH.eq(tipsReconciliation.getBranch()),
						TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.eq(tipsReconciliation.getReverseTransSign())));
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
				return delete(TIPS_RECONCILIATION_TABLE).where(TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(pk));
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
				return delete(TIPS_RECONCILIATION_TABLE).where(TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsReconciliation getByKey(Date pk) {
		return getDslTemplate().getByKey(pk, TipsReconciliation.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(TIPS_RECONCILIATION_TABLE).where(TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public List<TipsReconciliation> query(TipsReconciliation tipsReconciliation, final OrderBy... orderArgs) {
		if (tipsReconciliation == null) {
			tipsReconciliation = new TipsReconciliation();
		}
		return getDslTemplate().query(tipsReconciliation, new SelectGenerateCallback<TipsReconciliation>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TipsReconciliation t) {
				Select select = selectFrom(TIPS_RECONCILIATION_TABLE)
						.where(and(TIPS_RECONCILIATION_TABLE.CHECK_SIGN.eq(t.getCheckSign()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(t.getDealHostDate()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.eq(t.getDealHostSerial()),
								TIPS_RECONCILIATION_TABLE.OUT_ACCNO.eq(t.getOutAccno()),
								TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.eq(t.getPltTransAmt()),
								TIPS_RECONCILIATION_TABLE.HOST_DATE.eq(t.getHostDate()),
								TIPS_RECONCILIATION_TABLE.PLT_SERIAL.eq(t.getPltSerial()),
								TIPS_RECONCILIATION_TABLE.CHANNEL.eq(t.getChannel()),
								TIPS_RECONCILIATION_TABLE.BRANCH.eq(t.getBranch()),
								TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.eq(t.getReverseTransSign())

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
	public Pager<TipsReconciliation> queryPager(int start, int limit, TipsReconciliation tipsReconciliation,
			final OrderBy... orderArgs) {
		if (tipsReconciliation == null) {
			tipsReconciliation = new TipsReconciliation();
		}
		return getDslTemplate().queryPager(start, limit, tipsReconciliation, false,
				new SelectGenerateCallback<TipsReconciliation>() {
					public Select generate(TipsReconciliation t) {
						Select select = Select.selectFrom(TIPS_RECONCILIATION_TABLE)
								.where(and(TIPS_RECONCILIATION_TABLE.CHECK_SIGN.eq(t.getCheckSign()),
										TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(t.getDealHostDate()),
										TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.eq(t.getDealHostSerial()),
										TIPS_RECONCILIATION_TABLE.OUT_ACCNO.eq(t.getOutAccno()),
										TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.eq(t.getPltTransAmt()),
										TIPS_RECONCILIATION_TABLE.HOST_DATE.eq(t.getHostDate()),
										TIPS_RECONCILIATION_TABLE.PLT_SERIAL.eq(t.getPltSerial()),
										TIPS_RECONCILIATION_TABLE.CHANNEL.eq(t.getChannel()),
										TIPS_RECONCILIATION_TABLE.BRANCH.eq(t.getBranch()),
										TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.eq(t.getReverseTransSign())

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
	public int[] batchInsert(boolean autoGeneratedKeys, List<TipsReconciliation> tipsReconciliation) {
		if (CollectionUtil.isEmpty(tipsReconciliation)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsReconciliation,
				new InsertGenerateCallback<TipsReconciliation>() {

					public Insert generate(TipsReconciliation t) {
						return insertInto(TIPS_RECONCILIATION_TABLE).values(
								TIPS_RECONCILIATION_TABLE.CHECK_SIGN.value(t.getCheckSign()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.value(t.getDealHostDate()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.value(t.getDealHostSerial()),
								TIPS_RECONCILIATION_TABLE.OUT_ACCNO.value(t.getOutAccno()),
								TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt()),
								TIPS_RECONCILIATION_TABLE.HOST_DATE.value(t.getHostDate()),
								TIPS_RECONCILIATION_TABLE.PLT_SERIAL.value(t.getPltSerial()),
								TIPS_RECONCILIATION_TABLE.CHANNEL.value(t.getChannel()),
								TIPS_RECONCILIATION_TABLE.BRANCH.value(t.getBranch()),
								TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.value(t.getReverseTransSign())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchInsert(List<TipsReconciliation> tipsReconciliations) {
		return batchInsert(false, tipsReconciliations);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchUpdate(List<TipsReconciliation> tipsReconciliations) {
		if (CollectionUtil.isEmpty(tipsReconciliations)) {
			return new int[0];
		}
		for (TipsReconciliation tipsReconciliation : tipsReconciliations) {
			if (StringUtils.isBlank(String.valueOf(tipsReconciliation.getDealHostDate()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsReconciliations, new UpdateGenerateCallback<TipsReconciliation>() {
			public Update generate(TipsReconciliation t) {
				return update(TIPS_RECONCILIATION_TABLE)
						.set(TIPS_RECONCILIATION_TABLE.CHECK_SIGN.value(t.getCheckSign()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.value(t.getDealHostSerial()),
								TIPS_RECONCILIATION_TABLE.OUT_ACCNO.value(t.getOutAccno()),
								TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.value(t.getPltTransAmt()),
								TIPS_RECONCILIATION_TABLE.HOST_DATE.value(t.getHostDate()),
								TIPS_RECONCILIATION_TABLE.PLT_SERIAL.value(t.getPltSerial()),
								TIPS_RECONCILIATION_TABLE.CHANNEL.value(t.getChannel()),
								TIPS_RECONCILIATION_TABLE.BRANCH.value(t.getBranch()),
								TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.value(t.getReverseTransSign())

						).where(TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(t.getDealHostDate()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchDelete(List<TipsReconciliation> tipsReconciliations) {
		if (CollectionUtil.isEmpty(tipsReconciliations)) {
			return new int[0];
		}
		for (TipsReconciliation tipsReconciliation : tipsReconciliations) {
			if (StringUtils.isBlank(tipsReconciliation.getCheckSign())
					&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getDealHostDate()))
					&& StringUtils.isBlank(tipsReconciliation.getDealHostSerial())
					&& StringUtils.isBlank(tipsReconciliation.getOutAccno())
					&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getPltTransAmt()))
					&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getHostDate()))
					&& StringUtils.isBlank(tipsReconciliation.getPltSerial())
					&& StringUtils.isBlank(tipsReconciliation.getChannel())
					&& StringUtils.isBlank(tipsReconciliation.getBranch())
					&& StringUtils.isBlank(tipsReconciliation.getReverseTransSign())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchDelete(tipsReconciliations, new DeleteGenerateCallback<TipsReconciliation>() {
			public Delete generate(TipsReconciliation t) {
				return delete(TIPS_RECONCILIATION_TABLE)
						.where(and(TIPS_RECONCILIATION_TABLE.CHECK_SIGN.eq(t.getCheckSign()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(t.getDealHostDate()),
								TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.eq(t.getDealHostSerial()),
								TIPS_RECONCILIATION_TABLE.OUT_ACCNO.eq(t.getOutAccno()),
								TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.eq(t.getPltTransAmt()),
								TIPS_RECONCILIATION_TABLE.HOST_DATE.eq(t.getHostDate()),
								TIPS_RECONCILIATION_TABLE.PLT_SERIAL.eq(t.getPltSerial()),
								TIPS_RECONCILIATION_TABLE.CHANNEL.eq(t.getChannel()),
								TIPS_RECONCILIATION_TABLE.BRANCH.eq(t.getBranch()),
								TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.eq(t.getReverseTransSign())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TipsReconciliation> tipsReconciliation) {
		if (CollectionUtil.isEmpty(tipsReconciliation)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsReconciliation, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(TIPS_RECONCILIATION_TABLE).values(
						TIPS_RECONCILIATION_TABLE.CHECK_SIGN.value(new JdbcNamedParameter("checkSign")),
						TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.value(new JdbcNamedParameter("dealHostSerial")),
						TIPS_RECONCILIATION_TABLE.OUT_ACCNO.value(new JdbcNamedParameter("outAccno")),
						TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.value(new JdbcNamedParameter("pltTransAmt")),
						TIPS_RECONCILIATION_TABLE.HOST_DATE.value(new JdbcNamedParameter("hostDate")),
						TIPS_RECONCILIATION_TABLE.PLT_SERIAL.value(new JdbcNamedParameter("pltSerial")),
						TIPS_RECONCILIATION_TABLE.CHANNEL.value(new JdbcNamedParameter("channel")),
						TIPS_RECONCILIATION_TABLE.BRANCH.value(new JdbcNamedParameter("branch")),
						TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.value(new JdbcNamedParameter("reverseTransSign"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchUpdate(List<TipsReconciliation> tipsReconciliations) {
		if (CollectionUtil.isEmpty(tipsReconciliations)) {
			return new int[0];
		}

		for (TipsReconciliation tipsReconciliation : tipsReconciliations) {
			if (StringUtils.isBlank(String.valueOf(tipsReconciliation.getDealHostDate()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsReconciliations, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(TIPS_RECONCILIATION_TABLE).set(
						TIPS_RECONCILIATION_TABLE.CHECK_SIGN.value(new JdbcNamedParameter("checkSign")),
						TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.value(new JdbcNamedParameter("dealHostSerial")),
						TIPS_RECONCILIATION_TABLE.OUT_ACCNO.value(new JdbcNamedParameter("outAccno")),
						TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.value(new JdbcNamedParameter("pltTransAmt")),
						TIPS_RECONCILIATION_TABLE.HOST_DATE.value(new JdbcNamedParameter("hostDate")),
						TIPS_RECONCILIATION_TABLE.PLT_SERIAL.value(new JdbcNamedParameter("pltSerial")),
						TIPS_RECONCILIATION_TABLE.CHANNEL.value(new JdbcNamedParameter("channel")),
						TIPS_RECONCILIATION_TABLE.BRANCH.value(new JdbcNamedParameter("branch")),
						TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.value(new JdbcNamedParameter("reverseTransSign"))

				).where(TIPS_RECONCILIATION_TABLE.DEAL_HOST_DATE.eq(new JdbcNamedParameter("dealHostDate")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchDelete(List<TipsReconciliation> tipsReconciliations) {
		if (CollectionUtil.isEmpty(tipsReconciliations)) {
			return new int[0];
		}

		for (TipsReconciliation tipsReconciliation : tipsReconciliations) {
			if (StringUtils.isBlank(tipsReconciliation.getCheckSign())
					&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getDealHostDate()))
					&& StringUtils.isBlank(tipsReconciliation.getDealHostSerial())
					&& StringUtils.isBlank(tipsReconciliation.getOutAccno())
					&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getPltTransAmt()))
					&& StringUtils.isBlank(String.valueOf(tipsReconciliation.getHostDate()))
					&& StringUtils.isBlank(tipsReconciliation.getPltSerial())
					&& StringUtils.isBlank(tipsReconciliation.getChannel())
					&& StringUtils.isBlank(tipsReconciliation.getBranch())
					&& StringUtils.isBlank(tipsReconciliation.getReverseTransSign())) {
				return new int[0];
			}
		}

		return getDslTemplate().batchDelete(tipsReconciliations, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_RECONCILIATION_TABLE).where(and(
						TIPS_RECONCILIATION_TABLE.CHECK_SIGN.eq(new JdbcNamedParameter("checkSign")),
						TIPS_RECONCILIATION_TABLE.DEAL_HOST_SERIAL.eq(new JdbcNamedParameter("dealHostSerial")),
						TIPS_RECONCILIATION_TABLE.OUT_ACCNO.eq(new JdbcNamedParameter("outAccno")),
						TIPS_RECONCILIATION_TABLE.PLT_TRANS_AMT.eq(new JdbcNamedParameter("pltTransAmt")),
						TIPS_RECONCILIATION_TABLE.HOST_DATE.eq(new JdbcNamedParameter("hostDate")),
						TIPS_RECONCILIATION_TABLE.PLT_SERIAL.eq(new JdbcNamedParameter("pltSerial")),
						TIPS_RECONCILIATION_TABLE.CHANNEL.eq(new JdbcNamedParameter("channel")),
						TIPS_RECONCILIATION_TABLE.BRANCH.eq(new JdbcNamedParameter("branch")),
						TIPS_RECONCILIATION_TABLE.REVERSE_TRANS_SIGN.eq(new JdbcNamedParameter("reverseTransSign"))

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(List<TipsReconciliation> tipsReconciliation) {
		return preparedBatchInsert(false, tipsReconciliation);
	}

}
