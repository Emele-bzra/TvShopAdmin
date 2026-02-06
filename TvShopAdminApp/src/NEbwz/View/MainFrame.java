package NEbwz.View;

import NEbwz.Modell.DisplayTechnologie;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTabbedPane tabbedPane;

    private JList<String> tvList;
    private DefaultListModel<String> tvListModel;
    private JTextField txtMarke;
    private JTextField txtModell;
    private JTextField txtPreis;
    private JTextField txtDiagonale;
    private JTextField txtFrequenz;
    private JTextField txtGewicht;
    private JTextField txtRelease;
    private JTextField txtPixel;
    private JTextField txtLeistung;
    private JTextField txtAufloesung;

    private JComboBox<DisplayTechnologie> cbTechnologie;
    private JButton btnHinzufuegen, btnLoeschen, btnSpeichern;

    private JList<String> kundeList;
    private DefaultListModel<String> kundeListModel;
    private JTextField txtKundeVorname;
    private JTextField txtKundeNachname;
    private JTextField txtKundeStrasse;
    private JTextField txtKundePlz;
    private JTextField txtKundeOrt;
    private JTextField txtKundeEmail;
    private JTextField txtKundeTelefon;

   //Buttons
    private JButton btnKundeHinzufuegen;
    private JButton btnKundeLoeschen;
    private JButton btnKundeSpeichern;

    public MainFrame() {
        setTitle("TV_Shop Admin-App");
        setSize(950, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("TVs", createTvPanel());
        tabbedPane.addTab("Kunden", createKundePanel());


        JPanel bestellungPanel = new JPanel(new BorderLayout());
        bestellungPanel.add(new JLabel("Hier kommen die Bestellungen hin", SwingConstants.CENTER));
        tabbedPane.addTab("Bestellungen", bestellungPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createTvPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));


        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("TV Liste"));
        tvListModel = new DefaultListModel<>();
        tvListModel.addElement("Samsung G8");
        tvListModel.addElement("Sony PqP 3 Pro");
        tvListModel.addElement("LG Plasma +");
        tvList = new JList<>(tvListModel);
        left.add(new JScrollPane(tvList), BorderLayout.CENTER);
        left.setPreferredSize(new Dimension(220, 0));
        panel.add(left, BorderLayout.WEST);


        JPanel details = new JPanel(new GridLayout(11, 2, 10, 10));
        details.setBorder(BorderFactory.createTitledBorder("Details:"));

        details.add(new JLabel("Marke:"));
        details.add(txtMarke = new JTextField());

        details.add(new JLabel("Modell:"));
        details.add(txtModell = new JTextField());

        details.add(new JLabel("Preis (CHF):"));
        details.add(txtPreis = new JTextField());

        details.add(new JLabel("Bildschirmdiagonale:"));
        details.add(txtDiagonale = new JTextField());

        details.add(new JLabel("Display-Technologie:"));
        cbTechnologie = new JComboBox<>(DisplayTechnologie.values());
        details.add(cbTechnologie);

        details.add(new JLabel("Bildschirmauflösung:"));
        details.add(txtAufloesung = new JTextField());

        details.add(new JLabel("Wiederholfrequenz (Hz):"));
        details.add(txtFrequenz = new JTextField());

        details.add(new JLabel("Gewicht (Kg):"));
        details.add(txtGewicht = new JTextField());

        details.add(new JLabel("Releasedatum:"));
        details.add(txtRelease = new JTextField());

        details.add(new JLabel("Pixel:"));
        details.add(txtPixel = new JTextField());

        details.add(new JLabel("Nennleistung (w):"));
        details.add(txtLeistung = new JTextField());


        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(details, BorderLayout.NORTH);
        panel.add(wrapper, BorderLayout.CENTER);

        // editier Buttons
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnHinzufuegen = new JButton("Hinzufügen");
        btnLoeschen = new JButton("Löschen");
        btnSpeichern = new JButton("Speichern");
        south.add(btnHinzufuegen); south.add(btnLoeschen); south.add(Box.createHorizontalStrut(20)); south.add(btnSpeichern);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }


    private JPanel createKundePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));


        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Kunden Liste"));
        kundeListModel = new DefaultListModel<>();
        kundeListModel.addElement("Florian Elser");
        kundeListModel.addElement("Noel Emele");
        kundeListModel.addElement("Nicholas Malinov");
        kundeList = new JList<>(kundeListModel);
        left.add(new JScrollPane(kundeList), BorderLayout.CENTER);
        left.setPreferredSize(new Dimension(220, 0));
        panel.add(left, BorderLayout.WEST);

        //Kunden formular
        JPanel details = new JPanel(new GridLayout(7, 2, 10, 10));
        details.setBorder(BorderFactory.createTitledBorder("Kunden Details:"));

        details.add(new JLabel("Vorname:"));
        details.add(txtKundeVorname = new JTextField());

        details.add(new JLabel("Nachname:"));
        details.add(txtKundeNachname = new JTextField());

        details.add(new JLabel("Strasse:"));
        details.add(txtKundeStrasse = new JTextField());

        details.add(new JLabel("PLZ:"));
        details.add(txtKundePlz = new JTextField());

        details.add(new JLabel("Ort:"));
        details.add(txtKundeOrt = new JTextField());

        details.add(new JLabel("Email:"));
        details.add(txtKundeEmail = new JTextField());

        details.add(new JLabel("Telefon:"));
        details.add(txtKundeTelefon = new JTextField());


        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(details, BorderLayout.NORTH);
        panel.add(wrapper, BorderLayout.CENTER);

        //bearbeitungs Buttons
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnKundeHinzufuegen = new JButton("Kunde Hinzufügen");
        btnKundeLoeschen = new JButton("Kunde Löschen");
        btnKundeSpeichern = new JButton("Kunde Speichern");
        south.add(btnKundeHinzufuegen); south.add(btnKundeLoeschen); south.add(Box.createHorizontalStrut(20)); south.add(btnKundeSpeichern);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }
}