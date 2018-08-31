package com.campusnumerique.vehicle.servlet.booking;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.campusnumerique.vehiclerental.entity.Car;

import java.util.List;

import com.campusnumerique.vehiclerental.dao.CarDAO;

public class BookingServlet extends HttpServlet {
	/**
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;

	private CarDAO carDAO = null;
	
	

	public BookingServlet() throws ClassNotFoundException {
		super();
		carDAO = new CarDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Affichage de la page booking */

		try {
			List<Car> cars = carDAO.findAll();
			request.setAttribute("cars", cars);
			response.setStatus(HttpServletResponse.SC_OK);
			this.getServletContext().getRequestDispatcher("/pages/booking.jsp").forward(request, response);
		} catch (SQLException e) {

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}