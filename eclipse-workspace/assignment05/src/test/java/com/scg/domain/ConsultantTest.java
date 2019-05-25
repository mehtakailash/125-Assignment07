
package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import java.time.LocalDate;

import org.junit.jupiter.api.Test;

//import com.scg.util.Address;
import com.scg.util.PersonalName;
//import com.scg.util.StateCode;

/**
 * @author kailashm
 *
 */
class ConsultantTest {
	private String firstName = "First";
	private String lastName = "Last";
	private String middleName = "Middle";
	PersonalName pName = new PersonalName(firstName,lastName,middleName);
	Consultant Consultant = new Consultant(pName);

	/**
	 * Test method for {@link com.scg.domain.Consultant#Consultant(com.scg.util.PersonalName)}.timeCard
	 */
	@Test
	void testConsultant() {
		assertThrows(NullPointerException.class, ()-> new Consultant(null));
//		PersonalName pName1 = new PersonalName(firstName,lastName,middleName);
		Consultant a1 = new Consultant( pName);
		assertNotNull(a1);
		PersonalName pName2 = new PersonalName(null,null,null);
		Consultant a2 = new Consultant( pName2);
		assertNotNull(a2);
	}

	/**
	 * Test method for {@link com.scg.domain.Consultant#toString()}.
	 */
	@Test
	void testToString() {
//		PersonalName pName = new PersonalName(firstName,lastName,middleName);
		Consultant a = new Consultant( pName);
		assertNotNull(a.toString());
	}
	
	
	/**
	 * Test method for {@link com.scg.domain.Consultant#toString()}.
	 */
	@Test
	void testEquals() {

//		assertEquals(this.Consultant,Consultant);
		PersonalName pName = new PersonalName(firstName,lastName);
		Consultant Consultant = new Consultant(pName);
		assertNotEquals(this.Consultant,Consultant);
		assertNotEquals(this.Consultant,pName);
	}
	
	/**
	 * Test method for {@link com.scg.domain.Consultant#hashCode()}.
	 */
	@Test
	void testHashCode() {
//		PersonalName pName = new PersonalName(firstName,lastName,middleName);
		Consultant a = new Consultant( pName);
		assertNotNull(a.hashCode());
	}
	

	@Test
	void testCompare() {
		String firstName = "First1";
		String lastName = "Last1";
		String middleName = "Middle1";
		PersonalName pName1 = new PersonalName(firstName,lastName,middleName);
		Consultant Consultant1 = new Consultant(pName1);
		
		assertNotNull(Consultant.compareTo(Consultant));
		assertThrows(NullPointerException.class, ()-> Consultant.compareTo( null ));
//		assertThrows(NullPointerException.class, ()-> Consultant.compareTo( Consultant1 ));
		assertEquals( 0, Consultant.compareTo( Consultant ) );
		assertTrue( Consultant.compareTo( Consultant1 ) < 0 );
		assertTrue( Consultant1.compareTo( Consultant ) > 0 );
//		assertThrows(NullPointerException.class, ()-> Consultant.compareTo( Consultant ));
	}
	
}
