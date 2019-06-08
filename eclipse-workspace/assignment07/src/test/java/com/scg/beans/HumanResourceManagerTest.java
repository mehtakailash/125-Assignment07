/**
 * 
 */
package com.scg.beans;

import java.beans.PropertyVetoException;
import java.time.LocalDate;
import com.scg.util.PersonalName;

/**
 * @author kailashm
 *
 */
class HumanResourceManagerTest {

	PersonalName personalName = new PersonalName("Mehta","Kail","BR");
	
	StaffConsultant staffConsultant = new StaffConsultant(personalName, 5, 5, 5);
	
	LocalDate effectiveDate = LocalDate.now();
	
	BenefitEvent benefitEvent = new BenefitEvent(staffConsultant, effectiveDate);
	
	TerminationEvent terminationEvent = new TerminationEvent(staffConsultant, staffConsultant, true);
	
	TerminationListener tListener;
	
//	private final EventListenerList listenerList = new EventListenerList();
	
	HumanResourceManager humanResourceManager = new HumanResourceManager();
	
	BenefitManager          benMgr  = new BenefitManager();
    HumanResourceManager    hrMgr   = new HumanResourceManager();
    CompensationManager     comMgr  = new CompensationManager();
    Eeoc                    eeoc    = new Eeoc();
   
	
	void testHumanResourceManagerTest() throws PropertyVetoException {
		humanResourceManager.addBenefitListener( benMgr );
		humanResourceManager.acceptResignation(staffConsultant);
		humanResourceManager.addTerminationListener(tListener);
		humanResourceManager.terminate(staffConsultant);
		
		humanResourceManager.adjustPayRate(staffConsultant, 8);
		
		humanResourceManager.adjustPayRate(staffConsultant, 4);
		humanResourceManager.adjustSickLeaveHours(staffConsultant, 8);
		humanResourceManager.adjustVacationHours(staffConsultant, 6);
		
		humanResourceManager.enrollMedical(staffConsultant, effectiveDate);
		staffConsultant.addPropertyChangeListener( benMgr );
		humanResourceManager.cancelMedical(staffConsultant, effectiveDate);
		humanResourceManager.enrollDental(staffConsultant, effectiveDate);
		humanResourceManager.cancelDental(staffConsultant, effectiveDate);
		
	}
}

