package aufgabenblatt3;

import org.junit.internal.Throwables;

public class Rangierbahnhof {
	private Zug[] gleise;

	public Rangierbahnhof(int anzahlGleise) {
		this.gleise = new Zug[anzahlGleise];

	}

	public synchronized void einfahren(Zug zug, int gleisNummer) throws IllegalArgumentException{
		if (gleisNummer < 0) {
			throw new IllegalArgumentException("" + gleisNummer + " ist eine zu kleine Gleisnummer! Es Existieren nur "+gleise.length);
		} else if (gleisNummer >= gleise.length) {
			throw new IllegalArgumentException("" + gleisNummer + " ist eine zu grosse Gleisnummer! Es Existieren nur "+gleise.length);
		}
		while (gleise[gleisNummer] != null) {
			try {
				
				System.out.println("Lokfuehrer wartet beim einfahren auf Gleis "+gleisNummer+"!");
				wait();// Hier wird der Zug geparkt, wenn der Gleis bereits
						// besetzt ist.
				System.out.println("Lokfuehrer faehrt jetzt ein!");
			} catch (InterruptedException e) {
			}
		}
		
		gleise[gleisNummer] = zug;
		this.notifyAll();// Alle geparkten Züge werden wieder freigegeben
	}

	public synchronized void ausfahren(int gleisNummer) throws IllegalArgumentException{
		if (gleisNummer < 0) {
			throw new IllegalArgumentException("" + gleisNummer + " ist eine zu kleine Gleisnummer! Es Existieren nur "+gleise.length);
		} else if (gleisNummer >= gleise.length) {
			throw new IllegalArgumentException("" + gleisNummer + " ist eine zu grosse Gleisnummer! Es Existieren nur "+gleise.length);
		}
		while (gleise[gleisNummer] == null) {
			try {
				System.out.println("Lokfuehrer wartet beim ausfahren auf den Zug auf Gleis "+gleisNummer+"!");
				wait();// Hier wird der Zug geparkt, wenn kein Zug auf dem Gleis
						// steht.
				System.out.println("Lokfuehrer faehrt jetzt aus!");
			} catch (InterruptedException e) {
			}
		}
		
		gleise[gleisNummer] = null;
		this.notifyAll();// Alle geparkten Zuege werden wieder freigegeben
	}

	public Zug[] getGleise() {
		return this.gleise;
	}

	public int getAnzahlGleise() {
		return gleise.length;
	}
public static void main(String[]args){
	Rangierbahnhof bahnhof = new Rangierbahnhof(10);
	System.out.println(bahnhof.getAnzahlGleise());

}


}
