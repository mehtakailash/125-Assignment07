
package com.scg.util;

import com.scg.domain.TimeCard;

import java.io.Serializable;
import java.util.Comparator;

/**
* Class to the Personal Data.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class TimeCardConsultantComparator implements Comparator<TimeCard>, Serializable {
	
	//This method must perform its comparison using a streaming expression, beginning with 
	//Comparator.comparing( TimeCard::getConsultant ) and ending with .compare( card1, card2 ) 
	
	private static final long serialVersionUID = 3943886236504883820L;

	public int compare( TimeCard card1, TimeCard card2 ) {
		if(card1 == null || card2 == null) 
			throw new NullPointerException( "argument may not be null" );
		int comparrissionValue = Comparator.comparing( TimeCard::getConsultant)
				.thenComparing(TimeCard::getWeekStartingDate)
				.thenComparing(TimeCard::getTotalBillableHours)
				.thenComparing(TimeCard::getTotalNonBillableHours)
				.compare( card1, card2 );
		return comparrissionValue;
	}
	
}
