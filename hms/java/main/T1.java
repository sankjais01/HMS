package main;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//try {
				int num = 1/0;
				System.out.println(num);
			/*} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println();
			System.out.println("after Arithmetic Exception");
			
			
			try {
				int s;
				throw new NumberFormatException();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("after NumberFormat Exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("final exception");
			e.printStackTrace();
		}
		
		
	}

}
