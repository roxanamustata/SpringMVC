package app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class User {
	private int userId;
	@Size(min = 5, max = 10, message = "Enter the name between 5 to 10 characters")
	private String name;
	
	private String gender;
	private String country;
	
	@Email
	private String email;
	
	private String[] visitedCountries;
	
	
	
	
	public User() {
		
	}
	public User(int userId, @Size(min = 5, max = 10, message = "Enter the name between 5 to 10 characters") String name,
			String gender, String country, @Email String email) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.country = country;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String[] getVisitedCountries() {
		return visitedCountries;
	}
	public void setVisitedCountries(String[] visitedCountries) {
		this.visitedCountries = visitedCountries;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", gender=" + gender + ", country=" + country + ", email="
				+ email + "]";
	}
	
	
	
}
