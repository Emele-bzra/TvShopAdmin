package NEbwz.Controller;

import NEbwz.Model.Bestellung;
import NEbwz.Model.Kunde;
import NEbwz.Persistance.BestellungPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BestellungController {
    private BestellungPersistence bestellungPersistence;

    public BestellungController(BestellungPersistence bestellungPersistence) {
        this.bestellungPersistence = bestellungPersistence;
    }
    public List<Bestellung> readBestellung(Kunde toSelect) {
        List<Bestellung> bestellungen = new ArrayList<>();

        if (toSelect != null) {
            for (Bestellung bestellung : this.bestellungPersistence.getBestellungen()) {
                if (Objects.equals(bestellung.getKunde().getId(), toSelect.getId())) {
                    bestellungen.add(bestellung);
                }
            }
        }
        return bestellungen;
    }

    public void addBestellung(Bestellung toAdd)  {
        this.bestellungPersistence.addBestellung(toAdd);
    }

    public void updateBestellung(Bestellung toUpdate)  {
        this.bestellungPersistence.updateBestellung(toUpdate);
    }

    public void deleteBestellung(Bestellung toDelete) {
        this.bestellungPersistence.deleteBestellung(toDelete);
    }
}
