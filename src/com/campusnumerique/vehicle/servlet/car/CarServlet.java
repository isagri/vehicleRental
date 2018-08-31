package com.campusnumerique.vehicle.servlet.car;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.campusnumerique.vehiclerental.entity.Car;

import java.util.List;

import com.campusnumerique.vehiclerental.dao.CarDAO;

/**
 * Servlet implementation class MyServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    
    private CarDAO carDAO = null;
    
    public CarServlet() throws ClassNotFoundException {
        super();
        carDAO= new CarDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page booking */

		try {
			List<Car> cars = carDAO.findAll();
			request.setAttribute("cars", cars);
			response.setStatus(HttpServletResponse.SC_OK);
			this.getServletContext().getRequestDispatcher("/pages/cars.jsp").forward(request, response);
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
