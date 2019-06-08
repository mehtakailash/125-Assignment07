package com.scg.beans;

import java.util.logging.Logger;

import com.scg.util.PersonalName;

/**
* Eeoc Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-26 
*/
public class Eeoc implements TerminationListener {

	/** This class' logger. */
    private static final Logger log = Logger.getLogger(Eeoc.class.getName());

    /** Keeps the tally of voluntary terminations. */
    private int voluntaryTerminationCount;

    /** Keeps the tally of forced terminations. */
    private int forcedTerminationCount;
    
    /**
     * Simply prints a message indicating that the consultant quit.
     *
     * @param evt the termination event
     */
	@Override
	public void voluntaryTermination(TerminationEvent evt) {
		final PersonalName name = evt.getConsultant().getName();
		 log.info("Voluntary termination: " + name);
        voluntaryTerminationCount++;
	}
	
	/**
     * Simply prints a message indicating that the consultant was fired.
     *
     * @param evt the termination event
     */
	@Override
	public void forcedTermination(TerminationEvent evt) {
		final PersonalName name = evt.getConsultant().getName();
        log.info("Forced termination: " + name);
        forcedTerminationCount++;
	}
	
	/**
     * Gets the forced termination count.
     *
     * @return the forced termination count
     */
    public int forcedTerminationCount() {
        return forcedTerminationCount;
    }

    /**
     * Gets the voluntary termination count.
     *
     * @return the voluntary termination count
     */
    public int voluntaryTerminationCount() {
        return voluntaryTerminationCount;
    }

}
