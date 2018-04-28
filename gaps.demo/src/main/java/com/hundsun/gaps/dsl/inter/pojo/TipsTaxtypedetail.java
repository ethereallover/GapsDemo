
package com.hundsun.gaps.dsl.inter.pojo;

import java.sql.Date;
import java.math.BigDecimal;

/**
 * <!-- begin-user-doc --> 税种明细 * <!-- end-user-doc -->
 */
public class TipsTaxtypedetail {

	/**
	 * <!-- begin-user-doc --> 业务日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private Date businessDate;

	/**
	 * <!-- begin-user-doc --> 交易流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String serial;

	/**
	 * <!-- begin-user-doc --> 订单信息 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String orderInfo;

	/**
	 * <!-- begin-user-doc --> 明细序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String detailNum;

	/**
	 * <!-- begin-user-doc --> 票据名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String billName;

	/**
	 * <!-- begin-user-doc --> 平台交易金额 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private BigDecimal pltTransAmt;

	/**
	 * <!-- begin-user-doc --> 业务日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	/**
	 * <!-- begin-user-doc --> 业务日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Date getBusinessDate() {
		return businessDate;
	}

	/**
	 * <!-- begin-user-doc --> 交易流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * <!-- begin-user-doc --> 交易流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * <!-- begin-user-doc --> 订单信息 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	/**
	 * <!-- begin-user-doc --> 订单信息 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getOrderInfo() {
		return orderInfo;
	}

	/**
	 * <!-- begin-user-doc --> 明细序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setDetailNum(String detailNum) {
		this.detailNum = detailNum;
	}

	/**
	 * <!-- begin-user-doc --> 明细序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getDetailNum() {
		return detailNum;
	}

	/**
	 * <!-- begin-user-doc --> 票据名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setBillName(String billName) {
		this.billName = billName;
	}

	/**
	 * <!-- begin-user-doc --> 票据名称 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getBillName() {
		return billName;
	}

	/**
	 * <!-- begin-user-doc --> 平台交易金额 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setPltTransAmt(BigDecimal pltTransAmt) {
		this.pltTransAmt = pltTransAmt;
	}

	/**
	 * <!-- begin-user-doc --> 平台交易金额 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public BigDecimal getPltTransAmt() {
		return pltTransAmt;
	}

}
