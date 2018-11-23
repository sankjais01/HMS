package main;

import java.util.ArrayList;

import utils.ExcelUtils;

public class GetExcelData {

	final String path = System.getProperty("user.dir") + "/resources/utils/User.xlsx";
	ExcelUtils excelsheet;
	ExcelUtils excelinvalidusers;
	int cols, rows;
	public String[][] usersheetdata;

	public static GetExcelData get_exceldata(String sheetname) {
		GetExcelData data=new GetExcelData();
		data.excelsheet = new ExcelUtils(data.path, sheetname);

		try {
			int cols = data.excelsheet.excel_get_cols();
			int rows = data.excelsheet.excel_get_rows();
			data.usersheetdata = new String[rows][cols];
			for (int r = 1; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					data.usersheetdata[r][c] = data.excelsheet.getCellDataAsString(r, c);
					
					System.out.print(data.usersheetdata[r][c] + " ");
					
				}
				 System.out.println();
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

}
