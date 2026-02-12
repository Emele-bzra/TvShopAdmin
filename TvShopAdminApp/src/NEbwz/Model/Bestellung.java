package NEbwz.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bestellung {
    private String id;
    private String bestellnummer;
    private LocalDate bestelldatum;
    private Kunde kunde;
    private List<BestellPosition> positionen = new ArrayList<>();
    private double total;

    public Bestellung() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getBestellnummer() { return bestellnummer; }
    public void setBestellnummer(String bestellnummer) { this.bestellnummer = bestellnummer; }
    public LocalDate getBestelldatum() { return bestelldatum; }
    public void setBestelldatum(LocalDate bestelldatum) { this.bestelldatum = bestelldatum; }
    public Kunde getKunde() { return kunde; }
    public void setKunde(Kunde kunde) { this.kunde = kunde; }
    public List<BestellPosition> getPositionen() { return positionen; }
    public void setPositionen(List<BestellPosition> positionen) { this.positionen = positionen; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public void berechneTotal() {
        this.total = positionen.stream()
                .mapToDouble(p -> p.getEinzelpreis() * p.getStueckzahl())
                .sum();
    }
}