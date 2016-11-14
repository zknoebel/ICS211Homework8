package binarySearchStuff;

/**
 * 
 * Contact
 *
 * @author Zachery Knoebel
 *
 *         This class is used as a test class for the BinarySearchTree class. it
 *         creats an object called a contact that stores three strings,
 *         "firstName", "lastName", and "contactNumber". These values are used
 *         to compare each contact with one another and then sort them with the
 *         binary search tree
 */
public class Contact {
	private String firstName;
	private String lastName;
	private String contactNumber;

	Contact(String firstName, String lastName, String contactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String toString() {
		return lastName + ", " + firstName + ": " + contactNumber;
	}
}
