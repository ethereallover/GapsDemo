
package com.hundsun.gaps.dsl.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

import com.hundsun.gaps.dsl.inter.pojo.TipsContacts;

/**
 * <!-- begin-user-doc --> 联系人登记表 * <!-- end-user-doc -->
 */
public class TipsContactsTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public static final TipsContactsTable TIPS_CONTACTS_TABLE = new TipsContactsTable();

	/**
	 * <!-- begin-user-doc --> 代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column CODE = new Column(this, "code");
	/**
	 * <!-- begin-user-doc --> 公司名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column COMPANY_NAME = new Column(this, "company_name");
	/**
	 * <!-- begin-user-doc --> 国库名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column TREASURY_NAME = new Column(this, "treasury_name");
	/**
	 * <!-- begin-user-doc --> 单位联系人电话 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column UNIT_CONTACT_PHONE = new Column(this, "unit_contact_phone");
	/**
	 * <!-- begin-user-doc --> 单位联系人名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column UNIT_CONTACT_NAME = new Column(this, "unit_contact_name");
	/**
	 * <!-- begin-user-doc --> 备注 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column REMARKS = new Column(this, "remarks");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsContactsTable() {
		super("tips_contacts");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsContactsTable(String schemaName) {
		super(schemaName, "tips_contacts");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsContactsTable(String schemaName, String alias) {
		super(schemaName, "tips_contacts", alias);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsContactsTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "tips_contacts", alias, withAs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Class<TipsContacts> getPojoType() {
		return TipsContacts.class;
	}

}
