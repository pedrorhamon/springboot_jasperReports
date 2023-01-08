package com.starking.jasper;

import java.sql.Connection;
import java.sql.SQLException;

import com.starking.jasper.services.JasperService;



public class JasperApplication {

	public static void main(String[] args) throws SQLException {
//		abrirJrxml("01");
//		exportarParaPdf("18", "E:\\dev\\projetos\\" + "jasper-" + UUID.randomUUID() + ".pdf");
		//abrirJasper("09");
		abrirJasperSubRelatorio("10");
	}
	
	private static void abrirJasperSubRelatorio(String arquivo) throws SQLException {
		Connection connection = JdbcConnection.connection();
		JasperService service = new JasperService();
		service.addParams("SUB_REPORT_DIR", "relatorios/jasper/");
		service.abrirPontoJasper("relatorios/jasper/funcionario-" + arquivo + ".jasper", connection);
		connection.close();
	}

//	private static void abrirJasper(String arquivo) throws SQLException {
//		Connection connection = JdbcConnection.connection();
//		JasperService service = new JasperService();
//		service.abrirPontoJasper("relatorios/jasper/funcionario-" + arquivo + ".jasper", connection);
//		connection.close();
//	}

//	private static void exportarParaPdf(String numero, String saida) throws SQLException {
//		Connection connection = JdbcConnection.connection();
//		JasperService service = new JasperService();
//		service.exportarPDF("relatorios/jrxml/funcionario-" + numero + ".jrxml", connection, saida);
//		connection.close();
//	}

//	private static void abrirJrxml(String numero) throws SQLException {
//		Connection connection = JdbcConnection.connection();
//		JasperService service = new JasperService();
////		service.addParams("NIVEL_DESC", "JUNIOR");
////		service.addParams("UF", "SP");
//		service.abrirJasperViewer("relatorios/jrxml/funcionario-" + numero + ".jrxml", connection);
//		connection.close();
//	}

}
