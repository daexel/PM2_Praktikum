package Wiederholung;

/**
 * Prüfungsleistung
 * 
 * Beschreibt eine bereits geschrieben Klausur.
 * 
 * @author phil
 *
 */
public class Pruefungsleistung {


	private final int noten;
	private final String klausurenName;
	
	public Pruefungsleistung(int note, String klausurenName){
		this.noten=note;
		this.klausurenName=klausurenName;
	}
	
	public int getNote() {
		return noten;
	}

	public String getKlausurenName() {
		return klausurenName;
	}
}