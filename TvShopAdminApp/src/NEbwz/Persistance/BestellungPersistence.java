package NEbwz.Persistance;

import NEbwz.Model.Bestellung;
import NEbwz.Model.Fernseher;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
        List<Bestellung> bestellungen = new ArrayList<>();
        getCollection().find().into(bestellungen);
        return bestellungen;
    }

    public void addBestellung(Bestellung bestellung) {
        MongoCollection<Bestellung> bestellungen = getCollection();
        bestellungen.insertOne(bestellung);

    }

    public void updateBestellung(Bestellung bestellung) {
        MongoCollection<Bestellung> tvs = getCollection();
        tvs.replaceOne(
                Filters.eq("_id", bestellung.getId()),
                bestellung
        );
    }

    public void deleteBestellung(Bestellung bestellung) {
        MongoCollection<Bestellung> bestellungen = getCollection();
        bestellungen.deleteOne(Filters.eq("_id", bestellung.getId()));
    }

    private MongoCollection<Bestellung> getCollection() {
        MongoDatabase database = mongoClient.getDatabase("TVShop").withCodecRegistry(pojoCodecRegistry);
        return database.getCollection("Bestellung", Bestellung.class);
    }
}