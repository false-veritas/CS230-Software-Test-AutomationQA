/*
 * Contact Service Test Class
 * 
 * @author 	Vitalie Cucuta
 * @date 	01/24/2021
 * @school	SNHU CS-320
 * 
 */

package contactApplication;

import static org.junit.Assert.*;
import org.junit.Test;


public class ContactServiceTest {
	
	//test singleton instance is the same instance
	@Test
	public void testSingleton() {
		
		ContactService newContact1 = ContactService.getInstance();
		ContactService newContact2 = ContactService.getInstance();
		
		assertEquals(newContact1, newContact2);
	};
	
	//test adding contact with unique ID
	@Test
	public void testAddUniqueContact() {
		//call singleton instance
		ContactService newEntry = ContactService.getInstance();
		
		//create 3 new entries in the HashMap
		newEntry.addContact("John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		newEntry.addContact("Alvin", "Kamara", "4141414141", "41 Who Dat");
		newEntry.addContact("Drew", "Brees", "9999999999", "9 Retired");
		
		//create assertion to check that the entries have different first names
		assertFalse(newEntry.contactList.get("1").getFirstName() == newEntry.contactList.get("2").getFirstName());
		assertFalse(newEntry.contactList.get("2").getFirstName() == newEntry.contactList.get("3").getFirstName());
		assertFalse(newEntry.contactList.get("3").getFirstName() == newEntry.contactList.get("1").getFirstName());	
	};
	  
	//test deleting contact with unique ID
	@Test
	public void testDeleteUniqueContact() {
		//call singleton instance
		ContactService newEntry = ContactService.getInstance();
				
		//create 3 new entries in the hashmap
		newEntry.addContact("John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		newEntry.addContact("Alvin", "Kamara", "4141414141", "41 Who Dat");
		newEntry.addContact("Drew", "Brees", "9999999999", "9 Retired");
		
		//create assertion to check that there is a unique ID 3
		assertTrue(newEntry.contactList.containsKey("3"));
		
		//delete entry 3
		newEntry.deleteContact("3");
		
		//create assertion to check that there is no unique ID 3
		assertFalse(newEntry.contactList.containsKey("3"));
		
		//verify throw value if instance doesn't exist
		assertThrows(IllegalArgumentException.class, () ->
				  	 newEntry.deleteContact("3"));
	};
	
	//test updating firstName
	@Test
	public void testUpdateFirstName() {
		//call singleton instance
		ContactService newEntry = ContactService.getInstance();
				
		//create a new entry in the HashMap
		newEntry.addContact("John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		
		//update the firstName
		newEntry.updateFirstName("1", "Alvin");
		
		//create assertion to verify updated firstName
		assertTrue(newEntry.contactList.get("1").getFirstName() == "Alvin");
		
		//create assertion to test throw exception
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updateFirstName("1", "Shamalammadingdong"));
		assertThrows(IllegalArgumentException.class, () ->
		 			 newEntry.updateFirstName("1", null));
		
		//verify throw value if contactId doesn't exist
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updateFirstName("11", "Alvin"));
	};
	 
	//test updating lastName
	@Test
	public void testUpdateLastName() {
		//call singleton instance
		ContactService newEntry = ContactService.getInstance();
				
		//create a new entry in the HashMap
		newEntry.addContact("John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		
		//update the firstName
		newEntry.updateLastName("1", "Kamara");
		
		//create assertion to verify updated lastName
		assertTrue(newEntry.contactList.get("1").getLastName() == "Kamara");
		
		//create assertion to test throw exception
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updateLastName("1", "Superlonglastnameguy"));
		assertThrows(IllegalArgumentException.class, () ->
		 			 newEntry.updateLastName("1", null));
		
		//verify throw value if contactId doesn't exist
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updateLastName("11", "Kamara"));
	};
	
	//test updating phone
	@Test
	public void testUpdatePhone() {
		//call singleton instance
		ContactService newEntry = ContactService.getInstance();
				
		//create a new entry in the HashMap
		newEntry.addContact("John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		
		//update the phone number
		newEntry.updatePhone("1", "4141414141");
		
		//create assertion to verify updated phone number
		assertTrue(newEntry.contactList.get("1").getPhone() == "4141414141");
		
		//create assertion to test throw exception
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updatePhone("1", "41"));
		assertThrows(IllegalArgumentException.class, () ->
		 			 newEntry.updatePhone("1", null));
		
		//verify throw exception if contactId doesn't exist
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updatePhone("11", "4141414141"));
	};
	
	//test updating address
	@Test
	public void testUpdateAddress() {
		//call singleton instance
		ContactService newEntry = ContactService.getInstance();
				
		//create a new entry in the HashMap
		newEntry.addContact("John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		
		//update the firstName
		newEntry.updateAddress("1", "41 Who Dat");
		
		//create assertion to verify updated address
		assertTrue(newEntry.contactList.get("1").getAddress() == "41 Who Dat");
		
		//create assertion to test throw exception
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updateAddress("1", "41 Who Dat Way, New Orleans, Louisiana 70032"));
		assertThrows(IllegalArgumentException.class, () ->
		 			 newEntry.updateAddress("1", null));
		
		//verify throw value if contactId doesn't exist
		assertThrows(IllegalArgumentException.class, () ->
					 newEntry.updateAddress("11", "41 Who Dat"));
	}; 
	
	

}
