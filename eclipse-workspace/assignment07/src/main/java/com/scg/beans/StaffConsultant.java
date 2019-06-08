package com.scg.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

import com.scg.domain.Consultant;
import com.scg.util.PersonalName;

/**
* StaffConsultant Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-24 
*/
public class StaffConsultant extends Consultant implements Serializable {
	

	/** The serialVersionUID. */
	private static final long serialVersionUID = 4913717230551827884L;

	/** Pay rate property name. */
    public static final String PAY_RATE_PROPERTY_NAME = "payRate";

    /** Pay rate property name. */
    public static final String SICK_LEAVE_HOURS_PROPERTY_NAME = "sickLeaveHours";
    
    /** Vacation hours property name. */
    public static final String VACATION_HOURS_PROPERTY_NAME = "vacationHours";

    /** Pay rate in cents. */
    private int payRate;

    /** Sick leave hours balance. */
    private int sickLeaveHours;

    /** Vacation hours balance. */
    private int vacationHours;
    
    /** Property change support helper. */
    private final PropertyChangeSupport propertyChangeSupport;

    /** Vetoable change support helper. */
    private final VetoableChangeSupport vetoableChangeSupport;

    /**
     * Creates a new instance of StaffConsultant
     *
     * @param personalName the consultant's name
     * @param rate the pay rate in cents
     * @param sickLeave the sick leave hours
     * @param vacation the vacation hours
     */
    public StaffConsultant(final PersonalName personalName, final int rate,
                           final int sickLeave, final int vacation) throws NullPointerException {
        super(personalName);
        payRate = rate;
        sickLeaveHours = sickLeave;
        vacationHours = vacation;
        propertyChangeSupport = new PropertyChangeSupport(this);
        vetoableChangeSupport = new VetoableChangeSupport(this);
}
    /**
     * Get the current pay rate.
     *
     * @return the pay rate in cents
     */
    public int getPayRate() {
        return payRate;
    }
    
    /**addPropertyChangeListener();
     * Set the pay rate. Fires the VetoableChange event.
     *
     * @param payRate the pay rate in cents
     * @throws PropertyVetoException if a veto occurs
     */
    public void setPayRate(final int payRate) throws PropertyVetoException {
    	vetoableChangeSupport.fireVetoableChange(PAY_RATE_PROPERTY_NAME, this.payRate, payRate);
        final int oldRate = this.payRate;
        this.payRate = payRate;
        propertyChangeSupport.firePropertyChange(PAY_RATE_PROPERTY_NAME, oldRate, payRate);
    }
    
    /**
     * Adds a general property change listener.
     *
     * @param l the listener
     */
    public void addPropertyChangeListener(final PropertyChangeListener l) {
    	propertyChangeSupport.addPropertyChangeListener(l);
    }
    
    /**
     * Remove a general property change listener.
     *
     * @param l the listener
     */
    public void removePropertyChangeListener(final PropertyChangeListener l) {
    	propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    /**
     * Adds a payRate property change listener.	PropertyChangeListener PropertyChangeListener = true;
     *
     * @param l the listener
     */
    public void addPayRateListener(final PropertyChangeListener l) {
    	propertyChangeSupport.addPropertyChangeListener(PAY_RATE_PROPERTY_NAME, l);
    }
    
    /**
     * Removes a payRate property change listener.
     *
     * @param l the listener	PropertyChangeListener PropertyChangeListener = true;
     */
    public void removePayRateListener(final PropertyChangeListener l) {
    	propertyChangeSupport.removePropertyChangeListener(PAY_RATE_PROPERTY_NAME, l);
    }
    
    /**
     * Adds a vetoable change listener.
     *
     * @param l the listener
     */
    public void addVetoableChangeListener(final VetoableChangeListener l) {
        // The only constrained property is payRate register specifically for it
    	vetoableChangeSupport.addVetoableChangeListener(PAY_RATE_PROPERTY_NAME, l);
    	}
    
    /**
     * Removes a vetoable change listener.
     *
     * @param l the listener
     */
    public void removeVetoableChangeListener(final VetoableChangeListener l) {
    	vetoableChangeSupport.removeVetoableChangeListener(PAY_RATE_PROPERTY_NAME, l);
    }
    
    /**
     * Get the available sick leave.
     *
     * @return the available sick leave hours
     */
    public int getSickLeaveHours() {
        return sickLeaveHours;
    }

    /**
     * Set the sick leave hours. Fires the ProperrtyChange event.
     *
     * @param sickLeaveHours the available sick leave hours
     */
    public void setSickLeaveHours(final int sickLeaveHours) {
        final int oldHours = this.sickLeaveHours;
        this.sickLeaveHours = sickLeaveHours;
        propertyChangeSupport.firePropertyChange(SICK_LEAVE_HOURS_PROPERTY_NAME, oldHours, sickLeaveHours);
    }
    
    /**
     * Adds a sickLeaveHours property change listener.
     *
     * @param l the listener
     */
    public void addSickLeaveHoursListener(final PropertyChangeListener l) {
    	propertyChangeSupport.addPropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME, l);
    }

    /**
     * Removes a sickLeaveHours property change listener.
     *
     * @param l the listener
     */
    public void removeSickLeaveHoursListener(final PropertyChangeListener l) {
    	propertyChangeSupport.removePropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME, l);
}
    
    /**
     * Get the available vacation hours.
     *
     * @return the available vacation hours
     */
    public int getVacationHours() {
        return vacationHours;
    }

    /**
     * Set the vacation hours. Fires the ProperrtyChange event.
     *
     * @param vacationHours the vacation hours
     */
    public void setVacationHours(final int vacationHours) {
        final int oldHours = this.vacationHours;
        this.vacationHours = vacationHours;
        propertyChangeSupport.firePropertyChange(VACATION_HOURS_PROPERTY_NAME, oldHours, vacationHours);
    }
    
    /**
     * Adds a vacationHours property change listener.
     *
     * @param l the listener
     */
    public void addVacationHoursListener(final PropertyChangeListener l) {
    	propertyChangeSupport.addPropertyChangeListener(VACATION_HOURS_PROPERTY_NAME, l);
    }

    /**
     * Removes a vacationHours property change listener.
     *
     * @param l the listener
     */
    public void removeVacationHoursListener(final PropertyChangeListener l) {
    	propertyChangeSupport.removePropertyChangeListener(VACATION_HOURS_PROPERTY_NAME, l);
    }
}
