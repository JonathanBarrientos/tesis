

package Dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import Principal.Usuario;




import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao {
    private static UsuarioDao dao;
   private static  MongoClient client;
    private static MongoClientURI uri;
      MongoDatabase db;
    
    
    
     public static UsuarioDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new UsuarioDao();
        }
        return dao;
    }
    
      private UsuarioDao() throws UnknownHostException{
        uri = new MongoClientURI("mongodb://myzrael:myzrael456@ds131854.mlab.com:31854/arsad");
        client = new MongoClient(uri);
        db =  client.getDatabase("arsad");
    }
      
      //Login
      public Usuario GetUsuario(String codigo, String password){
        MongoCollection<Document> usuCol = db.getCollection("usuario");
        Document filtro1 = new Document("NombreUsuario", codigo)
                .append("contraseña", password);
          
        Document usuDoc = usuCol.find(filtro1).first();
        Usuario usuario = null;
        
        usuario= new Usuario(usuDoc.get("nombre").toString(), Integer.parseInt(usuDoc.get("edad").toString()), Integer.parseInt(usuDoc.get("dni").toString()), codigo, password, usuDoc.get("tipoUsuario").toString());
      
        
        
        //cliente= new Cliente(cli.get("nombre").toString(), Integer.parseInt(cli.get("edad").toString()), Integer.parseInt(cli.get("dni").toString()), codigo, null, usuario);
        return usuario;
       
          
      }
      
      
      public List<Usuario> mirarClientes(){
          MongoCollection<Document> usuCol = db.getCollection("usuario");
          List<Usuario> usuarios  = new ArrayList<>();
          MongoCursor<Document> cursor =  usuCol.find().iterator();
          
          
         try{
            while(cursor.hasNext()){
              
                Document usuDoc = cursor.next();
                if(usuDoc.get("tipoUsuario").toString().equals("paciente")){
                Usuario usu = new Usuario(usuDoc.get("nombre").toString(), Integer.parseInt(usuDoc.get("edad").toString()), Integer.parseInt(usuDoc.get("dni").toString()));
              
                usuarios.add(usu);
                }   
            }
        }finally{
            cursor.close();
        }
        return usuarios;
          
          
          
      }
      
         
      
      
      
       //Registrar a un nuevo usuario 
      public void CreateUsuario(Usuario usu){
          MongoCollection<Document> usuCol = db.getCollection("usuario");
          
          Document usuDoc = new Document()
                .append("nombre", usu.getNombre())
                .append("edad",usu.getEdad())
                .append("dni", usu.getDni())
                .append("NombreUsuario", usu.getNombreUsuario())
                .append("contraseña", usu.getContraseña())
                .append("tipoUsuario", "paciente")  ;
                
             
        
        usuCol.insertOne(usuDoc);
      
      }
      
    
    
}
