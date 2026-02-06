package NEbwz.View;

import NEbwz.Modell.DisplayTechnologie;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

   // alle Elemente
    private JTabbedPane tabbedPane;
    private JList<String> tvList;
    private DefaultListModel<String> tvListModel;
    private JTextField txtMarke, txtModell, txtPreis, txtDiagonale, txtFrequenz, txtGewicht, txtRelease, txtPixel, txtLeistung, txtAufloesung;
    private JComboBox<DisplayTechnologie> cbTechnologie;
    private JButton btnHinzufuegen, btnLoeschen, btnSpeichern;


    private JList<String> kundeList;
    private DefaultListModel<String> kundeListModel;
    private JTextField txtKundeVorname, txtKundeNachname, txtKundeStrasse, txtKundePlz, txtKundeOrt, txtKundeEmail, txtKundeTelefon;
    private JButton btnKundeHinzufuegen, btnKundeLoeschen, btnKundeSpeichern;

    public MainFrame() {
        setTitle("TV_Shop Admin-App");
        setSize(950, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        tabbedPane = new JTabbedPane();

        //  TVs Tab
        tabbedPane.addTab("TVs", createTvPanel());

        // Kunden tab
        tabbedPane.addTab("Kunden", createKundePanel());

        //Bestellungen Tab
        JPanel bestellungPanel = new JPanel(new BorderLayout());
        bestellungPanel.add(new JLabel("Hier kommen die Bestellungen hin", SwingConstants.CENTER));
        tabbedPane.addTab("Bestellungen", bestellungPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createTvPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // Liste Links mit den vorgegebenen elementen
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("TV Liste"));
        tvListModel = new DefaultListModel<>();
        tvListModel.addElement("Samsung G8");
        tvListModel.addElement("Samsung G8");
        tvList = new JList<>(tvListModel);
        left.add(new JScrollPane(tvList), BorderLayout.CENTER);
        left.setPreferredSize(new Dimension(220, 0));
        panel.add(left, BorderLayout.WEST);

        // Details Mitte
        JPanel details = new JPanel(new GridBagLayout());
        details.setBorder(BorderFactory.createTitledBorder("Details:"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); gbc.fill = GridBagConstraints.HORIZONTAL;
        int r = 0;
        addLabelAndField(details, "Marke:", txtMarke = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Modell:", txtModell = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Preis (CHF):", txtPreis = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Bildschirmdiagonale:", txtDiagonale = new JTextField(20), gbc, r++);

        gbc.gridy = r++; gbc.gridx = 0; details.add(new JLabel("Display-Technologie:"), gbc);
        cbTechnologie = new JComboBox<>(DisplayTechnologie.values());
        gbc.gridx = 1; details.add(cbTechnologie, gbc);

        addLabelAndField(details, "Bildschirmauflösung:", txtAufloesung = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Wiederholfrequenz (Hz):", txtFrequenz = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Gewicht (Kg):", txtGewicht = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Releasedatum:", txtRelease = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Pixel:", txtPixel = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Nennleistung (w):", txtLeistung = new JTextField(20), gbc, r++);
        panel.add(details, BorderLayout.CENTER);

        // Buttons Unten
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

        // Übersichts liste
        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Kunden Liste"));
        kundeListModel = new DefaultListModel<>();
        kundeListModel.addElement("Müller Hans");
        kundeList = new JList<>(kundeListModel);
        left.add(new JScrollPane(kundeList), BorderLayout.CENTER);
        left.setPreferredSize(new Dimension(220, 0));
        panel.add(left, BorderLayout.WEST);

        // Details mite
        JPanel details = new JPanel(new GridBagLayout());
        details.setBorder(BorderFactory.createTitledBorder("Kunden Details:"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); gbc.fill = GridBagConstraints.HORIZONTAL;
        int r = 0;
        addLabelAndField(details, "Vorname:", txtKundeVorname = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Nachname:", txtKundeNachname = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Strasse:", txtKundeStrasse = new JTextField(20), gbc, r++);
        addLabelAndField(details, "PLZ:", txtKundePlz = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Ort:", txtKundeOrt = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Email:", txtKundeEmail = new JTextField(20), gbc, r++);
        addLabelAndField(details, "Telefon:", txtKundeTelefon = new JTextField(20), gbc, r++);
        panel.add(details, BorderLayout.CENTER);

        // Buttons bottom
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnKundeHinzufuegen = new JButton("Kunde Hinzufügen");
        btnKundeLoeschen = new JButton("Kunde Löschen");
        btnKundeSpeichern = new JButton("Kunde Speichern");
        south.add(btnKundeHinzufuegen); south.add(btnKundeLoeschen); south.add(Box.createHorizontalStrut(20)); south.add(btnKundeSpeichern);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }

    private void addLabelAndField(JPanel panel, String labelText, JTextField field, GridBagConstraints gbc, int row) {
        gbc.gridy = row; gbc.gridx = 0;
        panel.add(new JLabel(labelText), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }
}