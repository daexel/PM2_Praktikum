package Lambdas;

import org.junit.Assert;
import org.junit.Test;

public class RechnerTest {
	@Test
	public void berechneTest(){
		Rechner acer = new Rechner();
		Assert.assertTrue(acer.berechne(Operation.ADDITON, 1, 1) == 2);	
		Assert.assertTrue(acer.berechne(Operation.SUBTRAKTION, 1, 1) ==0);
		Assert.assertTrue(acer.berechne(Operation.DIVISION, 10, 1) ==10);
		Assert.assertTrue(acer.berechne(Operation.MULTIPLIKATION, 10, 1) ==10);
		Assert.assertTrue(acer.berechneDouble(Operation.NULLSTELLE, 1, -2) ==2);
		Assert.assertTrue(acer.berechneDouble(Operation.MULTIPLIKATIONNEU, 6, 6)==36);
		
	}
}
