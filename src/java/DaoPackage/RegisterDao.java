package DaoPackage;
import BeanPackage.RegisterBean;
import connection.RegisterDBConnection;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao {
    public String registerUser(RegisterBean registerBean){
        
        Connection con = null;
       // PreparedStatement preparedStatement = null;
        try
        {
            con = RegisterDBConnection.createConnection();
            
            String firstName = registerBean.getFirstName();
            String lastName = registerBean.getLastName();
            
            String locality = registerBean.getLocality();
            String city = registerBean.getCity();
            String state = registerBean.getState();
            int pin = Integer.parseInt(registerBean.getPin());
            String custEmail = registerBean.getCustEmail();
            int custAge = Integer.parseInt(registerBean.getCustAge());
            String custGender = registerBean.getCustGender();
            String custPassword = registerBean.getCustPassword();
            
            
            String[] custMobile = new String[2];
            custMobile[0] = registerBean.getCustMobile1();
            custMobile[1] = registerBean.getCustMobile2();
            System.out.println("Mobile 2: "+custMobile[1]);

            String query = "INSERT INTO public.customer(\n" +
"	\"custName\", \"custAddress\", \"custEmail\", \"custAge\", \"custGender\", \"custPassword\", \"custMobile\")\n" +
"	VALUES (('"+firstName+"','"+lastName+"'), ('"+locality+"','"+city+"','"+state+"',"+pin+"),'"+custEmail+"' ,"+custAge+" ,'"+custGender+"','"+ custPassword+"','{"+custMobile[0]+","+custMobile[1]+"}' )";     
            
            Statement stmt = con.createStatement();

            int i= stmt.executeUpdate(query);

            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        
   return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
 }
}