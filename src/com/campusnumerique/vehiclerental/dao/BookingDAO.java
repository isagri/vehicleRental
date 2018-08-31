package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import com.campusnumerique.vehiclerental.entity.Booking;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Car;

public class BookingDAO extends DAO<Booking>{

	@Override
	public boolean create(Booking obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Booking obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Booking obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existClientDate(Client client, String startDate, String endDate) throws SQLException{

		String requete = "SELECT * FROM booking WHERE id_client = " + client.getId() + " AND '" + startDate + "'<= endDate AND '" + endDate + "'>= startDate"; 

		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery(requete);
		
		if (result.first()) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public Booking find(int id) throws SQLException{
		Booking booking = new Booking();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM booking WHERE id = " + id);
		if(result.first())
			booking = new Booking(result.getInt("id"),(Client) result.getObject("id_client"), (Car) result.getObject("id_car"), result.getDate("startDate"), result.getDate("endDate"), result.getInt("estimatedDistance"), result.getFloat("estimatedPrice"), result.getInt("realDistance"), result.getFloat("realPrice"));    

		return booking;
	}


	
	
	@Override
	public List<Booking> findAll() throws SQLException{
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM booking");
		while(result.next()){
			Booking booking = new Booking(); 
			booking = new Booking(result.getInt("id"),(Client) result.getObject("id_client"), (Car) result.getObject("id_car"), result.getDate("startDate"), result.getDate("endDate"), result.getInt("estimatedDistance"), result.getFloat("estimatedPrice"), result.getInt("realDistance"), result.getFloat("realPrice"));    
			bookings.add(booking);
		}
		return bookings;
	}


}
