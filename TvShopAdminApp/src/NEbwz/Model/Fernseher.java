package NEbwz.Model;

import org.bson.types.ObjectId;

import java.time.LocalDate;


public class Fernseher {
    private ObjectId id;
    private String marke;
    private String modell;
    private double preis;
    private String bildschirmdiagonale;
    private String displayTechnologie;
    private String aufloesung;
    private int bildwiederholfrequenz;
    private double gewicht;
    private LocalDate releaseDatum;
    private String pixelAufloesung;
    private int nennleistung;

    public Fernseher() {}


    public Fernseher(String marke, String modell, double preis) {
        this.marke = marke;
        this.modell = modell;
        this.preis = preis;
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public String getMarke() { return marke; }
    public void setMarke(String marke) { this.marke = marke; }
    public String getModell() { return modell; }
    public void setModell(String modell) { this.modell = modell; }
    public double getPreis() { return preis; }
    public void setPreis(double preis) { this.preis = preis; }
    public String getBildschirmdiagonale() { return bildschirmdiagonale; }
    public void setBildschirmdiagonale(String bildschirmdiagonale) { this.bildschirmdiagonale = bildschirmdiagonale; }
    public String getDisplayTechnologie() { return displayTechnologie; }
    public void setDisplayTechnologie(String displayTechnologie) { this.displayTechnologie = displayTechnologie; }
    public String getAufloesung() { return aufloesung; }
    public void setAufloesung(String aufloesung) { this.aufloesung = aufloesung; }
    public int getBildwiederholfrequenz() { return bildwiederholfrequenz; }
    public void setBildwiederholfrequenz(int bildwiederholfrequenz) { this.bildwiederholfrequenz = bildwiederholfrequenz; }
    public double getGewicht() { return gewicht; }
    public void setGewicht(double gewicht) { this.gewicht = gewicht; }
    public LocalDate getReleaseDatum() { return releaseDatum; }
    public void setReleaseDatum(LocalDate releaseDatum) { this.releaseDatum = releaseDatum; }
    public String getPixelAufloesung() { return pixelAufloesung; }
    public void setPixelAufloesung(String pixelAufloesung) { this.pixelAufloesung = pixelAufloesung; }
    public int getNennleistung() { return nennleistung; }
    public void setNennleistung(int nennleistung) { this.nennleistung = nennleistung; }
}