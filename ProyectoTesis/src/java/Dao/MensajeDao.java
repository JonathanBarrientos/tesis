
package Dao;

import com.mongodb.client.MongoCursor;


import com.mongodb.MongoURI;
import Principal.Mensaje;
import Principal.Usuario;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class MensajeDao {
    private static MensajeDao dao= null;
    MongoClientURI uri;
    MongoClient  client;
  MongoDatabase db;
    
    
    
     public static MensajeDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new MensajeDao();
        }
        return dao;
    }
    
      private MensajeDao() throws UnknownHostException{
          uri = new MongoClientURI("mongodb://myzrael:myzrael456@ds131854.mlab.com:31854/arsad");
            client = new MongoClient(uri);
          db =  client.getDatabase("arsad");

      }

      
    
  public List<Mensaje> retrievePorUsuario(Usuario usu){
      
       MongoCollection<Document> mensajeCol = db.getCollection("mensaje");
        
        MongoCursor<Document> cursor =mensajeCol.find().iterator();
        
        List<Mensaje> mensajes = new ArrayList<>();
         try{
            while (cursor.hasNext()){
                Document mensajeDoc = cursor.next();
                if(usu.getNombre().equals(mensajeDoc.get("nombrePaciente").toString())){
                Mensaje mensaje = new Mensaje(mensajeDoc.get("mensaje").toString(), mensajeDoc.get("termino").toString(), mensajeDoc.get("nombrePaciente").toString(),mensajeDoc.get("hora").toString());
                
                mensajes.add(mensaje);
                }
            }
        }finally{
            cursor.close();
        }
        return mensajes;
    }   
  
  
    public List <Mensaje> retrieveTotal(){
        
       MongoCollection<Document> mensajeCol = db.getCollection("mensaje");
        
       MongoCursor<Document> cursor = mensajeCol.find().iterator();
   
        
        List<Mensaje> mensajes = new ArrayList<>();
         try{
            while (cursor.hasNext()){
              
                Document mensajeDoc = cursor .next();
                Mensaje mensaje = new Mensaje(mensajeDoc.get("mensaje").toString(), mensajeDoc.get("termino").toString(), mensajeDoc.get("nombrePaciente").toString(),mensajeDoc.get("hora").toString());
              
                mensajes.add(mensaje);
                
            }
        }finally{
            cursor.close();
        }
        return mensajes;
   
        
        
        
    }
    
    public void CreateMensaje(String nombre,String mensaje,String termino){
            
        MongoCollection<Document> mensajeCol = db.getCollection("mensaje");
          Date fecha1 = new Date ();
        Document mens = new Document()
                .append("mensaje", mensaje)
                .append("termino", termino)
                .append("nombrePaciente", nombre)
                .append("hora", fecha1.toLocaleString());
        
        mensajeCol.insertOne(mens);
    }
    
  
    
    
 }
    
   