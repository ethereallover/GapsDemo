
package com.hundsun.gaps.dsl.impl;

import static com.hundsun.gaps.dsl.inter.constant.TipsBankdeclareTable.TIPS_BANKDECLARE_TABLE;
import static org.tinygroup.tinysqldsl.Delete.delete;
import static org.tinygroup.tinysqldsl.Insert.insertInto;
import static org.tinygroup.tinysqldsl.Select.selectFrom;
import static org.tinygroup.tinysqldsl.Update.update;
import static org.tinygroup.tinysqldsl.base.StatementSqlBuilder.and;

import java.io.Serializable;
import java.sql.Date;
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

import com.hundsun.gaps.dsl.inter.TipsBankdeclareDao;
import com.hundsun.gaps.dsl.inter.pojo.TipsBankdeclare;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以删除方法或者变量的注释@modifiable <!--
 * end-user-doc -->
 */
@Service
public class TipsBankdeclareDaoImpl extends TinyDslDaoSupport implements TipsBankdeclareDao {

	public static final String TABLE_NAME = "TIPS_BANKDECLARE";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsBankdeclare add(TipsBankdeclare tipsBankdeclare) {
		return getDslTemplate().insertAndReturnKey(tipsBankdeclare, new InsertGenerateCallback<TipsBankdeclare>() {
			public Insert generate(TipsBankdeclare t) {
				Insert insert = insertInto(TIPS_BANKDECLARE_TABLE).values(
						TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.value(t.getBusinessDate()),
						TIPS_BANKDECLARE_TABLE.SERIAL.value(t.getSerial()),
						TIPS_BANKDECLARE_TABLE.CHANNEL.value(t.getChannel()),
						TIPS_BANKDECLARE_TABLE.AREA.value(t.getArea()),
						TIPS_BANKDECLARE_TABLE.BRANCH.value(t.getBranch()),
						TIPS_BANKDECLARE_TABLE.TELLER.value(t.getTeller()),
						TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.value(t.getTerminalCode()),
						TIPS_BANKDECLARE_TABLE.QUERY_ORDER.value(t.getQueryOrder()),
						TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.value(t.getPayOpbankno()),
						TIPS_BANKDECLARE_TABLE.ADDWORD.value(t.getAddword())

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
	public int edit(TipsBankdeclare tipsBankdeclare) {
		if (tipsBankdeclare == null || StringUtils.isBlank(String.valueOf(tipsBankdeclare.getBusinessDate()))) {
			return 0;
		}
		return getDslTemplate().update(tipsBankdeclare, new UpdateGenerateCallback<TipsBankdeclare>() {
			public Update generate(TipsBankdeclare t) {
				Update update = update(TIPS_BANKDECLARE_TABLE)
						.set(TIPS_BANKDECLARE_TABLE.SERIAL.value(t.getSerial()),
								TIPS_BANKDECLARE_TABLE.CHANNEL.value(t.getChannel()),
								TIPS_BANKDECLARE_TABLE.AREA.value(t.getArea()),
								TIPS_BANKDECLARE_TABLE.BRANCH.value(t.getBranch()),
								TIPS_BANKDECLARE_TABLE.TELLER.value(t.getTeller()),
								TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.value(t.getTerminalCode()),
								TIPS_BANKDECLARE_TABLE.QUERY_ORDER.value(t.getQueryOrder()),
								TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.value(t.getPayOpbankno()),
								TIPS_BANKDECLARE_TABLE.ADDWORD.value(t.getAddword()))
						.where(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()));
				return update;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int remove(TipsBankdeclare tipsBankdeclare) {
		if (tipsBankdeclare == null) {
			return 0;
		}
		if (StringUtils.isBlank(String.valueOf(tipsBankdeclare.getBusinessDate()))
				&& StringUtils.isBlank(tipsBankdeclare.getSerial()) && StringUtils.isBlank(tipsBankdeclare.getChannel())
				&& StringUtils.isBlank(tipsBankdeclare.getArea()) && StringUtils.isBlank(tipsBankdeclare.getBranch())
				&& StringUtils.isBlank(tipsBankdeclare.getTeller())
				&& StringUtils.isBlank(tipsBankdeclare.getTerminalCode())
				&& StringUtils.isBlank(tipsBankdeclare.getQueryOrder())
				&& StringUtils.isBlank(tipsBankdeclare.getPayOpbankno())
				&& StringUtils.isBlank(tipsBankdeclare.getAddword())) {
			return 0;
		}
		return getDslTemplate().delete(new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_BANKDECLARE_TABLE)
						.where(and(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(tipsBankdeclare.getBusinessDate()),
								TIPS_BANKDECLARE_TABLE.SERIAL.eq(tipsBankdeclare.getSerial()),
								TIPS_BANKDECLARE_TABLE.CHANNEL.eq(tipsBankdeclare.getChannel()),
								TIPS_BANKDECLARE_TABLE.AREA.eq(tipsBankdeclare.getArea()),
								TIPS_BANKDECLARE_TABLE.BRANCH.eq(tipsBankdeclare.getBranch()),
								TIPS_BANKDECLARE_TABLE.TELLER.eq(tipsBankdeclare.getTeller()),
								TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.eq(tipsBankdeclare.getTerminalCode()),
								TIPS_BANKDECLARE_TABLE.QUERY_ORDER.eq(tipsBankdeclare.getQueryOrder()),
								TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.eq(tipsBankdeclare.getPayOpbankno()),
								TIPS_BANKDECLARE_TABLE.ADDWORD.eq(tipsBankdeclare.getAddword())));
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
				return delete(TIPS_BANKDECLARE_TABLE).where(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(pk));
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
				return delete(TIPS_BANKDECLARE_TABLE).where(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsBankdeclare getByKey(Date pk) {
		return getDslTemplate().getByKey(pk, TipsBankdeclare.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(TIPS_BANKDECLARE_TABLE).where(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public List<TipsBankdeclare> query(TipsBankdeclare tipsBankdeclare, final OrderBy... orderArgs) {
		if (tipsBankdeclare == null) {
			tipsBankdeclare = new TipsBankdeclare();
		}
		return getDslTemplate().query(tipsBankdeclare, new SelectGenerateCallback<TipsBankdeclare>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TipsBankdeclare t) {
				Select select = selectFrom(TIPS_BANKDECLARE_TABLE).where(and(
						TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()),
						TIPS_BANKDECLARE_TABLE.SERIAL.eq(t.getSerial()),
						TIPS_BANKDECLARE_TABLE.CHANNEL.eq(t.getChannel()), TIPS_BANKDECLARE_TABLE.AREA.eq(t.getArea()),
						TIPS_BANKDECLARE_TABLE.BRANCH.eq(t.getBranch()),
						TIPS_BANKDECLARE_TABLE.TELLER.eq(t.getTeller()),
						TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.eq(t.getTerminalCode()),
						TIPS_BANKDECLARE_TABLE.QUERY_ORDER.eq(t.getQueryOrder()),
						TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.eq(t.getPayOpbankno()),
						TIPS_BANKDECLARE_TABLE.ADDWORD.eq(t.getAddword())

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
	public Pager<TipsBankdeclare> queryPager(int start, int limit, TipsBankdeclare tipsBankdeclare,
			final OrderBy... orderArgs) {
		if (tipsBankdeclare == null) {
			tipsBankdeclare = new TipsBankdeclare();
		}
		return getDslTemplate().queryPager(start, limit, tipsBankdeclare, false,
				new SelectGenerateCallback<TipsBankdeclare>() {
					public Select generate(TipsBankdeclare t) {
						Select select = Select.selectFrom(TIPS_BANKDECLARE_TABLE)
								.where(and(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()),
										TIPS_BANKDECLARE_TABLE.SERIAL.eq(t.getSerial()),
										TIPS_BANKDECLARE_TABLE.CHANNEL.eq(t.getChannel()),
										TIPS_BANKDECLARE_TABLE.AREA.eq(t.getArea()),
										TIPS_BANKDECLARE_TABLE.BRANCH.eq(t.getBranch()),
										TIPS_BANKDECLARE_TABLE.TELLER.eq(t.getTeller()),
										TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.eq(t.getTerminalCode()),
										TIPS_BANKDECLARE_TABLE.QUERY_ORDER.eq(t.getQueryOrder()),
										TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.eq(t.getPayOpbankno()),
										TIPS_BANKDECLARE_TABLE.ADDWORD.eq(t.getAddword())

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
	public int[] batchInsert(boolean autoGeneratedKeys, List<TipsBankdeclare> tipsBankdeclare) {
		if (CollectionUtil.isEmpty(tipsBankdeclare)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsBankdeclare,
				new InsertGenerateCallback<TipsBankdeclare>() {

					public Insert generate(TipsBankdeclare t) {
						return insertInto(TIPS_BANKDECLARE_TABLE).values(
								TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.value(t.getBusinessDate()),
								TIPS_BANKDECLARE_TABLE.SERIAL.value(t.getSerial()),
								TIPS_BANKDECLARE_TABLE.CHANNEL.value(t.getChannel()),
								TIPS_BANKDECLARE_TABLE.AREA.value(t.getArea()),
								TIPS_BANKDECLARE_TABLE.BRANCH.value(t.getBranch()),
								TIPS_BANKDECLARE_TABLE.TELLER.value(t.getTeller()),
								TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.value(t.getTerminalCode()),
								TIPS_BANKDECLARE_TABLE.QUERY_ORDER.value(t.getQueryOrder()),
								TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.value(t.getPayOpbankno()),
								TIPS_BANKDECLARE_TABLE.ADDWORD.value(t.getAddword())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchInsert(List<TipsBankdeclare> tipsBankdeclares) {
		return batchInsert(false, tipsBankdeclares);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchUpdate(List<TipsBankdeclare> tipsBankdeclares) {
		if (CollectionUtil.isEmpty(tipsBankdeclares)) {
			return new int[0];
		}
		for (TipsBankdeclare tipsBankdeclare : tipsBankdeclares) {
			if (StringUtils.isBlank(String.valueOf(tipsBankdeclare.getBusinessDate()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsBankdeclares, new UpdateGenerateCallback<TipsBankdeclare>() {
			public Update generate(TipsBankdeclare t) {
				return update(TIPS_BANKDECLARE_TABLE).set(TIPS_BANKDECLARE_TABLE.SERIAL.value(t.getSerial()),
						TIPS_BANKDECLARE_TABLE.CHANNEL.value(t.getChannel()),
						TIPS_BANKDECLARE_TABLE.AREA.value(t.getArea()),
						TIPS_BANKDECLARE_TABLE.BRANCH.value(t.getBranch()),
						TIPS_BANKDECLARE_TABLE.TELLER.value(t.getTeller()),
						TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.value(t.getTerminalCode()),
						TIPS_BANKDECLARE_TABLE.QUERY_ORDER.value(t.getQueryOrder()),
						TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.value(t.getPayOpbankno()),
						TIPS_BANKDECLARE_TABLE.ADDWORD.value(t.getAddword())

				).where(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchDelete(List<TipsBankdeclare> tipsBankdeclares) {
		if (CollectionUtil.isEmpty(tipsBankdeclares)) {
			return new int[0];
		}
		for (TipsBankdeclare tipsBankdeclare : tipsBankdeclares) {
			if (StringUtils.isBlank(String.valueOf(tipsBankdeclare.getBusinessDate()))
					&& StringUtils.isBlank(tipsBankdeclare.getSerial())
					&& StringUtils.isBlank(tipsBankdeclare.getChannel())
					&& StringUtils.isBlank(tipsBankdeclare.getArea())
					&& StringUtils.isBlank(tipsBankdeclare.getBranch())
					&& StringUtils.isBlank(tipsBankdeclare.getTeller())
					&& StringUtils.isBlank(tipsBankdeclare.getTerminalCode())
					&& StringUtils.isBlank(tipsBankdeclare.getQueryOrder())
					&& StringUtils.isBlank(tipsBankdeclare.getPayOpbankno())
					&& StringUtils.isBlank(tipsBankdeclare.getAddword())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchDelete(tipsBankdeclares, new DeleteGenerateCallback<TipsBankdeclare>() {
			public Delete generate(TipsBankdeclare t) {
				return delete(TIPS_BANKDECLARE_TABLE).where(and(
						TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(t.getBusinessDate()),
						TIPS_BANKDECLARE_TABLE.SERIAL.eq(t.getSerial()),
						TIPS_BANKDECLARE_TABLE.CHANNEL.eq(t.getChannel()), TIPS_BANKDECLARE_TABLE.AREA.eq(t.getArea()),
						TIPS_BANKDECLARE_TABLE.BRANCH.eq(t.getBranch()),
						TIPS_BANKDECLARE_TABLE.TELLER.eq(t.getTeller()),
						TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.eq(t.getTerminalCode()),
						TIPS_BANKDECLARE_TABLE.QUERY_ORDER.eq(t.getQueryOrder()),
						TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.eq(t.getPayOpbankno()),
						TIPS_BANKDECLARE_TABLE.ADDWORD.eq(t.getAddword())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TipsBankdeclare> tipsBankdeclare) {
		if (CollectionUtil.isEmpty(tipsBankdeclare)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsBankdeclare, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(TIPS_BANKDECLARE_TABLE).values(
						TIPS_BANKDECLARE_TABLE.SERIAL.value(new JdbcNamedParameter("serial")),
						TIPS_BANKDECLARE_TABLE.CHANNEL.value(new JdbcNamedParameter("channel")),
						TIPS_BANKDECLARE_TABLE.AREA.value(new JdbcNamedParameter("area")),
						TIPS_BANKDECLARE_TABLE.BRANCH.value(new JdbcNamedParameter("branch")),
						TIPS_BANKDECLARE_TABLE.TELLER.value(new JdbcNamedParameter("teller")),
						TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.value(new JdbcNamedParameter("terminalCode")),
						TIPS_BANKDECLARE_TABLE.QUERY_ORDER.value(new JdbcNamedParameter("queryOrder")),
						TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.value(new JdbcNamedParameter("payOpbankno")),
						TIPS_BANKDECLARE_TABLE.ADDWORD.value(new JdbcNamedParameter("addword"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchUpdate(List<TipsBankdeclare> tipsBankdeclares) {
		if (CollectionUtil.isEmpty(tipsBankdeclares)) {
			return new int[0];
		}

		for (TipsBankdeclare tipsBankdeclare : tipsBankdeclares) {
			if (StringUtils.isBlank(String.valueOf(tipsBankdeclare.getBusinessDate()))) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsBankdeclares, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(TIPS_BANKDECLARE_TABLE)
						.set(TIPS_BANKDECLARE_TABLE.SERIAL.value(new JdbcNamedParameter("serial")),
								TIPS_BANKDECLARE_TABLE.CHANNEL.value(new JdbcNamedParameter("channel")),
								TIPS_BANKDECLARE_TABLE.AREA.value(new JdbcNamedParameter("area")),
								TIPS_BANKDECLARE_TABLE.BRANCH.value(new JdbcNamedParameter("branch")),
								TIPS_BANKDECLARE_TABLE.TELLER.value(new JdbcNamedParameter("teller")),
								TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.value(new JdbcNamedParameter("terminalCode")),
								TIPS_BANKDECLARE_TABLE.QUERY_ORDER.value(new JdbcNamedParameter("queryOrder")),
								TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.value(new JdbcNamedParameter("payOpbankno")),
								TIPS_BANKDECLARE_TABLE.ADDWORD.value(new JdbcNamedParameter("addword"))

						).where(TIPS_BANKDECLARE_TABLE.BUSINESS_DATE.eq(new JdbcNamedParameter("businessDate")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchDelete(List<TipsBankdeclare> tipsBankdeclares) {
		if (CollectionUtil.isEmpty(tipsBankdeclares)) {
			return new int[0];
		}

		for (TipsBankdeclare tipsBankdeclare : tipsBankdeclares) {
			if (StringUtils.isBlank(String.valueOf(tipsBankdeclare.getBusinessDate()))
					&& StringUtils.isBlank(tipsBankdeclare.getSerial())
					&& StringUtils.isBlank(tipsBankdeclare.getChannel())
					&& StringUtils.isBlank(tipsBankdeclare.getArea())
					&& StringUtils.isBlank(tipsBankdeclare.getBranch())
					&& StringUtils.isBlank(tipsBankdeclare.getTeller())
					&& StringUtils.isBlank(tipsBankdeclare.getTerminalCode())
					&& StringUtils.isBlank(tipsBankdeclare.getQueryOrder())
					&& StringUtils.isBlank(tipsBankdeclare.getPayOpbankno())
					&& StringUtils.isBlank(tipsBankdeclare.getAddword())) {
				return new int[0];
			}
		}

		return getDslTemplate().batchDelete(tipsBankdeclares, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_BANKDECLARE_TABLE)
						.where(and(TIPS_BANKDECLARE_TABLE.SERIAL.eq(new JdbcNamedParameter("serial")),
								TIPS_BANKDECLARE_TABLE.CHANNEL.eq(new JdbcNamedParameter("channel")),
								TIPS_BANKDECLARE_TABLE.AREA.eq(new JdbcNamedParameter("area")),
								TIPS_BANKDECLARE_TABLE.BRANCH.eq(new JdbcNamedParameter("branch")),
								TIPS_BANKDECLARE_TABLE.TELLER.eq(new JdbcNamedParameter("teller")),
								TIPS_BANKDECLARE_TABLE.TERMINAL_CODE.eq(new JdbcNamedParameter("terminalCode")),
								TIPS_BANKDECLARE_TABLE.QUERY_ORDER.eq(new JdbcNamedParameter("queryOrder")),
								TIPS_BANKDECLARE_TABLE.PAY_OPBANKNO.eq(new JdbcNamedParameter("payOpbankno")),
								TIPS_BANKDECLARE_TABLE.ADDWORD.eq(new JdbcNamedParameter("addword"))

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(List<TipsBankdeclare> tipsBankdeclare) {
		return preparedBatchInsert(false, tipsBankdeclare);
	}

}
