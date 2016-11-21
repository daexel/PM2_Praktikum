package Wiederholung;

import org.junit.Test;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Assert.*;

public class StudentTest {

	@Test
	public void testStudentenErstllen(){
		// Student ohne Klausuren erstellen
		Student studentOhneKlausuren = new Student(1234, "Henning", "Schulz");
		Assert.assertTrue(studentOhneKlausuren!=null);
		
		// Student mit Klausur erstellen
		Pruefungsleistung klausur = new Pruefungsleistung(0, "Mathe");
		Student studentMitKlausur = new Student(0, "Henning", "Schulz",klausur);
		Assert.assertTrue(studentMitKlausur!=null);

	}
	
	@Test
	
	public void testStudentenCompare(){
		
		
		//Fall 1: Student 1.matrikelnummer < Student 2.matrikelnummer
		Student student1 = new Student(100, "Henning", "Schulz");
		Student student2 = new Student(200, "Henning", "Schulz");
		
		Assert.assertEquals(-1,student1.compareTo(student2),0);
		
		//Fall 2: Student 1.matrikelnummer > Student 3.matrikelnummer
		Student student3 = new Student (80,"Henning","Schulz");
		
		Assert.assertEquals(1,student1.compareTo(student3),0);
	
		//Fall 3: Student 1.matrikelnummer == Student 4.matrikelnummer
		Student student4 = new Student (100,"Henning","Schulz");
		
		Assert.assertEquals(0,student1.compareTo(student4),0);
	}
	
	@Test
	public void testStudentenEquals(){
		
		//Studenten mit gleicher Matrikelnummer werden verglichen
		Student student1 = new Student(100,"Henning","Schulz");
		Student student2 = new Student(100,"Henning","Peters");
		
		Assert.assertTrue(student1.equals(student2));
		
		//Studenten mit unterschiedlicher Matrikelnummer werden verglichen
		Student student3 = new Student (200,"Henning","Schulz");
		
		Assert.assertFalse(student1.equals(student3));
	}

	@Test 
	public void testStudentenHashCode(){
		
		Student student1 = new Student(100,"Henning","Schulz");
		Assert.assertEquals(10, student1.hashCode(), 0);
	}
	
	@Test 
	public void testStudentenComparator(){
		
		// Vergleich anhand der Vornamen
		VornamenComparator vornamenComparator = new VornamenComparator();
		
		//Student mit gleichem Vornamen
		Student student1 = new Student(100,"Henning","Schulz");
		Student student2 = new Student(100,"Henning","Schulz");
		
		Assert.assertEquals(0, vornamenComparator.compare(student1, student2),0);
		
		
		//Studenten mit ungleichem Vornamen	
		Student student3 = new Student(100,"Matthias","Schulz");
		
		Assert.assertTrue(vornamenComparator.compare(student1, student3)<0||vornamenComparator.compare(student1, student3)>0);
		
		
		//Vergleich anhand der Nachnamen
		NachnamenComparator nachnamenComparator = new NachnamenComparator();
		
		//Student mit gleichem Nachnamen
		Assert.assertEquals(0, nachnamenComparator.compare(student1, student2),0);		
		
		//Studenten mit ungleichem Nachnamen
		Student student4 = new Student (100,"Henning","Englisch");
		
		Assert.assertTrue(nachnamenComparator.compare(student1, student4)<0||nachnamenComparator.compare(student1, student4)>0);
		
	}
}
