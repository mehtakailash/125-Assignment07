

package com.scg.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;

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
	PersonalName pName = new PersonalName("Mehta","Kailash");	
    Address address = new Address("123 test","Bellevue",StateCode.WA,"98207");
	Consultant Consultant = new Consultant(pName);
	TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
	private String name = "testClient";
	private LocalDate consultDate = LocalDate.now();
	private int hours = 8;
    private Account account = new ClientAccount(name,pName,address);

	ConsultantTime consultantTime = new ConsultantTime(consultDate, account, Skill.SOFTWARE_TESTER, hours);
	/**
	 * Test method for {@link com.scg.domain.TimeCard#TimeCard(com.scg.domain.Consultant, java.time.LocalDate)}.
	 */
	@Test
	void testTimeCard() {
		assertNotNull(timeCard);
		assertNotNull(timeCard.getConsultant());
		assertNotNull(timeCard.getWeekStartingDate());
	}

//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getConsultant()}.
//	 */
//	@Test
//	void testGetConsultant() {
//		assertNotNull(timeCard.getConsultant());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getWeekStartingDate()}.
//	 */
//	@Test
//	void testGetWeekStartingDate() {
//		assertNotNull(timeCard.getWeekStartingDate());
//	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getTotalBillableHours()}.
	 */
	@Test
	void testGetTotalBillableHours() {
		int billableHours = 0;
		if ( account.isBillable() )
            billableHours += consultantTime.getHours();
		assertNotNull(billableHours);
		assertNotNull(timeCard.getTotalBillableHours());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getTotalNonBillableHours()}.
	 */
	@Test
	void testGetTotalNonBillableHours() {
		consultantTime = null;
		int nonBillableHours = 0;
		if ( !account.isBillable() )
            nonBillableHours += consultantTime.getHours();
		assertNotNull(nonBillableHours);
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

		timeCard.addConsultantTime(consultantTime);
		assertNotNull(timeCard.getConsultingHours());
	}

	/**
	 * Test method for {@link com.scg.domain.TimeCard#getBillableHoursForClient(java.lang.String)}.
	 */
	@Test
	void testGetBillableHoursForClient() {
		String name = "testClient";
		Skill skill = null; 
		int hours = 2;
		LocalDate newDate = LocalDate.now();
		ArrayList<ConsultantTime> consultantTimeHours = new ArrayList<ConsultantTime>();
		ArrayList<ConsultantTime> consultantTimeNonBillableHours = new ArrayList<ConsultantTime>();
		int totalBillableHours = 0;
		int totalNonBillableHours = 2;

		   Address address = new Address("123 test","Bellevue",StateCode.WA,"98207");
		   PersonalName contact = new PersonalName("Mehta","Kail","BR");
		   Account account = new ClientAccount(name,contact,address);

		@SuppressWarnings("static-access")
		ConsultantTime consultantTime = new ConsultantTime(newDate, account, skill.UNKNOWN_SKILL, hours);
		assertNotNull(timeCard.getBillableHoursForClient(consultantTime.getAccount().getName()));
		timeCard.addConsultantTime(consultantTime);
		if (consultantTime.isBillable()) {
		consultantTimeHours.add(consultantTime);
		            totalBillableHours = totalBillableHours + consultantTime.getHours();
		        } else {
		        consultantTimeNonBillableHours.add(consultantTime);
		            totalNonBillableHours = totalNonBillableHours + consultantTime.getHours();
		        }

		String name1 = "testClient1";
		Address address1 = new Address("321 test","Bellevue1",StateCode.CA,"98207");
		   PersonalName contact1 = new PersonalName("Mehta","Kail","BR");
		   Account account1 = new ClientAccount(name1,contact1,address1);
		@SuppressWarnings("static-access")
		ConsultantTime consultantTime1 = new ConsultantTime(newDate, account1, skill.SOFTWARE_ENGINEER, hours);
		assertNotNull(timeCard.getBillableHoursForClient(consultantTime1.getAccount().getName()));
		timeCard.addConsultantTime(consultantTime1);

		String name2 = "testClient2";
		Address address2 = new Address("321 test","Bellevue1",StateCode.CA,"98207");
		   PersonalName contact2 = new PersonalName("Mehta","Kail","BR");
		   Account account2 = new ClientAccount(name2,contact2,address2);
		@SuppressWarnings("static-access")
		ConsultantTime consultantTime2 = new ConsultantTime(newDate, account2, skill.PROJECT_MANAGER, hours);
		assertNotNull(timeCard.getBillableHoursForClient(name2));
		timeCard.addConsultantTime(consultantTime2);
		assertNotNull(timeCard.getTotalBillableHours());
		assertNotNull(timeCard.getTotalNonBillableHours());
		assertNotNull(timeCard.getTotalHours());

		Account account3 = NonBillableAccount.BUSINESS_DEVELOPMENT;
		@SuppressWarnings("static-access")
		ConsultantTime consultantTime3 = new ConsultantTime(newDate, account3, skill.PROJECT_MANAGER, hours);
		timeCard.addConsultantTime(consultantTime3);

		assertNotNull(timeCard.toReportString());
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
		LocalDate weekStartingDate = LocalDate.now();
		PersonalName pName = new PersonalName("Mehta","Kailash");	
	    Address address = new Address("123 test","Bellevue",StateCode.WA,"98207");
		Consultant Consultant = new Consultant(pName);
		TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
		String name = "testClient";
		LocalDate consultDate = LocalDate.now();
		int hours = 1;
	    Account account = new ClientAccount(name,pName,address);

		ConsultantTime consultantTime = new ConsultantTime(consultDate, account, Skill.UNKNOWN_SKILL, hours);
		timeCard.addConsultantTime(consultantTime);
		timeCard.getBillableHoursForClient(name);
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
	
	@Test
	void testCompare() {
		LocalDate weekStartingDate = LocalDate.now();
		PersonalName pName = new PersonalName("Mehta1","Kailash1");
		Consultant Consultant = new Consultant(pName);
		assertNotNull(timeCard.toString());
		TimeCard timeCard1 = new TimeCard(Consultant,weekStartingDate);
		assertNotNull(timeCard.compareTo( timeCard ));
		assertThrows(NullPointerException.class, ()-> timeCard1.compareTo( null ));
//		assertThrows(NullPointerException.class, ()-> timeCard.compareTo( timeCard1 ));
//		assertThrows(NullPointerException.class, ()-> timeCard.compareTo( timeCard ));
	}

}

//
//package com.scg.domain;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.Test;
//
//import com.scg.util.Address;
//import com.scg.util.PersonalName;
//import com.scg.util.StateCode;
//
///**
// * @author kailashm
// *
// */
//class TimeCardTest {
//	
//	private LocalDate weekStartingDate = LocalDate.now();
//	PersonalName pName = new PersonalName("Mehta","Kailash");	
//    Address address = new Address("123 test","Bellevue",StateCode.WA,"98207");
//	Consultant Consultant = new Consultant(pName);
//	TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
//	private String name = "testClient";
//	private LocalDate consultDate = LocalDate.now();
//	private int hours = 8;
//    private Account account = new ClientAccount(name,pName,address);
//
//	ConsultantTime consultantTime = new ConsultantTime(consultDate, account, Skill.SOFTWARE_TESTER, hours);
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#TimeCard(com.scg.domain.Consultant, java.time.LocalDate)}.
//	 */
//	@Test
//	void testTimeCard() {
//		assertNotNull(timeCard);
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getConsultant()}.
//	 */
//	@Test
//	void testGetConsultant() {
//		assertNotNull(timeCard.getConsultant());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getWeekStartingDate()}.
//	 */
//	@Test
//	void testGetWeekStartingDate() {
//		assertNotNull(timeCard.getWeekStartingDate());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getTotalBillableHours()}.
//	 */
//	@Test
//	void testGetTotalBillableHours() {
//		int billableHours = 0;
//		if ( account.isBillable() )
//            billableHours += consultantTime.getHours();
//		assertNotNull(billableHours);
//		assertNotNull(timeCard.getTotalBillableHours());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getTotalNonBillableHours()}.
//	 */
//	@Test
//	void testGetTotalNonBillableHours() {
//		consultantTime = null;
//		int nonBillableHours = 0;
//		if ( !account.isBillable() )
//            nonBillableHours += consultantTime.getHours();
//		assertNotNull(nonBillableHours);
//		assertNotNull(timeCard.getTotalNonBillableHours());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getTotalHours()}.
//	 */
//	@Test		
//	void testGetTotalHours() {
//		assertNotNull(timeCard.getTotalHours());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getConsultingHours()}.
//	 */
//	@Test
//	void testGetConsultingHours() {
//
//		timeCard.addConsultantTime(consultantTime);
//		assertNotNull(timeCard.getConsultingHours());
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#getBillableHoursForClient(java.lang.String)}.
//	 */
//	@Test
//	void testGetBillableHoursForClient() {
//		String name = "testClient";
//		Skill skill = null; 
//		int hours = 10;
//		LocalDate newDate = LocalDate.now();
//		String     STREET     = "123 test";
//	    String     CITY       = "Bellevue";
//	    StateCode  STATE      = StateCode.WA;
//	    String     ZIP        = "98207";
//
//	    Address address = new Address(STREET,CITY,STATE,ZIP);
//		
//	    String     LAST   = "Mehta";
//	    String     FIRST  = "Kail";
//	    String     MIDDLE = "BR";
//	    
//	    PersonalName contact = new PersonalName(LAST,FIRST,MIDDLE);
//	    
//	    Account account = new ClientAccount(name,contact,address);
//
//		ConsultantTime consultantTime = new ConsultantTime(newDate, account, skill, hours);
//		assertNotNull(timeCard.getBillableHoursForClient(consultantTime.getAccount().getName()));
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#paddingForReport(java.lang.String, int)}.
//	 */
//	@Test
//	void testPaddingForReport() {
////		assertNotNull(timeCard.paddingForReport("Test Padding", 4));
//	}
//	
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#toReportString()}.
//	 */
//	@Test
//	void testToReportString() {
//		assertNotNull(timeCard.toReportString());
//		LocalDate weekStartingDate = LocalDate.now();
//		PersonalName pName = new PersonalName("Mehta","Kailash");	
//	    Address address = new Address("123 test","Bellevue",StateCode.WA,"98207");
//		Consultant Consultant = new Consultant(pName);
//		TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
//		String name = "testClient";
//		LocalDate consultDate = LocalDate.now();
//		int hours = 1;
//	    Account account = new ClientAccount(name,pName,address);
//
//		ConsultantTime consultantTime = new ConsultantTime(consultDate, account, Skill.UNKNOWN_SKILL, hours);
//		timeCard.getBillableHoursForClient(name);
//		assertNotNull(timeCard.toReportString());
//		
//	}
//
//	/**
//	 * Test method for {@link com.scg.domain.TimeCard#toString()}.
//	 */
//	@Test
//	void testToString() {
//		assertNotNull(timeCard.toString());
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#hashCode()}.
//	 */
//	@Test
//	void testHashCode() {
//		assertNotNull(timeCard.hashCode());
//	}
//	
//	@Test
//	void testCompare() {
//		LocalDate weekStartingDate = LocalDate.now();
//		PersonalName pName = new PersonalName("Mehta1","Kailash1");
//		Consultant Consultant = new Consultant(pName);
//		assertNotNull(timeCard.toString());
//		TimeCard timeCard1 = new TimeCard(Consultant,weekStartingDate);
//		assertNotNull(timeCard.compareTo( timeCard ));
//		assertThrows(NullPointerException.class, ()-> timeCard1.compareTo( null ));
////		assertThrows(NullPointerException.class, ()-> timeCard.compareTo( timeCard1 ));
////		assertThrows(NullPointerException.class, ()-> timeCard.compareTo( timeCard ));
//	}
//
//}
