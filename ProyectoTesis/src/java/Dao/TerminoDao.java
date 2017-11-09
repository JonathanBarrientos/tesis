

package Dao;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;
import com.datumbox.opensource.classifiers.NaiveBayes;
import com.datumbox.opensource.dataobjects.NaiveBayesKnowledgeBase;
import com.mongodb.BasicDBObject;


import com.mongodb.DBObject;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


public class TerminoDao {
    private static TerminoDao dao= null;
     MongoClient client;
     MongoClientURI uri;
        MongoDatabase db;
    
    
    public static TerminoDao getInstance() throws UnknownHostException{
        if (dao == null){
            dao = new TerminoDao();
        }
        return dao;
    }
    
      private TerminoDao() throws UnknownHostException{
    //    client = new MongoClient("localhost",27017);
     //    db = client.getDB("clinica");
        uri = new MongoClientURI("mongodb://myzrael:myzrael456@ds131854.mlab.com:31854/arsad");
        client = new MongoClient(uri);
        db = client.getDatabase("arsad");

      }
    
    
       
       
      public String SacarTermino(String men,String tiempo, String dolor){
          
           Map<String, String[]> trainingFiles = new HashMap<>();
           MongoCollection<Document> terminoCol = db.getCollection("terminos");
           MongoCursor<Document> cursor= terminoCol.find().iterator();
           String term;
           
            try{
            while (cursor.hasNext()){
                Document termino = cursor.next();
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
           MongoCollection<Document> terminoCol = db.getCollection("terminos");
           Document ter = new Document()
                .append("termino", termino)
                .append("significado", significado)
                .append("categoriaTiempo", tiempo)
                .append("categoriaDolor",dolor);
           
           terminoCol.insertOne(ter);
          
      }
}
