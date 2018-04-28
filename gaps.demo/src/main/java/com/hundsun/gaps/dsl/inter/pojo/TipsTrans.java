
package com.hundsun.gaps.dsl.inter.pojo;

import java.sql.Date;

/**
 * <!-- begin-user-doc --> 交易人员登记表 * <!-- end-user-doc -->
 */
public class TipsTrans {

	/**
	 * <!-- begin-user-doc --> 证件号码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String idNum;

	/**
	 * <!-- begin-user-doc --> 账户开立日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private Date accOpenDate;

	/**
	 * <!-- begin-user-doc --> 到期日 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String dueDate;

	/**
	 * <!-- begin-user-doc --> 性别 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String grander;

	/**
	 * <!-- begin-user-doc --> 核心收款笔数 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private Integer hostRecvNum;

	/**
	 * <!-- begin-user-doc --> 账单递送方式 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String billDeliveryWay;

	/**
	 * <!-- begin-user-doc --> hash值 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private Integer hashValue;

	/**
	 * <!-- begin-user-doc --> 证件号码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	/**
	 * <!-- begin-user-doc --> 证件号码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getIdNum() {
		return idNum;
	}

	/**
	 * <!-- begin-user-doc --> 账户开立日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setAccOpenDate(Date accOpenDate) {
		this.accOpenDate = accOpenDate;
	}

	/**
	 * <!-- begin-user-doc --> 账户开立日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Date getAccOpenDate() {
		return accOpenDate;
	}

	/**
	 * <!-- begin-user-doc --> 到期日 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * <!-- begin-user-doc --> 到期日 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * <!-- begin-user-doc --> 性别 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setGrander(String grander) {
		this.grander = grander;
	}

	/**
	 * <!-- begin-user-doc --> 性别 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getGrander() {
		return grander;
	}

	/**
	 * <!-- begin-user-doc --> 核心收款笔数 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setHostRecvNum(Integer hostRecvNum) {
		this.hostRecvNum = hostRecvNum;
	}

	/**
	 * <!-- begin-user-doc --> 核心收款笔数 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Integer getHostRecvNum() {
		return hostRecvNum;
	}

	/**
	 * <!-- begin-user-doc --> 账单递送方式 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setBillDeliveryWay(String billDeliveryWay) {
		this.billDeliveryWay = billDeliveryWay;
	}

	/**
	 * <!-- begin-user-doc --> 账单递送方式 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getBillDeliveryWay() {
		return billDeliveryWay;
	}

	/**
	 * <!-- begin-user-doc --> hash值 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setHashValue(Integer hashValue) {
		this.hashValue = hashValue;
	}

	/**
	 * <!-- begin-user-doc --> hash值 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Integer getHashValue() {
		return hashValue;
	}

}
