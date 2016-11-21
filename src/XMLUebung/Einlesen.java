package XMLUebung;

import java.io.File;
import java.time.LocalDateTime;
import java.io.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

/**
 * Einlesen
 * 
 * Liest eine xml datei ein und produziert ein Sensorobjekt darauß.
 * 
 * @author phil
 *
 */
public class Einlesen {
	private String nameXMLDatei;
	
	public Einlesen(String nameXMLDatei ){
		this.nameXMLDatei=nameXMLDatei;
	}
	/**
	 * importSensor
	 * 
	 * Nimmt eine vorhandene XML-Datei und erstellt ein Sensorobjekt darauß.
	 * 
	 */
	public Sensor importSensor() {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(nameXMLDatei));

			// Sicherung des Rootnodes
			Node root = (Node) document.getDocumentElement();

			// Erstellen einer NamedNodeMap, in der alle Attribute des Rootnodes
			// festgehalten werden
			NamedNodeMap attribute = root.getAttributes();

			// ID Speicher
			String[] sensorenID = new String[20];

			// Anzahl der Senoren, um das Array vorzubereiten.
			int anzSensoren = 0;

			/*
			 * Nimmt das erste weitere Attribut und liefert es als Node an
			 * attribut zurück.
			 */
			for (int i = 0; i < attribute.getLength(); i++) {

				Node attribut = attribute.item(i);
				sensorenID[i] = attribut.getNodeValue();
				anzSensoren++;
			}

			// Erstellen des Speichers aller Sensoren
			Sensor[] sensoren = new Sensor[anzSensoren];

			// erstellt die Sensoren
			for (int i = 0; i < anzSensoren; i++) {
				sensoren[i] = new Sensor(sensorenID[i]);
			}

			// Vorhanden Messungen ablegen
			Node[] kindKnotenMessungen = kinderAuslesen(root);

			Sensor ausgabeTest = messungenEinfuegen(sensoren[0], kindKnotenMessungen);
			return ausgabeTest;

		} catch (ParserConfigurationException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * kinderAuslesen
	 * 
	 * kinderAuslesen nimmt den root und kopiert seine Kinder, speichert diese
	 * in einem Node-Array ab und liefert dieses zurück.
	 * 
	 * @param root
	 *            Node, wessen Kinder ausgelesen werden sollen.
	 * 
	 * @return Nodearray, welches alle Kinder von root enthält.
	 */
	public Node[] kinderAuslesen(Node root) {

		// Erstellen einer Liste, mit allen vorhanden Kindern
		NodeList childrenRoot = root.getChildNodes();

		// Vorbereitung des Rückgabearrays
		Node[] kindKnotenMessungen = new Node[root.getChildNodes().getLength()];

		// Iteration über Liste und einfügen der vorhandenen Kindern in ein
		// sepperates Array
		for (int i = 1; i <= childrenRoot.getLength(); i++) {
			if (childrenRoot.item(i) != null) {
				kindKnotenMessungen[i] = root.getChildNodes().item(i);
			}
		}
		return kindKnotenMessungen;
	}

	/**
	 * messungenEinfuegen
	 * 
	 * Diese Methode fügt einem als Parameter übergebenen Sensor, die ihr als
	 * Parameter übergebenen Messungen hinzu. Diese sind jedoch nur als
	 * Nodeobjekte vorliegend, weshalb diese erst von der Methode bearbeitet
	 * werden.
	 * 
	 * @param sensor
	 *            Sensor, welchem die Messungen zugefügt werden sollen
	 * @param kindKnotenMessungen
	 *            Nodes, welche Messungen enthalten und dem Sensor angefügt
	 *            werden sollen
	 * @return fertiges Sensorobjekt
	 */
	public Sensor messungenEinfuegen(Sensor sensor, Node[] kindKnotenMessungen) {

		// Variable um die Anzahl der vorhanden
		// Messungen festzuhalten

		int anzMessungen = 0;

		for (int i = 0; i < kindKnotenMessungen.length; i++) {
			if (kindKnotenMessungen[i] == null) {
				continue;
			}
			anzMessungen++;
		}
		Messung[] sensorMessungen = new Messung[anzMessungen];

		// Variable um sich zu merken wo man im sensorMessungsarray ist
		int position = 0;

		// Iteration über Messungen und Entnahme der Attribute
		for (int i = 0; i < kindKnotenMessungen.length; i++) {
			if (kindKnotenMessungen[i] == null) {
				continue;
			}

			System.out.println(kindKnotenMessungen[i].getNodeName());

			// Check ob der Node über Attribute verfügt
			if (kindKnotenMessungen[i].hasAttributes()) {

				// Auslesen der Attribute und eintragen in das Messungsarray
				NamedNodeMap att = kindKnotenMessungen[i].getAttributes();
				System.out.println(att.item(0).getNodeName() + ": " + att.item(0).getNodeValue());
				System.out.println(att.item(1).getNodeName() + ": " + att.item(1).getNodeValue());

				sensorMessungen[position] = new Messung(Double.parseDouble(att.item(0).getNodeValue()),
						LocalDateTime.parse(att.item(1).getNodeValue()));
				position++;
			}

		}
		// Befüllen des Sensors mit Messwerten
		for (int i = 0; i < sensorMessungen.length; i++) {
			// wir gehen davon aus, dass es nur einen sensor gibt
			sensor.messungHinzufuegen(sensorMessungen[i]);
		}
		return sensor;
	}

	public static void main(String[] args) {
		Einlesen e = new Einlesen("Sensor.xml");
		e.importSensor();

	}
}
