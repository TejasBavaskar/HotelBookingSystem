package DaoPackage;

import BeanPackage.BooknowBean;
import java.sql.Connection;
import connection.RegisterDBConnection;
import java.sql.ResultSet;


public class BooknowDao {
    Connection conn=RegisterDBConnection.createConnection();
	boolean flag=false;
	ResultSet rs=null;
	String query;
	public boolean isAlreadyAvailable(User user)
	{
		boolean flag=false;
		ResultSet rs;
		query="select * from registration";
		
		try{
			    Statement stmt=conn.createStatement();
			    rs=stmt.executeQuery(query);
				while(rs.next())
				{
					if(rs.getString(3).equals(user.getEmail()))
					{
						flag=true;
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return flag;
	}
}
