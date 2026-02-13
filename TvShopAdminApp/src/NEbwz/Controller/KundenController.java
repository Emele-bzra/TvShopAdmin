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

    public void addKunde(Kunde toAdd)  {
        this.kundePersistence.addKunden(toAdd);
    }

    public void updateKunde(Kunde toUpdate)  {
        this.kundePersistence.updateKunden(toUpdate);
    }

    public void deleteKunde(Kunde toDelete) {
        this.kundePersistence.deleteKunden(toDelete);
    }
}
