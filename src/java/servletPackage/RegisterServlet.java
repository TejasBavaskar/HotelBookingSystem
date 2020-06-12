package servletPackage;
import BeanPackage.RegisterBean;
import DaoPackage.RegisterDao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    RequestDispatcher rd=null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String custFirstName = request.getParameter("custFirstName");
        String custLastName = request.getParameter("custLastName");
        String custEmail = request.getParameter("custEmail");
        String password = request.getParameter("custPassword");
        String custAge = request.getParameter("custAge");
        String custGender = request.getParameter("gender");
        String locality = request.getParameter("locality");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pin = request.getParameter("pin");
        String[] custMobile = new String[2];
        custMobile[0]= request.getParameter("custMobile1");
        custMobile[1]= request.getParameter("custMobile2");
        //***********************************************
        
         RegisterBean registerBean = new RegisterBean();
         registerBean.setFirstName(custFirstName);
         registerBean.setLastName(custLastName);
         registerBean.setCustEmail(custEmail);
         registerBean.setCustPassword(password);
         registerBean.setCustAge(custAge);
         registerBean.setCustGender(custGender);
         registerBean.setLocality(locality);
         registerBean.setCity(city);
         registerBean.setState(state);
         registerBean.setPin(pin);
         registerBean.setCustMobile1(custMobile[0]);
         registerBean.setCustMobile2(custMobile[1]);
         
         
         RegisterDao registerDao = new RegisterDao();
         String userRegistered = registerDao.registerUser(registerBean);
         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
            request.getRequestDispatcher("login.html").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("registration.html").forward(request, response);
        }

    }

}
