package NEbwz.Controller;

import NEbwz.Modell.*;
import NEbwz.Modell.DisplayTechnologie;
import NEbwz.View.MainFrame;
import javax.swing.JOptionPane;

public class MainFrameController {

    public MainFrameController() {
    }

    public void saveKundeToDb(String kundeVorname, String kundeNachname) {

    }

    public Fernseher saveTvToDb(String marke, String modell) {
            Fernseher neuerTv = new Fernseher();

            neuerTv.setMarke(marke);
            neuerTv.setModell(modell);

/*
            neuerTv.setPreis(Double.parseDouble(view.getTxtPreis().getText()));
            //neuerTv.setDiagonale(view.getTxtDiagonale().getText()); // Meist String wie "55 Zoll"
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
            */
        return neuerTv;
    }


}