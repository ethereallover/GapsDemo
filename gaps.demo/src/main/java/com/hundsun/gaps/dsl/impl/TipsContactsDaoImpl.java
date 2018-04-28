
package com.hundsun.gaps.dsl.impl;

import static com.hundsun.gaps.dsl.inter.constant.TipsContactsTable.TIPS_CONTACTS_TABLE;
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

import com.hundsun.gaps.dsl.inter.TipsContactsDao;
import com.hundsun.gaps.dsl.inter.pojo.TipsContacts;

/**
 * <!-- begin-user-doc --> 如果不希望某方法或者变量被覆盖，可以删除方法或者变量的注释@modifiable <!--
 * end-user-doc -->
 */
@Service
public class TipsContactsDaoImpl extends TinyDslDaoSupport implements TipsContactsDao {

	public static final String TABLE_NAME = "TIPS_CONTACTS";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsContacts add(TipsContacts tipsContacts) {
		return getDslTemplate().insertAndReturnKey(tipsContacts, new InsertGenerateCallback<TipsContacts>() {
			public Insert generate(TipsContacts t) {
				Insert insert = insertInto(TIPS_CONTACTS_TABLE).values(TIPS_CONTACTS_TABLE.CODE.value(t.getCode()),
						TIPS_CONTACTS_TABLE.COMPANY_NAME.value(t.getCompanyName()),
						TIPS_CONTACTS_TABLE.TREASURY_NAME.value(t.getTreasuryName()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.value(t.getUnitContactPhone()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.value(t.getUnitContactName()),
						TIPS_CONTACTS_TABLE.REMARKS.value(t.getRemarks())

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
	public int edit(TipsContacts tipsContacts) {
		if (tipsContacts == null || StringUtils.isBlank(tipsContacts.getCode())) {
			return 0;
		}
		return getDslTemplate().update(tipsContacts, new UpdateGenerateCallback<TipsContacts>() {
			public Update generate(TipsContacts t) {
				Update update = update(TIPS_CONTACTS_TABLE)
						.set(TIPS_CONTACTS_TABLE.COMPANY_NAME.value(t.getCompanyName()),
								TIPS_CONTACTS_TABLE.TREASURY_NAME.value(t.getTreasuryName()),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.value(t.getUnitContactPhone()),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.value(t.getUnitContactName()),
								TIPS_CONTACTS_TABLE.REMARKS.value(t.getRemarks()))
						.where(TIPS_CONTACTS_TABLE.CODE.eq(t.getCode()));
				return update;
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int remove(TipsContacts tipsContacts) {
		if (tipsContacts == null) {
			return 0;
		}
		if (StringUtils.isBlank(tipsContacts.getCode()) && StringUtils.isBlank(tipsContacts.getCompanyName())
				&& StringUtils.isBlank(tipsContacts.getTreasuryName())
				&& StringUtils.isBlank(tipsContacts.getUnitContactPhone())
				&& StringUtils.isBlank(tipsContacts.getUnitContactName())
				&& StringUtils.isBlank(tipsContacts.getRemarks())) {
			return 0;
		}
		return getDslTemplate().delete(new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_CONTACTS_TABLE).where(and(TIPS_CONTACTS_TABLE.CODE.eq(tipsContacts.getCode()),
						TIPS_CONTACTS_TABLE.COMPANY_NAME.eq(tipsContacts.getCompanyName()),
						TIPS_CONTACTS_TABLE.TREASURY_NAME.eq(tipsContacts.getTreasuryName()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.eq(tipsContacts.getUnitContactPhone()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.eq(tipsContacts.getUnitContactName()),
						TIPS_CONTACTS_TABLE.REMARKS.eq(tipsContacts.getRemarks())));
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
				return delete(TIPS_CONTACTS_TABLE).where(TIPS_CONTACTS_TABLE.CODE.eq(pk));
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
				return delete(TIPS_CONTACTS_TABLE).where(TIPS_CONTACTS_TABLE.CODE.in(t));
			}
		}, pks);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsContacts getByKey(String pk) {
		return getDslTemplate().getByKey(pk, TipsContacts.class, new SelectGenerateCallback<Serializable>() {

			@SuppressWarnings("rawtypes")
			public Select generate(Serializable t) {
				return selectFrom(TIPS_CONTACTS_TABLE).where(TIPS_CONTACTS_TABLE.CODE.eq(t));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public List<TipsContacts> query(TipsContacts tipsContacts, final OrderBy... orderArgs) {
		if (tipsContacts == null) {
			tipsContacts = new TipsContacts();
		}
		return getDslTemplate().query(tipsContacts, new SelectGenerateCallback<TipsContacts>() {
			@SuppressWarnings("rawtypes")
			public Select generate(TipsContacts t) {
				Select select = selectFrom(TIPS_CONTACTS_TABLE).where(and(TIPS_CONTACTS_TABLE.CODE.eq(t.getCode()),
						TIPS_CONTACTS_TABLE.COMPANY_NAME.eq(t.getCompanyName()),
						TIPS_CONTACTS_TABLE.TREASURY_NAME.eq(t.getTreasuryName()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.eq(t.getUnitContactPhone()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.eq(t.getUnitContactName()),
						TIPS_CONTACTS_TABLE.REMARKS.eq(t.getRemarks())

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
	public Pager<TipsContacts> queryPager(int start, int limit, TipsContacts tipsContacts, final OrderBy... orderArgs) {
		if (tipsContacts == null) {
			tipsContacts = new TipsContacts();
		}
		return getDslTemplate().queryPager(start, limit, tipsContacts, false,
				new SelectGenerateCallback<TipsContacts>() {
					public Select generate(TipsContacts t) {
						Select select = Select.selectFrom(TIPS_CONTACTS_TABLE)
								.where(and(TIPS_CONTACTS_TABLE.CODE.eq(t.getCode()),
										TIPS_CONTACTS_TABLE.COMPANY_NAME.eq(t.getCompanyName()),
										TIPS_CONTACTS_TABLE.TREASURY_NAME.eq(t.getTreasuryName()),
										TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.eq(t.getUnitContactPhone()),
										TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.eq(t.getUnitContactName()),
										TIPS_CONTACTS_TABLE.REMARKS.eq(t.getRemarks())

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
	public int[] batchInsert(boolean autoGeneratedKeys, List<TipsContacts> tipsContacts) {
		if (CollectionUtil.isEmpty(tipsContacts)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsContacts,
				new InsertGenerateCallback<TipsContacts>() {

					public Insert generate(TipsContacts t) {
						return insertInto(TIPS_CONTACTS_TABLE).values(TIPS_CONTACTS_TABLE.CODE.value(t.getCode()),
								TIPS_CONTACTS_TABLE.COMPANY_NAME.value(t.getCompanyName()),
								TIPS_CONTACTS_TABLE.TREASURY_NAME.value(t.getTreasuryName()),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.value(t.getUnitContactPhone()),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.value(t.getUnitContactName()),
								TIPS_CONTACTS_TABLE.REMARKS.value(t.getRemarks())

				);
					}
				});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchInsert(List<TipsContacts> tipsContactss) {
		return batchInsert(false, tipsContactss);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchUpdate(List<TipsContacts> tipsContactss) {
		if (CollectionUtil.isEmpty(tipsContactss)) {
			return new int[0];
		}
		for (TipsContacts tipsContacts : tipsContactss) {
			if (StringUtils.isBlank(tipsContacts.getCode())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsContactss, new UpdateGenerateCallback<TipsContacts>() {
			public Update generate(TipsContacts t) {
				return update(TIPS_CONTACTS_TABLE).set(TIPS_CONTACTS_TABLE.COMPANY_NAME.value(t.getCompanyName()),
						TIPS_CONTACTS_TABLE.TREASURY_NAME.value(t.getTreasuryName()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.value(t.getUnitContactPhone()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.value(t.getUnitContactName()),
						TIPS_CONTACTS_TABLE.REMARKS.value(t.getRemarks())

				).where(TIPS_CONTACTS_TABLE.CODE.eq(t.getCode()));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] batchDelete(List<TipsContacts> tipsContactss) {
		if (CollectionUtil.isEmpty(tipsContactss)) {
			return new int[0];
		}
		for (TipsContacts tipsContacts : tipsContactss) {
			if (StringUtils.isBlank(tipsContacts.getCode()) && StringUtils.isBlank(tipsContacts.getCompanyName())
					&& StringUtils.isBlank(tipsContacts.getTreasuryName())
					&& StringUtils.isBlank(tipsContacts.getUnitContactPhone())
					&& StringUtils.isBlank(tipsContacts.getUnitContactName())
					&& StringUtils.isBlank(tipsContacts.getRemarks())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchDelete(tipsContactss, new DeleteGenerateCallback<TipsContacts>() {
			public Delete generate(TipsContacts t) {
				return delete(TIPS_CONTACTS_TABLE).where(and(TIPS_CONTACTS_TABLE.CODE.eq(t.getCode()),
						TIPS_CONTACTS_TABLE.COMPANY_NAME.eq(t.getCompanyName()),
						TIPS_CONTACTS_TABLE.TREASURY_NAME.eq(t.getTreasuryName()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.eq(t.getUnitContactPhone()),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.eq(t.getUnitContactName()),
						TIPS_CONTACTS_TABLE.REMARKS.eq(t.getRemarks())

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(boolean autoGeneratedKeys, List<TipsContacts> tipsContacts) {
		if (CollectionUtil.isEmpty(tipsContacts)) {
			return new int[0];
		}
		return getDslTemplate().batchInsert(autoGeneratedKeys, tipsContacts, new NoParamInsertGenerateCallback() {

			public Insert generate() {
				return insertInto(TIPS_CONTACTS_TABLE).values(
						TIPS_CONTACTS_TABLE.COMPANY_NAME.value(new JdbcNamedParameter("companyName")),
						TIPS_CONTACTS_TABLE.TREASURY_NAME.value(new JdbcNamedParameter("treasuryName")),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.value(new JdbcNamedParameter("unitContactPhone")),
						TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.value(new JdbcNamedParameter("unitContactName")),
						TIPS_CONTACTS_TABLE.REMARKS.value(new JdbcNamedParameter("remarks"))

				);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchUpdate(List<TipsContacts> tipsContactss) {
		if (CollectionUtil.isEmpty(tipsContactss)) {
			return new int[0];
		}

		for (TipsContacts tipsContacts : tipsContactss) {
			if (StringUtils.isBlank(tipsContacts.getCode())) {
				return new int[0];
			}
		}
		return getDslTemplate().batchUpdate(tipsContactss, new NoParamUpdateGenerateCallback() {
			public Update generate() {
				return update(TIPS_CONTACTS_TABLE)
						.set(TIPS_CONTACTS_TABLE.COMPANY_NAME.value(new JdbcNamedParameter("companyName")),
								TIPS_CONTACTS_TABLE.TREASURY_NAME.value(new JdbcNamedParameter("treasuryName")),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE
										.value(new JdbcNamedParameter("unitContactPhone")),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.value(new JdbcNamedParameter("unitContactName")),
								TIPS_CONTACTS_TABLE.REMARKS.value(new JdbcNamedParameter("remarks"))

						).where(TIPS_CONTACTS_TABLE.CODE.eq(new JdbcNamedParameter("code")));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchDelete(List<TipsContacts> tipsContactss) {
		if (CollectionUtil.isEmpty(tipsContactss)) {
			return new int[0];
		}

		for (TipsContacts tipsContacts : tipsContactss) {
			if (StringUtils.isBlank(tipsContacts.getCode()) && StringUtils.isBlank(tipsContacts.getCompanyName())
					&& StringUtils.isBlank(tipsContacts.getTreasuryName())
					&& StringUtils.isBlank(tipsContacts.getUnitContactPhone())
					&& StringUtils.isBlank(tipsContacts.getUnitContactName())
					&& StringUtils.isBlank(tipsContacts.getRemarks())) {
				return new int[0];
			}
		}

		return getDslTemplate().batchDelete(tipsContactss, new NoParamDeleteGenerateCallback() {
			public Delete generate() {
				return delete(TIPS_CONTACTS_TABLE)
						.where(and(TIPS_CONTACTS_TABLE.COMPANY_NAME.eq(new JdbcNamedParameter("companyName")),
								TIPS_CONTACTS_TABLE.TREASURY_NAME.eq(new JdbcNamedParameter("treasuryName")),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_PHONE.eq(new JdbcNamedParameter("unitContactPhone")),
								TIPS_CONTACTS_TABLE.UNIT_CONTACT_NAME.eq(new JdbcNamedParameter("unitContactName")),
								TIPS_CONTACTS_TABLE.REMARKS.eq(new JdbcNamedParameter("remarks"))

				));
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public int[] preparedBatchInsert(List<TipsContacts> tipsContacts) {
		return preparedBatchInsert(false, tipsContacts);
	}

}
