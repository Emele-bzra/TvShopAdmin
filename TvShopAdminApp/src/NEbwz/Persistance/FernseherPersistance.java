package NEbwz.Persistance;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

public class FernseherPersistance {

    public class AddFernseher {
        String connectionString = "mongodb://localhost:27017";
        MongoClient mongoClient = (MongoClient) MongoClients.create(connectionString);

    }
}
