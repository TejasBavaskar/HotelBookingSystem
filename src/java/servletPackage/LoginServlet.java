/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletPackage;
import DaoPackage.UserDao;
import BeanPackage.UserBean;
import DaoPackage.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author TEJAS
 */
public class LoginServlet extends HttpServlet {
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {	    

             UserBean user = new UserBean();
             System.out.println("Email Getparameter: "+request.getParameter("email"));
             System.out.println("Password Getparameter: "+request.getParameter("custPassword"));
             user.setCustEmail(request.getParameter("email"));
             user.setCustPassword(request.getParameter("custPassword"));

             user = UserDao.login(user);
             System.out.println("user Validity: "+ user.isValid());
             if (user.isValid())
             {

                  HttpSession session = request.getSession(true);	    
                  session.setAttribute("currentSessionUser",user); 
                  response.sendRedirect("index2.html"); //logged-in page      		
             }
             else 
                  response.sendRedirect("login.html"); //error page 
            
        } 
        catch (Throwable theException) 	    
        {
             System.out.println(theException); 
        }
    }

    
}
