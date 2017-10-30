
package Dao;


import Principal.Mensaje;
import Principal.Usuario;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class MensajeDao {
    private static MensajeDao dao= null;
    private static  MongoClient client;
     ;
    private static DB db;
    
    
    
     public static MensajeDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new MensajeDao();
        }
        return dao;
    }
    
      private MensajeDao() throws UnknownHostException{
        client = new MongoClient("localhost",27017);
         db = client.getDB("clinica");
    
      }

      
    
  public List<Mensaje> retrievePorUsuario(Usuario usu){
       DBCollection mensajeCol = db.getCollection("mensaje");
        
        DBCursor cursor = mensajeCol.find();
        
        List<Mensaje> mensajes = new ArrayList<>();
         try{
            while (cursor.hasNext()){
                DBObject mensajeDoc = cursor.next();
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
       DBCollection mensajeCol = db.getCollection("mensaje");
        
        DBCursor cursor = mensajeCol.find();
   
        
        List<Mensaje> mensajes = new ArrayList<>();
         try{
            while (cursor.hasNext()){
              
                DBObject mensajeDoc = cursor.next();
                Mensaje mensaje = new Mensaje(mensajeDoc.get("mensaje").toString(), mensajeDoc.get("termino").toString(), mensajeDoc.get("nombrePaciente").toString(),mensajeDoc.get("hora").toString());
              
                mensajes.add(mensaje);
                
            }
        }finally{
            cursor.close();
        }
        return mensajes;
   
        
        
        
    }
    
    public void CreateMensaje(String nombre,String mensaje,String termino){
            
        DBCollection mensajeCol = db.getCollection("mensaje");
          Date fecha1 = new Date ();
        DBObject mens = new BasicDBObject()
                .append("mensaje", mensaje)
                .append("termino", termino)
                .append("nombrePaciente", nombre)
                .append("hora", fecha1.toLocaleString());
        
        mensajeCol.insert(mens);
    }
    
  
    
    
 }
    
   