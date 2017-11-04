

package Dao;


import Principal.Usuario;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao {
    private static UsuarioDao dao;
   Mongo client;
   MongoClientURI uri;
    
    DB db;
    
    
    
     public static UsuarioDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new UsuarioDao();
        }
        return dao;
    }
    
      private UsuarioDao() throws UnknownHostException{
        uri  = new MongoClientURI("mongodb://myzrael:myzrael456@ds131854.mlab.com:31854/arsad");
         client = new MongoClient(uri);
         db = client.getDB("arsad");
    }
      
      //Login
      public Usuario GetUsuario(String codigo, String password){
        DBCollection usuCol = db.getCollection("usuario");
        DBObject filtro1 = new BasicDBObject("NombreUsuario", codigo)
                .append("contraseña", password);
          
        DBObject usuDoc = usuCol.findOne(filtro1);
        Usuario usuario = null;
        
        usuario= new Usuario(usuDoc.get("nombre").toString(), Integer.parseInt(usuDoc.get("edad").toString()), Integer.parseInt(usuDoc.get("dni").toString()), codigo, password, usuDoc.get("tipoUsuario").toString());
      
        
        
        //cliente= new Cliente(cli.get("nombre").toString(), Integer.parseInt(cli.get("edad").toString()), Integer.parseInt(cli.get("dni").toString()), codigo, null, usuario);
        return usuario;
       
          
      }
      
      
      public List<Usuario> mirarClientes(){
          DBCollection usuCol = db.getCollection("usuario");
          List<Usuario> usuarios  = new ArrayList<>();
           DBCursor cursor = usuCol.find();
          
          
             try{
            while (cursor.hasNext()){
              
                DBObject usuDoc = cursor.next();
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
          DBCollection usuCol = db.getCollection("usuario");
          
          DBObject usuDoc = new BasicDBObject()
                .append("nombre", usu.getNombre())
                .append("edad",usu.getEdad())
                .append("dni", usu.getDni())
                .append("NombreUsuario", usu.getNombreUsuario())
                .append("contraseña", usu.getContraseña())
                .append("tipoUsuario", "paciente")  ;
                
             
        
        usuCol.insert(usuDoc);
      
      }
      
    
    
}
