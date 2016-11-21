package Streams;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamsAufgabe {

	public static String subString(int beginIndex, int endIndex, String wort) {
		if (wort.length() < (endIndex - beginIndex)) {
			return wort;
		}
		return wort.substring(beginIndex, endIndex);
	}

	public static void eingabeUmwandeln(List<String> eingabenListe) {

		List<String> eingabenListeBearbeitet = eingabenListe.stream().filter(String -> String != null).map(String::trim)
				.map(String -> String.replaceFirst("ß", "ss")).map(String::toUpperCase)
				.map(String -> String.replaceFirst("Ä", "AE")).map(String -> String.replaceFirst("Ö", "OE"))
				.map(String -> String.replaceFirst("Ü", "UE")).map((String t) -> StreamsAufgabe.subString(0, 8, t))
				.collect(Collectors.toList());

		eingabenListeBearbeitet.stream().forEach(System.out::println);
	}

	public void mitBenutzereingabe() {
		System.out.println(
				"Geben Sie beliebig viele Wörter ein (NULL/null realisiert null), trennen Sie die Eingabe mit einem Enter\nund beenden Sie die Eingabe mit einem +");
		Scanner scan = new Scanner(System.in);
		String eingabe;
		String exitString = "+";
		List<String> eingabenListe = new ArrayList<>();

		while (true) {
			eingabe = scan.nextLine();
			if (eingabe.equals(exitString)) {
				break;
			} else if (eingabe.equals("null") || eingabe.equals("NULL")) {
				eingabe = null;
			}
			eingabenListe.add(eingabe);
		}
		StreamsAufgabe.eingabeUmwandeln(eingabenListe);
		scan.close();
	}

	public static void ohneBenutzereingabe() {
		String[] eingabe = { "Eingabe ", "Äußeres ", null, "Strassen-Feger", " ein Haus" };
		List<String> eingabeListe = new ArrayList<>(Arrays.asList(eingabe));
		eingabeUmwandeln(eingabeListe);
	}

	public static void main(String[] args) {
		StreamsAufgabe.ohneBenutzereingabe();
	}

}
