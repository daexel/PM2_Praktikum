package Threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Praktikum 2 
 * Aufgabenblatt 2.3
 * 
 * Beschreibt einen Flughafen der Flugzeuge verwaltet.
 * 
 * @author Michel Gerlach, Philipp Beck
 *
 */
public class Flughafen extends Thread {
	private int anzahlFlugzeuge;
	List<Flugzeug> flugzeuge;
	private int zaehler;
	private final String[] airlines = { "Lufthansa", "Air Berlin", "Eurowings", "Air France" };
/**
 * Konstruktor
 * @param anzahlFlugzeuge
 */
	
	public Flughafen(int anzahlFlugzeuge) {
		this.zaehler=0;
		this.anzahlFlugzeuge = anzahlFlugzeuge;
		this.flugzeuge = new ArrayList<Flugzeug>();
		for (int i = 0; i < anzahlFlugzeuge; i++) {
			flugzeuge.add(this.erzeugeFlugzeug(this, 30));
		}

	}
/**
 * Führt die Landung je Flugzeug, wobei jeweils nur ein Flugzeug zur Zeit landen kann!
 * 
 * @param flugzeug mit dem Status IM_LANDEANFLUG
 */
	public synchronized void landen(Flugzeug flugzeug) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flugzeug.setIstGelandet();
		System.out.println("->Flugzeug gelandet: " + flugzeug.toString());

	}

	
	

	@Override
	public void run() {
		while (!isInterrupted()) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			zaehler++;
			System.out.println("Zeit: " + zaehler);
			for (int i = 0; i < this.anzahlFlugzeuge; i++) {

				if (flugzeuge.get(i).getStatus() == Status.GELANDET) {
					// flugzeuge.remove(flugzeuge.indexOf(flugzeuge.get(i)));
					int index = flugzeuge.indexOf(flugzeuge.get(i));
					flugzeuge.remove(flugzeuge.get(i));
					//System.out.println(flugzeuge.get(i).getId() + " würde geloescht!");
					flugzeuge.add(index, erzeugeFlugzeug(this, 30));
				}
				if(!(flugzeuge.get(i).getStatus()==Status.IM_LANDEANFLUG)){
				flugzeuge.get(i).setZeit(zaehler);}
				if (flugzeuge.get(i).getZeit() < 0) {
					this.interrupt();
				}

				System.out.println(flugzeuge.get(i).toString());

				if ((flugzeuge.get(i).getStatus() == Status.IM_LANDEANFLUG)) {
					landen(flugzeuge.get(i));
				}

			}
		}
	}
	
	/**
	 * Erzeugt Flugzeuge und startet den Flugzeug-Thread
	 * 
	 * @param flughafen 
	 * @param flugdauer
	 * @return	Das erstellte Flugzeug als gestarteter Thread
	 */
	public Flugzeug erzeugeFlugzeug(Flughafen flughafen, int flugdauer) {
		int flugzeugnummer = (int) (Math.random() * 100000);
		String airline = null;
		if (flugzeugnummer < 30000) {
			airline = airlines[0];
		}
		if (flugzeugnummer < 60000 && flugzeugnummer > 30000) {
			airline = airlines[1];
		}
		if (flugzeugnummer < 70000 && flugzeugnummer > 60000) {
			airline = airlines[2];
		}
		if (flugzeugnummer > 70000) {
			airline = airlines[3];
		}

		String flugId = airline + " " + flugzeugnummer;
		Flugzeug flugzeug = new Flugzeug(flugId, (int) ((Math.random() * flugdauer) + 1), flughafen, zaehler);
		System.out.println("->Neues Flugzeug erzeugt: Flugzeug " + flugzeug.toString());
		flugzeug.start();

		return flugzeug;
	}


	public static void main(String[] ags) {

		
		Flughafen flughafen = new Flughafen(6);


		flughafen.start();



	}

}
