package com.campusnumerique.vehiclerental.entity;

import java.util.ArrayList;
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
	private float estimatedPrice;
	private int realDistance;
	private float realPrice;
	
	public Booking(){
	}
	
	public Booking(Client client, Date startDate, Date endDate, int estimatedDistance) {
		super();
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
		this.estimatedDistance = estimatedDistance;
		
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


	public float getEstimatedPrice() {
		return estimatedPrice;
	}


	public void setEstimatedPrice() {
		
		this.estimatedPrice = car.getPrice() + (car.getKilometerRate() * estimatedDistance);
	}


	public int getRealDistance() {
		return realDistance;
	}


	public void setRealDistance(int realDistance) {
		this.realDistance = realDistance;
	}


	public float getRealPrice() {
		return realPrice;
	}


	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}

	public void setClient(String firstName) {
		// TODO Auto-generated method stub
		
	}


}
