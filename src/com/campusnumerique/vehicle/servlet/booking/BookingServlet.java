package com.campusnumerique.vehicle.servlet.booking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;

import java.util.ArrayList;
import java.util.List;

import com.campusnumerique.vehiclerental.dao.BookingDAO;
import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.ClientDAO;

public class BookingServlet extends HttpServlet {
	/**
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;

	private ClientDAO clientDAO=null;
    private CarDAO carDAO=null;
    private BookingDAO bookingDAO=null;
	
	

	public BookingServlet() throws ClassNotFoundException {
		super();
		clientDAO= new ClientDAO();
        carDAO= new CarDAO();
        bookingDAO= new BookingDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Affichage de la page booking */
		int idClient = Integer.parseInt((String) request.getAttribute("idClient"));
		String startDate = (String) request.getAttribute("startDate");
		String endDate = (String) request.getAttribute("endDate");
		String estimatedDistance = (String) request.getAttribute("estimatedDistance");
		
		System.out.println(" id_client");
		System.out.println(idClient);
		System.out.println(" startDate");
		System.out.println(startDate);
		System.out.println("endDate");
		System.out.println(endDate);
		
		
		Client client=null;
    	try {
    		client = clientDAO.find(idClient);
    	} catch (Exception e) {
    		
    	}
		
		List<Car> cars=new ArrayList<Car>();
    	try {
    		
    		
    		cars = carDAO.availableCar(client.getAge(), startDate, endDate, estimatedDistance); // ajouter estimatedDistance dans DAO
    	} catch (Exception e) {
    		
    	}
		
    	for (Car car : cars) {
			System.out.print(car.getBrand());
			System.out.print("  ");
			System.out.println(car.getHorsePower());
		}
    	

    	
		request.setAttribute("cars", cars);
//		request.setAttribute("idClient", String.valueOf(client.getId()));
//		request.setAttribute("startDate", startDate);
//		request.setAttribute("endDate", endDate);
//		request.setAttribute("estimatedDistance", estimatedDistance);
//		response.setStatus(HttpServletResponse.SC_OK);
		this.getServletContext().getRequestDispatcher("/pages/booking.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		
	}

}