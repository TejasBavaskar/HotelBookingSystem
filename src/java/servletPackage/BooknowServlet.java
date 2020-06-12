package servletPackage;
import BeanPackage.BooknowBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BooknowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String arrivalDate = request.getParameter("checkindate");
        String departureDate = request.getParameter("checkoutdate");
        String numOfRooms = request.getParameter("numofroom");
        String roomType = request.getParameter("roomtype");
        
        BooknowBean booknowbean = new BooknowBean();
        booknowbean.setArrivalDate(arrivalDate);
        booknowbean.setDepartureDate(departureDate);
        booknowbean.setNumOfRooms(numOfRooms);
        booknowbean.setRoomType(roomType);
        
        
        
        
        
        
        
    }

    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
