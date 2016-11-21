package Wiederholung;

import java.util.ArrayList;
import java.util.List;;

/**
 * Studentenklasse
 * 
 * Beschreibt einen Studenten mit seinem Vor- und Nachnamen, sowie seine
 * Matrikelnummer und seine bestandenen Klausuren.
 * 
 * @author phil
 *
 */
public class Student implements Comparable<Student> {

	private final String vorname;
	private final String nachname;
	private final int matrikelnummer;
	private final List<Pruefungsleistung> listeKlausuren = new ArrayList<>();

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public List<Pruefungsleistung> getListeKlausuren() {
		return listeKlausuren;
	}

	@Override
	public boolean equals(Object o) {
		// null-Test
		if (o == null) {
			return false;
		}
		// Klassenueberpruefung
		if (!(o instanceof Student)) {
			return false;
		}
		// Rueckgabe
		Student student = (Student) o;
		return this.matrikelnummer == student.matrikelnummer;

	}

	@Override
	public int hashCode() {
		return this.matrikelnummer / 10;
	}

	/**
	 * Konstruktor
	 * 
	 * Alle finalisierten Objektvariablen werden initialisiert.
	 * 
	 * @param Matrikelnummer
	 */
	public Student(int matrikelnummer, String vorname, String nachname) {
		this.matrikelnummer = matrikelnummer;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	/**
	 * 2. Konstruktor
	 * 
	 * Alle finalisierten Objektvariablen werden initialisiert und eine Klausur
	 * wird der Pruefungsliste hinzugefügt.
	 * 
	 * @param Matrikelnummer
	 */
	public Student(int matrikelnummer, String vorname, String nachname, Pruefungsleistung pruefung) {
		this.matrikelnummer = matrikelnummer;
		this.vorname = vorname;
		this.nachname = nachname;
		listeKlausuren.add(pruefung);
	}
	
	/**
	 * PruefungHinzufuegen
	 * 
	 * Fügt der Liste, der von dem Studenten geschrieben Klausuren, eine Pruefung hinzu.
	 * @param pruefung
	 */
	public void PruefungHinzufuegen(Pruefungsleistung pruefung){
		if(pruefung!=null){
			listeKlausuren.add(pruefung);
		}
	}
	
	/**
	 * compareTo-Methode
	 * 
	 * Vergleicht anhand der Matrikelnummer die einzelen Studenten und überprüft
	 * zuvor ob der als Parameter übergebene Student null ist.
	 *
	 * @return 0 bei gleicher, 1 bei größerer, -1 bei kleinerer Matrikelnummer
	 */
	@Override
	public int compareTo(Student o) {
		// null-Test
		if (o == null) {
			return 1;
		}

		if (this.matrikelnummer == o.matrikelnummer) {
			return 0;
		} else if (this.matrikelnummer > o.matrikelnummer) {
			return 1;
		} else {
			return -1;
		}

	}

}