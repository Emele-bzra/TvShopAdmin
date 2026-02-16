package NEbwz.Persistance;

import NEbwz.Model.Fernseher;
import NEbwz.Model.Kunde;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
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

    public void addKunden(Kunde kunde, String password)  {
        MongoDatabase database = getDatabase();
        MongoCollection<Kunde> kunden = database.getCollection("Kunde", Kunde.class);

        setPassword(kunde, password);
        kunden.insertOne(kunde);
    }
    public void deleteKunden(Kunde kunde) {
        MongoCollection<Kunde> kunden = getCollection();
        kunden.deleteOne(Filters.eq("_id", kunde.getId()));
    }

    private MongoDatabase getDatabase() {
        return mongoClient.getDatabase("TVShop").withCodecRegistry(pojoCodecRegistry);
    }

    public void updateKunden(Kunde kunde, String password) {
        MongoCollection<Kunde> tvs = getCollection();
        if (!password.isBlank()) {
            setPassword(kunde, password);
        }
        tvs.replaceOne(
                Filters.eq("_id", kunde.getId()),
                kunde
        );
    }

    private void setPassword(Kunde kunde, String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);

        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();

            kunde.setPasswort(hash);
            kunde.setSalt(salt);

        } catch (Exception e) {
            System.out.print("Vorsicht, ungültiger Hash Algo spezifiziert: " + e);
        }
    }

    private MongoCollection<Kunde> getCollection() {
        MongoDatabase database = mongoClient.getDatabase("TVShop").withCodecRegistry(pojoCodecRegistry);
        return database.getCollection("Kunde", Kunde.class);
    }
}