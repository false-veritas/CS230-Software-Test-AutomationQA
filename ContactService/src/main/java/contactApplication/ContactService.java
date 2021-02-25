/*
 * Contact Service Class
 * 
 * @author 	Vitalie Cucuta
 * @date 	01/23/2021
 * @school	SNHU CS-320
 * 
 */


package contactApplication;

import java.util.HashMap;




public class ContactService {
	
	//create singleton
	private static ContactService singletonId = new ContactService();
	
	//create variable that will always be written into the main memory and never cached
	//any changes will also be written into main memory
	private volatile int next = 0;
	
	//prevent instantiation
	private ContactService() {};
	
	//lazy instantiation
	public static ContactService getInstance() {
		return singletonId;
	};
	
	//create protected synchronized methods to only allow one thread to execute method at a time
	//one will return incremented value and next method will return current value
	protected synchronized int getNextId() {
		return next++;
	};
		
	protected synchronized int getCurrentId() {
		return next;
	};
	
	//create HashMap to be used as contact list
	HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	
	//create function to add a new contact
	public void addContact(String firstName, String lastName, String phone, String address) {
		
		//call singleton instance
		ContactService newId = ContactService.getInstance();
		
		//assign id from memory value using singleton to create unique ID each time
		String contactId = Integer.toString(newId.getNextId());
		
		//assign values and put values in HashMap
		Contact newEntry = new Contact(contactId, firstName, lastName, phone, address);
		contactList.put(Integer.toString(newId.getCurrentId()), newEntry);
		
	};
	
	//create function to delete contact using contactId
	public void deleteContact(String contactId) {
		
		//check if HashMap contains contactId
		if (contactList.containsKey(contactId)) {
			//if it exists then remove it
			contactList.remove(contactId);
		}
		else {
			//if contactId doesn't exist throw exception
			throw new IllegalArgumentException("Contact ID does not exist.");
		}
	};
	
	//create function to update firstName
	public void updateFirstName(String contactId, String updatedFirstName) {
		
		//check if contactId exists
		if (contactList.containsKey(contactId)) {
			//if it exists then update firstName
			contactList.get(contactId).setFirstName(updatedFirstName);
		}
		else {
			//if contactId doesn't exist throw exception
			throw new IllegalArgumentException("Contact ID does not exist.");
		}
		
		
	};
	
	//create function to update lastName
	public void updateLastName(String contactId, String updatedLastName) {

		//check if contactId exists
		if (contactList.containsKey(contactId)) {
			//if it exists then update lastName
			contactList.get(contactId).setLastName(updatedLastName);	
		}
		else {
			//if contactId doesn't exist throw exception
			throw new IllegalArgumentException("Task ID does not exist.");
		}

	};

	//create function to update phone
	public void updatePhone(String contactId, String updatedPhone) {
		
		//check if contactId exists
		if (contactList.containsKey(contactId)) {
			//if it exists update phone
			contactList.get(contactId).setPhone(updatedPhone);
		}
		else {
			//if contactId doesn't exist throw exception
			throw new IllegalArgumentException("Task ID does not exist.");
		}

		
	};
	
	//create function to update address
	public void updateAddress(String contactId, String updatedAddress) {
		
		//check if contactId exists
		if (contactList.containsKey(contactId)) {
			//if it exists update address
			contactList.get(contactId).setAddress(updatedAddress);
		}
		else {
			//if contactId doesn't exist throw exception
			throw new IllegalArgumentException("Task ID does not exist.");
		}

	}; 

}
