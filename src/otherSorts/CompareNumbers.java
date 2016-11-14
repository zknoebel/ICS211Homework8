package otherSorts;

import java.util.Comparator;

/*
 * @author Zachery Knoebel
 * 
 * used to create a comparator object that takes in Integers as the parameters
 */
public class CompareNumbers implements Comparator<Integer> {

	public int compare(Integer a, Integer b) {

		return a.compareTo(b);
	}
}
