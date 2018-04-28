
package com.hundsun.gaps.dsl.inter.pojo;

import java.sql.Date;
import java.math.BigDecimal;

/**
 * <!-- begin-user-doc --> 核心对账表 * <!-- end-user-doc -->
 */
public class TipsReconciliation {

	/**
	 * <!-- begin-user-doc --> 对账标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String checkSign;

	/**
	 * <!-- begin-user-doc --> 处理主机日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private Date dealHostDate;

	/**
	 * <!-- begin-user-doc --> 处理主机流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String dealHostSerial;

	/**
	 * <!-- begin-user-doc --> 转出帐卡号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String outAccno;

	/**
	 * <!-- begin-user-doc --> 平台交易金额 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private BigDecimal pltTransAmt;

	/**
	 * <!-- begin-user-doc --> 核心日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private Date hostDate;

	/**
	 * <!-- begin-user-doc --> 平台流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String pltSerial;

	/**
	 * <!-- begin-user-doc --> 渠道代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String channel;

	/**
	 * <!-- begin-user-doc --> 交易机构代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String branch;

	/**
	 * <!-- begin-user-doc --> 冲正交易标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String reverseTransSign;

	/**
	 * <!-- begin-user-doc --> 对账标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setCheckSign(String checkSign) {
		this.checkSign = checkSign;
	}

	/**
	 * <!-- begin-user-doc --> 对账标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getCheckSign() {
		return checkSign;
	}

	/**
	 * <!-- begin-user-doc --> 处理主机日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setDealHostDate(Date dealHostDate) {
		this.dealHostDate = dealHostDate;
	}

	/**
	 * <!-- begin-user-doc --> 处理主机日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Date getDealHostDate() {
		return dealHostDate;
	}

	/**
	 * <!-- begin-user-doc --> 处理主机流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setDealHostSerial(String dealHostSerial) {
		this.dealHostSerial = dealHostSerial;
	}

	/**
	 * <!-- begin-user-doc --> 处理主机流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getDealHostSerial() {
		return dealHostSerial;
	}

	/**
	 * <!-- begin-user-doc --> 转出帐卡号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setOutAccno(String outAccno) {
		this.outAccno = outAccno;
	}

	/**
	 * <!-- begin-user-doc --> 转出帐卡号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getOutAccno() {
		return outAccno;
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

	/**
	 * <!-- begin-user-doc --> 核心日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setHostDate(Date hostDate) {
		this.hostDate = hostDate;
	}

	/**
	 * <!-- begin-user-doc --> 核心日期 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public Date getHostDate() {
		return hostDate;
	}

	/**
	 * <!-- begin-user-doc --> 平台流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setPltSerial(String pltSerial) {
		this.pltSerial = pltSerial;
	}

	/**
	 * <!-- begin-user-doc --> 平台流水号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getPltSerial() {
		return pltSerial;
	}

	/**
	 * <!-- begin-user-doc --> 渠道代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * <!-- begin-user-doc --> 渠道代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * <!-- begin-user-doc --> 交易机构代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * <!-- begin-user-doc --> 交易机构代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * <!-- begin-user-doc --> 冲正交易标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setReverseTransSign(String reverseTransSign) {
		this.reverseTransSign = reverseTransSign;
	}

	/**
	 * <!-- begin-user-doc --> 冲正交易标识 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getReverseTransSign() {
		return reverseTransSign;
	}

}
