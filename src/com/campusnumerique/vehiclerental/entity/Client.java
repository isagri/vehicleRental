package com.campusnumerique.vehiclerental.entity;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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
	private String password;
	long milliBirth;
	private String strKey = "toto";
	private String encryptPassword;

	public Client() {
		setLogin("guest");
		setGuest(true);
	}

	public Client(int id, String login, String firstName, String lastName, String mail, Date birthDate,
			Date licenceDate, String licenceNumber, boolean isGuest, String password) {
		setId(id);
		setLogin(login);
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setBirthDate(birthDate);
		setLicenceDate(licenceDate);
		setLicenceNumber(licenceNumber);
		setGuest(false);
		setPassword(password);
	}



	public Client(String login, String firstName, String lastName, String mail, Date birthDate, Date licenceDate, String licenceNumber, String password) {
		setLogin(login);
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setBirthDate(birthDate);
		setLicenceDate(licenceDate);
		setLicenceNumber(licenceNumber);
		setEncryptPassword(password);

	}

	public boolean ableToBook() {
		if (this.getAge() >= 18 && !this.getLicenceNumber().isEmpty() ) {
			return true;
		} else {
			return false;
		}
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

	public int getAge() {

		long millis = System.currentTimeMillis();
		long date = getBirthDate().getTime();
		int age = (int) ((millis - date) * 3.1709791983765E-11);
		

		return age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String encryptPassword(String password){
		 String encrypt = "";
		try {
			encrypt = encrypt(password, this.strKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encrypt;
	}
	
	public void setEncryptPassword(String password){
		try {
			this.password = encrypt(password, this.strKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
	}
	
	public static String encrypt(String password,String strKey) throws Exception{
		String encryptPassword="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(password.getBytes());
			encryptPassword=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return encryptPassword;
	}

}