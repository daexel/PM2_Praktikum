package ArrayListe;

/**
 * Zusatzklasse
 * 
 * Die Zusatzklasse beinhaltet lediglich eine statische Methode, welche
 * Ueberprueft, ob es sich bei dem ersten Eintrag der Array Liste um eine Zahl
 * handelt.
 * 
 * @author phil
 *
 */
public class ZusatzKlasse {
	/**
	 * ersterEintragTest
	 * 
	 * Die Methode extrahiert den ersten Eintrag aus einer an sie uebergebenen
	 * Array Liste und testet, ob es sich bei diesem Eintrag um eine Zahl
	 * handelt.
	 * 
	 * @param arrayliste
	 *            Liste, aus der der erste Eintrag ueberprueft werden soll.
	 * @return true, wenn es sich um eine Zahl handelt.
	 */
	public static boolean ersterEintragTest(ArrayListe<?> arrayliste) {
		boolean istZahl = false;
		Object eintrag = arrayliste.get(0);
		if (eintrag instanceof Integer) {
			istZahl = true;
		} else if (eintrag instanceof Double) {
			istZahl = true;
		} 
		else if (eintrag instanceof Character) {
			istZahl = true;
		} 
		else if (eintrag instanceof Float) {
			istZahl = true;
		} else if (eintrag instanceof Long) {
			istZahl = true;
		} else if (eintrag instanceof Byte) {
			istZahl = true;
		} else if(eintrag instanceof Short) {
			istZahl = true;
		}
		return istZahl;
	}
}
