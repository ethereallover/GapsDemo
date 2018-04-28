
package com.hundsun.gaps.dsl.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

import com.hundsun.gaps.dsl.inter.pojo.TipsBankdeclare;

/**
 * <!-- begin-user-doc --> 银行申报查询表 * <!-- end-user-doc -->
 */
public class TipsBankdeclareTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public static final TipsBankdeclareTable TIPS_BANKDECLARE_TABLE = new TipsBankdeclareTable();

	/**
	 * <!-- begin-user-doc --> 业务日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column BUSINESS_DATE = new Column(this, "business_date");
	/**
	 * <!-- begin-user-doc --> 交易流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column SERIAL = new Column(this, "serial");
	/**
	 * <!-- begin-user-doc --> 渠道代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column CHANNEL = new Column(this, "channel");
	/**
	 * <!-- begin-user-doc --> 地区代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column AREA = new Column(this, "area");
	/**
	 * <!-- begin-user-doc --> 交易机构代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column BRANCH = new Column(this, "branch");
	/**
	 * <!-- begin-user-doc --> 交易柜员代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column TELLER = new Column(this, "teller");
	/**
	 * <!-- begin-user-doc --> 终端代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column TERMINAL_CODE = new Column(this, "terminal_code");
	/**
	 * <!-- begin-user-doc --> 查询序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column QUERY_ORDER = new Column(this, "query_order");
	/**
	 * <!-- begin-user-doc --> 付款开户行行号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column PAY_OPBANKNO = new Column(this, "pay_opbankno");
	/**
	 * <!-- begin-user-doc --> 附言 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column ADDWORD = new Column(this, "addword");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsBankdeclareTable() {
		super("tips_bankdeclare");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsBankdeclareTable(String schemaName) {
		super(schemaName, "tips_bankdeclare");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsBankdeclareTable(String schemaName, String alias) {
		super(schemaName, "tips_bankdeclare", alias);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsBankdeclareTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "tips_bankdeclare", alias, withAs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Class<TipsBankdeclare> getPojoType() {
		return TipsBankdeclare.class;
	}

}
