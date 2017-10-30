/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.ulima.edu;

import Dao.TerminoDao;
import Dao.UsuarioDao;
import Principal.Usuario;
import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.util.HashMap;
import java.util.Map;


public class PruebaConexion {
    private static Mongo client;
    private static DB db;
    
  
    public static void main(String[] args) {
        
         client = new Mongo("localhost",27017);
         db = client.getDB("clinica");
                        
         
        
           Map<String, String[]> trainingFiles = new HashMap<>();
           DBCollection terminoCol = db.getCollection("terminos");
           DBCursor cursor= terminoCol.find();
           String term;
           
            try{
            while (cursor.hasNext()){
                DBObject termino = cursor.next();
                trainingFiles.put(termino.get("termino").toString(), termino.get("significado").toString().split(""));
                
            }
           }finally{
            cursor.close();
        }
           NaiveBayes nb = new NaiveBayes();
           nb.setChisquareCriticalValue(6.63);
           nb.train(trainingFiles);
           
           NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
           
           
           nb = null;
          
        
        
           nb = new NaiveBayes(knowledgeBase);
     
           term = nb.predict(" ");
           
         System.out.print(term);
      
       
         
         
        
    }
    
}
