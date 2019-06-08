
package com.scg.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
 * @author kailashm
 *
 */
class TimeCardConsultantComparatorTest {
	
	private LocalDate weekStartingDate = LocalDate.now();
	private String firstName = "First";
	private String lastName = "Last";
	private String middleName = "Middle";
	PersonalName pName = new PersonalName(firstName,lastName,middleName);
	Consultant Consultant = new Consultant(pName);
	TimeCard timeCard1 = new TimeCard(Consultant,weekStartingDate);
	
	private String firstName2 = "First2";
	private String lastName2 = "Last2";
	private String middleName2 = "Middle2";
	PersonalName pName2 = new PersonalName(firstName2,lastName2,middleName2);
	Consultant Consultant2 = new Consultant(pName2);
	TimeCard timeCard2 = new TimeCard(Consultant2,weekStartingDate);
	
	TimeCardConsultantComparator timeCardConsultantComparator = new TimeCardConsultantComparator();
	
	
	/**
	 * Test method for {@link com.scg.util.TimeCardConsultantComparator#compare(com.scg.domain.TimeCard, com.scg.domain.TimeCard)}.
	 */
	@Test
	void testCompare() {
		assertNotNull(timeCardConsultantComparator.compare(timeCard1, timeCard2));
		assertThrows(NullPointerException.class, ()-> timeCardConsultantComparator.compare(null, null ));
		assertThrows(NullPointerException.class, ()-> timeCardConsultantComparator.compare(null, timeCard2 ));
	}

}
