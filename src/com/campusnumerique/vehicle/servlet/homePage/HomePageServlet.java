package com.campusnumerique.vehicle.servlet.homePage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.dao.CarDAO;



public class HomePageServlet extends HttpServlet {
    /**
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO=null;
    private CarDAO carDAO=null;
	public static final String VUE = "/pages/homePage.jsp";
	public static final String VUEPOST = "/pages/booking.jsp";

	
	public static final String CHAMP_FIRSTNAME = "firstName";
	public static final String CHAMP_LASTNAME = "lastName";
	public static final String CHAMP_STARTDATE = "startDate";
	public static final String CHAMP_ENDDATE = "endDate";
	public static final String CHAMP_ESTIMATEDDISTANCE = "estimatedDistance";

	
/*    public HomePageServlet() throws ClassNotFoundException {
        super();
        clientDAO= new ClientDAO();
        carDAO= new CarDAO();

    }
*/
	
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
         /*Affichage de la page d'inscription */
    	
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	/* Affichage de la vue booking au post du formulaire*/
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/booking");
        rd.forward(request,response);

        /* Récupérations des champs du formulaire */
    	
    	String firstName = request.getParameter( CHAMP_FIRSTNAME );
    	String lastName = request.getParameter( CHAMP_LASTNAME );
    	String startDate = request.getParameter( CHAMP_STARTDATE ); 
    	String endDate = request.getParameter( CHAMP_ENDDATE ); 
    	String estimatedDistance = request.getParameter( CHAMP_ESTIMATEDDISTANCE );
    	

    	try {
    		validationFirstName(firstName);
    		validationLastName(lastName);
    		validationStartDate(startDate);
    		validationEndDate(endDate);
    		validationEstimatedDistance(estimatedDistance);
    	} catch (Exception e) {
    		/* Gérer les erreurs de validation ici*/
    	}
/*
    	System.out.println(firstName);
    	System.out.println(lastName);
    	System.out.println(startDate);
    	System.out.println(endDate);
    	System.out.println(estimatedDistance);
    	
    	
    	Client client=null;
    	try {
    		client = clientDAO.findName(firstName, lastName);
    	} catch (Exception e) {
    		
    	}
    	System.out.println(client.getFirstName());
    	System.out.println(client.getLastName());
    	System.out.println(client.getBirthDate());
    	System.out.println(client.getLicenceNumber());
  */  	
		
    	
    	
 
    }
    
    private void  validationFirstName( String firstName ) throws Exception{
    	if (firstName == null ){	
    		throw new Exception("merci de renseigner votre prénom");
    	}
    }
    private void validationLastName( String lastName ) throws Exception {
    	if (lastName == null ){	
    		throw new Exception("merci de renseigner votre prénom");
    	}
    }
    private void validationStartDate( String startDate ) throws Exception {
    	
    }
    private void validationEndDate( String endDate ) throws Exception {
    	
    }
    private void validationEstimatedDistance ( String estimatedDistance ) throws Exception {
    	
    }
    
    
    
}