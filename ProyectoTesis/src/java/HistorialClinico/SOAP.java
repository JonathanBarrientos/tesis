
package HistorialClinico;

import static HistorialClinico.prueba1.archivo;
import Principal.Mensaje;
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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SOAP {
    
  //    public static String archivo = "C:\\Users\\USER\\Documents\\Ulima 2017-2\\Tesis 2\\Ayuda Aplicacion\\Impresiones//usuario.pdf";
    

        public static void crearPDF(ArrayList<Mensaje> mensajes, String paciente) throws DocumentException{
         //Declaramos un documento como un objecto Document. 
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
        documento.add(vacio1);
        
        
         //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
        Paragraph titulo = new Paragraph();
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.RED));
        titulo.add("Lista de mensajes del paciente " + paciente);
        
        
        //Creamos un párrafo nuevo llamado "saltolinea" simulando un salto de linea para espaciar
        //los elementos del PDF.
        Paragraph saltolinea = new Paragraph();
        saltolinea.add("\n\n");
        documento.add(saltolinea);
        
        
        
        
        //Creamos una tabla tabla en donde irá el contenido del PDF.
        float[] mediaCeldas ={3.30f,3.50f,3.50f,3.70f,3.70f,3.50f};
        PdfPTable tabla = new PdfPTable(6);
        
        tabla.setWidths(mediaCeldas);
        tabla.addCell(new Paragraph("Mensaje del usuario", FontFactory.getFont("Arial",12)));
        tabla.addCell(new Paragraph("Termino", FontFactory.getFont("Arial",12)));
        tabla.addCell(new Paragraph("Hora registrada", FontFactory.getFont("Arial",12)));
        
        
        
        for (Mensaje mes : mensajes){
           tabla.addCell(new Paragraph(mes.getMensaje(), FontFactory.getFont("Arial",10)));                  
             tabla.addCell(new Paragraph(mes.getTermino(), FontFactory.getFont("Arial",10)));
             tabla.addCell(new Paragraph(mes.getTiempo().toString(), FontFactory.getFont("Arial",10)));
       
        
               }
        
        documento.add(tabla);

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
    
    
    
    
    
}
