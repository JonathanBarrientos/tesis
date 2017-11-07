
package Dao;
import b
import com.mongodb.MongoCollection
import com.mongodb.MongoURI
import Principal.Mensaje;
import Principal.Usuario;
import com.mongodb.BasicDBObject;
import org.bson.Document;
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
    private static MongoURI uri ;
    private static MongoDatabase db;
    
    
    
     public static MensajeDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new MensajeDao();
        }
        return dao;
    }
    
      private MensajeDao() throws UnknownHostException{
        uri = new MongoClientURI("mongodb://myzrael:myzrael456@ds131854.mlab.com:31854/arsad");
        client = new MongoClient(uri);
        db = new MongoDatabase(client.getDatabase("arsad"));

      }

      
    
  public List<Mensaje> retrievePorUsuario(Usuario usu){
       MongoCollection<Document> mensajeCol = db.getCollection("mensaje");
        
        MongoCursor<Document> cursor = mensajeCol.find();
        
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
    
   