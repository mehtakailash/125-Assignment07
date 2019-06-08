package com.scg.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonalNameTest {
	
	private static final String     LAST   = "Mehta";
    private static final String     FIRST  = "Kail";
    private static final String     MIDDLE = "BR";

    
	PersonalName personalName = new PersonalName(LAST,FIRST,MIDDLE);

	@Test 
	void testConstructorlValues() {
		PersonalName personalName = new PersonalName();
		assertTrue( personalName.getLastName().isEmpty() );
        assertTrue( personalName.getFirstName().isEmpty() );
        assertTrue( personalName.getMiddleName().isEmpty() );
        
        personalName = new PersonalName( null, null );
        assertTrue( personalName.getLastName().isEmpty() );
        assertTrue( personalName.getFirstName().isEmpty() );
        assertTrue( personalName.getMiddleName().isEmpty() );
		
		personalName = new PersonalName(LAST,FIRST,MIDDLE);
		assertEquals( LAST, personalName.getLastName() );
        assertEquals( FIRST, personalName.getFirstName() );
        assertEquals( MIDDLE, personalName.getMiddleName() );
		
		
	}	
	
	@Test
	void testToString() {
		PersonalName personalName = new PersonalName();
		assertNotNull(personalName.toString());
//		assertTrue((personalName.getFirstName().equals("(no first name)")));
//		assertTrue((personalName.getLastName().equals("(no last name)")));
	}
	
	PersonalName personalName3 = new PersonalName(LAST,FIRST);
//	PersonalName personalName = new PersonalName();
	PersonalName personalName4 = new PersonalName("(no last name)","(no first name)");

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEquals() {
		String     STREET     = "123 test";
		String     CITY       = "Bellevue";
	    StateCode  STATE      = StateCode.WA;
	    String     ZIP        = "98207";
	    Address address = new Address(STREET,CITY,STATE,ZIP);
	    
		assertEquals("(no first name)",personalName4.getFirstName());
		assertFalse(personalName.equals(personalName4));
		assertFalse(personalName.equals(personalName3));
		assertTrue(personalName.getFirstName().equals(personalName3.getFirstName()));
		assertTrue(personalName.getLastName().equals(personalName3.getLastName()));
//		assertTrue(personalName.getMiddleName().equals(personalName3.getMiddleName()));
		assertFalse(personalName.equals(null));
		assertFalse(personalName.equals(address));
	}
	
	@Test
	void testHashCode() {
		assertNotNull(personalName.hashCode());
	}
	
	@Test
	void testCompare() {
		assertThrows(NullPointerException.class, ()-> personalName.compareTo( null ));
		assertNotNull(personalName.compareTo(personalName));
		assertEquals( 0, personalName.compareTo( personalName ) );
        assertNotEquals( 0, personalName.compareTo( personalName4 ) );
        assertTrue( personalName.compareTo( personalName4 ) > 0 );
        assertTrue( personalName4.compareTo( personalName ) < 0 );
		
//		assertThrows(NullPointerException.class, ()-> personalName.compareTo( personalName4 ));
//		assertThrows(NullPointerException.class, ()-> personalName.compareTo( personalName ));
	}
	
    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void testCompareToByFirst()
    {
        String  first       = "Test";
        String  middle      = "QA";
        String  last        = "Automation";
        String  first1      = first + 1;
        String  first2      = first + 2;
        String  first1Dup   = first + 1;
        
        PersonalName    name1       = new PersonalName( last, first1, middle );
        PersonalName    name2       = new PersonalName( last, first2, middle );
        PersonalName    name1Dup    = 
            new PersonalName( last, first1Dup, middle );
        
        assertEquals( 0, name1.compareTo( name1 ) );
        assertEquals( 0, name1.compareTo( name1Dup ) );
        assertTrue( name1.compareTo( name2 ) < 0 );
        assertTrue( name2.compareTo( name1 ) > 0 );
        assertTrue( name1.compareTo( name1 ) == 0);
        assertTrue( name2.compareTo( name2) == 0 );
    }
}
