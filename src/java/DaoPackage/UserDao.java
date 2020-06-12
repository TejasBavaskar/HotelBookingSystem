package DaoPackage;


import BeanPackage.UserBean;
import connection.LoginDBConnection;
import BeanPackage.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
    static Connection currentCon = null;
      static ResultSet rs = null;  
	
	
	
      public static UserBean login(UserBean bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String username = bean.getCustEmail();    
         String password = bean.getCustPassword();   
	    
         String searchQuery =
               "SELECT *" +
"	FROM public.customer where \"custEmail\" = '"+username +"' AND \"custPassword\" = '"+password+"';";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + username);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
         currentCon = LoginDBConnection.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = false;
         more = rs.next();
	         System.out.println("rs.next----"+ more);
                 System.out.println("rs.next----"+ (!more));
         // if user does not exist set the isValid variable to false
         if(!(more)) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
         else if (more)  //if user exists set the isValid variable to true
         {
            String cname = rs.getString("custName");
           /* String lastName = rs.getString("LastName");
	     	
            System.out.println("Welcome " + firstName);
            bean.setFirstName(firstName);
            bean.setLastName(lastName);
            bean.setValid(true);
           */
            System.out.println("Welcome " + cname); 
             bean.setValid(true);
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return bean;
	
      }	
      
      
      
}
