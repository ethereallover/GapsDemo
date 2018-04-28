
package com.hundsun.gaps.dsl.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

import com.hundsun.gaps.dsl.inter.pojo.TipsReconciliation;

/**
 * <!-- begin-user-doc --> 核心对账表 * <!-- end-user-doc -->
 */
public class TipsReconciliationTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public static final TipsReconciliationTable TIPS_RECONCILIATION_TABLE = new TipsReconciliationTable();

	/**
	 * <!-- begin-user-doc --> 对账标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column CHECK_SIGN = new Column(this, "check_sign");
	/**
	 * <!-- begin-user-doc --> 处理主机日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column DEAL_HOST_DATE = new Column(this, "deal_host_date");
	/**
	 * <!-- begin-user-doc --> 处理主机流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column DEAL_HOST_SERIAL = new Column(this, "deal_host_serial");
	/**
	 * <!-- begin-user-doc --> 转出帐卡号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column OUT_ACCNO = new Column(this, "out_accno");
	/**
	 * <!-- begin-user-doc --> 平台交易金额 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column PLT_TRANS_AMT = new Column(this, "plt_trans_amt");
	/**
	 * <!-- begin-user-doc --> 核心日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column HOST_DATE = new Column(this, "host_date");
	/**
	 * <!-- begin-user-doc --> 平台流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column PLT_SERIAL = new Column(this, "plt_serial");
	/**
	 * <!-- begin-user-doc --> 渠道代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column CHANNEL = new Column(this, "channel");
	/**
	 * <!-- begin-user-doc --> 交易机构代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column BRANCH = new Column(this, "branch");
	/**
	 * <!-- begin-user-doc --> 冲正交易标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column REVERSE_TRANS_SIGN = new Column(this, "reverse_trans_sign");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsReconciliationTable() {
		super("tips_reconciliation");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsReconciliationTable(String schemaName) {
		super(schemaName, "tips_reconciliation");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsReconciliationTable(String schemaName, String alias) {
		super(schemaName, "tips_reconciliation", alias);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsReconciliationTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "tips_reconciliation", alias, withAs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Class<TipsReconciliation> getPojoType() {
		return TipsReconciliation.class;
	}

}
