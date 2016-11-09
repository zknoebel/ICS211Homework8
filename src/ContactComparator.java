
/**
 * 
 */

import java.util.Comparator;

/**
 * Comparator for Contacts.
 * 
 * @author Cam Moore
 *
 */
public class ContactComparator implements Comparator<Contact> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Contact o1, Contact o2) {
		int nameComp = o1.getLastName().compareTo(o2.getLastName());
		if (nameComp == 0) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}
		return nameComp;
	}

}
