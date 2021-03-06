package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.ExcelUtils;

public class DBConnect {
	static String database_details[][];
	static ExcelUtils database_excel_details = new ExcelUtils(
			(System.getProperty("user.dir") + "/resources/utils/User.xlsx"), "database");
	String dbusername = database_details[1][0];
	String dbpassword = database_details[1][1];
	String port = database_details[1][2];
	String database = database_details[1][3];
	String connectionURL = database_details[1][4] + ":" + port + "/" + database;
	String driver_type = database_details[1][5];
	Connection con = null;
	PreparedStatement prepare_stmts = null;
	public List<String> db_rowdata;

	// "com.mysql.jdbc.Driver" depricated one

	// static block for setting db connection details
	static {
		try {
			int cols = database_excel_details.excel_get_cols();
			int rows = database_excel_details.excel_get_rows();
			database_details = new String[rows][cols];

			for (int r = 1; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					database_details[r][c] = database_excel_details.getCellDataAsString(r, c);
					// System.out.print(database_details[r][c] + " ");
				}
				// System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//creating db connection
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(connectionURL, dbusername, dbpassword);
			Class.forName(driver_type);
			System.out.println("connected to database successfuly..!");
			return con;
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("OOPs,....fail to connect database");
			return null;
		}

		// createstatements = con.createStatement();
	}

	public static DBConnect readEmail_of_forgorpasswords(String querry,String coloumn) throws SQLException {
		DBConnect db = new DBConnect();
		db.con = db.getConnection();
		db.db_rowdata = new ArrayList<String>();
		if (db.con == null) {
			System.out.println("fail to connected to database");
			System.exit(1);
		}

		try {
			db.prepare_stmts = db.con.prepareStatement(querry);
			ResultSet rs = db.prepare_stmts.executeQuery();

			while (rs.next()) {

				// System.out.print(rs.getString("user_id"));
				db.db_rowdata.add(rs.getString(coloumn));
				// System.out.println(" test success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.con.close();
			System.out.println("Disconnecting database");
		}
		return db;
	}

}
