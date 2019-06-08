package com.scg.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scg.domain.Consultant;
import com.scg.util.PersonalName;

/**
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-26 
*/
class TerminationEventTest {
	PersonalName personalName = new PersonalName("Mehta","Kail","BR");
	Consultant Consultant = new Consultant(personalName);
	TerminationEvent terminationEvent = new TerminationEvent(Consultant, Consultant, true);
	/**
	 * Test method for {@link com.scg.beans.TerminationEvent#TerminationEvent(java.lang.Object, com.scg.domain.Consultant, boolean)}.
	 */
	@Test
	void testTerminationEvent() {
		
		assertNotNull(terminationEvent.getConsultant());
	}

	/**
	 * Test method for {@link com.scg.beans.TerminationEvent#getConsultant()}.
	 */
	@Test
	void testGetConsultant() {
		assertNotNull(terminationEvent.getConsultant());
	}

	/**
	 * Test method for {@link com.scg.beans.TerminationEvent#isVoluntary()}.
	 */
	@Test
	void testIsVoluntary() {
		assertNotNull(terminationEvent.isVoluntary());
		TerminationEvent terminationEvent = new TerminationEvent(Consultant, Consultant, false);
		assertNotNull(terminationEvent.isVoluntary());
	}

}
