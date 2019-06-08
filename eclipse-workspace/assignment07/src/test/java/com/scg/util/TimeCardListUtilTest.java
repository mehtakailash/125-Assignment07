package com.scg.util;

import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
* Class to the Personal Data.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
class TimeCardListUtilTest {
	
	TimeCardListUtil timeCardListUtil = new TimeCardListUtil();
	
	private LocalDate weekStartingDate = LocalDate.now();
	private String firstName = "First";
	private String lastName = "Last";
	private String middleName = "Middle";
	PersonalName pName = new PersonalName(firstName,lastName,middleName);//	@Test
//	void testGetTimeCardsForDateRange() {
//	assertNotNull(TimeCardListUtil.getTimeCardsForDateRange(timeCardList, dateRange));
//}
	Consultant Consultant = new Consultant(pName);
	TimeCard timeCard1 = new TimeCard(Consultant,weekStartingDate);
	
	private String firstName2 = "First2";
	private String lastName2 = "Last2";
	private String middleName2 = "Middle2";
	PersonalName pName2 = new PersonalName(firstName2,lastName2,middleName2);
	Consultant Consultant2 = new Consultant(pName2);
	TimeCard timeCard2 = new TimeCard(Consultant2,weekStartingDate);
	
	private String firstName3 = "First3";
	private String lastName3 = "Last3";
	private String middleName3 = "Middle3";
	PersonalName pName3 = new PersonalName(firstName3,lastName3,middleName3);
	Consultant Consultant3 = new Consultant(pName3);
	TimeCard timeCard3 = new TimeCard(Consultant3,weekStartingDate);
	
	private final ArrayList<TimeCard> timeCardList = new ArrayList<>();
	

	int year = 2019;
	LocalDate startDate = LocalDate.of(year, Month.APRIL, 1 );
    LocalDate endDate = LocalDate.of(year, Month.MAY, 30 );
    
    DateRange dateRange = new DateRange(startDate, endDate);
    
    @Test
	void testConstructor() {
    	TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
    	timeCardList.add(timeCard);
    	TimeCard timeCard2 = new TimeCard(Consultant2,weekStartingDate);
    	timeCardList.add(timeCard2);
    	TimeCard timeCard3 = new TimeCard(Consultant3,weekStartingDate);
    	timeCardList.add(timeCard3);
    	
	}
    
	
	@SuppressWarnings("static-access")
	@Test
	void testGetTimeCardsForConsultant() {
		TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
    	timeCardList.add(timeCard);
    	TimeCard timeCard2 = new TimeCard(Consultant2,weekStartingDate);
    	timeCardList.add(timeCard2);
    	TimeCard timeCard3 = new TimeCard(Consultant3,weekStartingDate);
    	timeCardList.add(timeCard3);
		assertNotNull(TimeCardListUtil.getTimeCardsForConsultant(timeCardList, Consultant));
		assertNotNull(TimeCardListUtil.getTimeCardsForConsultant(timeCardList, Consultant2));
		timeCardListUtil.sortByConsultantName(timeCardList);
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testGetTimeCardsForDateRange() {
		TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
    	timeCardList.add(timeCard);
    	TimeCard timeCard2 = new TimeCard(Consultant2,weekStartingDate);
    	timeCardList.add(timeCard2);
    	TimeCard timeCard3 = new TimeCard(Consultant3,weekStartingDate);
    	timeCardList.add(timeCard3);
		timeCardListUtil.sortByStartDate(timeCardList);
		assertNotNull(TimeCardListUtil.getTimeCardsForDateRange(timeCardList, dateRange));
	}
	
//	@Test
//	void testGetTimeCardsForDateRange() {
//		assertNotNull(TimeCardListUtil.getTimeCardsForDateRange(timeCardList, dateRange));
//	}
	
}
