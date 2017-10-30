
package HistorialClinico;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class prueba1 {
    
      public static String archivo = System.getProperty("user.dir")+"/lista_clientes.pdf";


    public static void crearPDF(ArrayList<String> clientes) throws DocumentException{
        //Declaramos un documento como un objecto Document. 
        Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
        //writer es declarado como el método utilizado para escribir en el archivo.
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

        try{
            //Obtenemos la instancia de la imagen/logo.
            Image imagen = Image.getInstance("..\\imagenes\\LOGO.png");
            //Alineamos la imagen al centro del documento.
            imagen.setAlignment(Image.ALIGN_CENTER);
            //Agregamos la imagen al documento.
            documento.add(imagen);
        }catch(IOException | DocumentException ex){
            ex.getMessage();
        }

        //Creamos un párrafo nuevo llamado "vacio1" para espaciar los elementos.
        Paragraph vacio1 = new Paragraph();
        vacio1.add("\n\n");
        documento.add(vacio1);

        //Declaramos un texto como Paragraph. Le podemos dar formato alineado, tamaño, color, etc.
        Paragraph titulo = new Paragraph();
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.RED));
        titulo.add("***LISTA DE CLIENTES***");

        try{
            //Agregamos el texto al documento.
            documento.add(titulo);
        }catch(DocumentException ex){
            ex.getMessage();
        }

        //Creamos un párrafo nuevo llamado "saltolinea" simulando un salto de linea para espaciar
        //los elementos del PDF.
        Paragraph saltolinea = new Paragraph();
        saltolinea.add("\n\n");
        documento.add(saltolinea);

        //Creamos un párrafo llamado "parrafo" donde irá el contenido del PDF.
        Paragraph parrafo = new Paragraph();
        for (int i=0; i<clientes.size(); i++){
            parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Times New Roman", 12, Font.BOLD, BaseColor.BLACK));
            //Añadimos al párrafo "parrafo" los clientes de la lista clientes.
            parrafo.add(clientes.get(i));
            //Añadimos ese párrafo "parrafo" al documento "documento".
            documento.add(parrafo);
        }

        //Cerramos el documento.
        documento.close();
        //Cerramos el writer.
        writer.close();
    }
    
}
