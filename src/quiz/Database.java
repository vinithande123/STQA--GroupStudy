package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public Database()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Swarali@123");
			st=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		
	}
	
	public void getData(){
		try{
			String sql="select * from Form";
			rs=st.executeQuery(sql);
			System.out.println("Data from online Database");
			while(rs.next()){
				String username=rs.getString("Username");
				String password=rs.getString("Password");
				System.out.println("Username :"+username+" Password :"+password);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
