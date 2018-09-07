package com.campusnumerique.vehiclerental.servlet.signup;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import com.campusnumerique.vehiclerental.entity.Client;

import com.campusnumerique.vehiclerental.dao.ClientDAO;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.BookingDAO;


public class SignUpServlet extends HttpServlet {
	/**
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO = null;
	private CarDAO carDAO = null;
	private BookingDAO bookingDAO = null;
	public static final String VUE = "/pages/signUp.jsp";

	
	public static final String CHAMP_LOGIN = "login";
	public static final String CHAMP_FIRSTNAME = "firstName";
	public static final String CHAMP_LASTNAME = "lastName";
	public static final String CHAMP_PASSWORD = "password";
	public static final String CHAMP_MAIL = "mail";
	public static final String CHAMP_BIRTHDATE = "birthDate";
	public static final String CHAMP_LICENCEDATE = "licenceDate";
	public static final String CHAMP_LICENCENUMBER = "licenceNumber";
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";
	
	

	public SignUpServlet() throws ClassNotFoundException {
		super();
		clientDAO = new ClientDAO();
		carDAO = new CarDAO();
		bookingDAO = new BookingDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		

		/* Affichage de la vue booking au post du formulaire */

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/booking");
		 * rd.forward(request,response);
		 */
		/* Récupérations des champs du formulaire */

		String resultat = null;
		Map<String, String> erreurs = new HashMap<String, String>();

		String login = request.getParameter(CHAMP_LOGIN);
		String firstName = request.getParameter(CHAMP_FIRSTNAME);
		String lastName = request.getParameter(CHAMP_LASTNAME);
		String mail = request.getParameter(CHAMP_MAIL);
		String birthDate = request.getParameter(CHAMP_BIRTHDATE);
		String licenceDate = request.getParameter(CHAMP_LICENCEDATE);
		String licenceNumber = request.getParameter(CHAMP_LICENCENUMBER);
		String password = request.getParameter(CHAMP_PASSWORD);
		
		
		
		
		
		try {
			validationLogin(login);
		} catch (Exception e) {
			erreurs.put(CHAMP_LOGIN, e.getMessage());
		}
		try {
			validationFirstName(firstName);
		} catch (Exception e) {
			erreurs.put(CHAMP_FIRSTNAME, e.getMessage());
		}
		try {
			validationLastName(lastName);
		} catch (Exception e) {
			erreurs.put(CHAMP_LASTNAME, e.getMessage());
		}
		try {
			validationMail(mail);
		} catch (Exception e) {
			erreurs.put(CHAMP_MAIL, e.getMessage());
		}
		try {
			validationBirthDate(birthDate);
		} catch (Exception e) {
			erreurs.put(CHAMP_BIRTHDATE, e.getMessage());
		}
		try {
			validationLicenceDate(licenceDate);
		} catch (Exception e) {
			erreurs.put(CHAMP_LICENCEDATE, e.getMessage());
		}
		try {
			validationLicenceNumber(licenceNumber);
		} catch (Exception e) {
			erreurs.put(CHAMP_LICENCENUMBER, e.getMessage());
		}
		try {
			validationPassword(password);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASSWORD, e.getMessage());
			
		}
		
		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_ERREURS, erreurs);
		request.setAttribute(ATT_RESULTAT, resultat);

		/* Gérer les erreurs de validation ici */

		if (erreurs.isEmpty()) {
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBirth = null;
			try {
				dateBirth = dateFormatter.parse(birthDate);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Date dateLicence = null;
			try {
				dateLicence = dateFormatter.parse(licenceDate);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			
			Client client = new Client(login, firstName, lastName, mail, dateBirth, dateLicence, licenceNumber, password);
			
			try {
				clientDAO.createClient(client);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/login");
	
			rd.forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}

	}

	
	private void validationLogin(String login) throws Exception{
		if (login.trim().length() == 0) {
			throw new Exception("merci de renseigner un identifiant");

		}
		
	}

	private void validationFirstName(String firstName) throws Exception {
		if (firstName.trim().length() == 0) {
			throw new Exception("merci de renseigner votre prénom");
		}
	}

	private void validationLastName(String lastName) throws Exception {
		if (lastName.trim().length() == 0) {
			throw new Exception("merci de renseigner votre nom");
		}
	}
	
	private void validationMail(String mail) throws Exception {
		if(!mail.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")){
			throw new Exception("merci de renseigner une adresse mail valide");
		}
		
	}
	private void validationBirthDate(String birthDate) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currenDate = new Date();
		Date dateStart = null;
		try {
			dateStart = formatter.parse(birthDate);
		} catch (Exception e) {
			throw new Exception("merci de renseigner une date valide");
		}
		int res = dateStart.compareTo(currenDate);
		if (res > 0) {
			throw new Exception("La date de naissance ne peut pas être dans le futur ");

		}
		
	}
	
	private void validationLicenceDate(String licenceDate) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currenDate = new Date();
		Date dateStart = null;
		try {
			dateStart = formatter.parse(licenceDate);
		} catch (Exception e) {
			throw new Exception("merci de renseigner une date valide");
		}
		int res = dateStart.compareTo(currenDate);
		if (res > 0) {
			throw new Exception("La date de permis ne peut pas être dans le futur ");

		}
		
		
	}
	

	private void validationLicenceNumber(String licenceNumber) throws Exception {
		if (licenceNumber.trim().length() < 3 ){
			throw new Exception("Le numéro de permis doit comporter au moins 3 caractères ");

		}
		
	}

	private void validationPassword(String password) throws Exception {
		if (password.trim().length() < 3) {
			throw new Exception("Le mot de passe doit contenir au moins 3 caractères");
		}
		
	}
	
	
	




}