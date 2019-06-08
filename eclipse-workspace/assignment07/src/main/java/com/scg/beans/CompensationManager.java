package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* CompensationManager Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-26 
*/
public class CompensationManager implements PropertyChangeListener, VetoableChangeListener {
	
	/** Maximum allowed raise, 5%. */
    private static final int MAX_NEW_RATE_PERCENT = 105;

    /** Percent multiplier. */
    private static final int TO_PERCENT = 100;

    /** This class' logger. */
    private static final Logger log = Logger.getLogger(CompensationManager.class.getName());

    /**
     * Processes to final pay rate change.
     * 
     * @param evt a change event for the payRate property
     */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (StaffConsultant.PAY_RATE_PROPERTY_NAME.equals(evt.getPropertyName())) {
            log.info("Pay rate change for: " + ((StaffConsultant)evt.getSource()).getName() + ", "
            	+ "old rate " + evt.getOldValue() + " , new rate " + evt.getNewValue() );
		}
	}
	
	/**
     * Rejects any raise over 5%.
     *
     * @param evt a vetoable change event for the payRate property
     *
     * @throws PropertyVetoException if the change is vetoed
     */
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		if (StaffConsultant.PAY_RATE_PROPERTY_NAME.equals(evt.getPropertyName())) {
            final int oldValue = (Integer)evt.getOldValue();
            final int newValue = (Integer)evt.getNewValue();

            if (newValue * TO_PERCENT > oldValue * MAX_NEW_RATE_PERCENT) {
                if (log.isLoggable(Level.INFO)) {
                    log.info("REJECTED Pay rate change for: " + ((StaffConsultant)evt.getSource()).getName() + ", "
                        	+ "old rate " + evt.getOldValue() + " , new rate " + evt.getNewValue() );
                }
                throw new PropertyVetoException("Raise denied!", evt);
            }
//            if (log.isLoggable(Level.INFO)) {
//                log.info("APPROVED Pay rate change for: " + ((StaffConsultant)evt.getSource()).getName() + ", "
//                    	+ "old rate " + evt.getOldValue() + " , new rate " + evt.getNewValue() );
//            }
		}
		
	}

}
