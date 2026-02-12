package NEbwz.Persistance;

import NEbwz.Model.Bestellung;
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

public class BestellungPersistence {

    CodecProvider pojoCodecProvider;
    CodecRegistry pojoCodecRegistry;
    MongoClient mongoClient;
    String connectionString = "mongodb://localhost:27017";

    public BestellungPersistence() {
        pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        mongoClient = MongoClients.create(connectionString);
    }

    public List<Bestellung> getBestellungen() {
        MongoDatabase database = getDatabase();
        List<Bestellung> bestellungen = new ArrayList<>();
        database.getCollection("Bestellung", Bestellung.class).find().into(bestellungen);
        return bestellungen;
    }

    public void addBestellung(Bestellung bestellung) {
        MongoDatabase database = getDatabase();
        MongoCollection<Bestellung> bestellungen = database.getCollection("Bestellung", Bestellung.class);
        bestellungen.insertOne(bestellung);

    }

    private MongoDatabase getDatabase() {
        return mongoClient.getDatabase("TVShop").withCodecRegistry(pojoCodecRegistry);
    }
}