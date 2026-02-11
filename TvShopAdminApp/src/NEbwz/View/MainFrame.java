package NEbwz.View;

import NEbwz.Controller.FernseherController;
import NEbwz.Controller.MainFrameController;
import NEbwz.Model.DisplayTechnologie;
import NEbwz.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private MainFrameController controller;

    //attribute Für Fernseher
    private JTabbedPane tabbedPane;

    private JList<String> tvList;
    private JList<String> tvListModel;
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
    private JButton btnHinzufuegen;
    private JButton btnLoeschen;
    private JButton  btnSpeichern;

    //Attribute Für kuden
    private JList<String> kundeList;
    private DefaultListModel<String> kundeListModel;
    private JTextField txtKundeVorname;
    private JTextField txtKundeNachname;
    private JTextField txtKundeStrasse;
    private JTextField txtKundePlz;
    private JTextField txtKundeOrt;
    private JTextField txtKundeEmail;
    private JTextField txtKundeTelefon;


    private JButton btnKundeHinzufuegen;
    private JButton btnKundeLoeschen;
    private JButton btnKundeSpeichern;

    public MainFrame(MainFrameController controller) {
        this.controller = controller;

        setTitle("TV_Shop Admin-App");
        setSize(950, 580);
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
        DefaultListModel<String> tvListModel = new DefaultListModel<>();

        tvListModel.addElement("Samsung G8");
        tvListModel.addElement("Sony PqP 3 Pro");
        tvListModel.addElement("LG Plasma +");

        JList<String> tvList = new JList<>(tvListModel);

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
        btnHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // text holen
                    controller.saveTvToDb(
                            getTxtMarke().getText(),
                            getTxtModell().getText(),
                            getTxtDiagonale().getText(),
                            getTxtPreis().getText(),
                            getTxtFrequenz().getText(),
                            getTxtGewicht().getText(),
                            getTxtRelease().getText(),
                            getTxtPixel().getText(),
                            getTxtAufloesung().getText(),
                            getTxtLeistung().getText()
                    );

                    // felder leeren
                    getTxtMarke().setText("");
                    getTxtModell().setText("");
                    getTxtPreis().setText("");
                    getTxtDiagonale().setText("");
                    getTxtAufloesung().setText("");
                    getTxtFrequenz().setText("");
                    getTxtGewicht().setText("");
                    getTxtRelease().setText("");
                    getTxtPixel().setText("");
                    getTxtLeistung().setText("");

                    // ComboBox auf den ersten Eintrag zurücksetzen
                    getCbTechnologie().setSelectedIndex(0);

                    // Fokus wieder auf das erste Feld setzen für die nächste Eingabe
                    getTxtMarke().requestFocus();

                    System.out.println("TV hinzugefügt und Felder geleert.");

                } catch (NumberFormatException ex) {
                    // Falls der Controller beim Umwandeln der Zahlen (Preis, Watt etc.) einen Fehler wirft
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Fehler: Bitte überprüfe die Zahlenfelder! Die Eingaben wurden nicht gelöscht.");
                }
            }

        });



        btnLoeschen = new JButton("Löschen");
        btnLoeschen.addActionListener(new ActionListener() {
            String tv = tvList.getSelectedValue();

            @Override
            public void actionPerformed(ActionEvent e) {
                // Alle Textfelder auf leer setzen
                getTxtMarke().setText("");
                getTxtModell().setText("");
                getTxtPreis().setText("");
                getTxtDiagonale().setText("");
                getTxtAufloesung().setText("");
                getTxtFrequenz().setText("");
                getTxtGewicht().setText("");
                getTxtRelease().setText("");
                getTxtPixel().setText("");
                getTxtLeistung().setText("");

                // ComboBox auf das erste Element zurücksetzen
                getCbTechnologie().setSelectedIndex(0);

                //controller.delete();
            }
        });
        btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tv = tvList.getSelectedValue();

                    tv.
                    controller.saveTvToDb(
                            getTxtMarke().getText(),
                            getTxtModell().getText(),
                            getTxtDiagonale().getText(),
                            getTxtPreis().getText(),
                            getTxtFrequenz().getText(),
                            getTxtGewicht().getText(),
                            getTxtRelease().getText(),
                            getTxtPixel().getText(),
                            getTxtAufloesung().getText(),
                            getTxtLeistung().getText()
                    );


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Fehler: Bitte überprüfe die INT werte (Preis, Gewicht, Hz, Watt)!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Allgemeiner Fehler: " + ex.getMessage());
                }
            }
        });

        south.add(btnHinzufuegen);
        south.add(btnLoeschen); south.add(Box.createHorizontalStrut(20));
        south.add(btnSpeichern);
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
        btnKundeHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.saveKundeToDb(
                            getTxtKundeVorname().getText(),
                            getTxtKundeNachname().getText(),
                            getTxtKundeStrasse().getText(),
                            getTxtKundePlz().getText(),
                            getTxtKundeOrt().getText(),
                            getTxtKundeEmail().getText(),
                            getTxtKundeTelefon().getText()
                    );

                    // Alle Felder leeren
                    getTxtKundeVorname().setText("");
                    getTxtKundeNachname().setText("");
                    getTxtKundeStrasse().setText("");
                    getTxtKundePlz().setText("");
                    getTxtKundeOrt().setText("");
                    getTxtKundeEmail().setText("");
                    getTxtKundeTelefon().setText("");

                    getTxtKundeVorname().requestFocus();

                    System.out.println("Kunde erfolgreich gespeichert und Felder geleert.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Fehler beim Hinzufügen des Kunden: " + ex.getMessage());
                }
            }
        });


        btnKundeLoeschen = new JButton("Kunde Löschen");
        btnKundeLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                        getTxtKundeVorname().setText(" ");
                        getTxtKundeNachname().setText(" ");
                        getTxtKundeStrasse().setText(" ");
                        getTxtKundePlz().setText(" ");
                        getTxtKundeOrt().setText(" ");
                        getTxtKundeEmail().setText(" ");
                        getTxtKundeTelefon().setText(" ");


                getCbTechnologie().setSelectedIndex(0);

                //controller.delete();
            }
        });

        btnKundeSpeichern = new JButton("Kunde Speichern");
        btnKundeSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    controller.saveKundeToDb(
                            getTxtKundeVorname().getText(),
                            getTxtKundeNachname().getText(),
                            getTxtKundeStrasse().getText(),
                            getTxtKundePlz().getText(),
                            getTxtKundeOrt().getText(),
                            getTxtKundeEmail().getText(),
                            getTxtKundeTelefon().getText()
                    );

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Fehler: Bitte überprüfe die INT werte (Preis, Gewicht, Hz, Watt)!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Allgemeiner Fehler: " + ex.getMessage());
                }
            }
        });



        south.add(btnKundeHinzufuegen); south.add(btnKundeLoeschen); south.add(Box.createHorizontalStrut(20)); south.add(btnKundeSpeichern);
        panel.add(south, BorderLayout.SOUTH);

        return panel;
    }

    public JTextField getTxtMarke() { return txtMarke; }
    public JTextField getTxtModell() { return txtModell; }
    public JTextField getTxtPreis() { return txtPreis; }
    public JTextField getTxtDiagonale() { return txtDiagonale; }
    public JTextField getTxtFrequenz() { return txtFrequenz; }
    public JTextField getTxtGewicht() { return txtGewicht; }
    public JTextField getTxtRelease() { return txtRelease; }
    public JTextField getTxtPixel() { return txtPixel; }
    public JTextField getTxtLeistung() { return txtLeistung; }
    public JTextField getTxtAufloesung() { return txtAufloesung; }
    public JComboBox<DisplayTechnologie> getCbTechnologie() { return cbTechnologie; }
    public JButton getBtnSpeichern() { return btnSpeichern; }
    public DefaultListModel<String> getTvListModel() { return tvListModel; }

    public MainFrameController getController() {
        return controller;
    }

    public void setController(MainFrameController controller) {
        this.controller = controller;
    }

    public JTextField getTxtKundeVorname() {
        return txtKundeVorname;
    }

    public void setTxtKundeVorname(JTextField txtKundeVorname) {
        this.txtKundeVorname = txtKundeVorname;
    }

    public JTextField getTxtKundeNachname() {
        return txtKundeNachname;
    }

    public void setTxtKundeNachname(JTextField txtKundeNachname) {
        this.txtKundeNachname = txtKundeNachname;
    }

    public JTextField getTxtKundeStrasse() {
        return txtKundeStrasse;
    }

    public void setTxtKundeStrasse(JTextField txtKundeStrasse) {
        this.txtKundeStrasse = txtKundeStrasse;
    }

    public JTextField getTxtKundeOrt() {
        return txtKundeOrt;
    }

    public void setTxtKundeOrt(JTextField txtKundeOrt) {
        this.txtKundeOrt = txtKundeOrt;
    }

    public JTextField getTxtKundePlz() {
        return txtKundePlz;
    }

    public void setTxtKundePlz(JTextField txtKundePlz) {
        this.txtKundePlz = txtKundePlz;
    }

    public JTextField getTxtKundeEmail() {
        return txtKundeEmail;
    }

    public void setTxtKundeEmail(JTextField txtKundeEmail) {
        this.txtKundeEmail = txtKundeEmail;
    }

    public JTextField getTxtKundeTelefon() {
        return txtKundeTelefon;
    }

    public void setTxtKundeTelefon(JTextField txtKundeTelefon) {
        this.txtKundeTelefon = txtKundeTelefon;
    }
}