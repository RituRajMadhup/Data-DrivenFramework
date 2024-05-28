package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ExcelDriver;

public class TestDataProvider {

	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "mngr26593";
		data[0][1] = "1234567!";
		
		data[1][0] = "mngr26593";
		data[1][1] = "1234567!";
		
		data[2][0] = "mngr26593";
		data[2][1] = "1234567!";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws Exception{
		String excelFileName = System.getProperty("user.dir")+"/testDataInputFiles/TestData.xlsx";
		String sheetname = "TestData";
		
		ExcelDriver excelDriver = new ExcelDriver();
		
		excelDriver.openWorkbook(excelFileName);
		
		Object[][] data;
		
		int rowCount = excelDriver.getRowCount(sheetname);
		
		int cellCount = excelDriver.getCellCountFromARow(sheetname, 1);
		
		data = new Object[rowCount+1][cellCount];
		
		for(int row = 0; row <= rowCount; row++) {
			for(int cell = 0; cell < cellCount; cell++) {
				data[row][cell] = excelDriver.getCellData(sheetname, row, cell);
			}
		}
		
		return data;
	}
}
