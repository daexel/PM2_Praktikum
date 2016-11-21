package XMLUebung;

import org.junit.Test;

import org.junit.Assert;

public class AuslesenTest {

	@Test
	public void () {
		Sensor sensor1 = new Sensor("Temperatur Hosentasche");
		Messung messung1 = new Messung(13);
		Messung messung2 = new Messung(99);
		sensor1.messungHinzufuegen(messung1);
		sensor1.messungHinzufuegen(messung2);
		Auslesen.export(sensor1);
		Einlesen einlesen = new Einlesen("sensorenExport.xml");
		Assert.assertTrue(einlesen.importSensor().getId().equals(sensor1.getId()));
		System.out.println(einlesen.importSensor().getMessungen().getFirst());
		System.out.println(sensor1.getMessungen().getFirst());
		Assert.assertTrue(einlesen.importSensor().getId().equals(sensor1.getId()));


	}

}
