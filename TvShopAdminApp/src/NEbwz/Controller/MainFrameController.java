package NEbwz.Controller;

import NEbwz.Model.*;
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


    public FernseherController getFernseher() { return fernseher; }
    public KundenController getKunden() { return kunden; }
    public BestellungController getBestellungen() {  return bestellungen; }


/*
    public Fernseher saveTvToDb(String marke, String modell, String preis, String text, String s, String string, String text1, String s1, String string1, String text2) {
            Fernseher neuerTv = new Fernseher();

            neuerTv.setMarke(marke);
            neuerTv.setModell(modell);
            neuerTv.setPreis(Double.parseDouble(preis));

            / *
            neuerTv.setBildschirmdiagonale();
            neuerTv.setAufloesung(view.getTxtAufloesung().getText());

            // Integer-Werte
            //neuerTv.setWiederholfrequenz(Integer.parseInt(view.getTxtFrequenz().getText()));
            neuerTv.setGewicht(Double.parseDouble(view.getTxtGewicht().getText()));

            //neuerTv.setReleaseDatum(view.getTxtRelease().getText());
            neuerTv.setPixelAufloesung(view.getTxtPixel().getText());
            neuerTv.setNennleistung(Integer.parseInt(view.getTxtLeistung().getText()));

            // Enum aus ComboBox
            DisplayTechnologie tech = (DisplayTechnologie) view.getCbTechnologie().getSelectedItem();
            neuerTv.setDisplayTechnologie(String.valueOf(tech));

            // 3. Übergabe an Persistence (Simuliert)
            System.out.println("Objekt erstellt: " + neuerTv.getMarke() + " " + neuerTv.getModell());

            // Beispiel: persistence.insert(neuerTv);

            // 4. Erfolg melden und Liste aktualisieren
            view.getTvListModel().addElement(neuerTv.getMarke() + " - " + neuerTv.getModell());

            // Alles leeren
            clearAllFields();
            JOptionPane.showMessageDialog(view, "Fernseher erfolgreich gespeichert!");
* /
        return neuerTv;
    }

*/
}