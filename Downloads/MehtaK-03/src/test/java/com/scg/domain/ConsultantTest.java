/**
 * 
 */
package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.scg.util.PersonalName;

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
	 * Test method for {@link com.scg.domain.Consultant#Consultant(com.scg.util.PersonalName)}.
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

		assertEquals(this.Consultant,Consultant);
		PersonalName pName = new PersonalName(firstName,lastName);
		Consultant Consultant = new Consultant(pName);
		assertNotEquals(this.Consultant,Consultant);
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

}
