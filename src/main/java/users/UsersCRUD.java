package users;
import java.io.FileInputStream;
import java.sql.*;

import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UsersCRUD {
	// connection

	public Connection getConnection() throws Exception{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream =new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("userName"),properties.getProperty("password")  );
	
		return connection;
		}

	// Sign up method

	public void signUpUser(Users users) throws Exception {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, users.getId());
		preparedStatement.setString(2, users.getUsername());
		preparedStatement.setString(3, users.getEmail());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getFacebookpassword());
		preparedStatement.setString(6, users.getInstapassword());
		preparedStatement.setString(7, users.getSnapchatpassword());
		preparedStatement.setString(8, users.getWhatsappassword());
		preparedStatement.setString(9, users.getTwitterpassword());

		// to execute

		preparedStatement.execute();
		connection.close();
		System.out.println("inserted");

	}

	public boolean loginUser(Users users) throws Exception {
		String query = "SELECT * FROM USERS WHERE USERMAIL=?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, users.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();

		String password = null;

		while (resultSet.next()) {
			password = resultSet.getString("userPassword");

		}
		if (password.equals(users.getPassword())) {
			return true;
		}

		return false;
	}
	
	 public void facebook(String email) throws Exception
	 {
		 Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT FACEBOOKPASSWORD FROM USERS WHERE USERMAIL=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("Facebook password is : "+resultSet.getString("facebookpassword"));
			}
			
			connection.close();
			
	 }

	public int signupFacebook(String email, String facebookpassword) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USERS SET FACEBOOKPASSWORD=? WHERE USERMAIL=?");
		preparedStatement.setString(1, facebookpassword);
		preparedStatement.setString(2, email);

		int saved=preparedStatement.executeUpdate();

		connection.close();
		return saved;
	}
	public void instagram(String email) throws Exception
	 {
		 Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT INSTAGRAMPASSWORD FROM USERS WHERE USERMAIL=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("Instagram password is : "+resultSet.getString("instagrampassword"));
			}
			
			connection.close();
			
	 }	 
	public int signupInsta(String email, String instapassword) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USERS SET INSTAGRAMPASSWORD=? WHERE USERMAIL=?");
		preparedStatement.setString(1, instapassword);
		preparedStatement.setString(2, email);

		int saved = preparedStatement.executeUpdate();

		connection.close();
		return saved;
	}
	
	public void snapchat(String email) throws Exception
	 {
		 Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT SNAPCHATPASSWORD FROM USERS WHERE USERMAIL=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("Snapchat password is : "+resultSet.getString("snapchatPassword"));
			}
			
			connection.close();
			
	 }
		
	public int signupSnapChat(String email, String snapchatpassword) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USERS SET SNAPCHATPASSWORD=? WHERE USERMAIL=?");
		preparedStatement.setString(1, snapchatpassword);
		preparedStatement.setString(2, email);

		int saved = preparedStatement.executeUpdate();

		connection.close();
		return saved;
	}
	public void whatsap(String email) throws Exception
	 {
		 Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT WHATSAPPASSWORD FROM USERS WHERE USERMAIL=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("Whatsap password is : "+resultSet.getString("whatsappassword"));
			}
			
			connection.close();
			
	 }
	public int signupWhatsap(String email, String whatsappassword) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USERS SET WHATSAPPASSWORD=? WHERE USERMAIL=?");
		preparedStatement.setString(1, whatsappassword);
		preparedStatement.setString(2, email);

		int saved = preparedStatement.executeUpdate();

		connection.close();
		return saved;
	}
	public void twitter(String email) throws Exception
	 {
		 Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT TWITTERPASSWORD FROM USERS WHERE USERMAIL=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("Twitter password is : "+resultSet.getString("twitterpassword"));
			}
			
			connection.close();
			
	 }
	public int signupTwitter(String email, String twitterpassword) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE USERS SET TWITTERPASSWORD=? WHERE USERMAIL=?");
		preparedStatement.setString(1, twitterpassword);
		preparedStatement.setString(2, email);

		int saved = preparedStatement.executeUpdate();

		connection.close();
		return saved;
	}
}

