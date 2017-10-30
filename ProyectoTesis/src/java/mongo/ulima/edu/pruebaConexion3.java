
package mongo.ulima.edu;

import Principal.Mensaje;
import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pruebaConexion3 {
  private static  MongoClient client;
   
    private static DB db;
  
    public static void main(String[] args) {
      client = new MongoClient("localhost",27017);
         db = client.getDB("clinica");
      /*
         String tiempo ="mucho";
         String dolor = "medio";
        String men="tengo inflamados los dientes"; 
         
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
           
       */ 
           
   DBCollection mensajeCol = db.getCollection("mensaje");
        
        DBCursor cursor = mensajeCol.find();
   
        
        List<Mensaje> mensajes = new ArrayList<Mensaje>();
         try{
            while (cursor.hasNext()){
            
                DBObject mensajeDoc = cursor.next();
                
                         Mensaje  mens  = new Mensaje(mensajeDoc.get("mensaje").toString(), mensajeDoc.get("termino").toString(), mensajeDoc.get("nombrePaciente").toString(), mensajeDoc.get("hora").toString());
                  mensajes.add(mens);
                  
       
                   
              
               
                
            
                  }
        }finally{
            cursor.close();
        }
        
        System.out.print(mensajes.get(0).getTiempo());
         System.out.print(mensajes.get(1).getTiempo());
         System.out.print(mensajes.get(2).getTiempo());
         System.out.print(mensajes.get(3).getTiempo());
         System.out.print(mensajes.get(4).getTiempo());    
    }
    
}
