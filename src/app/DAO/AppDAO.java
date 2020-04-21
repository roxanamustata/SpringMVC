package app.DAO;

import java.util.List;

import app.model.User;

public interface AppDAO {

	public List<User> listUsers();
	public void addUser(User user);

}
