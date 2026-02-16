package NEbwz.Controller;

import NEbwz.Model.Kunde;
import NEbwz.Persistance.KundePersistence;

import java.util.ArrayList;
import java.util.List;

public class KundenController {
    private KundePersistence kundePersistence;

    public KundenController(KundePersistence kundePersistence) {
        this.kundePersistence = kundePersistence;
    }

    public List<Kunde> readKunde() {        //   return new ArrayList<>();
        return this.kundePersistence.getKunden();
    }

    public void addKunde(Kunde toAdd, String password)  {
        this.kundePersistence.addKunden(toAdd, password);
    }

    public void updateKunde(Kunde toUpdate, String password)  {
        this.kundePersistence.updateKunden(toUpdate, password);
    }

    public void deleteKunde(Kunde toDelete) {
        this.kundePersistence.deleteKunden(toDelete);
    }
}
