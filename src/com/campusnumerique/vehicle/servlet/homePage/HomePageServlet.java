package com.campusnumerique.vehicle.servlet.homePage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
	
	public static final String CHAMP_FIRSTNAME = "firstName";
	public static final String CHAMP_LASTNAME = "lastName";
	public static final String CHAMP_STARTDATE = "startDate";
	public static final String CHAMP_ENDDATE = "endDate";
	public static final String CHAMP_ESTIMATEDDISTANCE = "estimatedDistance";

	
    public HomePageServlet() throws ClassNotFoundException {
        super();
        clientDAO= new ClientDAO();
        carDAO= new CarDAO();

    }

	
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
         /*Affichage de la page d'inscription */
    	
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        /* Récupérations des champs du formulaire */
    	
    	String firstName = request.getParameter( CHAMP_FIRSTNAME );
    	String lastName = request.getParameter( CHAMP_LASTNAME );
    	Date startDate = new Date(request.getParameter( CHAMP_STARTDATE )); 
    	Date endDate = new Date(request.getParameter( CHAMP_ENDDATE )); 
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
    	
		List<Car> cars=null;
		
    	try {
    		cars = carDAO.availableCarAll(startDate, endDate);
    	} catch (Exception e) {
    		
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
    private void validationStartDate( Date startDate ) throws Exception {
    	
    }
    private void validationEndDate( Date endDate ) throws Exception {
    	
    }
    private void validationEstimatedDistance ( String estimatedDistance ) throws Exception {
    	
    }
    
    
    
}