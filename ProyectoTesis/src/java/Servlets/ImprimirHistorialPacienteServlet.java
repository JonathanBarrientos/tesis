/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HistorialClinico.SOAP;
import static HistorialClinico.prueba1.archivo;
import Principal.Mensaje;
import Principal.Usuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "ImprimirHistorialPacienteServlet", urlPatterns = {"/ImprimirHistorialPacienteServlet"})
public class ImprimirHistorialPacienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        
    
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Usuario usu = (Usuario)request.getSession().getAttribute("usuario");
        String paciente = usu.getNombre();
         List<Mensaje> mensajes = (List<Mensaje>)request.getSession().getAttribute("listaMensaje");
        
        
             Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
            try {
                //writer es declarado como el método utilizado para escribir en el archivo.
                OutputStream file = new FileOutputStream(new File("C:\\Users\\USER\\Documents\\Ulima 2017-2\\Tesis 2\\Ayuda Aplicacion\\usuario.pdf"));
                //C:\Users\USER\Documents\Ulima 2017-2\Tesis 2\Ayuda Aplicacion\Impresiones
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SOAP.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        PdfWriter writer = null;

        try{
            //Obtenemos la instancia del archivo a utilizar.
            writer = PdfWriter.getInstance(documento, new FileOutputStream(archivo));
           }catch(FileNotFoundException | DocumentException ex){
            ex.getMessage();
        }

        //Agregamos un título al documento.
        documento.addTitle("Historial Clinico Basado en problema");
        //Abrimos el documento a editar.
        documento.open();
        
        //Creamos un párrafo nuevo llamado "vacio1" para espaciar los elementos.
        Paragraph vacio1 = new Paragraph();
        vacio1.add("\n\n");
        try {
            documento.add(vacio1);
        } catch (DocumentException ex) {
            Logger.getLogger(ImprimirHistorialPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
        Paragraph titulo = new Paragraph();
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.RED));
        titulo.add("Lista de mensajes del paciente " + paciente);
        
        
        //Creamos un párrafo nuevo llamado "saltolinea" simulando un salto de linea para espaciar
        //los elementos del PDF.
        Paragraph saltolinea = new Paragraph();
        saltolinea.add("\n\n");
        try {
            documento.add(saltolinea);
        } catch (DocumentException ex) {
            Logger.getLogger(ImprimirHistorialPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        //Creamos una tabla tabla en donde irá el contenido del PDF.
        float[] mediaCeldas ={3.30f,3.50f,3.50f,3.70f,3.70f,3.50f};
        PdfPTable tabla = new PdfPTable(6);
        
        try {
            tabla.setWidths(mediaCeldas);
        } catch (DocumentException ex) {
            Logger.getLogger(ImprimirHistorialPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla.addCell(new Paragraph("Mensaje del usuario", FontFactory.getFont("Arial",12)));
        tabla.addCell(new Paragraph("Termino", FontFactory.getFont("Arial",12)));
        tabla.addCell(new Paragraph("Hora registrada", FontFactory.getFont("Arial",12)));
        
        
        
        for (Mensaje mes : mensajes){
           tabla.addCell(new Paragraph(mes.getMensaje(), FontFactory.getFont("Arial",10)));                  
             tabla.addCell(new Paragraph(mes.getTermino(), FontFactory.getFont("Arial",10)));
             tabla.addCell(new Paragraph(mes.getTiempo().toString(), FontFactory.getFont("Arial",10)));
       
        
               }
        
        try {
            documento.add(tabla);
        } catch (DocumentException ex) {
            Logger.getLogger(ImprimirHistorialPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cerramos el documento.
        documento.close();
        //Cerramos el writer.
        writer.close();
        
      
        
        
        try{
          File file1 = new File("C:\\Users\\USER\\Documents\\Ulima 2017-2\\Tesis 2\\Ayuda Aplicacion\\usuario.pdf");
          Desktop.getDesktop().open(file1);
       }   
      catch (Exception e){
        e.printStackTrace();
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
