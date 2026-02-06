package NEbwz.Modell;

import java.time.LocalDate;

public class Kunde {
    private String anrede;
    private String nachname;
    private String vorname;
    private Addresse adresse;
    private String telefonPrivat;
    private String telefonMobile;
    private String email;
    private LocalDate geburtsdatum;
    private String username;
    private String passwort;

    public Kunde() {}

    public String getAnrede() { return anrede; }
    public void setAnrede(String anrede) { this.anrede = anrede; }
    public String getNachname() { return nachname; }
    public void setNachname(String nachname) { this.nachname = nachname; }
    public String getVorname() { return vorname; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public Addresse getAdresse() { return adresse; }
    public void setAdresse(Addresse adresse) { this.adresse = adresse; }
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
    public String getPasswort() { return passwort; }
    public void setPasswort(String passwort) { this.passwort = passwort; }
}