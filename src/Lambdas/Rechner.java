package Lambdas;

import java.util.HashMap;
import java.util.function.BinaryOperator;
/**
 * Rechnerklasse
 * 
 * Die Rechnerklasse hat die Fähigkeit, Operationen wie Addieren, Subtrahieren, Multiplizieren und Dividieren.
 * Intern wird alles über Lambda Expressions realisiert.
 * 
 * @author acd186
 *
 */
public class Rechner   {
	
	HashMap<Operation, BinaryOperator<Double>> map = new HashMap<Operation, BinaryOperator<Double>>();
	double ergebnis = 0;
	
	HashMap<Operation,DoubleDoubleZuDouble> mapDouble = new HashMap<Operation,DoubleDoubleZuDouble>();
	
	BinaryOperator<Double> addition = (a, b) -> {
		return a + b;
	};
	BinaryOperator<Double> subtraktion = (a, b) -> {
		return a - b;
	};
	BinaryOperator<Double> multiplikation = (a, b) -> {
		return a * b;
	};
	BinaryOperator<Double> division = (a, b) -> {
		return a / b;
	};
	
	DoubleDoubleZuDouble multiplikationNeu = (zahl1, zahl2)->{
		return zahl1*zahl2;
	};
	DoubleDoubleZuDouble nullstelle = (zahl1,zahl2)->{
		return ((-zahl2)/zahl1);
	};

	public Rechner(){
		map.put(Operation.ADDITON, addition);
		map.put(Operation.SUBTRAKTION, subtraktion);
		map.put(Operation.MULTIPLIKATION, multiplikation);
		map.put(Operation.DIVISION, division);
		mapDouble.put(Operation.MULTIPLIKATIONNEU, multiplikationNeu);
		mapDouble.put(Operation.NULLSTELLE, nullstelle);
		}

	/**
	 * BinaryOperator
	 * 
	 * Dient der Verwendung von Lambda Ausdruecken
	 * 
	 * @author phil
	 *
	 */

	
	/**
	 * Eigenes funktionsales Interface
	 * 
	 * Dient der Verwendung von Lambda Ausdruecken
	 * 
	 * 
	 *
	 */
	
	@FunctionalInterface
	interface DoubleDoubleZuDouble{
		double werteAus(double zahl1,double zahl2);
		
		//Wie kann man das interface in Kombination testen? In der Aufgabe steht z.B. Multiplikation + Nullstelle des Gleichung y=ax+b 
	}
	
	public double berechneDouble(Operation werteAus ,double operant1, double operant2) throws IllegalArgumentException{
		double ergebnis = mapDouble.get(werteAus).werteAus(operant1, operant2);
		return ergebnis;
	}

	/**
	 * berechne
	 * 
	 * Berechne fuehrt die vom Benutzer angeforderte Rechenoperation an den
	 * zwei, als Parameter uebergebenen Operanden aus. Werden
	 * 
	 * @param op
	 *            Die durchzufuehrende Rechenoperation
	 * @param op1
	 *            Operand1
	 * @param op2
	 *            Operand2
	 * @throws IllegalArgumentException
	 *             Wenn eine im Enum nicht vorhandene Operation durchgefuehrt
	 *             wird.
	 * @return Ergebnis Das mit dem Operator erhaltene Ergebnis.
	 */
	public  double berechne(Operation op, double op1, double op2) throws IllegalArgumentException {
		
		double ergebnis = map.get(op).apply(op1, op2);
		return ergebnis;
	}

}
