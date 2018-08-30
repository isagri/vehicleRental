package com.campusnumerique.vehiclerental.entity;

import java.util.Date;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;

public class Booking {
	
	private int id;
	private Client client;
	private Car car;
	private Date startDate;
	private Date endDate;
	private int estimatedDistance;
	private int estimatedPrice;
	private int realDistance;
	private int realPrice;
	
	
	public Booking(int id, Client client, Car car, Date startDate, Date endDate, int estimatedDistance,
			int estimatedPrice, int realDistance, int realPrice) {
		super();
		this.id = id;
		this.client = client;
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedDistance = estimatedDistance;
		this.estimatedPrice = estimatedPrice;
		this.realDistance = realDistance;
		this.realPrice = realPrice;
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getEstimatedDistance() {
		return estimatedDistance;
	}


	public void setEstimatedDistance(int estimatedDistance) {
		this.estimatedDistance = estimatedDistance;
	}


	public int getEstimatedPrice() {
		return estimatedPrice;
	}


	public void setEstimatedPrice(int estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}


	public int getRealDistance() {
		return realDistance;
	}


	public void setRealDistance(int realDistance) {
		this.realDistance = realDistance;
	}


	public int getRealPrice() {
		return realPrice;
	}


	public void setRealPrice(int realPrice) {
		this.realPrice = realPrice;
	}


	
	

}
