package NEbwz.Modell;

public class BestellPosition {
    private Fernseher tv;
    private double einzelpreis;
    private int stueckzahl;

    public BestellPosition() {}

    public Fernseher getTv() { return tv; }
    public void setTv(Fernseher tv) { this.tv = tv; }
    public double getEinzelpreis() { return einzelpreis; }
    public void setEinzelpreis(double einzelpreis) { this.einzelpreis = einzelpreis; }
    public int getStueckzahl() { return stueckzahl; }
    public void setStueckzahl(int stueckzahl) { this.stueckzahl = stueckzahl; }
}