package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Client;



public class ClientDAO extends DAO<Client> {

	@Override
	public boolean create(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client find(int id) throws SQLException {
		Client client = new Client();

		ResultSet result = this.connection
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeQuery("SELECT * FROM client WHERE id = " + id);
		if (result.first())
			client = new Client(result.getInt("id"), result.getString("login"), result.getString("firstName"),
					result.getString("lastName"), result.getString("mail"), result.getDate("birthDate"),
					result.getDate("licenceDate"), result.getString("licenceNumber"), result.getBoolean("isGuest"),
					result.getString("password"));

		return client;
	}

	public Client findName(String firstName, String lastName) throws SQLException {
		Client client = null;
		String requete = "SELECT * FROM client WHERE firstname = '" + firstName + "' AND lastname = '" + lastName + "'";

		ResultSet result = this.connection
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(requete);

		if (result.first()) {
			client = new Client(result.getInt("id"), result.getString("login"), result.getString("firstName"),
					result.getString("lastName"), result.getString("mail"), result.getDate("birthDate"),
					result.getDate("licenceDate"), result.getString("licenceNumber"), result.getBoolean("isGuest"),
					result.getString("password"));
		}
		return client;
	}

	@Override
	public List<Client> findAll() throws SQLException {
		ArrayList<Client> clients = new ArrayList<Client>();
		ResultSet result = this.connection
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeQuery("SELECT * FROM client");
		while (result.next()) {
			Client client = new Client(result.getInt("id"), result.getString("login"), result.getString("firstName"),
					result.getString("lastName"), result.getString("mail"), result.getDate("licenceDate"),
					result.getDate("birthDate"), result.getString("licenceNumber"), result.getBoolean("isGuest"),
					result.getString("password"));
			clients.add(client);
		}
		return clients;
	}

	public JSONArray findAllAsJson() {
		JSONArray clients = new JSONArray();
		ResultSet result;
		try {
			result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM client");
			while (result.next()) {
				Client client = new Client(result.getInt("id"), result.getString("login"),
						result.getString("firstName"), result.getString("lastName"), result.getString("mail"),
						result.getDate("licenceDate"), result.getDate("birthDate"), result.getString("licenceNumber"),
						result.getBoolean("isGuest"), result.getString("password"));
				clients.put(client.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
	

	public void createClient(Client client) throws SQLException {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO client (login, firstName, lastName, mail, birthDate, licenceDate, licenceNumber, password) VALUES (?,?,?,?,?,?,?,?)";

		preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		
		preparedStatement.setString(1, client.getLogin());
		preparedStatement.setString(2, client.getFirstName());
		preparedStatement.setString(3, client.getLastName());
		preparedStatement.setString(4, client.getMail());
		preparedStatement.setDate(5, java.sql.Date.valueOf(dateFormatter.format(client.getBirthDate())));
		preparedStatement.setDate(6, java.sql.Date.valueOf(dateFormatter.format(client.getLicenceDate())));
		preparedStatement.setString(7, client.getLicenceNumber());
		preparedStatement.setString(8, client.getPassword());

		preparedStatement.executeUpdate();

	}

}
