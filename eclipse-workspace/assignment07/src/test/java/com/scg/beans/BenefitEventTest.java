
package com.scg.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.scg.util.PersonalName;

/**
 * @author kailashm
 *
 */
class BenefitEventTest {

	PersonalName personalName = new PersonalName("Mehta","Kail","BR");
	int rate = 2 ;
    int sickLeave = 1 ;
    int vacation = 3 ;
    LocalDate effectiveDate = LocalDate.now();
    
    StaffConsultant consultant = new StaffConsultant(personalName, rate, sickLeave, vacation);
	/**
	 * Test method for {@link com.scg.beans.BenefitEvent#BenefitEvent(com.scg.beans.StaffConsultant, java.time.LocalDate)}.
	 */
	@Test
	void testBenefitEvent() {
	    
		BenefitEvent benefitEvent = new BenefitEvent(consultant, effectiveDate);
		assertNotNull(benefitEvent);
		
	}

	/**
	 * Test method for {@link com.scg.beans.BenefitEvent#enrollMedical(com.scg.beans.StaffConsultant, java.time.LocalDate)}.
	 */
	@Test
	void testEnrollMedical() {
		assertNotNull(BenefitEvent.enrollMedical(  consultant,  effectiveDate ));
		
	}

	/**
	 * Test method for {@link com.scg.beans.BenefitEvent#cancelMedical(com.scg.beans.StaffConsultant, java.time.LocalDate)}.
	 */
	@Test
	void testCancelMedical() {
		assertNotNull(BenefitEvent.cancelMedical(  consultant,  effectiveDate ));
	
	}

	/**
	 * Test method for {@link com.scg.beans.BenefitEvent#enrollDental(com.scg.beans.StaffConsultant, java.time.LocalDate)}.
	 */
	@Test
	void testEnrollDental() {
		
		assertNotNull(BenefitEvent.enrollDental( consultant,  effectiveDate ));
	}

	/**
	 * Test method for {@link com.scg.beans.BenefitEvent#cancelDental(com.scg.beans.StaffConsultant, java.time.LocalDate)}.
	 */
	@Test
	void testCancelDental() {
		
		assertNotNull(BenefitEvent.cancelDental( consultant,  effectiveDate ));
	}

}
