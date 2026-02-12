package NEbwz.Model;

public class Addresse {
    private String strasse;
    private String plz;
    private String ort;

    public Addresse() { }
    public Addresse(String strasse, String plz, String ort) {
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    public String getStrasse() { return strasse; }
    public void setStrasse(String strasse) { this.strasse = strasse; }
    public String getPlz() { return plz; }
    public void setPlz(String plz) { this.plz = plz; }
    public String getOrt() { return ort; }
    public void setOrt(String ort) { this.ort = ort; }
}