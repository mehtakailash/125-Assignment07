package com.scg.beans;

import java.util.EventListener;

/**
* BenefitListener Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-24 
*/
public interface BenefitListener extends EventListener  {

	public abstract void benefitChange( BenefitEvent event ); 
}
