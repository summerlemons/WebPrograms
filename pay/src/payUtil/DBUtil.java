package payUtil;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/pay?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String username = "root";
	private static final String password = "2032153705ztf";
	private static final String jdbcname = "com.mysql.jdbc.Driver";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcname);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		if(conn != null) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		conn.close();
	}
	
}
