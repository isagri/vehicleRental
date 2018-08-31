package com.campusnumerique.vehiclerental.entity;

import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

public class Client {

	private int id;
	private String login;
	private String firstName;
	private String lastName;
	private String mail;
	private Date birthDate;
	private Date licenceDate;
	private String licenceNumber;
	private boolean isGuest = false;
	long milliBirth;

	public Client() {
		setLogin("guest");
		setGuest(true);
	}

	public Client(int id, String login, String firstName, String lastName, String mail, Date birthDate,
			Date licenceDate, String licenceNumber, boolean isGuest) {
		setId(id);
		setLogin(login);
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setBirthDate(birthDate);
		setLicenceDate(licenceDate);
		setLicenceNumber(licenceNumber);
		setGuest(false);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if (login != null && !login.equals(""))
			this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JSONObject getInfos() {
		JSONObject infos = new JSONObject();
		infos.put("login", login);
		infos.put("id", id);
		infos.put("firstName", firstName);
		infos.put("lastName", lastName);
		infos.put("mail", mail);
		infos.put("isGuest", isGuest);
		return infos;
	}

	public String toString() {
		return getInfos().toString();
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public long getAge() {

		long millis = System.currentTimeMillis();
		long date = getBirthDate().getTime();
		long age = (long) ((millis - date) * 3.1709791983765E-11);
		

		return age;
	}

}