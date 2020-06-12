package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class RegisterDBConnection {
    public static Connection createConnection(){
    Connection con = null;
    String url = "jdbc:postgresql://localhost:5432/H1"; //MySQL URL followed by the database name
    try 
    {
        try 
        {
            Class.forName("org.postgresql.Driver"); //loading MySQL drivers. This differs for database servers 
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    con = DriverManager.getConnection(url, "postgres","root"); //attempting to connect to MySQL database
    //System.out.println("Printing connection object "+con);
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
 
    return con;
    }
}
