package com.scg.util;

//import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
* Class to the Personal Data.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class TimeCardListUtil {
	
	/**
     * Get a list of TimeCards for the specified consultant.
     * @param timeCards - the list of time cards to extract the sub set from
     * @param consultant - the consultant whose TimeCards will be obtained.
     * @return a list of TimeCards for the specified consultant.
     */
	public static List<TimeCard> getTimeCardsForConsultant(List<TimeCard> timeCards, Consultant consultant) {
		
		List<TimeCard> consultantsTimeCards = timeCards.stream()
				  .filter(tCards -> tCards.getConsultant().equals(consultant))
				  .collect(Collectors.toList());
		
		return consultantsTimeCards;
	}
	
	/**
     * Get a list of TimeCards that cover dates that fall within a date range. Each time may have time entries through
     * out one week beginning with the time card start date.
     * @param timeCards - the list of time cards to extract the sub set from
     * @param dateRange - The DateRange within which the dates of the returned TimeCards must fall.
     * @return a list of TimeCards having dates fall within the date range.
     */
	public static List<TimeCard> getTimeCardsForDateRange(List<TimeCard> timeCards, DateRange dateRange) {
        List<TimeCard> cardsInRange = timeCards.stream()
                .filter( (c) -> dateRange.isInRange( c.getWeekStartingDate() ) )
                .collect( Collectors.toList() );
       
		return cardsInRange;
	}

	/**
     * Sorts into ascending order by consultant name..
     * @param timeCards - the list of time cards to sort
     */
	public static void sortByConsultantName( List<TimeCard> timeCards ) {
		Collections.sort(timeCards, (t1, t2) -> 
			t1.getConsultant().compareTo(t2.getConsultant()));
	}
	
	/**
     * Sorts into ascending order, by the start date.
     * @param timeCards - the list of time cards to sort
     */
	static void sortByStartDate( List<TimeCard> timeCards ) {
		Collections.sort(timeCards, (TimeCard t1, TimeCard t2) -> 
			t1.getWeekStartingDate().compareTo(t2.getWeekStartingDate()));
	 }
	
	

}
