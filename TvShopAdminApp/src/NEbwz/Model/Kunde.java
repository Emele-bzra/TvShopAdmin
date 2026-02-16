package NEbwz.Model;

import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.Objects;

public class Kunde {
    private ObjectId id;
    private String anrede;
    private String nachname;
    private String vorname;
    private Adresse adresse = new Adresse();
    private String telefonPrivat;
    private String telefonMobile;
    private String email;
    private LocalDate geburtsdatum;
    private String username;
    private byte[] passwort;
    private byte[] salt;

    public Kunde() {}


    @Override
    public String toString() {
        return vorname + " " + nachname;
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public String getAnrede() { return anrede; }
    public void setAnrede(String anrede) { this.anrede = anrede; }
    public String getNachname() { return nachname; }
    public void setNachname(String nachname) { this.nachname = nachname; }
    public String getVorname() { return vorname; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
    public String getTelefonPrivat() { return telefonPrivat; }
    public void setTelefonPrivat(String telefonPrivat) { this.telefonPrivat = telefonPrivat; }
    public String getTelefonMobile() { return telefonMobile; }
    public void setTelefonMobile(String telefonMobile) { this.telefonMobile = telefonMobile; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getGeburtsdatum() { return geburtsdatum; }
    public void setGeburtsdatum(LocalDate geburtsdatum) { this.geburtsdatum = geburtsdatum; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public byte[] getPasswort() { return passwort; }
    public void setPasswort(byte[] passwort) { this.passwort = passwort; }
    public byte[] getSalt() { return salt; }
    public void setSalt(byte[] salt) { this.salt = salt; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Kunde kunde = (Kunde) o;
        return Objects.equals(id, kunde.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}