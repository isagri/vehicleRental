package com.campusnumerique.vehiclerental.bean;

public class ClientBean  {

	private int id;
	private String login;
	private String firstName;
	private String lastName;
	private String mail;
	private String birthDate;
	private String licenceDate;
	private boolean isGuest=false;

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(String licenceDate) {
		this.licenceDate = licenceDate;
	}

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public ClientBean(){
		setLogin("NoUserLogin");
	}

	public ClientBean(String login){
		setLogin(login);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
