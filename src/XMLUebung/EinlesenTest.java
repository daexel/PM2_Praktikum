package XMLUebung;
import org.junit.Test;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Assert.*;
public class EinlesenTest {
	//Anhaengig von der Eingelesenen XML Datei der Methode in Einlesen
	@Test
	public void importSensor(){
		Sensor sensor1 = new Sensor("Temperatur Wohnzimmer");
		Einlesen einlesen1= new Einlesen("Sensor");
		Sensor sensor2 = einlesen1.importSensor();
		System.out.println(sensor1.getId());
		System.out.println(sensor2.getId());
		Assert.assertTrue(sensor1.getId().equals(sensor2.getId())); 
	}
	
	@Test
	public void kinderAuslesen(){
		Einlesen einlesen1= new Einlesen("Sensor");
		einlesen1.importSensor();
	}

}
