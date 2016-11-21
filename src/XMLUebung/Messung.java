package XMLUebung;

import java.time.LocalDateTime;

/**
 * Messung
 * 
 * Repräsentiert eine Messung, welche von einem Sensor durchgeführt werden muss.
 * 
 * @author phil
 *
 */
public class Messung {

	private final double wert;
	private final LocalDateTime zeitstempel;

	public Messung(double wert) {
		this.wert = wert;
		zeitstempel = LocalDateTime.now();
	}
	public Messung( double wert, LocalDateTime zeitstempel){
		this.wert= wert;
		this.zeitstempel=zeitstempel;
	}

	public double getWert() {
		return wert;
	}

	public LocalDateTime getZeitstempel() {
		return zeitstempel;
	}
	
	@Override
	public String toString(){
		return " Wert: "+ wert + "\n Zeitstempel: "+zeitstempel.toString()+"\n";
	}

}
