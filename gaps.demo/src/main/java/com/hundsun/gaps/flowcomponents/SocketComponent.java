package com.hundsun.gaps.flowcomponents;

import java.io.IOException;
import java.lang.String;

public class SocketComponent {

	public static String requestServer(String host, int port, String message) {
		String returnMsg = "<CFX><HEAD><MsgNode>1009</MsgNode><MsgVer>1.0</MsgVer><SRC>0001</SRC><MsgID>00000001</MsgID><MsgRef>00000001</MsgRef><WorkDate>20180208</WorkDate></HEAD><MSG>"
				+ "<RealHead1009><BankNo>123456</BankNo><OriEntrustDate>20180208</OriEntrustDate><OriQueryNo>0001</OriQueryNo><Result>00000</Result><AddWord>查询成功</AddWord></RealHead1009>"
				+ "<Payment1009><TaxOrgCode>101010</TaxOrgCode><CorpCode>010101</CorpCode><TaxPayCode>430725199510171595</TaxPayCode>"
				+ "<OuterLevyNo>15990087284</OuterLevyNo><PayOpBkCode>104100000004</PayOpBkCode><BankName>中国人民银行</BankName><TraAmt>10000.000</TraAmt><DetailNum>1</DetailNum>"
				+ "<TaxTypeList1009><ProjectId>99</ProjectId><TaxTypeName>增值税</TaxTypeName><TaxTypeCode>1312141553</TaxTypeCode>"
				+ "<TaxStartDate>20180101</TaxStartDate><TaxEndDate>20180210</TaxEndDate><TaxType>1</TaxType><DetailNum>2</DetailNum>"
				+ "<TaxSubjectList1009>"
				+ "<DetailNo>130012</DetailNo><TaxSubjectCode>21001</TaxSubjectCode><TaxNumber>1</TaxNumber><TaxAmt>5000.000</TaxAmt><FactTaxAmt>5000.000</FactTaxAmt>"
				+ "<DetailNo>130013</DetailNo><TaxSubjectCode>21002</TaxSubjectCode><TaxNumber>1</TaxNumber><TaxAmt>5000.000</TaxAmt><FactTaxAmt>5000.000</FactTaxAmt>"
				+ "</TaxSubjectList1009></TaxTypeList1009>" + "</Payment1009></MSG></CFX>";
		return returnMsg;
	}

	/**
	 * 发送tips申报请求
	 */
	public static String tipsPut(String xmlMsg) throws IOException {
		return xmlMsg;
	}

}
