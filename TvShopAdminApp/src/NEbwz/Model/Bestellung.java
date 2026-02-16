package NEbwz.Model;

import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bestellung {
    private ObjectId id;
    private LocalDate bestelldatum;
    private Kunde kunde;
    private List<BestellPosition> positionen = new ArrayList<>();
    private double total;

    public Bestellung() {}

    @Override
    public String toString() {
        return getBestellnummer();
    }

    public String getBestellnummer() {
        return (this.id != null) ? this.id.toString() : "unbekannt";
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public LocalDate getBestelldatum() { return bestelldatum; }
    public void setBestelldatum(LocalDate bestelldatum) { this.bestelldatum = bestelldatum; }
    public Kunde getKunde() { return kunde; }
    public void setKunde(Kunde kunde) { this.kunde = kunde; }
    public List<BestellPosition> getPositionen() { return positionen; }
    public void setPositionen(List<BestellPosition> positionen) { this.positionen = positionen; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bestellung that = (Bestellung) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}