package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

//	@DataProvider(name = "db-inputs")
//	public Object [][] getDBData() {
//
//		List<LoginBean> list = new ELearningDAO().getLogins(); 
//		
//		Object[][] result = new Object[list.size()][]; 
//		int count = 0; 
//		for(LoginBean temp : list){
//			Object[]  obj = new Object[12]; 
//			obj[0] = temp.getUserName(); 
//			obj[1] = temp.getPassword(); 
//			
//			result[count ++] = obj; 
//		}
//		
//		
//		return result;
//	}
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegisterBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegisterBean temp : list){
			Object[]  obj = new Object[12]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.getEmail(); 
			obj[3] = temp.getTelephone(); 
			obj[4] = temp.getAddress1(); 
			obj[5] = temp.getAddress2(); 
			obj[6] = temp.getCity(); 
			obj[7] = temp.getPostCode(); 
			obj[8] = temp.getCountry(); 
			obj[9] = temp.getRegion(); 
			obj[10] = temp.getPassword(); 
			obj[11] = temp.getPasswordConfirm(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\VagmitaSaxena\\Desktop/Testing.xlsx"; 
		String Sheetname="TestCase1";
		return new ApachePOIExcelRead().getExcelContent(fileName,Sheetname); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\VagmitaSaxena\\Desktop/Testing.xlsx"; 
		String Sheetname="TestCase2";
		return new ApachePOIExcelRead().getExcelContent(fileName,Sheetname); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\VagmitaSaxena\\Desktop/Testing.xlsx"; 
		String Sheetname="TestCase3";
		return new ApachePOIExcelRead().getExcelContent(fileName,Sheetname); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\VagmitaSaxena\\Desktop/Testing.xlsx", "Sheet1"); 
	}
}
