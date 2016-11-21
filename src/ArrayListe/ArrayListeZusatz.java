package ArrayListe;

public class ArrayListeZusatz {
	public static boolean  ersteElementZahl(ArrayListe<?> arrayListe){
		boolean istZahl=false;
		Object ersterEintrag=arrayListe.get(0);
		if(ersterEintrag!=null){
			if(ersterEintrag instanceof Integer){
				istZahl=true;
			}
			else if(ersterEintrag instanceof Double){
				istZahl=true;
			}
			else if(ersterEintrag instanceof Long){
				istZahl=true;
			}
			else if(ersterEintrag instanceof Float){
				istZahl=true;
		}
			return istZahl;
		}
		return istZahl;
		
}
}
