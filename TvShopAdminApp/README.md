# TvShopAdminApp

Java-Swing-Desktopanwendung zur Verwaltung eines TV-Shops (Modul M165). Verwaltet Kunden, Fernseher und Bestellungen über eine MongoDB-Datenbank.

## Funktionen

- **Kundenverwaltung** – Anlegen, Bearbeiten und Löschen von Kunden inkl. Adresse und Kontaktdaten
- **Fernseherverwaltung** – Verwaltung des Fernseher-Sortiments (Marke, Modell, Preis, technische Daten)
- **Bestellungsverwaltung** – Erfassen von Bestellungen mit mehreren Bestellpositionen pro Kunde
- **Passwortsicherheit** – Kundenpasswörter werden nicht im Klartext gespeichert, sondern mit PBKDF2WithHmacSHA1 (Salt + Hash) abgelegt
- **Demo-Daten** – Beim ersten Start werden automatisch Beispiel-Kunden, -Fernseher und -Bestellungen angelegt, falls die Datenbank leer ist

## Architektur

Die Anwendung folgt dem MVC-Muster:

```
src/NEbwz/
├── Main.java              Einstiegspunkt
├── Model/                 Domänenmodelle (Kunde, Fernseher, Bestellung, ...)
├── View/                  Swing-Oberfläche (MainFrame)
├── Controller/             Vermittelt zwischen View und Persistance
└── Persistance/            Zugriff auf MongoDB (inkl. DbInitializer für Seed-Daten)
```

## Voraussetzungen

- Java JDK (IntelliJ-Projekt, siehe `TvShopAdminApp.iml`)
- Laufende MongoDB-Instanz auf `mongodb://localhost:27017`
- MongoDB Java Driver 3.12.14 (bereits im Ordner `lib/` enthalten)

## Starten

1. MongoDB lokal starten (Standardport `27017`)
2. Projekt in IntelliJ IDEA öffnen
3. `src/NEbwz/Main.java` ausführen

Die Datenbank `TVShop` sowie die Collections `Kunde`, `Fernseher` und `Bestellung` werden automatisch angelegt und beim ersten Start mit Beispieldaten befüllt.

## Technologien

- Java Swing (GUI)
- MongoDB (Datenpersistenz, POJO-Codec)
- PBKDF2 (Passwort-Hashing)
