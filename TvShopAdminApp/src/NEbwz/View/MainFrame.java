package NEbwz.View;

import NEbwz.Controller.MainFrameController;
import NEbwz.Model.DisplayTechnologie;
import NEbwz.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainFrame extends JFrame {
    private MainFrameController mainFrameController;

    //attribute Für Fernseher
    private JTabbedPane tabbedPane;

    private JList<String> tvList;
    private DefaultListModel<Fernseher> tvListModel = new DefaultListModel<>();
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
    private DefaultListModel<Kunde> kundeListModel = new DefaultListModel<>();
    private JTextField txtKundeVorname;
    private JTextField txtKundeNachname;
    private JTextField txtKundeStrasse;
    private JTextField txtKundePlz;
    private JTextField txtKundeOrt;
    private JTextField txtKundeEmail;
    private JTextField txtKundeTelefon;
    private JTextField txtKundeTelefonMobile;
    private JTextField txtKundeGeburtsdatum;
    private JTextField txtKundeUsername;
    private JPasswordField txtKundePasswort;

    private JButton btnKundeHinzufuegen;
    private JButton btnKundeLoeschen;
    private JButton btnKundeSpeichern;

    public MainFrame(MainFrameController mainFrameController) {
        this.mainFrameController = mainFrameController;

        setTitle("TV Shop");
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

        for (Fernseher fernseher : mainFrameController.getFernsehController().readFernseher()) {
            tvListModel.addElement(fernseher);
        }

        // JList<Fernseher> tvList = new JList<>(tvListModel);
        JList<Fernseher> tvList = new JList<>(tvListModel);
        tvList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Fernseher tv = tvList.getSelectedValue();
                if (tv != null) {
                    // text setzen
                    getTxtMarke().setText(tv.getMarke());
                    getTxtModell().setText(tv.getModell());
                    getTxtDiagonale().setText(tv.getBildschirmdiagonale());
                    getTxtPreis().setText(String.valueOf(tv.getPreis()));
                    getTxtFrequenz().setText(String.valueOf(tv.getBildwiederholfrequenz()));
                    getTxtGewicht().setText(String.valueOf(tv.getGewicht()));
                    getTxtRelease().setText(tv.getReleaseDatum().toString());
                    getTxtPixel().setText(tv.getPixelAufloesung());
                    getTxtAufloesung().setText(tv.getAufloesung());
                    getTxtLeistung().setText(String.valueOf(tv.getNennleistung()));
                    getCbTechnologie().getModel().setSelectedItem(tv.getDisplayTechnologie());
                }
            }
        });

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
                    Fernseher tv = new Fernseher();
                    // text holen
                    tv.setMarke(getTxtMarke().getText());
                    tv.setModell(getTxtModell().getText());
                    tv.setBildschirmdiagonale(getTxtDiagonale().getText());
                    tv.setPreis(Double.parseDouble(getTxtPreis().getText()));
                    tv.setBildwiederholfrequenz(Integer.parseInt(getTxtFrequenz().getText()));
                    tv.setGewicht(Double.parseDouble(getTxtGewicht().getText()));
                    tv.setReleaseDatum(LocalDate.parse(getTxtRelease().getText()));
                    tv.setPixelAufloesung(getTxtPixel().getText());
                    tv.setAufloesung(getTxtAufloesung().getText());
                    tv.setNennleistung(Integer.parseInt(getTxtLeistung().getText()));
                    tv.setDisplayTechnologie(String.valueOf(getCbTechnologie().getModel().getSelectedItem()));

                    mainFrameController.getFernsehController().addFernseher(tv);
                    tvListModel.addElement(tv);

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

                    // ComboBox auf index 0 zurückstellen
                    getCbTechnologie().setSelectedIndex(0);


                    getTxtMarke().requestFocus();

                    System.out.println("TV hinzugefügt und Felder geleert.");

                } catch (NumberFormatException ex) {
                    // Falls es einen datentyp fehler wirft (auslöst)
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Fehler: Bitte überprüfe die Zahlenfelder! Die Eingaben wurden nicht gelöscht.");
                }
            }

        });



        btnLoeschen = new JButton("Löschen");
        btnLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fernseher tv = tvList.getSelectedValue();

                if (tv != null) {
                    mainFrameController.getFernsehController().deleteFernseher(tv);
                    tvListModel.removeElement(tv);

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
                }
            }
        });
        btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Fernseher tv = tvList.getSelectedValue();

                    if (tv != null) {
                        tv.setModell(getTxtModell().getText());
                        tv.setMarke(getTxtMarke().getText());
                        tv.setBildschirmdiagonale(getTxtDiagonale().getText());
                        tv.setPreis(Double.parseDouble(getTxtPreis().getText()));
                        tv.setBildwiederholfrequenz(Integer.parseInt(getTxtFrequenz().getText()));
                        tv.setGewicht(Double.parseDouble(getTxtGewicht().getText()));
                        tv.setReleaseDatum(LocalDate.parse(getTxtRelease().getText()));
                        tv.setAufloesung(getTxtAufloesung().getText());
                        tv.setPixelAufloesung(getTxtPixel().getText());
                        tv.setNennleistung(Integer.parseInt(getTxtLeistung().getText()));
                        tv.setDisplayTechnologie(String.valueOf(getCbTechnologie().getModel().getSelectedItem()));
                        mainFrameController.getFernsehController().updateFernseher(tv);

                        int currentIndex = tvList.getSelectedIndex();
                        tvList.clearSelection();
                        tvList.setSelectedIndex(currentIndex);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Fehler: Bitte überprüfe die INT werte (Preis, Gewicht, Hz, Watt)!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Allgemeiner Fehler: " + ex.getMessage());
                }
            }
        });

        south.add(btnHinzufuegen);
        south.add(btnLoeschen);
        south.add(Box.createHorizontalStrut(20));
        south.add(btnSpeichern);
        panel.add(south, BorderLayout.SOUTH);

        if (!tvListModel.isEmpty()) {
            tvList.setSelectedIndex(0);
        }

        return panel;
    }







    //Kunde----------------------------------------------------------------------------------------------------------------------------------------








    private JPanel createKundePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));


        JPanel left = new JPanel(new BorderLayout());
        left.setBorder(BorderFactory.createTitledBorder("Kunden Liste"));
       /* kundeListModel = new DefaultListModel<>();
        kundeListModel.addElement("Florian Elser");
        kundeListModel.addElement("Noel Emele");
        kundeListModel.addElement("Nicholas Malinov"); */


        for (Kunde kunde : mainFrameController.getKundenController().readKunde()) {
            kundeListModel.addElement(kunde);
        }

        JList<Kunde> kundeList = new JList<>(kundeListModel);
        kundeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Kunde kunde = kundeList.getSelectedValue();
                if (kunde != null) {
                    Addresse addresse = new Addresse();
                    // text setzen
                    getTxtKundeNachname().setText(kunde.getNachname());
                    getTxtKundeVorname().setText(kunde.getVorname());
                    getTxtKundeOrt().setText(addresse.getOrt());
                    getTxtKundePlz().setText(addresse.getPlz());  //--------------------------------------------------------------Fehler
                    getTxtKundeStrasse().setText(addresse.getStrasse());
                    getTxtKundeTelefon().setText(kunde.getTelefonPrivat());
                    getTxtKundeTelefonMobile().setText(String.valueOf(kunde.getTelefonMobile()));
                    getTxtKundeEmail().setText(String.valueOf(kunde.getEmail()));
                    getTxtKundeGeburtsdatum().setText(String.valueOf(kunde.getGeburtsdatum().toString()));
                    getTxtKundeUsername().setText(kunde.getUsername());
                    getTxtKundePasswort().setText(kunde.getPasswort());

                }
            }
        });

        left.add(new JScrollPane(kundeList), BorderLayout.CENTER);
        left.setPreferredSize(new Dimension(220, 0));
        panel.add(left, BorderLayout.WEST);

        //Kunden formular
        JPanel details = new JPanel(new GridLayout(11, 2, 10, 10));
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

        details.add(new JLabel("Mobile Telefon:"));
        details.add(txtKundeTelefonMobile = new JTextField());

        details.add(new JLabel("Geburtsdatum:"));
        details.add(txtKundeGeburtsdatum = new JTextField());

        details.add(new JLabel("Username:"));
        details.add(txtKundeUsername = new JTextField());

        details.add(new JLabel("Passwort:"));
        details.add(txtKundePasswort = new JPasswordField());

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

                    Addresse adresse = new Addresse();
                    Kunde kunde = new Kunde();
                    // text holen
                    kunde.setNachname(getTxtKundeNachname().getText());
                    kunde.setVorname(getTxtKundeVorname().getText());
                    adresse.setOrt(getTxtKundeOrt().getText());
                    adresse.setPlz(getTxtKundePlz().getText());
                    adresse.setStrasse(getTxtKundeStrasse().getText());
                    kunde.setTelefonMobile(getTxtKundeTelefonMobile().getText());
                    kunde.setTelefonPrivat(getTxtKundeTelefon().getText());
                    kunde.setEmail(getTxtKundeEmail().getText());       //setBildwiederholfrequenz(Integer.parseInt(getTxtFrequenz().getText()));
                    kunde.setUsername(getTxtKundeUsername().getText());
                    kunde.setPasswort(getTxtKundePasswort().getText());
                    kunde.setGeburtsdatum(LocalDate.parse(getTxtKundeGeburtsdatum().toString()) );

                    mainFrameController.getKundenController().addKunde(kunde);
                    kundeListModel.addElement(kunde);


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
/*
                    controller.saveKundeToDb(
                            getTxtKundeVorname().getText(),
                            getTxtKundeNachname().getText(),
                            getTxtKundeStrasse().getText(),
                            getTxtKundePlz().getText(),
                            getTxtKundeOrt().getText(),
                            getTxtKundeEmail().getText(),
                            getTxtKundeTelefon().getText()
                    );
*/
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
    public DefaultListModel<Fernseher> getTvListModel() { return tvListModel; }



    public JTextField getTxtKundeUsername() {
        return txtKundeUsername;
    }

    public void setTxtKundeUsername(JTextField txtKundeUsername) {
        this.txtKundeUsername = txtKundeUsername;
    }

    public JPasswordField getTxtKundePasswort() {
        return txtKundePasswort;
    }

    public void setTxtKundePasswort(JPasswordField txtKundePasswort) {
        this.txtKundePasswort = txtKundePasswort;
    }

    public JTextField getTxtKundeGeburtsdatum() {
        return txtKundeGeburtsdatum;
    }

    public void setTxtKundeGeburtsdatum(JTextField txtKundeGeburtsdatum) {
        this.txtKundeGeburtsdatum = txtKundeGeburtsdatum;
    }

    public JTextField getTxtKundeTelefonMobile() {
        return txtKundeTelefonMobile;
    }

    public void setTxtKundeTelefonMobile(JTextField txtKundeTelefonMobile) {
        this.txtKundeTelefonMobile = txtKundeTelefonMobile;
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