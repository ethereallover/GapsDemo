
package com.hundsun.gaps.dsl.inter.pojo;

import java.sql.Date;

/**
 * <!-- begin-user-doc --> 银行申报查询表 * <!-- end-user-doc -->
 */
public class TipsBankdeclare {

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
	 * <!-- begin-user-doc --> 渠道代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String channel;

	/**
	 * <!-- begin-user-doc --> 地区代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String area;

	/**
	 * <!-- begin-user-doc --> 交易机构代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String branch;

	/**
	 * <!-- begin-user-doc --> 交易柜员代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String teller;

	/**
	 * <!-- begin-user-doc --> 终端代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String terminalCode;

	/**
	 * <!-- begin-user-doc --> 查询序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String queryOrder;

	/**
	 * <!-- begin-user-doc --> 付款开户行行号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String payOpbankno;

	/**
	 * <!-- begin-user-doc --> 附言 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	private String addword;

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
	 * <!-- begin-user-doc --> 地区代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * <!-- begin-user-doc --> 地区代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getArea() {
		return area;
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
	 * <!-- begin-user-doc --> 交易柜员代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setTeller(String teller) {
		this.teller = teller;
	}

	/**
	 * <!-- begin-user-doc --> 交易柜员代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getTeller() {
		return teller;
	}

	/**
	 * <!-- begin-user-doc --> 终端代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	/**
	 * <!-- begin-user-doc --> 终端代码 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getTerminalCode() {
		return terminalCode;
	}

	/**
	 * <!-- begin-user-doc --> 查询序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setQueryOrder(String queryOrder) {
		this.queryOrder = queryOrder;
	}

	/**
	 * <!-- begin-user-doc --> 查询序号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getQueryOrder() {
		return queryOrder;
	}

	/**
	 * <!-- begin-user-doc --> 付款开户行行号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setPayOpbankno(String payOpbankno) {
		this.payOpbankno = payOpbankno;
	}

	/**
	 * <!-- begin-user-doc --> 付款开户行行号 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getPayOpbankno() {
		return payOpbankno;
	}

	/**
	 * <!-- begin-user-doc --> 附言 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public void setAddword(String addword) {
		this.addword = addword;
	}

	/**
	 * <!-- begin-user-doc --> 附言 * <!-- end-user-doc -->
	 * 
	 * @modifiable
	 */
	public String getAddword() {
		return addword;
	}

}
