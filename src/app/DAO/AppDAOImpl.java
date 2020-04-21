package app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



import app.model.User;

public class AppDAOImpl implements AppDAO {

	private DataSource dataSource;

	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> listUsers() {
		String SQL = "Select * from users";
		List<User> listUsers = new ArrayList<User>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User tempUser = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("gender"),
						rs.getString("country"), rs.getString("email"));
				listUsers.add(tempUser);

			}
			rs.close();
			preparedStatement.close();
			return listUsers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void addUser(User user) {
		String SQL = "INSERT INTO users "+ "(name, email, country, gender) VALUES (?,?,?,?)";
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			PreparedStatement ps=connection.prepareStatement(SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.setString(4, user.getGender());
			ps.execute();
			
			ps.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
	}

}
