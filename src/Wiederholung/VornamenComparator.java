package Wiederholung;

import java.util.Comparator;

/**
 *  VornamenComparator
 * 
 * Dient zum abgleichen zweier Studenten anhand des Vornamens.
 * 
 * @author phil
 *
 */
public class VornamenComparator implements Comparator<Student> {

	/**
	 * compare
	 * 
	 * Vergleicht Studenten anhand des Vornamens und überprüft zuvor ob
	 * einer der beiden oder beide Studenten null sind.
	 */
	@Override
 	public int compare(Student o1, Student o2) {
		// null-Test
		if (o1 == null && o2 != null) {
			return -1;
		} else if (o1 != null && o2 == null) {
			return 1;
		} else if (o1 == null && o2 == null) {
			return 0;
		}

		return o1.getVorname().compareTo(o2.getVorname());
	}

}