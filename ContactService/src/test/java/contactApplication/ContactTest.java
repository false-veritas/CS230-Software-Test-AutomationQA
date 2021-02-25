/*
 * Contact Test Class
 * 
 * @author 	Vitalie Cucuta
 * @date 	01/23/2021
 * @school	SNHU CS-320
 * 
 */

package contactApplication;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {
	
	//test to determine input values are taken through constructor
	@Test
	public void testContact() {
		//create Contact class
		Contact contactClass = new Contact("1452788463", "John", "Smith", 
				  "7701234567", "4040 Schoolhouse Lane");
		
		//create assertions to make sure same value is returned as input
		assertTrue(contactClass.getContactId().equals("1452788463"));
		assertTrue(contactClass.getFirstName().equals("John"));
		assertTrue(contactClass.getLastName().equals("Smith"));
		assertTrue(contactClass.getPhone().equals("7701234567"));
		assertTrue(contactClass.getAddress().equals("4040 Schoolhouse Lane"));
		
		
	};
	
	//test set method values
	@Test
	public void testSetterMethods() {
		//create Contact class
		Contact contactClass = new Contact("1452788463", "John", "Smith", "7701234567", "4040 Schoolhouse Lane");
		
		//set values
		contactClass.setContactId("1234567890");
		contactClass.setFirstName("Alvin");
		contactClass.setLastName("Kamara");
		contactClass.setPhone("4141414141");
		contactClass.setAddress("41 Who Dat");
		
		//test new value is set value for contactId
		assertTrue(contactClass.getContactId() == "1234567890");
		
		//verify throw value for contactId too long or null
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setContactId("1234567890000"));
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setContactId(null));
		
		//test new value is set value firstName
		assertTrue(contactClass.getFirstName() == "Alvin");
		
		//verify throw value for firstName too long or null
		assertThrows(IllegalArgumentException.class, () -> 
					 contactClass.setFirstName("Shamalammadingdong"));
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setFirstName(null));
		
		//test new value is set value for lastName
		assertTrue(contactClass.getLastName() == "Kamara");
		
		//verify throw value for lastName too long or null
		assertThrows(IllegalArgumentException.class, () -> 
		   			 contactClass.setLastName("Superlonglastnameguy"));
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setLastName(null));
		
		//test new value is set value for phone
		assertTrue(contactClass.getPhone() == "4141414141");
		
		//verify throw value for phone too short, too long or null
		assertThrows(IllegalArgumentException.class, () -> 
					 contactClass.setPhone("41"));
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setPhone("1234567890000"));
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setPhone(null));
		
		//test new value is set value for address
		assertTrue(contactClass.getAddress() == "41 Who Dat");
		
		//verify throw value for address too long or null
		assertThrows(IllegalArgumentException.class, () -> 
					 contactClass.setAddress("4141 Saints Row New Orleans, Louisiana"));
		assertThrows(IllegalArgumentException.class, () ->
					 contactClass.setAddress(null));
		
	};
	
}

