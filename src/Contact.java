
public class Contact {
	private String firstName;
	private String lastName;
	private String contactNumber;
	
	Contact(String firstName, String lastName, String contactNumber){
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
	
}
