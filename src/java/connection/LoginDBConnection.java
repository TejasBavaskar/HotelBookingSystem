package connection;
import java.sql.*;
import java.util.*;
public class LoginDBConnection {
    static Connection con;
      static String url;
            
      public static Connection getConnection()
      {
        
         try
         {
            String url = "jdbc:postgresql://localhost:5432/H1"; 
            // assuming "DataSource" is your DataSource name

            Class.forName("org.postgresql.Driver");
            
            try
            {            	
               con = DriverManager.getConnection(url,"postgres","root"); 
                								
            // assuming your SQL Server's	username is "username"               
            // and password is "password"
                 
            }
            
            catch (SQLException ex)
            {
               ex.printStackTrace();
            }
         }

         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }

      return con;
    }
}
