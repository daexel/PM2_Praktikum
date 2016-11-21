package ArrayListe;

public class mainTest {
public static void  main(String []args){
	ArrayListe<Integer> liste = new ArrayListe<Integer>(20);
	liste.hinzufuegen((Integer) 1);
	liste.hinzufuegen((Integer) 2);
	liste.hinzufuegen((Integer) 99);	
	liste.hinzufuegen((Integer) 1);
	liste.hinzufuegen((Integer) 2);
	liste.hinzufuegen((Integer) 99);
	
	
	liste.getKleinstesElement();
}
}
