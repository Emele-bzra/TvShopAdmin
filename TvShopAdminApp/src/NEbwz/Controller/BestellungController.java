package NEbwz.Controller;

import NEbwz.Model.Bestellung;
import NEbwz.Persistance.BestellungPersistence;

import java.util.ArrayList;
import java.util.List;

public class BestellungController {
    private BestellungPersistence bestellungPersistence;

    public BestellungController(BestellungPersistence bestellungPersistence) {
        this.bestellungPersistence = bestellungPersistence;
    }
    public List<Bestellung> readKunde() {
        return new ArrayList<>();
    }

    public void addBestellung(Bestellung toAdd)  {

    }

    public void updateBestellung(Bestellung toUpdate)  {

    }

    public void deleteBestellung(Bestellung toDelete) {

    }
}
