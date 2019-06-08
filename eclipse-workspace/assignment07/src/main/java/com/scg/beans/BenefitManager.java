package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Logger;

/**
* BenefitManager Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-26 
*/
public class BenefitManager implements BenefitListener, PropertyChangeListener  {

	/** This class' logger. */
	private static final Logger log = Logger.getLogger(BenefitManager.class.getName());
	
	/** Constructor */
    public BenefitManager() {
    }

    /**
     * Logs the change.
     *
     * @param evt a property change event for the sickLeaveHours or
     *            vacationHours property
     */
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        final String propName = evt.getPropertyName();
        final int oldValue = (Integer) evt.getOldValue();
        final int newValue = (Integer) evt.getNewValue();     
        log.info(propName + " " + ((StaffConsultant)evt.getSource()).getName() + 
        		"; " + "old value " + oldValue + ", " + "new value " + newValue);
    }

    /**
     * Logs the change.
     *
     * @param evt a benefit change event for the consultant
     */
	@Override
	public void benefitChange(BenefitEvent evt) {
		
		if(evt.medicalStatus().isPresent()) 
			log.info(/*benefitName + ", " + */"Medical, enrolled: " + evt.getConsultant() + "; effective date: " + evt.getEffectiveDate());
		else log.info(/*benefitName + ", " + */"Medical, cancelled: " + evt.getConsultant() + "; effective date: " + evt.getEffectiveDate());
		
		if(evt.dentalStatus().isPresent()) 
			log.info(/*benefitName + ", " + */"Dental, enrolled: " + evt.getConsultant() + "; effective date: " + evt.getEffectiveDate());
		else log.info(/*benefitName + ", " + */"Dental, cancelled: " + evt.getConsultant() + "; effective date: " + evt.getEffectiveDate());
		
	}	
}