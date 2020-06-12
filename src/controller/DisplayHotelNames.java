package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Booking;
import model.Guest;
import model.Hotel;
import model.Room;
import dao.DataAccessObject;

/**Once the guest information has been entered, the agent can then query
hotels for available rooms on specified dates. That is, the agent
enters one or all of the following: startDate, endDate, hotelName,
city, room price, and room type. For any entry that is left blank,
the corresponding condition is not applied (e.g., if city is left
blank, all cities are considered).
* 
* @author Agent
*/
public class DisplayHotelNames extends HttpServlet
{
	
	public DisplayHotelNames()
	{
		
	}
	
	public void init() throws ServletException 
	{		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		/* Redirect to display hotels form. */
		ArrayList<String> hotelnamelist;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		hotelnamelist = (ArrayList<String>) session.getAttribute("hotelnamelist");
		out.println("The available hotels are ...");
		out.println(hotelnamelist.get(0));
		out.println(hotelnamelist.get(1));
	}
}
