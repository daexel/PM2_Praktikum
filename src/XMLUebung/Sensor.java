package XMLUebung;

import java.util.LinkedList;

/**
 * Sensor
 * 
 * Beschreibt einen Sensor mit (hoffentlich) einzigartigen ID und behinhaltet
 * die von ihm erfassten werde in einer Liste.
 * 
 * @author phil, michel
 *
 */

public class Sensor {

	private final String id;
	private LinkedList<Messung> messungen = new LinkedList<>();

	public Sensor(String id) {
		this.id = id;
	}

	/**
	 * messungDurchfuehren
	 * 
	 * Erstellt eine Messung mit eingehendem Wert und fügt diese der Liste
	 * hinzu.
	 * 
	 * @param wert
	 *            gemessener Wert
	 */
	public void messungDurchfuehren(double wert) {
		Messung messung = new Messung(wert);
		messungen.add(messung);
		System.out.println(messung.getWert() + "\n" + messung.getZeitstempel());
	}

	/**
	 * messungenHinzufuegen
	 * 
	 * fügt der liste eine bereits vorhandene Messung hinzu
	 * 
	 * @param messung
	 *            bereits erledigte Messung
	 */
	public void messungHinzufuegen(Messung messung) {
		messungen.add(messung);
	}

	@Override
	public String toString() {
		String returnString = "Sensor ID: " + id.toString()+"\n";
		for (int i = 0; i < messungen.size(); i++) {
			if (!(messungen.get(i) instanceof Messung)) {
				continue;
			}
			returnString = returnString+ (i+1)+ ".Messung:\n" + messungen.get(i).toString();
		}
		return returnString;

	}

	public LinkedList<Messung> getMessungen() {
		return messungen;
	}

	public void setMessungen(LinkedList<Messung> messungen) {
		this.messungen = messungen;
	}

	public String getId() {
		return id;
	}

}
