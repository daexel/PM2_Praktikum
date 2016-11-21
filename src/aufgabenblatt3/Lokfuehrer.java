package aufgabenblatt3;

public class Lokfuehrer extends Thread {
	private Rangierbahnhof rangierbahnhof;
	private int gleisNummer;
	// true=einfahrt
	// false= ausfaht
	private boolean fahrtrichtung;

	public Lokfuehrer(int gleisNummer, Rangierbahnhof rangierbahnhof, boolean fahrtrichtung) {
		this.rangierbahnhof = rangierbahnhof;
		this.gleisNummer = gleisNummer;
		this.fahrtrichtung = fahrtrichtung;
	}

	@Override
	public void run() {
		if (!isInterrupted()) {
			if (this.fahrtrichtung == true) {

				try {
					Zug zug = new Zug();
					rangierbahnhof.einfahren(zug, gleisNummer);
					System.err.println("Lockfuehrer " + Thread.currentThread().getId() + " fährt Zug auf Gleis "
							+ gleisNummer + " herein.");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			if(this.fahrtrichtung == false){
				try {
					rangierbahnhof.ausfahren(gleisNummer);
					System.err.println("Lockfuehrer " + Thread.currentThread().getId() + " fährt Zug aus Gleis "
							+ gleisNummer + " heraus.");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}

			}
		}

}

	public static void main(String[]args){
		Rangierbahnhof bahnhof = new Rangierbahnhof(20);
		Lokfuehrer lokfuehrer1 = new Lokfuehrer(3,bahnhof, false);
		Lokfuehrer lokfuehrer2 = new Lokfuehrer(3, bahnhof, true);
		Lokfuehrer lokfuehrer3 = new Lokfuehrer(3, bahnhof, false);
		Lokfuehrer lokfuehrer4 = new Lokfuehrer(3, bahnhof, true);
		Lokfuehrer lokfuehrer5 = new Lokfuehrer(3, bahnhof, true);
		lokfuehrer1.start();
		lokfuehrer2.start();
		lokfuehrer3.start();
		lokfuehrer4.start();
		lokfuehrer5.start();
		
				
	}
}
