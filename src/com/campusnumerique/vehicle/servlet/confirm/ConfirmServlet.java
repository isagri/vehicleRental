package com.campusnumerique.vehicle.servlet.confirm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    	
    	String idCar = request.getParameter( "choice" );
    	System.out.println("car choisi");
    	System.out.println(idCar);
    	
 	
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	doGet(request, response);
    }
    
}