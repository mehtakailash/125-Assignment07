/**
 * 
 */
package com.scg.beans;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import com.scg.domain.Consultant;
import com.scg.util.PersonalName;

/**
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-26
*/
class EeocTest {

	/**
	 * Test method for {@link com.scg.beans.Eeoc#forcedTerminationCount()}.
	 */
	@Test
	void testTerminationCounts() {
		Eeoc eeoc= new Eeoc();
		PersonalName personalNameF = new PersonalName("MehtaF","KailF","BRF");
		Consultant ConsultantF = new Consultant(personalNameF);
		TerminationEvent terminationEventForceF = new TerminationEvent(ConsultantF, ConsultantF, false);
		
		eeoc.forcedTermination(terminationEventForceF);
		assertNotNull(eeoc.forcedTerminationCount());		
		PersonalName personalNameV = new PersonalName("MehtaV","KailV","BRV");
		Consultant ConsultantV = new Consultant(personalNameV);
		TerminationEvent terminationEventForceV = new TerminationEvent(ConsultantV, ConsultantV, true);
		
		eeoc.voluntaryTermination(terminationEventForceV);
		assertNotNull(eeoc.voluntaryTerminationCount());
		
	}

}
