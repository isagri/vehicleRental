package com.campusnumerique.vehicle.servlet.confirm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.campusnumerique.vehiclerental.entity.Booking;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.BookingDAO;



public class ConfirmServlet extends HttpServlet {
    /**
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO=null;
    private CarDAO carDAO=null;
    private BookingDAO bookingDAO=null;
	public static final String VUE = "/pages/homePage.jsp";
	public static final String VUEPOST = "/pages/booking.jsp";

	
	public static final String CHAMP_FIRSTNAME = "firstName";
	public static final String CHAMP_LASTNAME = "lastName";
	public static final String CHAMP_STARTDATE = "startDate";
	public static final String CHAMP_ENDDATE = "endDate";
	public static final String CHAMP_ESTIMATEDDISTANCE = "estimatedDistance";
	public static final String CHAMP_IDCLIENT = "id_client";

	
    public ConfirmServlet() throws ClassNotFoundException {
        super();
        clientDAO= new ClientDAO();
        carDAO= new CarDAO();
        bookingDAO= new BookingDAO();
    }

	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

         /*Affichage de la page d'inscription */

    	HttpSession session = request.getSession(false);
      
	    Booking booking = (Booking) session.getAttribute("booking");
	    System.out.println("session");
	    System.out.println(booking.getClient().getFirstName());
	    System.out.println(booking.getStartDate());
    	
    	String idCar = request.getParameter( "choice" );
    	System.out.println("car choisi");
    	System.out.println(idCar);
    	
		Car car = null;
		try {
			car = carDAO.find(Integer.parseInt(idCar));
		} catch (Exception e) {

		}
		
		booking.setCar(car);
		
		try {
			bookingDAO.createBooking(booking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	doGet(request, response);
    }
    
}