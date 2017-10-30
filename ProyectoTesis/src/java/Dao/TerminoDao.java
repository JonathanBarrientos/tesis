

package Dao;

import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


public class TerminoDao {
        private static TerminoDao dao= null;
    private static  MongoClient client;
   
    private static DB db;
    
    
    public static TerminoDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new TerminoDao();
        }
        return dao;
    }
    
      private TerminoDao() throws UnknownHostException{
     client = new MongoClient("localhost",27017);
         db = client.getDB("clinica");
      }
    
    
       
       
      public String SacarTermino(String men,String tiempo, String dolor){
          
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
           
         
           return term;
         
      }
      public void InsertarTermino(String termino, String significado, String tiempo , String dolor){
          DBCollection terminoCol = db.getCollection("terminos");
           DBObject ter = new BasicDBObject()
                .append("termino", termino)
                .append("significado", significado)
                .append("categoriaTiempo", tiempo)
                .append("categoriaDolor",dolor);
           
           terminoCol.insert(ter);
          
      }
}
