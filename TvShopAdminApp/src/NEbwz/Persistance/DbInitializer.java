package NEbwz.Persistance;

import NEbwz.Model.Fernseher;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
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

public class DbInitializer {

    public DbInitializer() {
    }

    public void initialize() {
        seedKunden();
        seedTvs();
        seedBestellungen();
    }

    private void seedBestellungen() {

    }

    private void seedKunden() {

    }

    private void seedTvs() {

    }
}