package Threads;
/**
 * Praktikum 2 
 * Aufgabenblatt 2.3
 * 
 * Beschreibt ein Flugzeug.
 * 
 * @author Michel Gerlach, Philipp Beck
 *
 */
public class Flugzeug extends Thread {
	private Flughafen flughafen;
	private String iD;
	private int flugdauer;
	private Status status;
	private int zeit;
	private int startZeit;
	private boolean isInterrupted = false;
	
/**
 * Konstruktor
 * 
 * @param iD: 			Spezielle ID des Flugzeugs
 * @param flugdauer:	zu erwartende Dauer des Fluges
 * @param flughafen:	Zugewiesener Flughafen des Flugzeugs
 * @param startZeit:	StartZeit des Flugzeugs
 */

	public Flugzeug(String iD, int flugdauer, Flughafen flughafen, int startZeit) {

		this.iD = iD;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.startZeit = startZeit;
		this.status = Status.Im_FLUG;
	}

	public boolean isInterrupted() {
		return isInterrupted;
	}

	/**
	 * Setzt isInterrupted auf true, damit der Thread beendet wird.
	 */
	private void setInterrupt() {
		isInterrupted = true;

	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				Thread.sleep(100);
				if ((zeit-startZeit) == flugdauer && this.status == Status.Im_FLUG) {
					this.status = Status.IM_LANDEANFLUG;
					if (this.zeit == 0) {
						setInterrupt();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Flugzeug " + this.iD + "(" + this.status + ", Zeit bis zum Ziel: " + (flugdauer-(zeit-startZeit)) + ")";
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	public boolean istGelandet() {
		if (status == Status.GELANDET) {
			return true;
		}
		return false;
	}

	public int getZeit() {
		return this.zeit;
	}

	public int getFlugdauer() {
		return this.flugdauer;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setIstGelandet() {
		this.status = Status.GELANDET;
	}

}
