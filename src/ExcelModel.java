package org.tinygroup.studio.eclipse.database.ui.excel;

/**
 * 导出Excel表格的数据模型
 * @author wangwb 2018年4月17日
 *
 */
public class ExcelModel {
	
	private String group;

	private String name;

	private String title;

	private String dataType;

	private String length;

	private boolean isPK;
	
	private boolean isNull;

	private boolean isAutoInc;

	private String description;
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getDataType() {
		return dataType;
	}

	public String getLength() {
		return length;
	}

	public boolean getIsPK() {
		return isPK;
	}

	public boolean getIsNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public boolean getIsAutoInc() {
		return isAutoInc;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void setIsPK(boolean isPK) {
		this.isPK = isPK;
	}

	public void setIsAutoInc(boolean isAutoInc) {
		this.isAutoInc = isAutoInc;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
