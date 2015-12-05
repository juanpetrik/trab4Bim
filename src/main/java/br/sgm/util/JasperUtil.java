package br.sgm.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import br.sgm.conexao.ConexaoMysql;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class JasperUtil {

	public static void geraRelatorioEmPdfConsulta(String SQL, String jasper, String nomeRelatorio) {
		try {
			String saida = null;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("SQL", SQL);

			InputStream jasperTemplate = JasperUtil.class.getClass().getResourceAsStream(jasper);

			JasperPrint print = JasperFillManager.fillReport(jasperTemplate, map, ConexaoMysql.getConexaoBD());
			saida = "C:\\" + nomeRelatorio + ".pdf";
			JasperExportManager.exportReportToPdfFile(print, saida);
			JOptionPane.showMessageDialog(null, "<html>Arquivo exportado para PDF!<br><br>A aplicação vai pedir"
					+ " ao Sistema operacional <br>para abrir com o visualizador" + " padrão.");

			Desktop.getDesktop().open(new File(saida));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
