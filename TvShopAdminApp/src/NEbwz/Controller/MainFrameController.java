package NEbwz.Controller;

import NEbwz.Persistance.BestellungPersistence;
import NEbwz.Persistance.DbInitializer;
import NEbwz.Persistance.FernseherPersistence;
import NEbwz.Persistance.KundePersistence;

public class MainFrameController {

    private FernseherPersistence fernseherPersistence = new FernseherPersistence();
    private KundePersistence kundePersistence = new KundePersistence();
    private BestellungPersistence bestellungPersistence = new BestellungPersistence();

    private FernseherController fernseher = new FernseherController(fernseherPersistence);
    private KundenController kunden = new KundenController(kundePersistence);
    private BestellungController bestellungen = new BestellungController(bestellungPersistence);

    private DbInitializer initializer = new DbInitializer(fernseherPersistence, kundePersistence, bestellungPersistence);

    public MainFrameController() {
        initializer.initialize();
    }


    public FernseherController getFernsehController() { return fernseher; }
    public KundenController getKundenController() { return kunden; }
    public BestellungController getBestellungController() {  return bestellungen; }


}