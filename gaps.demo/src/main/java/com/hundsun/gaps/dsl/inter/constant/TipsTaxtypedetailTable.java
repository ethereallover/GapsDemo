
package com.hundsun.gaps.dsl.inter.constant;

import org.tinygroup.tinysqldsl.base.Column;
import org.tinygroup.tinysqldsl.base.Table;

import com.hundsun.gaps.dsl.inter.pojo.TipsTaxtypedetail;

/**
 * <!-- begin-user-doc --> 税种明细 * <!-- end-user-doc -->
 */
public class TipsTaxtypedetailTable extends Table {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public static final TipsTaxtypedetailTable TIPS_TAXTYPEDETAIL_TABLE = new TipsTaxtypedetailTable();

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
	 * <!-- begin-user-doc --> 订单信息 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column ORDER_INFO = new Column(this, "order_info");
	/**
	 * <!-- begin-user-doc --> 明细序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column DETAIL_NUM = new Column(this, "detail_num");
	/**
	 * <!-- begin-user-doc --> 票据名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column BILL_NAME = new Column(this, "bill_name");
	/**
	 * <!-- begin-user-doc --> 平台交易金额 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public final Column PLT_TRANS_AMT = new Column(this, "plt_trans_amt");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTaxtypedetailTable() {
		super("tips_taxtypedetail");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTaxtypedetailTable(String schemaName) {
		super(schemaName, "tips_taxtypedetail");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTaxtypedetailTable(String schemaName, String alias) {
		super(schemaName, "tips_taxtypedetail", alias);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public TipsTaxtypedetailTable(String schemaName, String alias, boolean withAs) {
		super(schemaName, "tips_taxtypedetail", alias, withAs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Class<TipsTaxtypedetail> getPojoType() {
		return TipsTaxtypedetail.class;
	}

}
