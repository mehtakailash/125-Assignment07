package com.scg.beans;

import java.util.EventObject;

import com.scg.domain.Consultant;

/**
* BenefitListener Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-24 
*/

public class TerminationEvent extends EventObject {
	/** The serialVersionUID. */
	private static final long serialVersionUID = 9072486492100111595L;
	
	 /** Was it a voluntary termination. */
    private final boolean voluntary;

    /** Consultant terminated. */
    private final Consultant consultant;

	public TerminationEvent( final Object source, Consultant consultant, boolean voluntary ) {
		super(source);
        this.voluntary = voluntary;
        this.consultant = consultant;
	}
	
	/**
     * Gets the consultant that was terminated.
     *
     * @return the consultant that was terminated
     */
    public Consultant getConsultant() {
        return consultant;
    }
    
    /**
     * Gets the voluntary termination status.
     *
     * @return true if a voluntary termination
     */
    public boolean isVoluntary() {
        return voluntary;
    }

}
