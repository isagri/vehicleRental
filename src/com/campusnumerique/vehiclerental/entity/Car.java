package com.campusnumerique.vehiclerental.entity;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

public class Car {

	private int id;
	private String brand;
	private String model;
	private String plateNumber;
	private String color;
	private float price;
	private float kilometerRate;
	private int horsePower;
	private float bookingPrice;
	
	
	
	public Car(){
		
	}
	
	public Car(int id, String brand, String model, String plateNumber, String color, float price, float kilometerRate, int horsePower){
		setId(id);
		setBrand(brand);
		setModel(model);
		setPlateNumber(plateNumber);
		setColor(color);
		setPrice(price);
		setKilometerRate(kilometerRate);
		setHorsePower(horsePower);
		
	}

	public Car(int id, String brand, String model, String plateNumber, String color, float price, float kilometerRate, int horsePower, float bookingPrice){
		setId(id);
		setBrand(brand);
		setModel(model);
		setPlateNumber(plateNumber);
		setColor(color);
		setPrice(price);
		setKilometerRate(kilometerRate);
		setHorsePower(horsePower);
		setBookingPrice(bookingPrice);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getBookingPrice() {
		return bookingPrice;
	}

	public void setBookingPrice(float bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	public float getKilometerRate() {
		return kilometerRate;
	}

	public void setKilometerRate(float kilometerRate) {
		this.kilometerRate = kilometerRate;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("brand", brand);
		infos.put("id", id);
		infos.put("model", model);
		infos.put("plateNumber", plateNumber);
		infos.put("horsePower", horsePower);
		infos.put("color", color);
		infos.put("price", price);
		infos.put("kilometerRate", kilometerRate);
		return infos;
	}
	
}