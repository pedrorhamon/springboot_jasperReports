package com.starking.jasper;

import java.sql.Connection;
import java.sql.SQLException;

import com.starking.jasper.services.JasperService;



public class JasperApplication {

	public static void main(String[] args) throws SQLException {
		abrirJrxml("01");
	}

	private static void abrirJrxml(String numero) throws SQLException {
		Connection connection = JdbcConnection.connection();
		JasperService service = new JasperService();
//		service.addParams("NIVEL_DESC", "JUNIOR");
//		service.addParams("UF", "SP");
		service.abrirJasperViewer("relatorios/jrxml/funcionario-" + numero + ".jrxml", connection);
		connection.close();
	}

}
