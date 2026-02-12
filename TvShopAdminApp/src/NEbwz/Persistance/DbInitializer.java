package NEbwz.Persistance;

import NEbwz.Model.Fernseher;

import java.time.LocalDate;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DbInitializer {
    private FernseherPersistence fernseherPersistence;
    private KundePersistence kundePersistence;
    private BestellungPersistence bestellungPersistence;

    public DbInitializer(
        FernseherPersistence fernseherPersistence,
        KundePersistence kundePersistence,
        BestellungPersistence bestellungPersistence)
    {
        this.fernseherPersistence = fernseherPersistence;
        this.kundePersistence = kundePersistence;
        this.bestellungPersistence = bestellungPersistence;
    }

    public void initialize() {
        if (kundePersistence.getKunden().isEmpty()) {
            seedKunden();
        }

        if (fernseherPersistence.getFernseher().isEmpty()) {
            seedTvs();
        }

        if (bestellungPersistence.getBestellungen().isEmpty()) {
            seedBestellungen();
        }
    }

    private void seedBestellungen() {

    }

    private void seedKunden() {

    }

    private void seedTvs() {
        Fernseher tv1 = new Fernseher();
        tv1.setMarke("Samsung");
        tv1.setModell("Q80C");
        tv1.setPreis(1299.99);
        tv1.setBildschirmdiagonale("65 Zoll");
        tv1.setDisplayTechnologie("QLED");
        tv1.setAufloesung("4K UHD");
        tv1.setBildwiederholfrequenz(120);
        tv1.setGewicht(21.5);
        tv1.setReleaseDatum(LocalDate.of(2023, 5, 12));
        tv1.setPixelAufloesung("3840 x 2160");
        tv1.setNennleistung(180);
        fernseherPersistence.addFernseher(tv1);

        Fernseher tv2 = new Fernseher();
        tv2.setMarke("LG");
        tv2.setModell("OLED C3");
        tv2.setPreis(1899.00);
        tv2.setBildschirmdiagonale("55 Zoll");
        tv2.setDisplayTechnologie("OLED");
        tv2.setAufloesung("4K UHD");
        tv2.setBildwiederholfrequenz(120);
        tv2.setGewicht(14.8);
        tv2.setReleaseDatum(LocalDate.of(2023, 3, 1));
        tv2.setPixelAufloesung("3840 x 2160");
        tv2.setNennleistung(160);
        fernseherPersistence.addFernseher(tv2);

        Fernseher tv3 = new Fernseher();
        tv3.setMarke("Sony");
        tv3.setModell("Bravia X90L");
        tv3.setPreis(999.00);
        tv3.setBildschirmdiagonale("50 Zoll");
        tv3.setDisplayTechnologie("Full Array LED");
        tv3.setAufloesung("4K UHD");
        tv3.setBildwiederholfrequenz(100);
        tv3.setGewicht(13.2);
        tv3.setReleaseDatum(LocalDate.of(2022, 11, 20));
        tv3.setPixelAufloesung("3840 x 2160");
        tv3.setNennleistung(150);
        fernseherPersistence.addFernseher(tv3);

        Fernseher tv4 = new Fernseher();
        tv4.setMarke("Philips");
        tv4.setModell("Ambilight 8507");
        tv4.setPreis(749.00);
        tv4.setBildschirmdiagonale("58 Zoll");
        tv4.setDisplayTechnologie("LED");
        tv4.setAufloesung("4K UHD");
        tv4.setBildwiederholfrequenz(60);
        tv4.setGewicht(17.4);
        tv4.setReleaseDatum(LocalDate.of(2022, 9, 5));
        tv4.setPixelAufloesung("3840 x 2160");
        tv4.setNennleistung(140);
        fernseherPersistence.addFernseher(tv4);

        Fernseher tv5 = new Fernseher();
        tv5.setMarke("Panasonic");
        tv5.setModell("LZ1500");
        tv5.setPreis(1599.00);
        tv5.setBildschirmdiagonale("55 Zoll");
        tv5.setDisplayTechnologie("OLED");
        tv5.setAufloesung("4K UHD");
        tv5.setBildwiederholfrequenz(120);
        tv5.setGewicht(16.0);
        tv5.setReleaseDatum(LocalDate.of(2023, 4, 10));
        tv5.setPixelAufloesung("3840 x 2160");
        tv5.setNennleistung(165);
        fernseherPersistence.addFernseher(tv5);

        Fernseher tv6 = new Fernseher();
        tv6.setMarke("TCL");
        tv6.setModell("C745");
        tv6.setPreis(699.00);
        tv6.setBildschirmdiagonale("55 Zoll");
        tv6.setDisplayTechnologie("QLED");
        tv6.setAufloesung("4K UHD");
        tv6.setBildwiederholfrequenz(144);
        tv6.setGewicht(15.3);
        tv6.setReleaseDatum(LocalDate.of(2023, 6, 18));
        tv6.setPixelAufloesung("3840 x 2160");
        tv6.setNennleistung(155);
        fernseherPersistence.addFernseher(tv6);

        Fernseher tv7 = new Fernseher();
        tv7.setMarke("Hisense");
        tv7.setModell("U8K");
        tv7.setPreis(1199.00);
        tv7.setBildschirmdiagonale("65 Zoll");
        tv7.setDisplayTechnologie("Mini-LED");
        tv7.setAufloesung("4K UHD");
        tv7.setBildwiederholfrequenz(144);
        tv7.setGewicht(22.0);
        tv7.setReleaseDatum(LocalDate.of(2023, 7, 2));
        tv7.setPixelAufloesung("3840 x 2160");
        tv7.setNennleistung(190);
        fernseherPersistence.addFernseher(tv7);

        Fernseher tv8 = new Fernseher();
        tv8.setMarke("Sharp");
        tv8.setModell("EQ3");
        tv8.setPreis(599.00);
        tv8.setBildschirmdiagonale("50 Zoll");
        tv8.setDisplayTechnologie("QLED");
        tv8.setAufloesung("4K UHD");
        tv8.setBildwiederholfrequenz(60);
        tv8.setGewicht(12.9);
        tv8.setReleaseDatum(LocalDate.of(2022, 8, 15));
        tv8.setPixelAufloesung("3840 x 2160");
        tv8.setNennleistung(130);
        fernseherPersistence.addFernseher(tv8);

        Fernseher tv9 = new Fernseher();
        tv9.setMarke("Grundig");
        tv9.setModell("Vision 7");
        tv9.setPreis(449.00);
        tv9.setBildschirmdiagonale("43 Zoll");
        tv9.setDisplayTechnologie("LED");
        tv9.setAufloesung("Full HD");
        tv9.setBildwiederholfrequenz(60);
        tv9.setGewicht(8.5);
        tv9.setReleaseDatum(LocalDate.of(2021, 10, 30));
        tv9.setPixelAufloesung("1920 x 1080");
        tv9.setNennleistung(90);
        fernseherPersistence.addFernseher(tv9);

        Fernseher tv10 = new Fernseher();
        tv10.setMarke("Metz");
        tv10.setModell("Topas 65");
        tv10.setPreis(1399.00);
        tv10.setBildschirmdiagonale("65 Zoll");
        tv10.setDisplayTechnologie("OLED");
        tv10.setAufloesung("4K UHD");
        tv10.setBildwiederholfrequenz(120);
        tv10.setGewicht(24.0);
        tv10.setReleaseDatum(LocalDate.of(2023, 2, 14));
        tv10.setPixelAufloesung("3840 x 2160");
        tv10.setNennleistung(175);
        fernseherPersistence.addFernseher(tv10);
    }
}