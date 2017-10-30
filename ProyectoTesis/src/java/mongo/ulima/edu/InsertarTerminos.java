/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.ulima.edu;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
public class InsertarTerminos {
 private static Mongo client;
    private static DB db;
    
    public static void main(String[] args) {
       client = new Mongo("localhost",27017);
         db = client.getDB("clinica");
    DBCollection terminoCol = db.getCollection("terminos");
    String termino ="Encias Sangrantes";
    String significado="tengo sangrado en los dientes, cuando me cepillo me sangran poco los dientes";
    String tiempo="leve";
    String dolor="medio";
    
    
     DBObject ter = new BasicDBObject()
                .append("termino", termino)
                .append("significado", significado)
                .append("categoriaTiempo",tiempo)
                .append("categoriaDolor", dolor);
           
           terminoCol.insert(ter);
    
    
    
    
}
    }
