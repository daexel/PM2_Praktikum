package ArrayListe;

import org.junit.Assert;
import org.junit.Test;

import Wiederholung.Student;

/**
 * ArrayListeTest
 * 
 * Testklasse, fuer die selbst erstellte Arraylistklasse.
 * 
 * @author phil,michel
 *
 */
public class ArrayListeTest {

	@Test
	/**
	 * hinzufuegenUndGetTest
	 * 
	 * Testet, ob die Funktion Arrayliste.hinzufuegen die als Parameter
	 * angegebenen Zahlen, hinzufuegt und ob die Mehtode Arrayliste.get die
	 * erwarteten Werte zurueck liefert.
	 */
	public void hinzufuegenUndGetTest() {
		ArrayListe<Integer> liste = new ArrayListe<Integer>(20);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		Assert.assertEquals(1, liste.get(0), 0);
		Assert.assertEquals(2, liste.get(1), 0);
		Assert.assertEquals(99, liste.get(2), 0);
	}

	@Test
	/**
	 * entferneElementAnIndexTest
	 * 
	 * Testet ob, das entfernen und nachruecken in der Liste funktioniert
	 */
	public void entferneElementAnIndexTest() {
		ArrayListe<Integer> liste = new ArrayListe<Integer>(20);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		liste.entferneElementAnIndex(1);
		// Der Erwartung nach wird die 2 gelöscht und die 99 nachgerueckt.
		Assert.assertTrue((liste.get(1) == 99));
	}

	@Test
	/**
	 * entferneElementTest
	 * 
	 * Testet, ob Arraylist.entferne funktioniert.
	 */
	public void entferneElementTest() {
		ArrayListe<Integer> liste = new ArrayListe<Integer>(20);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		liste.entfernen(new Integer(2));
		Assert.assertTrue(liste.get(1) == 99);
	}

	@Test
	/**
	 * getAnzahlElementeTest
	 * 
	 * getAnzahlElementeTest, testet ob die Anzahl der Elemente, welche der
	 * Liste hinzugefuegt wurden, stimmt.
	 */
	public void getAnzahlElementeTest() {
		ArrayListe<Integer> liste = new ArrayListe<Integer>(20);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		Assert.assertTrue(liste.getAnzahlElemente() == 6);
		liste.entferneElementAnIndex(2);
		Assert.assertTrue(liste.getAnzahlElemente() == 5);
		liste.entfernen(new Integer(2));
		Assert.assertTrue(liste.getAnzahlElemente() == 4);

	}

	@Test
	/**
	 * getKleinstesElementTest
	 * 
	 * Testet, ob getKleinstesElement, das Element an index 0 zurueck liefert.
	 */
	public void getKleinstesElementIntegerTest() {
		ArrayListe<Integer> liste = new ArrayListe<Integer>(20);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		liste.hinzufuegen((Integer) 1);
		liste.hinzufuegen((Integer) 2);
		liste.hinzufuegen((Integer) 99);
		Assert.assertTrue(liste.getKleinstesElement() == 1);
	}

	@Test
	/**
	 * getKleinstesElementTest
	 * 
	 * Testet, ob getKleinstesElement, das Element an index 0 zurueck liefert.
	 */
	public void getKleinstesElementDoubleTest() {
		ArrayListe<Double> liste = new ArrayListe<Double>(20);
		liste.hinzufuegen((Double) 1.1);
		liste.hinzufuegen((Double) 1.2);
		liste.hinzufuegen((Double) 1.3);
		liste.hinzufuegen((Double) 1.4);
		liste.hinzufuegen((Double) 1.5);
		liste.hinzufuegen((Double) 1.6);
		Assert.assertTrue(liste.getKleinstesElement() == 1.1);
	}

	@Test
	/**
	 * getKleinstesElementTest
	 * 
	 * Testet, ob getKleinstesElement, das Element an index 0 zurueck liefert.
	 */
	public void getKleinstesElementFloatTest() {
		ArrayListe<Float> liste = new ArrayListe<Float>(20);
		liste.hinzufuegen((Float) 1.1F);
		liste.hinzufuegen((Float) 1.2F);
		liste.hinzufuegen((Float) 1.3F);
		liste.hinzufuegen((Float) 1.4F);
		liste.hinzufuegen((Float) 1.5F);
		liste.hinzufuegen((Float) 1.6F);
		Assert.assertTrue(liste.getKleinstesElement() == 1.1F);

	}

	@Test
	/**
	 * getKleinstesElementTest
	 * 
	 * Testet, ob getKleinstesElement, das Element an index 0 zurueck liefert.
	 */
	public void getKleinstesElementByteTest() {
		ArrayListe<Byte> liste = new ArrayListe<Byte>(20);
		byte[] eintraege = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < eintraege.length; i++) {
			liste.hinzufuegen((Byte) eintraege[i]);
		}
		Assert.assertTrue(liste.getKleinstesElement() == eintraege[0]);
	}

	@Test
	/**
	 * getKleinstesElementTest
	 * 
	 * Testet, ob getKleinstesElement, das Element an index 0 zurueck liefert.
	 */
	public void getKleinstesElementCharacterTest() {
		ArrayListe<Character> liste = new ArrayListe<Character>(20);
		liste.hinzufuegen((Character) 'a');
		liste.hinzufuegen((Character) 'b');
		liste.hinzufuegen((Character) 'c');
		liste.hinzufuegen((Character) 'd');
		liste.hinzufuegen((Character) 'e');
		liste.hinzufuegen((Character) 'f');
		Assert.assertTrue(liste.getKleinstesElement() == 'a');

	}

	@Test
	/**
	 * getKleinstesElementTest
	 * 
	 * Testet, ob getKleinstesElement, das Element an index 0 zurueck liefert.
	 */
	public void getKleinstesElementShortTest() {
		ArrayListe<Short> liste = new ArrayListe<Short>(20);
		short[] eintraege = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < eintraege.length; i++) {
			liste.hinzufuegen((Short) eintraege[i]);
		}
		Assert.assertTrue(liste.getKleinstesElement() == eintraege[0]);

	}
	
	@Test
	public void erstrEintragTestTest(){
		ArrayListe<Character> liste = new ArrayListe<Character>(20);
		liste.hinzufuegen((Character) 'a');
		liste.hinzufuegen((Character) 'b');
		liste.hinzufuegen((Character) 'c');
		liste.hinzufuegen((Character) 'd');
		liste.hinzufuegen((Character) 'e');
		liste.hinzufuegen((Character) 'f');
		ZusatzKlasse.ersterEintragTest(liste);
		Assert.assertTrue( ZusatzKlasse.ersterEintragTest(liste) == true);
		ArrayListe<Student> studListe = new ArrayListe<Student>(20);
		studListe.hinzufuegen(new Student(1, "a", "b"));
		Assert.assertTrue(ZusatzKlasse.ersterEintragTest(studListe) == false);
		
	}
}
