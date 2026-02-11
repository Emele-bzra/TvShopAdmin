package NEbwz.Persistance;

import NEbwz.Model.Fernseher;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class FernseherPersistence {

    CodecProvider pojoCodecProvider;
    CodecRegistry pojoCodecRegistry;
    MongoClient mongoClient;
    String connectionString = "mongodb://localhost:27017";

    public FernseherPersistence() {
        pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        mongoClient = MongoClients.create(connectionString);
    }

    public void getFernseher(String[] args) {
        MongoDatabase database = mongoClient.getDatabase("TVShop");
        List<Document> fernseher = database.getCollection("Fernseher").find().into(new ArrayList<>());
        for (Document doc : fernseher) {
            System.out.println(doc.toJson());
        }

    }

    public void addFernseher(Fernseher fernseher) {
        MongoDatabase database = getDatabase();
        MongoCollection<Fernseher> tvs = database.getCollection("Fernseher", Fernseher.class);
        tvs.insertOne(fernseher);

    }

    private MongoDatabase getDatabase() {
        MongoDatabase database = mongoClient.getDatabase("TVShop").withCodecRegistry(pojoCodecRegistry);
        return database;
    }
}