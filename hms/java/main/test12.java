package main;


public class test12 {
	
	
	public static void main(String args [])
	{
	GetExcelData readdata=GetExcelData.get_exceldata("Invalidusers");
	System.out.println(readdata.usersheetdata.length);
	for (int r = 1; r < readdata.usersheetdata.length; r++) {
		for (int c = 0; c < 2; c++) {
			
			System.out.print(readdata.usersheetdata[r][c] + " ");
			
		}
		 System.out.println();
	}
		
	}
	

}
