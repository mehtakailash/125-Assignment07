
package com.scg.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

/**
* Class to the Personal Data.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
class DateRangeTest {
	int year = 2019;
    Month month = Month.APRIL;
	private LocalDate startDate = LocalDate.of(year, month, 1 );
    private LocalDate endDate = LocalDate.now();
    
    DateRange dateRange = new DateRange(startDate, endDate);

    @Test
	void testConstructors() {
    	DateRange dateRange1 = new DateRange(startDate, endDate);
		assertNotNull(dateRange1.getStartDate());
		
		Month month = Month.of(04);
		int year = 2019;
		DateRange dateRange2 = new DateRange(month, year);
		assertNotNull(dateRange2.getStartDate());
		
        String  fmt         = "%d-%02d-%02d";
        int     startYear   = 2017;
        int     startDay    = 5;
        int     endYear     = 2017;
        int     endDay      = 25;
        int         iMonth      = month.getValue();
        String      startDate    = 
            String.format( fmt, startYear, iMonth, startDay );
        String      endDate      = 
            String.format( fmt, endYear, iMonth, endDay );
//		String startDate = "01/05/2019";
//		String endDate = "14/05/2019";
		DateRange dateRange3 = new DateRange(startDate, endDate);
		assertNotNull(dateRange3.getStartDate());

	}
    
	@Test
	void testGetStartDate() {
		assertNotNull(dateRange.getStartDate());
	}
	
	@Test
	void testGetEndDate() {
		assertNotNull(dateRange.getEndDate());
	}

	@Test
	void testIsInRange() {
		Month month1 = Month.APRIL;
		LocalDate checkDate = LocalDate.of(year, month1, 2 );
		assertNotNull(dateRange.isInRange(checkDate));
		Month month2 = Month.JANUARY;
		LocalDate checkDate2 = LocalDate.of(year, month2, 2 );
		assertNotNull(dateRange.isInRange(checkDate2));
		Month month3 = Month.DECEMBER;
		LocalDate checkDate3 = LocalDate.of(year, month3, 2 );
		assertNotNull(dateRange.isInRange(checkDate3));
	}
	
}
