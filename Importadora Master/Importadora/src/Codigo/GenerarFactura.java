/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Month;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarFactura {
	
	public void crearPdf(String nombreArchivo,String numeroFactura,String nombreCliente,String Nit,int strCant, String strPr, int strpreUni, int strTot) throws FileNotFoundException, DocumentException{
		Document documento = new Document();

		FileOutputStream ficheroPdf = new FileOutputStream(nombreArchivo + ".pdf");
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(100);
		documento.addTitle("Primer PDF");
		documento.open();
		String numFactura = "Factura N: " + numeroFactura;
		String fecha = "";
		String Nombre = "Nombre: " + nombreCliente;
		String nit = "Nit/Ci: " + Nit;
		
		
		documento.add(new Paragraph("               IMPORTADORA TODO COMPRA",FontFactory.getFont("arial",22,Font.ITALIC,BaseColor.DARK_GRAY)));
		documento.add(new Paragraph(numFactura,FontFactory.getFont("arial",18,Font.ITALIC,BaseColor.DARK_GRAY)));
		documento.add(new Paragraph(" "));
		documento.add(new Paragraph(Nombre + "                                   " + nit,FontFactory.getFont("arial",18,Font.ITALIC,BaseColor.DARK_GRAY)));
		documento.add(new Paragraph(" "));
                documento.add(new Paragraph(" "));
                documento.add(new Paragraph(" "));
                documento.add(new Paragraph(" "));
		
		PdfPTable tabla = new PdfPTable(4);
		tabla.addCell("CANTIDAD");
		tabla.addCell("DESCRIPCION");
		tabla.addCell("PRECIO UNITARIO");
		tabla.addCell("TOTAL");
                tabla.addCell(""+strCant);
                tabla.addCell(strPr);
                tabla.addCell(""+strpreUni);
                tabla.addCell(""+strTot);
		
		documento.add(tabla);
                documento.add(new Paragraph(" "));
                documento.add(new Paragraph(" "));
                documento.add(new Paragraph(""));
		documento.close();
                
                try {
		     File path = new File (nombreArchivo + ".pdf");
		     Desktop.getDesktop().open(path);
		}catch (IOException ex) {
		     ex.printStackTrace();
		}
	}
}