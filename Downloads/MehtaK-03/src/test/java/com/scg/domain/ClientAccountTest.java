/**
 * 
 */
package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * @author kailashm
 *
 */
class ClientAccountTest {

	private String name = "testClient";
	private static final String     STREET     = "123 test";
    private static final String     CITY       = "Bellevue";
    private static final StateCode  STATE      = StateCode.WA;
    private static final String     ZIP        = "98207";

    Address address = new Address(STREET,CITY,STATE,ZIP);
	
    private static final String     LAST   = "Mehta";
    private static final String     FIRST  = "Kail";
    private static final String     MIDDLE = "BR";
    
    PersonalName contact = new PersonalName(LAST,FIRST,MIDDLE);
    
    ClientAccount clientAccount = new ClientAccount(name,contact,address);
    

	@Test
	void testClientAccount() {
		String          name    = "Acme, Inc.";
        PersonalName    contact = new PersonalName( "Munster", "Herman" );
        Address         addr    = 
            new Address(
                "123 AAA",
                "Norfolk",
                StateCode.ID,
                "44444"
            );
        ClientAccount   client  = new ClientAccount( name, contact, addr );
        
        assertEquals( contact, client.getContact() );
        assertEquals( name, client.getName() );
        assertEquals( addr, client.getAddress() );
	}
	
	/**
	 * Test method for {@link com.scg.domain.ClientAccount#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertNotNull(clientAccount.hashCode());
	}

	/**
	 * Test method for {@link com.scg.domain.ClientAccount#getContact()}.
	 */
	@Test
	void testGetContact() {
		clientAccount.setContact(contact);
		assertNotNull(clientAccount.getContact());
	}

	/**
	 * Test method for {@link com.scg.domain.ClientAccount#getAddress()}.
	 */
	@Test
	void testGetAddress() {
		clientAccount.setAddress(address);
		assertNotNull(clientAccount.getAddress());
	}

	/**
	 * Test method for {@link com.scg.domain.ClientAccount#getName()}.
	 */
	@Test
	void testGetName() {
		assertNotNull(clientAccount.getName());
	}

	/**
	 * Test method for {@link com.scg.domain.ClientAccount#isBillable()}.
	 */
	@Test
	void testIsBillable() {
		assertTrue(clientAccount.isBillable());
	}

	/**
	 * Test method for {@link com.scg.domain.ClientAccount#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		String name = "newTestClient";
		assertEquals(this.clientAccount,clientAccount);
		ClientAccount clientAccount = new ClientAccount(name,contact,address);
		assertNotEquals(this.clientAccount,clientAccount);
	}

	/**
	 * Test method for {@link com.scg.domain.ClientAccount#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(clientAccount.toString());
	}

}
