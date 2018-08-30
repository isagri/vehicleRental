package com.campusnumerique.vehicle.servlet.homePage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageServlet extends HttpServlet {
    /**
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/pages/homePage.jsp";
	
	public static final String CHAMP_FIRSTNAME = "firstName";
	public static final String CHAMP_LASTNAME = "lastName";
	public static final String CHAMP_STARTDATE = "startDate";
	public static final String CHAMP_ENDDATE = "endDate";
	public static final String CHAMP_ESTIMATEDDISTANCE = "estimatedDistance";
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
         /*Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
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
    }
    
    private void  validationFirstName( String firstName ) throws Exception{
    	
    }
    private void validationLastName( String lastName ) throws Exception {
    	
    }
    private void validationStartDate( String startDate ) throws Exception {
    	
    }
    private void validationEndDate( String endDate ) throws Exception {
    	
    }
    private void validationEstimatedDistance ( String estimatedDistance ) throws Exception {
    	
    }
    
    
    
}