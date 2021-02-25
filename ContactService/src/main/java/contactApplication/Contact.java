/*
 * Contact Class
 * 
 * @author 	Vitalie Cucuta
 * @date 	01/23/2021
 * @school	SNHU CS-320
 * 
 */

package contactApplication;

public class Contact {
	//create variables
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//create contact class
	public Contact(String contactId, String firstName, String lastName,
				   String phone, String address) {
		
		//set variables
		this.setContactId(contactId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
		
	};
	 
	//create get method for contactId, firstName, lastName, phone and address
	public String getContactId() {
		return contactId;
	};
	
	public String getFirstName() {
		return firstName;
	};
	
	public String getLastName() {
		return lastName;
	};
	
	public String getPhone() {
		return phone;
	};
	
	public String getAddress() {
		return address;
	};
	
	//create set method for contactId, firstName, lastName, phone and address
	public void setContactId(String contactId) {
		
		//verify contactId is not null and does not exceed 10 characters
		if(contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			this.contactId = contactId;
		}
	
	}
	
	public void setFirstName(String firstName) {
		
		//verify firstName is not null and does not exceed 10 characters
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		else {
			this.firstName = firstName;
			
		}	
	};
	
	public void setLastName(String lastName) {
		
		//verify lastName is not null and does not exceed 10 characters
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		} 
		else {
			this.lastName = lastName;	
		}
	};
	
	public void setPhone(String phone) {
		
		//verify phone is not null and is exactly 10 characters
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		} 
		else {
			this.phone = phone;
		}	
	};
	
	public void setAddress(String address) {

		//verify address is not null and does not exceed 30 characters
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		else {
			this.address = address;
		}
	};
	
}
