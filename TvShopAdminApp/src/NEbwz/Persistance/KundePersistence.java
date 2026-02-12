package NEbwz.Persistance;

import NEbwz.Model.Kunde;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class KundePersistence {

    CodecProvider pojoCodecProvider;
    CodecRegistry pojoCodecRegistry;
    MongoClient mongoClient;
    String connectionString = "mongodb://localhost:27017";

    public KundePersistence() {
        pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        mongoClient = MongoClients.create(connectionString);
    }

    public List<Kunde> getKunden() {
        MongoDatabase database = getDatabase();
        List<Kunde> kunden = new ArrayList<>();
        database.getCollection("Kunde", Kunde.class).find().into(kunden);
        return kunden;
    }

    public void addKunden(Kunde kunde) {
        MongoDatabase database = getDatabase();
        MongoCollection<Kunde> kunden = database.getCollection("Kunde", Kunde.class);
        kunden.insertOne(kunde);

    }

    private MongoDatabase getDatabase() {
        return mongoClient.getDatabase("TVShop").withCodecRegistry(pojoCodecRegistry);
    }
}