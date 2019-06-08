package com.scg.beans;

import java.util.EventListener;

/**
* TerminationListener Interface.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-24 
*/
public interface TerminationListener extends EventListener {
	
	/**
     * Invoked when a consultant is voluntarily terminated.
     *
     * @param event the termination event
     */
	public abstract void forcedTermination( TerminationEvent event );
	
	/**
     * Invoked when a consultant is involuntarily terminated.
     *
     * @param event the termination event
     */
	public abstract void voluntaryTermination( TerminationEvent event );
}
