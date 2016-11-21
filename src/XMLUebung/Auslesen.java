package XMLUebung;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;

	import java.io.File;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.OutputKeys;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerException;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	/**
	 * Auslesen
	 * 
	 * SensorExport ist dafuer verantwortlich, ein Sensorobjekt zu einer XML-Datei
	 * umzuwandeln.
	 * 
	 * 
	 * @author phil,michel
	 *
	 */
	public class Auslesen {
		/**
		 * export
		 * 
		 * export Methode nimmt ein Sensorobjekt, entzieht ihm alle fuer eine
		 * XML-Datei relevanten Daten und erstellt eine XMl-Datei daraus.
		 * 
		 * 
		 * @param s
		 *            Sensorobjekt, zudem eine XML-Datei erstellt werden soll.
		 */
		public static void export(Sensor s) {

			try {

				// irgendwelcher Kram den keine alte Sau versteht
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document document = documentBuilder.newDocument();

				// Erzeugen des rootNodes
				Element rootNode = document.createElement("Sensor");

				// Hinzufuegen des rootNodes in das Dokument
				document.appendChild(rootNode);

				// Hinzufuegen der Attribute des Sensors
				rootNode.setAttribute("ID", s.getId());

				// Erstellen der Messungen
				for (int i = 0; i < s.getMessungen().size(); i++) {

					Element rootNodeChild = document.createElement("Messung");
					// Anfuegen des Wert attributes
					rootNodeChild.setAttribute("wert", String.valueOf(s.getMessungen().get(i).getWert()));
					// Anfuegen des Zeistempels
					rootNodeChild.setAttribute("zeitstempel", String.valueOf(s.getMessungen().get(i).getZeitstempel()));
					// Anhaengen der Messung an den Root
					rootNode.appendChild(rootNodeChild);

					System.out.println(rootNodeChild.getAttributes().item(0).getNodeValue());
				}

				// Erstellt die XML Datei
				DOMSource domSource = new DOMSource(document);
				File fileOutput = new File("sensorenExport.xml");
				StreamResult streamResult = new StreamResult(fileOutput);
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer serializer = tf.newTransformer();
				serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				serializer.setOutputProperty(OutputKeys.INDENT, "yes");
				serializer.transform(domSource, streamResult);

			} catch (ParserConfigurationException e) {
				System.out.println(e.getMessage());
			} catch (TransformerException e) {
				System.out.println(e.getMessage());
			}
		}

		public static void main(String[] args) {

			Sensor sensor = new Sensor("Temperatursensor");
			sensor.messungDurchfuehren(3.3);
			sensor.messungDurchfuehren(3.9);
			Auslesen.export(sensor);
		}

}
