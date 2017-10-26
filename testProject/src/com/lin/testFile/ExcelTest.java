package com.lin.testFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelTest {
	public List<MyData> getDataByExcelFile(String filePath) throws Exception{
		List<MyData> list = new ArrayList<>();
		InputStream is = new FileInputStream(filePath) ;
		Workbook wb = null ;
		Sheet sheet = null ;
		if(filePath.endsWith(".xls")){
			wb = new HSSFWorkbook(is) ;
			sheet = (HSSFSheet) wb.getSheetAt(0) ; //得到第一页
		}else if(filePath.endsWith(".xlsx")){
			wb = new XSSFWorkbook(is) ;
			sheet = (XSSFSheet) wb.getSheetAt(0) ; //得到第一页
		}
		if(sheet != null){
			removeBlankRow(sheet) ; //删除空白行
			for(int rowNum=1 ;rowNum <= sheet.getLastRowNum() ;rowNum ++){ // hssfSheet.getLastRowNum() 得到该页的行数，从0开始，故真正的行数要加1
				Row row = null ;
				if(sheet instanceof HSSFSheet){
					row = (HSSFRow)sheet.getRow(rowNum) ;//得到第rowNum行
				}else if(sheet instanceof XSSFSheet){
					row = (XSSFRow)sheet.getRow(rowNum) ;//得到第rowNum行
				}
				if(row == null){
					continue ;
				}
				int cellNum = row.getLastCellNum() ;
				if(cellNum == 6){
					String taskName = row.getCell(0) == null ? null: row.getCell(0).toString();
					String remark = row.getCell(1) == null ? null: row.getCell(1).toString();
					String ruleType = row.getCell(2) == null ? null: row.getCell(2).toString();
					String key = row.getCell(3) == null ? null: row.getCell(3).toString();
					String password = row.getCell(4) == null ? null: row.getCell(4).toString();
					String state = row.getCell(5) == null ? null: row.getCell(5).toString();
					taskName = formatDoubleToString(taskName) ;
					remark = formatDoubleToString(remark) ;
					ruleType = formatDoubleToString(ruleType) ;
					key = formatDoubleToString(key) ;
					password = formatDoubleToString(password) ;
					state = formatDoubleToString(state) ;
					MyData m = new MyData(taskName,remark,ruleType,key,password,state) ;
					list.add(m) ;
				}
			}
		}
		if(wb != null){
			wb.close();
		}
		if(is != null){
			is.close();
		}
		return list ;
	}
	
	private String formatDoubleToString(String str){
		if(str != null && !"".endsWith(str) && isDouble(str) && str.endsWith(".0")){
			return str.substring(0, str.lastIndexOf(".0")) ;
		}else{
			return str ;
		}
	}
	
	private boolean isDouble(String str)
	{
	   try
	   {
	      Double.parseDouble(str);
	      return true;
	   }
	   catch(NumberFormatException ex){}
	   return false;
	}
	
	private void removeBlankRow(Sheet sheet){
		System.out.println("总行数："+(sheet.getLastRowNum()+1)); 
		//去除空白行
        CellReference cellReference = new CellReference("A4"); 
        boolean flag = false; 
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) { 
            Row r = sheet.getRow(i); 
            if(r == null){ 
                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动 
                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1); 
                continue; 
            } 
            flag = false; 
            for(Cell c:r){ 
                if(c.getCellType() != Cell.CELL_TYPE_BLANK){ 
                    flag = true; 
                    break; 
                } 
            } 
            if(flag){ 
                i++; 
                continue; 
            } 
            else{//如果是空白行（即可能没有数据，但是有一定格式） 
                if(i == sheet.getLastRowNum()){
                	sheet.removeRow(r); //如果到了最后一行，直接将那一行remove掉 
                } else{
                	sheet.shiftRows(i+1, sheet.getLastRowNum(),-1); //如果还没到最后一行，则数据往上移一行 
                }
            } 
        } 
        System.out.println("总行数："+(sheet.getLastRowNum()+1)); 
	}
	
	public static void main(String[] args) throws Exception {
		ExcelTest test = new ExcelTest() ;
//		String filePath = "F:/test.xls" ;
		String filePath = "F:/test2.xlsx" ;
		List<MyData> list = test.getDataByExcelFile(filePath) ;
		if(list != null){
			for(MyData data : list){
				System.out.println(data);
			}
		}
	}
}
