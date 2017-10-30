/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.ulima.edu;

import Principal.Mensaje;
import Principal.Usuario;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class PruebaConexion2 {
    private static Mongo client;
    private static DB db;
    
  
   
    public static void main(String[] args) {
         client = new Mongo("localhost",27017);
         db = client.getDB("clinica");
        
       
         DBCollection mensajeCol = db.getCollection("mensaje");
        
        DBCursor cursor = mensajeCol.find();
         Date fecha1 = new Date ();
        List<Mensaje> mensajes = new ArrayList<Mensaje>();
         try{
            while (cursor.hasNext()){
                DBObject mensajeDoc = cursor.next();
                if(mensajeDoc.get("nombrePaciente").toString().equals("Jonthan Barrientos")){
                } else {
                    Mensaje mensaje = new Mensaje(mensajeDoc.get("mensaje").toString(), mensajeDoc.get("termino").toString(), mensajeDoc.get("nombre").toString(),mensajeDoc.get("hora").toString());
                    
                    mensajes.add(mensaje);
                }
            }
        }finally{
            cursor.close();
        }
       
         mensajes.stream().forEach((ms) -> {
             System.out.print(ms.getNombrePaciente() + " " + ms.getTermino());
        });
        
        
        
        
        
        
        
        
        
    }
    
}
