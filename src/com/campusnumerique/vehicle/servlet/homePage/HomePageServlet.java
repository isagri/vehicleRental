package com.campusnumerique.vehicle.servlet.homePage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


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

	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	String today = dtf.format(localDate);
	

	
	
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
    	
    	Date currentDate = null;
		try {
			currentDate = sdf.parse(today);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	System.out.println(currentDate);
    	
    	System.out.println(startDate);

    	
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