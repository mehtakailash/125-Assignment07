/**
 * 
 */
package com.scg.domain;

import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * @author kailashm
 *
 */
class TimeCardTest {
	
	private LocalDate weekStartingDate = LocalDate.now();
	private String firstName = "First";
	private String lastName = "Last";
	private String middleName = "Middle";
	PersonalName pName = new PersonalName(firstName,lastName,middleName);
	Consultant Consultant = new Consultant(pName);
	TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
	ConsultantTime time;
	/**
	 * Test method for {@link com.scg.domain.TimeCard#TimeCard(com.scg.domain.Consultant, java.time.LocalDate)}.
	 */
	@Test
	void testTimeCard() {
		assertNotNull(timeCard);
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getConsultant()}.
	 */
	@Test
	void testGetConsultant() {
		assertNotNull(timeCard.getConsultant());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getWeekStartingDate()}.
	 */
	@Test
	void testGetWeekStartingDate() {
		assertNotNull(timeCard.getWeekStartingDate());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#addConsultantTime(com.scg.domain.ConsultantTime)}.
	 */
	@Test
	void testAddConsultantTime() {
//		assertNotNull(timeCard.addConsultantTime(time));
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getTotalBillableHours()}.
	 */
	@Test
	void testGetTotalBillableHours() {
		assertNotNull(timeCard.getTotalBillableHours());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getTotalNonBillableHours()}.
	 */
	@Test
	void testGetTotalNonBillableHours() {
		assertNotNull(timeCard.getTotalNonBillableHours());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getTotalHours()}.
	 */
	@Test
	void testGetTotalHours() {
		assertNotNull(timeCard.getTotalHours());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getConsultingHours()}.
	 */
	@Test
	void testGetConsultingHours() {
		assertNotNull(timeCard.getConsultingHours());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getBillableHoursForClient(java.lang.String)}.
	 */
	@Test
	void testGetBillableHoursForClient() {
		String name = "testClient";
		Skill skill = null; 
		int hours = 10;
		LocalDate newDate = LocalDate.now();
		String     STREET     = "123 test";
	    String     CITY       = "Bellevue";
	    StateCode  STATE      = StateCode.WA;
	    String     ZIP        = "98207";

	    Address address = new Address(STREET,CITY,STATE,ZIP);
		
	    String     LAST   = "Mehta";
	    String     FIRST  = "Kail";
	    String     MIDDLE = "BR";
	    
	    PersonalName contact = new PersonalName(LAST,FIRST,MIDDLE);
	    
	    Account account = new ClientAccount(name,contact,address);

		ConsultantTime consultantTime = new ConsultantTime(newDate, account, skill, hours);
		assertNotNull(timeCard.getBillableHoursForClient(consultantTime.getAccount().getName()));
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#paddingForReport(java.lang.String, int)}.
	 */
	@Test
	void testPaddingForReport() {
//		assertNotNull(timeCard.paddingForReport("Test Padding", 4));
	}
	
	/**
	 * Test method for {@link com.scg.domain.TimeCard#toReportString()}.
	 */
	@Test
	void testToReportString() {
		assertNotNull(timeCard.toReportString());
		
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(timeCard.toString());
	}

	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertNotNull(timeCard.hashCode());
	}

}
