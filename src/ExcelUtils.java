package org.tinygroup.studio.eclipse.database.ui.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.core.resources.IProject;
import org.tinygroup.studio.eclipse.framework.metadata.cache.TableCacheManager;

/**
 * 
 * @author wangwb 2018年4月16日
 *
 */
public class ExcelUtils {

	private static final String XLSX_FILE_NAME = ".xlsx";

	private static final String XLS_FILE_NAME = ".xls";
	
	private static Map<String,List<List<Object>>> map = new HashMap<String, List<List<Object>>>();
	
	/**
	 * 初始化---导入使用
	 * 
	 * @param excelPath
	 * @param project 
	 * @throws IOException
	 */
	public static Map<String,List<List<Object>>> importExcelFile(String excelPath, IProject project) throws IOException {
		map.clear();
		File file = new File(excelPath);
		Workbook workbook = createWorkbook(file);
		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			String sheetName = workbook.getSheetName(i);
			createDatas(sheet, sheetName, project);
		}
		return map;
	}

	/**
	 * 获取Excel文件内容--导入使用
	 * 
	 * @param sheet
	 * @param sheetName
	 * @param project2 
	 */
	private static void createDatas(Sheet sheet, String sheetName, IProject project) {
		List<List<Object>> data = new ArrayList<List<Object>>();
		int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		Row row = null;
		int rNum = sheet.getLastRowNum();
		for (int i = 1; i <=rNum ; i++) {
			row = sheet.getRow(i);
			List<Object> rowData = new ArrayList<Object>();
			for (int j = 0; j < colNum; j++) {
				if (row.getCell(j) != null) {
					switch (row.getCell(j).getCellType()) {
						case Cell.CELL_TYPE_STRING:
							rowData.add(row.getCell(j).getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							rowData.add((int) row.getCell(j).getNumericCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							rowData.add((boolean) row.getCell(j).getBooleanCellValue());
							break;
						default:
							rowData.add("");
							break;
					}
				} else {
					rowData.add("");
				}
			}
			data.add(rowData);
		}
		map.put(TableCacheManager.getTableByName(project, sheetName).getId(), data);
	}
	
	/**
	 * 创建工作簿文件---导入使用
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Workbook createWorkbook(File file) throws IOException {
		Workbook workBook = null;
		String fileName = file.getName();
		if (fileName.endsWith(XLSX_FILE_NAME)) {
			workBook = new XSSFWorkbook(new FileInputStream(file));
		} else if (fileName.endsWith(XLS_FILE_NAME)) {
			workBook = new HSSFWorkbook(new FileInputStream(file));
		} else {
			throw new IOException("不支持的文件格式");
		}
		return workBook;
	}

	/**
	 * 导出XLSX格式文件
	 * @param datas
	 * @param headers
	 * @param excelPath
	 * @param sheetNames
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> void exportXlsx(Map<String, List<T>> datas, String[] headers, String excelPath, List<String> sheetNames)
			throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Workbook workbook = new XSSFWorkbook();
		if (!sheetNames.isEmpty()) {
			for (String name : sheetNames) {
				XSSFSheet sheet = (XSSFSheet) workbook.createSheet(name);
				fillTargetSheet(datas.get(name), workbook, sheet, headers);
			}
		}
		FileOutputStream fos = new FileOutputStream(new File(excelPath));
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	/**
	 * XLSX格式---数据表格样式设置--导出使用
	 * 
	 * @param datas
	 * @param workbook
	 * @param sheet
	 * @param headers
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static <T> void fillTargetSheet(List<T> datas, Workbook workbook, XSSFSheet sheet, String[] headers) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		XSSFRow row = (XSSFRow) sheet.createRow(0);
		row.setHeightInPoints(20);

		XSSFCellStyle headerStyle = (XSSFCellStyle) workbook.createCellStyle();

		XSSFFont font = (XSSFFont) workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("宋体");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

		headerStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		headerStyle.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		headerStyle.setFont(font);

		for (int i = 0; i < headers.length; i++) {
			if (i == 0 || i == 3 || i == 4) {
				sheet.autoSizeColumn(i, true);
			} else if (i == 5 || i == 6 || i==7) {
				sheet.setColumnWidth(i, 12 * 256);
			} else {
				sheet.setColumnWidth(i, 26 * 256);
			}
			XSSFCell cell = row.createCell(i);
			cell.setCellStyle(headerStyle);
			XSSFRichTextString text = new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		XSSFCellStyle contentStyle = (XSSFCellStyle) workbook.createCellStyle();
		XSSFFont contentfont = (XSSFFont) workbook.createFont();
		contentfont.setFontHeightInPoints((short) 11);
		contentfont.setFontName("宋体");
		contentStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		contentStyle.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		contentStyle.setWrapText(true);
		contentStyle.setFont(contentfont);

		setXLSXContentData(datas, sheet, contentStyle,workbook);
	}

	/**
	 * XLSX格式---表格数据填充--导出使用
	 * 
	 * @param dtoList
	 * @param sheet
	 * @param contentStyle
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static <T> void setXLSXContentData(List<T> dtoList, XSSFSheet sheet, XSSFCellStyle contentStyle,Workbook workbook) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Iterator<T> it = dtoList.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			XSSFRow content_row = sheet.createRow(index);
			T t = (T) it.next();
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				XSSFCell content_cell = content_row.createCell(i);
				content_cell.setCellStyle(contentStyle);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				Class<? extends Object> tCls = t.getClass();
				Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
				Object value = getMethod.invoke(t, new Object[] {});
				if (value instanceof Boolean) {
					content_cell.setCellValue((boolean) value);
				} else if (value instanceof String) {
					XSSFRichTextString textValue = new XSSFRichTextString((String) value);
					content_cell.setCellValue(textValue);
				}
			}
		}
		XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();   
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		CellRangeAddress region = new CellRangeAddress(1, sheet.getPhysicalNumberOfRows()-1, 0, 0);
		sheet.addMergedRegion(region);
		XSSFCell nowCell = sheet.getRow(1).getCell(0);
		nowCell.setCellStyle(cellStyle);
	}

	/**
	 * 导出XLS格式文件
	 * 
	 * @param datas
	 * @param headers
	 * @param excelPath
	 * @param sheetNames
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> void exportXls(Map<String, List<T>> datas, String[] headers, String excelPath, List<String> sheetNames)
			throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Workbook workbook = new HSSFWorkbook();
		if (!sheetNames.isEmpty()) {
			for (String name : sheetNames) {
				HSSFSheet sheet = (HSSFSheet) workbook.createSheet(name);
				fillTargetSheet(datas.get(name), workbook, sheet, headers);
			}
		}
		FileOutputStream fos = new FileOutputStream(new File(excelPath));
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	/**
	 * XLS格式--表格样式设置--导出使用
	 * 
	 * @param datas
	 * @param workbook
	 * @param sheet
	 * @param headers
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static <T> void fillTargetSheet(List<T> datas, Workbook workbook, HSSFSheet sheet, String[] headers) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		HSSFRow row = (HSSFRow) sheet.createRow(0);
		row.setHeightInPoints(20);

		HSSFCellStyle headerStyle = (HSSFCellStyle) workbook.createCellStyle();
		HSSFFont font = (HSSFFont) workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("宋体");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		headerStyle.setFont(font);

		for (int i = 0; i < headers.length; i++) {
			if (i == 0 || i == 4) {
				sheet.autoSizeColumn(i, true);
			} else if (i == 3 || i == 5 || i == 6) {
				sheet.setColumnWidth(i, 12 * 256);
			} else {
				sheet.setColumnWidth(i, 26 * 256);
			}
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(headerStyle);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		HSSFCellStyle contentStyle = (HSSFCellStyle) workbook.createCellStyle();
		HSSFFont contentfont = (HSSFFont) workbook.createFont();
		contentfont.setFontHeightInPoints((short) 11);
		contentfont.setFontName("宋体");
		contentStyle.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		contentStyle.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		contentStyle.setWrapText(true);
		contentStyle.setFont(contentfont);
		setXLSContentData(datas, sheet, contentStyle,workbook);
	}

	/**
	 * XLS格式---表格数据填充--导出使用
	 * 
	 * @param dtoList
	 * @param sheet
	 * @param contentStyle
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static <T> void setXLSContentData(List<T> dtoList, HSSFSheet sheet, HSSFCellStyle contentStyle,Workbook workbook) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Iterator<T> it = dtoList.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			HSSFRow content_row = sheet.createRow(index);
			T t = (T) it.next();
			Field[] fields = t.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				HSSFCell content_cell = content_row.createCell(i);
				content_cell.setCellStyle(contentStyle);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				Class<? extends Object> tCls = t.getClass();
				Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
				Object value = getMethod.invoke(t, new Object[] {});
				if (value instanceof Boolean) {
					content_cell.setCellValue((boolean) value);
				} else if (value instanceof String) {
					HSSFRichTextString textValue = new HSSFRichTextString((String) value);
					content_cell.setCellValue(textValue);
				}
			}
		}
		
		HSSFCellStyle cellStyle = (HSSFCellStyle) workbook.createCellStyle();   
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
		CellRangeAddress region = new CellRangeAddress(1, sheet.getPhysicalNumberOfRows()-1, 0, 0);
		sheet.addMergedRegion(region);
		HSSFCell nowCell = sheet.getRow(1).getCell(0);
		nowCell.setCellStyle(cellStyle);
	}
}
