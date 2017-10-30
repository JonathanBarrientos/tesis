

package Dao;


import Principal.Usuario;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDao {
    
    private static ClientesDao dao= null;
    private static  MongoClient client;
   
    private static DB db;
    
    
    public static ClientesDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new ClientesDao();
        }
        return dao;
    }
    
      private ClientesDao() throws UnknownHostException{
     client = new MongoClient("localhost",27017);
         db = client.getDB("clinica");
      }
    
    
      //clienteDoc.get("nombre").toString(), Integer.parseInt(clienteDoc.get("edad").toString()), Integer.parseInt(clienteDoc.get("dni").toString()), clienteDoc.get("correo").toString()
   public List<Usuario> retrieve(){
        DBCollection clienteaCol = db.getCollection("usuario");
        
        DBCursor cursor = clienteaCol.find();
        List<Usuario> clientes = new ArrayList<Usuario>();
        try{
            while (cursor.hasNext()){
                DBObject clienteDoc = cursor.next();
                if(clienteDoc.get("tipoUsuario").toString().equalsIgnoreCase("paciente")){
                Usuario cliente;
                cliente = new Usuario(clienteDoc.get("nombre").toString(), Integer.parseInt(clienteDoc.get("edad").toString()),  Integer.parseInt(clienteDoc.get("dni").toString()));
                clientes.add(cliente);
                 }
            }
        }finally{
            cursor.close();
        }
        return clientes;
    }
    
    
}
