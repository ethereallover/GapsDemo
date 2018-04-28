
package com.hundsun.gaps.dsl.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

import com.hundsun.gaps.dsl.inter.pojo.TipsTrans;

/**
 * <!-- begin-user-doc --> 交易人员登记表 * <!-- end-user-doc -->
 */
public class TipsTransTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public static final TipsTransTable TIPS_TRANS_TABLE = new TipsTransTable();

	/**
	 * <!-- begin-user-doc --> 证件号码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column ID_NUM = new Column(this, "id_num");
	/**
	 * <!-- begin-user-doc --> 账户开立日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column ACC_OPEN_DATE = new Column(this, "acc_open_date");
	/**
	 * <!-- begin-user-doc --> 到期日 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column DUE_DATE = new Column(this, "due_date");
	/**
	 * <!-- begin-user-doc --> 性别 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column GRANDER = new Column(this, "grander");
	/**
	 * <!-- begin-user-doc --> 核心收款笔数 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column HOST_RECV_NUM = new Column(this, "host_recv_num");
	/**
	 * <!-- begin-user-doc --> 账单递送方式 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column BILL_DELIVERY_WAY = new Column(this, "bill_delivery_way");
	/**
	 * <!-- begin-user-doc --> hash值 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column HASH_VALUE = new Column(this, "hash_value");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTransTable() {
		super("tips_trans");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTransTable(String schemaName) {
		super(schemaName, "tips_trans");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTransTable(String schemaName, String alias) {
		super(schemaName, "tips_trans", alias);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTransTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "tips_trans", alias, withAs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Class<TipsTrans> getPojoType() {
		return TipsTrans.class;
	}

}
