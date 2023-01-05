package com.starking.jasper;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class JasperApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperApplication.class, args);
		abrirJrxml("01");
	}

	private static void abrirJrxml(String string) {
		Connection connection = JdbcConnection.connection();
	}

}
