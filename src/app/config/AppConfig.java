package app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import app.DAO.AppDAOImpl;

@Configuration
public class AppConfig {

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springmvc?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("roxi19");

		return dataSource;

	}

	@Bean(name = "DAOBean")
	public AppDAOImpl getAppDAOImpl() {
		return new AppDAOImpl(getDataSource());
	}

}
