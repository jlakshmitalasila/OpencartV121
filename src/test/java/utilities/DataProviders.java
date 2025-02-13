package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException{
		
		String xlPath = "./testData/Opencart_Logindata.xlsx";
		
		ExcelUtility xlUtil = new ExcelUtility(xlPath);
		
		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCols = xlUtil.getColCount("Sheet1");
		
		String loginData[][] = new String[totalRows][totalCols];
		
		for(int r=1;r<=totalRows;r++)
		{
			for(int c=0; c<totalCols;c++)
			{
				loginData[r-1][c]= xlUtil.getCellData("Sheet1", r, c);
			}
		}
		
		return loginData;
	}
	
	//DataProvider 2
	//DataProvider 3

}
