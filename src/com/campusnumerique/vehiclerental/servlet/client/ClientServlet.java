package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.campusnumerique.vehiclerental.entity.Client;

import java.util.List;

import com.campusnumerique.vehiclerental.dao.ClientDAO;

/**
 * Servlet implementation class MyServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    
    private ClientDAO clientDAO = null;
    
    public ClientServlet() throws ClassNotFoundException {
        super();
        clientDAO= new ClientDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page booking */

		try {
			List<Client> clients = clientDAO.findAll();
			request.setAttribute("clients", clients);
			response.setStatus(HttpServletResponse.SC_OK);
			this.getServletContext().getRequestDispatcher("/pages/clients.jsp").forward(request, response);
		} catch (SQLException e) {

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
