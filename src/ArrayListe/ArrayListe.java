package ArrayListe;

import java.util.Arrays;

/**
 * ArrayListe<T>
 * 
 * Beschreibt eine Containerklasse für Objekttypen von Objekt, die in einem
 * Array abgespeichert und verwaltet werden.
 * 
 * 
 * @author Phil Beck, Michel Gerlach
 *
 * @param <T>
 *            Typ, der Objekte, welche verwaltet werden sollen.
 */
public class ArrayListe<T extends Comparable<T>>  {
	/**
	 * @param anzahlElemente:
	 *            gibt die Anzahl der Elemente in ArrayListe wieder. Elemente:
	 *            ist ein Array von Objects
	 */
	int anzahlElemente = 0;
	private Object[] elemente;

	/**
	 * hinzufuegen
	 * 
	 * Fuegt dem Array, einen Wert hinzu.
	 * 
	 * @param elem
	 *            Element, welches hinzugefuegt werden soll.
	 */
	public void hinzufuegen(T elem) {
		anzahlElemente++;
		/*
		 * Test, ob genug Platz im Array ist.
		 */
		if (anzahlElemente >= elemente.length) {
			elemente = Arrays.copyOf(elemente, elemente.length * 2);
		}
		// Hinzufuegen des Eintrags ins Array
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] == null) {
				elemente[i] = elem;
				break;
			}
		}

	}

	/**
	 * get
	 * 
	 * Liefert das Element der Liste mit dem als Parameter uebergebenen Index
	 * zurueck.
	 * 
	 * @param index
	 *            Index des Elements, welches zurueckgeliefert werden soll.
	 * @return Element der Liste an verlangtem Index.
	 */
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) elemente[index];
	}

	/**
	 * entfernen
	 * 
	 * Entfernt ein Objekt aus der Liste, welches Aequivalent zu dem als
	 * Parameter Aebergebenen Objekt ist und raeckt die restlichen elemente
	 * nach.
	 * 
	 * @param elem
	 *            Das Element, nachdem in der Liste gesucht und geloescht werden
	 *            soll.
	 */
	public void entfernen(T elem) {
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i].equals(elem)) {
				elemente[i] = null;
				anzahlElemente--;
				for (int j = i; j < elemente.length; j++) {
					if (j + 1 < elemente.length) {
						elemente[j] = elemente[j + 1];
					}
				}
				break;
			}

		}
	}

	/**
	 * entferneElementAnIndex
	 * 
	 * entfernt das Element mit dem index i und rueckt die restliche elemente
	 * nach.
	 * 
	 * @param i
	 *            index, des zu entfernenden Elements
	 */
	public void entferneElementAnIndex(int index) {
		if (index + 1 < 0 || index + 1 > anzahlElemente) {
			return;
		}
		elemente[index] = null;
		anzahlElemente--;
		for (int j = index; j < elemente.length; j++) {
			if (j + 1 < elemente.length) {
				elemente[j] = elemente[j + 1];
			}
		}
	}

	@Override
	public String toString() {
		return "Array Liste mit " + getAnzahlElemente() + " Elementen.";
	}

	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	/**
	 * Konstruktor
	 */
	public ArrayListe(int groesseArray) {
		this.elemente = new Object[groesseArray];
	}
	/**
	 * getKleinstesElement
	 * 
	 * Liefert das kleinste ELement der Liste zurueck.
	 * 
	 * @return kleinstesElement kleinstesElement der Liste
	 * 
	 * 
	 */
	public T getKleinstesElement()  {
		
		T kleinstesElement = (T)elemente[0];
		for (int i = 0; i < anzahlElemente; i++) {
			if (((T)elemente[i]).compareTo(kleinstesElement) < 0) {
				kleinstesElement = (T)elemente[i];
			}
		}
		return kleinstesElement;
	}
	/**
	public T getKleinstesElement() {

		if (ArrayListeZusatz.ersteElementZahl(this)) {
			if (elemente[0] instanceof Float) {
				return (T) kleinstesFloatElementReturn();
			} else if (elemente[0] instanceof Double) {
				return (T) kleinstesDoubleElementReturn();
			} else if (elemente[0] instanceof Long) {
				return (T) kleinstesLongElementReturn();
			} else if (elemente[0] instanceof Integer) {
				return (T) kleinstesIntegerElementReturn();
			} else if (elemente[0] instanceof Character) {
				return (T) kleinstesCharacterElementReturn();
			} else if (elemente[0] instanceof Byte) {
				return (T) kleinstesByteElementReturn();
			}

		}

		return null;
	}

	/**
	 * kleinstesFloatElementReturn
	 * 
	 * Gibt den kleinsten Wert aus der Liste zurueck.
	 * 
	 * @return kleinstenWert Aus der Liste.
	 * 
	 */
	public Float kleinstesFloatElementReturn() {
		Object kleinstesElementDouble = (Float) elemente[0];
		for (int i = 1; i < elemente.length; i++) {
			if ((Float) elemente[i] == null) {
				break;
			}
			if ((Float) elemente[i] < (Float) kleinstesElementDouble && elemente[i] != null) {// Ueberpruefen
																								// der
																								// groesstmoeglichen
																								// double-Zahl
				kleinstesElementDouble = (Float) elemente[i];
			} else if ((Float) elemente[i] > (Float) kleinstesElementDouble) {
				continue;
			} else if ((Float) elemente[i] == (Float) kleinstesElementDouble) {
				continue;
			}
		}
		return (Float) kleinstesElementDouble;

	}
	
	/**
	 * kleinstesLongElementReturn
	 * 
	 * Gibt den kleinsten Wert aus der Liste zurueck.
	 * 
	 * @return kleinstenWert Aus der Liste.
	 * 
	 */
	public Long kleinstesLongElementReturn() {
		Object kleinstesElementLong = (Long) elemente[0];
		for (int i = 1; i < elemente.length; i++) {
			if ((Long) elemente[i] == null) {
				break;
			}
			if ((Long) elemente[i] < (Long) kleinstesElementLong && elemente[i] != null) {// Ueberpruefen
																							// der
																							// groesstmoeglichen
																							// ganzzahl
				kleinstesElementLong = (Long) elemente[i];
			} else if ((Long) elemente[i] > (Long) kleinstesElementLong) {
				continue;
			} else if ((Long) elemente[i] == (Long) kleinstesElementLong) {
				continue;
			}
		}
		return (Long) kleinstesElementLong;
	}

	/**
	 * kleinstesIntegerElementReturn
	 * 
	 * Gibt den kleinsten Wert aus der Liste zurueck.
	 * 
	 * @return kleinstenWert Aus der Liste.
	 * 
	 */
	public Integer kleinstesIntegerElementReturn() {
		Object kleinstesElementInteger = (Integer) elemente[0];
		for (int i = 1; i < elemente.length; i++) {
			if ((Integer) elemente[i] == null) {
				break;
			}
			if ((Integer) elemente[i] < (Integer) kleinstesElementInteger) {// Ueberpruefen
																			// der
																			// groesstmoeglichen
																			// ganzzahl
				kleinstesElementInteger = (Integer) elemente[i];
			} else if ((Integer) elemente[i] > (Integer) kleinstesElementInteger) {
				continue;
			} else if ((Integer) elemente[i] == (Integer) kleinstesElementInteger) {
				continue;
			}
		}
		return (Integer) kleinstesElementInteger;

	}

	/**
	 * kleinstesCharacterElementReturn
	 * 
	 * Gibt den kleinsten Wert aus der Liste zurueck.
	 * 
	 * @return kleinstenWert Aus der Liste.
	 * 
	 */
	public Character kleinstesCharacterElementReturn() {
		Object kleinstesElementInteger = (Character) elemente[0];
		for (int i = 1; i < elemente.length; i++) {
			if ((Character) elemente[i] == null) {
				break;
			}
			if ((Character) elemente[i] < (Character) kleinstesElementInteger) {// Ueberpruefen
				// der
				// groesstmoeglichen
				// ganzzahl
				kleinstesElementInteger = (Character) elemente[i];
			} else if ((Character) elemente[i] > (Character) kleinstesElementInteger) {
				continue;
			} else if ((Character) elemente[i] == (Character) kleinstesElementInteger) {
				continue;
			}
		}
		return (Character) kleinstesElementInteger;
	}

	/**
	 * kleinstesByteElementReturn
	 * 
	 * Gibt den kleinsten Wert aus der Liste zurueck.
	 * 
	 * @return kleinstenWert Aus der Liste.
	 * 
	 */
	public Byte kleinstesByteElementReturn() {
		Object kleinstesElementInteger = (Byte) elemente[0];
		for (int i = 1; i < elemente.length; i++) {
			if ((Byte) elemente[i] == null) {
				break;
			}
			if ((Byte) elemente[i] < (Byte) kleinstesElementInteger) {// Ueberpruefen
																		// der
																		// groesstmoeglichen
																		// ganzzahl
				kleinstesElementInteger = (Byte) elemente[i];
			} else if ((Byte) elemente[i] > (Byte) kleinstesElementInteger) {
				continue;
			} else if ((Byte) elemente[i] == (Byte) kleinstesElementInteger) {
				continue;
			}
		}
		return (Byte) kleinstesElementInteger;
	}
	
	/**
	 * kleinstesDoubleElementReturn
	 * 
	 * Gibt den kleinsten Wert aus der Liste zurueck.
	 * 
	 * @return kleinstenWert Aus der Liste.
	 * 
	 */
	public Double kleinstesDoubleElementReturn() {
		Object kleinstesElementInteger = (Double) elemente[0];
		for (int i = 1; i < elemente.length; i++) {
			if ((Double) elemente[i] == null) {
				break;
			}
			if ((Double) elemente[i] < (Double) kleinstesElementInteger) {// Ueberpruefen
																			// der
																			// groesstmoeglichen
																			// ganzzahl
				kleinstesElementInteger = (Double) elemente[i];
			} else if ((Double) elemente[i] > (Double) kleinstesElementInteger) {
				continue;
			} else if ((Double) elemente[i] == (Double) kleinstesElementInteger) {
				continue;
			}
		}
		return (Double) kleinstesElementInteger;
	}
}
