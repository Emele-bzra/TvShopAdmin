package NEbwz.Persistance;

import NEbwz.Model.*;

import java.time.LocalDate;
import java.util.List;

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
        Kunde firstKunde = kundePersistence.getKunden().getFirst();
        List<Fernseher> fernseher = fernseherPersistence.getFernseher();

        Bestellung newBestellung = new Bestellung();
        newBestellung.setKunde(firstKunde);
        newBestellung.setBestelldatum(LocalDate.of(2025, 10, 25));
        newBestellung.setTotal(5097.99);

        BestellPosition p1 = new BestellPosition();
        p1.setTv(fernseher.getFirst());
        p1.setStueckzahl(1);

        BestellPosition p2 = new BestellPosition();
        p2.setTv(fernseher.get(1));
        p2.setStueckzahl(2);

        newBestellung.getPositionen().add(p1);
        newBestellung.getPositionen().add(p2);
        bestellungPersistence.addBestellung(newBestellung);
    }

    private void seedKunden() {
        Adresse a1 = new Adresse("Bahnhofstrasse 12", "8001", "Zürich");
        Adresse a2 = new Adresse("Seestrasse 88", "8640", "Rapperswil");
        Adresse a3 = new Adresse("Hauptplatz 5", "9000", "St. Gallen");
        Adresse a4 = new Adresse("Dorfweg 3", "6300", "Zug");
        Adresse a5 = new Adresse("Industriestrasse 44", "8400", "Winterthur");
        Adresse a6 = new Adresse("Poststrasse 10", "7000", "Chur");
        Adresse a7 = new Adresse("Alpenblick 7", "3800", "Interlaken");
        Adresse a8 = new Adresse("Marktgasse 2", "3011", "Bern");
        Adresse a9 = new Adresse("Rheinweg 21", "4051", "Basel");
        Adresse a10 = new Adresse("Lindenstrasse 9", "6003", "Luzern");

        Kunde p1 = new Kunde();
        p1.setAnrede("Herr");
        p1.setNachname("Müller");
        p1.setVorname("Thomas");
        p1.setAdresse(a1);
        p1.setTelefonPrivat("044 123 45 67");
        p1.setTelefonMobile("079 111 22 33");
        p1.setEmail("thomas.mueller@example.com");
        p1.setGeburtsdatum(LocalDate.of(1985, 3, 12));
        p1.setUsername("tmueller");
        p1.setPasswort("Passwort123!");
        kundePersistence.addKunden(p1);

        Kunde p2 = new Kunde();
        p2.setAnrede("Frau");
        p2.setNachname("Schneider");
        p2.setVorname("Laura");
        p2.setAdresse(a2);
        p2.setTelefonPrivat("055 210 33 44");
        p2.setTelefonMobile("078 555 66 77");
        p2.setEmail("laura.schneider@example.com");
        p2.setGeburtsdatum(LocalDate.of(1992, 7, 5));
        p2.setUsername("lschneider");
        p2.setPasswort("Sommer2024!");
        kundePersistence.addKunden(p2);

        Kunde p3 = new Kunde();
        p3.setAnrede("Herr");
        p3.setNachname("Keller");
        p3.setVorname("Marco");
        p3.setAdresse(a3);
        p3.setTelefonPrivat("071 222 11 55");
        p3.setTelefonMobile("079 888 99 00");
        p3.setEmail("marco.keller@example.com");
        p3.setGeburtsdatum(LocalDate.of(1978, 11, 22));
        p3.setUsername("mkeller");
        p3.setPasswort("Winter!2024");
        kundePersistence.addKunden(p3);

        Kunde p4 = new Kunde();
        p4.setAnrede("Frau");
        p4.setNachname("Huber");
        p4.setVorname("Nina");
        p4.setAdresse(a4);
        p4.setTelefonPrivat("041 555 44 33");
        p4.setTelefonMobile("076 123 45 67");
        p4.setEmail("nina.huber@example.com");
        p4.setGeburtsdatum(LocalDate.of(1999, 1, 14));
        p4.setUsername("nhuber");
        p4.setPasswort("ZugLife2024!");
        kundePersistence.addKunden(p4);

        Kunde p5 = new Kunde();
        p5.setAnrede("Herr");
        p5.setNachname("Fischer");
        p5.setVorname("Daniel");
        p5.setAdresse(a5);
        p5.setTelefonPrivat("052 333 22 11");
        p5.setTelefonMobile("079 444 55 66");
        p5.setEmail("daniel.fischer@example.com");
        p5.setGeburtsdatum(LocalDate.of(1980, 6, 30));
        p5.setUsername("dfischer");
        p5.setPasswort("Fisch2024!");
        kundePersistence.addKunden(p5);

        Kunde p6 = new Kunde();
        p6.setAnrede("Frau");
        p6.setNachname("Baumann");
        p6.setVorname("Sabrina");
        p6.setAdresse(a6);
        p6.setTelefonPrivat("081 222 33 44");
        p6.setTelefonMobile("078 222 33 44");
        p6.setEmail("sabrina.baumann@example.com");
        p6.setGeburtsdatum(LocalDate.of(1995, 9, 3));
        p6.setUsername("sbaumann");
        p6.setPasswort("Chur2024!");
        kundePersistence.addKunden(p6);

        Kunde p7 = new Kunde();
        p7.setAnrede("Herr");
        p7.setNachname("Graf");
        p7.setVorname("Lukas");
        p7.setAdresse(a7);
        p7.setTelefonPrivat("033 555 66 77");
        p7.setTelefonMobile("079 999 88 77");
        p7.setEmail("lukas.graf@example.com");
        p7.setGeburtsdatum(LocalDate.of(1988, 12, 9));
        p7.setUsername("lgraf");
        p7.setPasswort("Interlaken2024!");
        kundePersistence.addKunden(p7);

        Kunde p8 = new Kunde();
        p8.setAnrede("Frau");
        p8.setNachname("Meier");
        p8.setVorname("Julia");
        p8.setAdresse(a8);
        p8.setTelefonPrivat("031 222 44 55");
        p8.setTelefonMobile("076 777 88 99");
        p8.setEmail("julia.meier@example.com");
        p8.setGeburtsdatum(LocalDate.of(1990, 4, 18));
        p8.setUsername("jmeier");
        p8.setPasswort("Bern2024!");
        kundePersistence.addKunden(p8);

        Kunde p9 = new Kunde();
        p9.setAnrede("Herr");
        p9.setNachname("Weber");
        p9.setVorname("Patrick");
        p9.setAdresse(a9);
        p9.setTelefonPrivat("061 333 22 44");
        p9.setTelefonMobile("079 333 22 44");
        p9.setEmail("patrick.weber@example.com");
        p9.setGeburtsdatum(LocalDate.of(1983, 2, 25));
        p9.setUsername("pweber");
        p9.setPasswort("Basel2024!");
        kundePersistence.addKunden(p9);

        Kunde p10 = new Kunde();
        p10.setAnrede("Frau");
        p10.setNachname("Kunz");
        p10.setVorname("Mara");
        p10.setAdresse(a10);
        p10.setTelefonPrivat("041 777 66 55");
        p10.setTelefonMobile("078 111 00 99");
        p10.setEmail("mara.kunz@example.com");
        p10.setGeburtsdatum(LocalDate.of(2001, 8, 7));
        p10.setUsername("mkunz");
        p10.setPasswort("Luzern2024!");
        kundePersistence.addKunden(p10);
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