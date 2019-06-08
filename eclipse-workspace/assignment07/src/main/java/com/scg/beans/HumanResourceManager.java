package com.scg.beans;

import java.beans.PropertyVetoException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.EventListenerList;

/**
* Eeoc Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-26 
*/
public class HumanResourceManager {

	/** This class' logger. */
    private static final Logger log = Logger.getLogger(HumanResourceManager.class.getName());
    
    /** Event listener list. */
    private final EventListenerList listenerList = new EventListenerList();
    
    /**
     * Fires a voluntary termination event for the staff consultant.
     *
     * @param consultant the consultant resigning
     */
	public void acceptResignation( StaffConsultant consultant ) {
		fireTerminationEvent(new TerminationEvent(this, consultant, true));
	}
	
	/**
     * Fires an involuntary termination event for the staff consultant.
     *
     * @param consultant the consultant being terminated
     */
	public void terminate( StaffConsultant consultant ) {
		fireTerminationEvent(new TerminationEvent(this, consultant, false));
	}
	
	/**
     * Sets the pay rate for a staff consultant.
     *
     * @param consultant the consultant
     * @param newPayRate the new pay rate for the consultant
     */
	public void adjustPayRate( StaffConsultant consultant, int newPayRate ) {
		try {
            if (log.isLoggable(Level.INFO)) {
                log.info("Change pay rate: " + consultant.getName() + "; approved");
                consultant.setPayRate(newPayRate);
            }
//            consultant.setPayRate(newPayRate);
//            log.info("Change pay rate: " + consultant.getName() + "; approved");
//            log.info("Approved pay adjustment for " + consultant.getName());
        } catch (final PropertyVetoException pve) {
//            log.info("Change pay rate: " + consultant.getName()+ "; vetoed");
        	log.info("Change pay rate: " + consultant.getName() + "; vetoed");
        }
	}
	
	/**
     * Sets the sick leave hours for a staff consultant.
     *
     * @param consultant the consultant
     * @param newSickLeaveHours the new sick leave hours for the consultant
     */
	public void adjustSickLeaveHours( StaffConsultant consultant, int newSickLeaveHours ) {
		consultant.setSickLeaveHours(newSickLeaveHours);
	}
	
	/**
     * Sets the vacation hours for a staff consultant.
     *
     * @param consultant the consultant
     * @param newVacationHours the new vacation hours for the consultant
     */
	public void adjustVacationHours( StaffConsultant consultant, int newVacationHours ) {
		consultant.setVacationHours(newVacationHours);
	}
	
	public void enrollMedical( StaffConsultant consultant, LocalDate effectiveDate )  {
		//Enrolls a given consultant in the corporate medical plan. Fires a BenefitEvent to BenefitListeners.
//		listenerList.add(BenefitListener.class, consultant);
//		BenefitEvent benefitEvent = new BenefitEvent(this, consultant,  effectiveDate);
		fireBenefitEvent(BenefitEvent.enrollDental(consultant, effectiveDate));
	}
	
	public void cancelMedical( StaffConsultant consultant, LocalDate effectiveDate ) {
		fireBenefitEvent(BenefitEvent.cancelMedical(consultant, effectiveDate));
	}
	 
	public void enrollDental( StaffConsultant consultant, LocalDate effectiveDate ) {
		fireBenefitEvent(BenefitEvent.enrollDental(consultant, effectiveDate));
	}
	
	public void cancelDental( StaffConsultant consultant, LocalDate effectiveDate ) {
		fireBenefitEvent(BenefitEvent.cancelDental(consultant, effectiveDate));
		
	}
	
	/**
     * Adds a termination listener.
     *
     * @param tListener the listener to add
     */
	public synchronized void addTerminationListener( TerminationListener tListener ) {
		listenerList.add(TerminationListener.class, tListener);
	}
	
	/**
     * Removes a termination listener.
     *
     * @param tListener the listener to remove
     */
	public synchronized void removeTerminationListener( TerminationListener tListener ) {
		listenerList.remove(TerminationListener.class, tListener);
	}
	
	/**
     * Adds a termination listener.
     *
     * @param bListener the listener to addlog.info("Pay rate change for: " + consultant.getName() + " approved");
     */
	public synchronized void addBenefitListener( BenefitListener bListener ) {
		//Registers a listener for benefit events. 
		listenerList.add(BenefitListener.class, bListener);
	}
	
	/**
     * Removes a termination listener.
     *
     * @param bListener the listener to remove
     */
	public synchronized void removeBenefitListener( BenefitListener bListener ) {
		//Deregisters a listener for benefit events. 
		listenerList.remove(BenefitListener.class, bListener);
	}
	
	/**
     * Fires a exchange event.
     *
     * @param evnt the event to be fired
     */
    private void fireTerminationEvent(final TerminationEvent evnt) {
        TerminationListener[] listeners;
        listeners = listenerList.getListeners(TerminationListener.class);

        for (final TerminationListener listener : listeners) {
            if (evnt.isVoluntary()) {
                listener.voluntaryTermination(evnt);
            } else {
                listener.forcedTermination(evnt);
            }
        }
    }
    
    /**
     * Fires a exchange event.
     *
     * @param evnt the event to be fired
     */
    private void fireBenefitEvent(final BenefitEvent evnt) {
    	BenefitListener[] listeners;
        listeners = listenerList.getListeners(BenefitListener.class);

        for (final BenefitListener listener : listeners) {
               listener.benefitChange(evnt);
        }
    }
}
