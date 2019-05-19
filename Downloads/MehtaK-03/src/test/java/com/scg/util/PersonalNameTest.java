package com.scg.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonalNameTest {
	
	private static final String     LAST   = "Mehta";
    private static final String     FIRST  = "Kail";
    private static final String     MIDDLE = "BR";

    
	PersonalName personalName = new PersonalName(LAST,FIRST,MIDDLE);

	@Test 
	void testConstructorlValues() {
		PersonalName personalName = new PersonalName(LAST,FIRST,MIDDLE);
		assertEquals( LAST, personalName.getLastName() );
        assertEquals( FIRST, personalName.getFirstName() );
        assertEquals( MIDDLE, personalName.getMiddleName() );
		
		personalName = new PersonalName( null, null, null );
        assertTrue( personalName.getLastName().isEmpty() );
        assertTrue( personalName.getFirstName().isEmpty() );
        assertTrue( personalName.getMiddleName().isEmpty() );
	}
	
	@Test
	void testGetLastName() {
		assertNotNull(personalName.getLastName());
	}
	
	@Test
	void testSetLastName() {
		personalName.setLastName(LAST);
		assertEquals( LAST, personalName.getLastName() );
		personalName.setLastName(null);
		assertNotNull(personalName.getLastName());
	}

	@Test
	void testGetFirstName() {
		assertNotNull(personalName.getFirstName());
	}
	
	@Test
	void testSetFirstName() {
		personalName.setLastName(FIRST);
		assertEquals( FIRST, personalName.getLastName() );
		personalName.setFirstName(null);
		assertNotNull(personalName.getFirstName());
	}

	@Test
	void testGetMiddleName() {
		assertNotNull(personalName.getMiddleName());
	}
	
	@Test
	void testSetMiddleName() {
		personalName.setLastName(MIDDLE);
		assertEquals( MIDDLE, personalName.getLastName() );
		personalName.setMiddleName(null);
		assertNotNull(personalName.getMiddleName());
	}
	
	@Test
	void testToString() {
		assertNotNull(personalName.toString());
	}
	
	PersonalName personalName2 = new PersonalName();
	
	PersonalName personalName3 = new PersonalName(LAST,FIRST);
	@Test
	void testGetLastName3() {
		assertNotNull(personalName3.getLastName());
	}
	
	@Test
	void testSetLastName3() {
		personalName.setLastName(null);
		assertNotNull(personalName3.getLastName());
	}
	
	PersonalName personalName4 = new PersonalName("(no last name)","(no first name)");
	@Test
	void testGetLastName4() {
		assertEquals("(no last name)",personalName4.getLastName());
	}
	
	@Test
	void testEquals() {
		assertEquals("(no first name)",personalName4.getFirstName());
		assertTrue((personalName.equals(personalName4)));
		assertFalse((personalName.equals(personalName3)));
		assertFalse((personalName.getFirstName().equals(personalName3.getFirstName())));
	}
	
	@Test
	void testHashCode() {
		assertNotNull(personalName.hashCode());
	}
	
}
