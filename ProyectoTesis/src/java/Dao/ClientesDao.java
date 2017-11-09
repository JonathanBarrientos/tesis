

package Dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import Principal.Usuario;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import com.mongodb.client.MongoCursor;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDao {
    
    private static ClientesDao dao= null;
     MongoClient client;
   MongoClientURI uri;
    MongoDatabase db;
    
    
    public static ClientesDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new ClientesDao();
        }
        return dao;
    }
    
      private ClientesDao() throws UnknownHostException{
    // client = new MongoClient("localhost",27017);
     //    db = client.getDB("clinica");
        uri = new MongoClientURI("mongodb://myzrael:myzrael456@ds131854.mlab.com:31854/arsad");
        client = new MongoClient(uri);
         db =  client.getDatabase("arsad");


      }
    
    
      //clienteDoc.get("nombre").toString(), Integer.parseInt(clienteDoc.get("edad").toString()), Integer.parseInt(clienteDoc.get("dni").toString()), clienteDoc.get("correo").toString()
   public List<Usuario> retrieve(){
        MongoCollection<Document> clienteCol = db.getCollection("usuario");
        
        MongoCursor<Document> cursor = clienteCol.find().iterator();
        List<Usuario> clientes = new ArrayList<Usuario>();
        try{
            while (cursor.hasNext()){
                Document clienteDoc = cursor.next();
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
