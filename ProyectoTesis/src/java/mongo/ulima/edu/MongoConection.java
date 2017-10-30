/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.ulima.edu;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


public class MongoConection {
    
        
    
    
        MongoClientURI uri  = new MongoClientURI("mongodb://<myzrael>:<myzrael456>@ds053310.mlab.com:53310/examenfinalb"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        
       
        
        
        
        
        
        
    
}
