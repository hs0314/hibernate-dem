package me.heesu.hibernatedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/sys?useSSL=false";
		String user = "user";
		String password = "user";

		try{
			System.out.println("Connecting to db : " + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl,user,password);

		}catch(Exception e){

		}


		SpringApplication.run(HibernateDemoApplication.class, args);
	}

}
