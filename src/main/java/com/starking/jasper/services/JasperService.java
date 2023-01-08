package com.starking.jasper.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class JasperService {
	
	private Map<String, Object> params = new HashMap<>();
	
	public void addParams(String key, Object value) {
		this.params.put(key, value);
	}
	
	public void abrirJrmxlSubReport(String arqMaster, String arqSub, Connection connection) {
		try {
			JasperReport subReport = compilarJrxml(arqSub);
			this.params.put("SUB_REPORT_PARAM", subReport);
			
			JasperReport masterReport = compilarJrxml(arqMaster);
			
			JasperPrint print = JasperFillManager.fillReport(masterReport, this.params, connection);
			JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public void abrirJasperViewer(String jrxml, Connection connection) {
		JasperReport report = compilarJrxml(jrxml);
		try {
			JasperPrint print = JasperFillManager.fillReport(report, this.params, connection);
			JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public void abrirPontoJasper(String jasperFile, Connection connection) {
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream(jasperFile);
			JasperPrint print = JasperFillManager.fillReport(is, this.params, connection);
			JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public void exportarPDF(String jrxml, Connection connection, String saida) {
		JasperReport report = compilarJrxml(jrxml);
		try {
			OutputStream out = new FileOutputStream(saida);
			JasperPrint print = JasperFillManager.fillReport(report, this.params, connection);
			JasperExportManager.exportReportToPdfStream(print, out);
		}catch (JRException e) {
			e.printStackTrace();
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} 
	}
	
	private JasperReport compilarJrxml(String arquivo) {
		InputStream is = getClass().getClassLoader().getResourceAsStream(arquivo);
		try {
			return JasperCompileManager.compileReport(is);
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}
}
