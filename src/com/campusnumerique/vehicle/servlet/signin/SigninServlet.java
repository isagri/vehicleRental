package com.campusnumerique.vehicle.servlet.signin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.BookingDAO;
import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;

public class SigninServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO = null;
	public static final String VUE = "/pages/signin.jsp";

	public static final String CHAMP_FIRSTNAME = "firstName";
	public static final String CHAMP_LASTNAME = "lastName";
	public static final String CHAMP_PASSWORD = "password";
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";

	public SigninServlet() throws ClassNotFoundException {
		super();
		clientDAO = new ClientDAO();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();

		String firstName = request.getParameter(CHAMP_FIRSTNAME);
		String lastName = request.getParameter(CHAMP_LASTNAME);
		String password = request.getParameter(CHAMP_PASSWORD);

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

		Client client = null;
		try {
			client = clientDAO.findName(firstName, lastName);
		} catch (Exception e) {
			erreurs.put(CHAMP_FIRSTNAME, "Client inexistant : merci de vous inscrire");
		}
		

		if (client != null) {

			if (!password.equals(client.getPassword()))
				erreurs.put(CHAMP_PASSWORD, "Mot de passe invalide");
		}

		if (erreurs.isEmpty()) {
			ClientBean clientBean = new ClientBean();
			clientBean.setFirstName(firstName);
			clientBean.setLastName(lastName);
			clientBean.setId(client.getId());
			clientBean.setGuest(client.isGuest());
			
			HttpSession session = request.getSession();

			session.setAttribute("clientBean", clientBean);

			this.getServletContext().getRequestDispatcher("/homePage").forward(request, response);
		} else {
			/* Stockage du résultat et des messages d'erreur dans l'objet request */
			resultat = "Echec de la connexion";
			request.setAttribute(ATT_ERREURS, erreurs);
			request.setAttribute(ATT_RESULTAT, resultat);

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
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


	
}
