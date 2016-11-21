package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams<T> implements Comparable<T>{
	
private String[] benutzerEingaben;
private List <String> benutzerEingabeList;
	
/**
 * Konstruktor
 * 
 * @param benutzerEingaben des Benutzers als Strings
 */
public Streams(String ... benutzerEingaben){
	this.benutzerEingaben = benutzerEingaben;
	this.benutzerEingabeList =Arrays.asList(benutzerEingaben); 
	
}

public String getBenutzerEingaben(int index) {
	return benutzerEingabeList.get(index);

}
public void setBenutzerEingaben(String[] benutzerEingaben) {
	this.benutzerEingaben = benutzerEingaben;
}
public void leerzeichenEntfernen(){
	
	
}


/**
 * 
 * Verarbeitet das String Array einer List mit anhand vorgegebener Bedingungen
 * 
 * @param benutzerEingaben als String Array
 */

public void verarbeiteEingabe(){
Stream<T> ausgabe = (Stream<T>) benutzerEingabeList.stream().filter(Objects::nonNull);


//List<String> list = new ArrayList<>();
//list = Arrays.asList( null, "Foo", null, "Bar", null, null);
//
//list.stream()
//    .filter( Objects::nonNull )  // <-- Filter out null values
//    .forEach( System.out::println );

}

@Override
public int compareTo(T arg0) {
	// TODO Auto-generated method stub
	return 0;
}

}
