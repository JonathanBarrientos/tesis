/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.ulima.edu;

import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
public class insertarMensajes {

    private static  MongoClient client;
   
    private static DB db;
  
    public static void main(String[] args) {
      client = new MongoClient("localhost",27017);
         db = client.getDB("clinica");
      
         String tiempo ="mucho";
         String dolor = "medio";
        String men="tengo los dientes oscurecidos"; 
         
         Map<String, String[]> trainingFiles = new HashMap<>();
           DBCollection terminoCol = db.getCollection("terminos");
           DBCursor cursor= terminoCol.find();
           String term;
           
            try{
            while (cursor.hasNext()){
                DBObject termino = cursor.next();
                if(termino.get("categoriaTiempo").equals(tiempo) && termino.get("categoriaDolor").equals(dolor)){
                trainingFiles.put(termino.get("termino").toString(), termino.get("significado").toString().split(""));
                 }
            }
           }finally{
            cursor.close();
        }
           NaiveBayes nb = new NaiveBayes();
           nb.setChisquareCriticalValue(6.63);
           nb.train(trainingFiles);
           
           NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();
           
           
           nb = null;
           trainingFiles = null;
        
        
           nb = new NaiveBayes(knowledgeBase);
     
           term = nb.predict(men);
          
          System.out.print(term);
     
            DBCollection mensajeCol = db.getCollection("mensaje");
          Date fecha1 = new Date ();
        DBObject mens = new BasicDBObject()
                .append("mensaje", men)
                .append("termino", term)
                .append("nombrePaciente", "Jonathan Barrientos")
                .append("hora", fecha1.toLocaleString());
      
        mensajeCol.insert(mens);
    
}
}