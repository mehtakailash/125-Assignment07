package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * @author kailashm
 *
 */
class InvoiceTest {
	
	private String businessName = "testBusiness";
	private LocalDate invoiceDate = LocalDate.of(2019, 05, 1);
	private Month month = invoiceDate.getMonth();
	private int year = invoiceDate.getYear();
	private static final String     STREET     = "123 test";
    private static final String     CITY       = "Bellevue";
    private static final StateCode  STATE      = StateCode.WA;
    private static final String     ZIP        = "98207";

    Address address = new Address(STREET,CITY,STATE,ZIP);
    private static final String     LAST   = "Mehta";
    private static final String     FIRST  = "Kail";
    private static final String     MIDDLE = "BR";
    
    PersonalName contact = new PersonalName(LAST,FIRST,MIDDLE);
	
	ClientAccount clientAccount = new ClientAccount(businessName,contact,address);
	
	Invoice invoice = new Invoice(clientAccount, month, year);

	/**
	 * Test method for {@link com.scg.domain.Invoice#Invoice(com.scg.domain.ClientAccount, java.time.Month, int)}.
	 */
	@Test
	void testInvoice() {
		assertNotNull(invoice);
		assertEquals( clientAccount, invoice.getClientAccount() );
        assertEquals( month, invoice.getInvoiceMonth() );
        assertEquals( year, invoice.getInvoiceYear() );

	}

	/**
	 * Test method for {@link com.scg.domain.Invoice#getClientAccount()}.
	 */
	@Test
	void testGetClientAccount() {
		assertNotNull(invoice.getClientAccount());
	}

	/**
	 * Test method for {@link com.scg.domain.Invoice#getInvoiceMonth()}.
	 */
	@Test
	void testGetInvoiceMonth() {
		assertNotNull(invoice.getInvoiceMonth());
	}

	/**
	 * Test method for {@link com.scg.domain.Invoice#getInvoiceYear()}.
	 */
	@Test
	void testGetInvoiceYear() {
		assertNotNull(invoice.getInvoiceYear());
	}

	/**
	 * Test method for {@link com.scg.domain.Invoice#getStartDate()}.
	 */
	@Test
	void testGetStartDate() {
		assertNotNull(invoice.getStartDate());
	}

	/**
	 * Test method for {@link com.scg.domain.Invoice#getTotalCharges()}.
	 */
	@Test
	void testGetTotalCharges() {
		assertNotNull(invoice.getTotalCharges());
	}

	/**
	 * Test method for {@link com.scg.domain.Invoice#toReportString()}.
	 */
	@Test
	void testToReportString() {
		
		assertNotNull(invoice.toReportString());
		
		List<InvoiceLineItem>    expTimeList1    = new ArrayList<>();
//		List<InvoiceLineItem>    expTimeList2    = new ArrayList<>();
		int hours = 8;
		LocalDate weekStartingDate = LocalDate.now();
		String firstName = "First";
		String lastName = "Last";
		String middleName = "Middle";
		PersonalName pName = new PersonalName(firstName,lastName,middleName);
		Consultant Consultant = new Consultant(pName);
		TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
		invoice.extractLineItems(timeCard);
		InvoiceLineItem invoiceLineItem = new InvoiceLineItem(invoiceDate, Consultant, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem);
		
		String firstName1 = "First1";
		String lastName1 = "Last1";
		String middleName1 = "Middle1";
		PersonalName pName1 = new PersonalName(firstName1,lastName1,middleName1);
		Consultant Consultant1 = new Consultant(pName1);
		TimeCard timeCard1 = new TimeCard(Consultant1,weekStartingDate);
		invoice.extractLineItems(timeCard1);
//		assertNotNull(invoice.toReportString());
		InvoiceLineItem invoiceLineItem1 = new InvoiceLineItem(invoiceDate, Consultant, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem1);
		invoice.addLineItem(invoiceLineItem1);
		
		String firstName2 = "First2";
		PersonalName pName2 = new PersonalName(firstName2,lastName,middleName);
		Consultant Consultant2 = new Consultant(pName2);
		TimeCard timeCard2 = new TimeCard(Consultant2,weekStartingDate);
		invoice.extractLineItems(timeCard2);
		InvoiceLineItem invoiceLineItem2 = new InvoiceLineItem(invoiceDate, Consultant2, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem2);
		invoice.addLineItem(invoiceLineItem2);
		
		String firstName3= "First3";
		PersonalName pName3 = new PersonalName(firstName3,lastName,middleName);
		Consultant Consultant3 = new Consultant(pName3);
		TimeCard timeCard3 = new TimeCard(Consultant3,weekStartingDate);
		invoice.extractLineItems(timeCard3);
		InvoiceLineItem invoiceLineItem3 = new InvoiceLineItem(invoiceDate, Consultant3, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem3);
		invoice.addLineItem(invoiceLineItem3);
		
		hours = invoiceLineItem3.getHours();
		String firstName4= "First4";
		PersonalName pName4 = new PersonalName(firstName4,lastName,middleName);
		Consultant Consultant4 = new Consultant(pName4);
		TimeCard timeCard4 = new TimeCard(Consultant4,weekStartingDate);
		invoice.extractLineItems(timeCard4);
		InvoiceLineItem invoiceLineItem4 = new InvoiceLineItem(invoiceDate, Consultant4, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem4);
		invoice.addLineItem(invoiceLineItem4);
		
		String firstName5= "First5";
		PersonalName pName5 = new PersonalName(firstName5,lastName,middleName);
		Consultant Consultant5 = new Consultant(pName5);
		TimeCard timeCard5 = new TimeCard(Consultant5,weekStartingDate);
		invoice.extractLineItems(timeCard5);
		InvoiceLineItem invoiceLineItem5 = new InvoiceLineItem(invoiceDate, Consultant5, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem5);
		invoice.addLineItem(invoiceLineItem5);
		
		String firstName6= "First6";
		PersonalName pName6 = new PersonalName(firstName6,lastName,middleName);
		Consultant Consultant6 = new Consultant(pName6);
		TimeCard timeCard6 = new TimeCard(Consultant5,weekStartingDate);
		invoice.extractLineItems(timeCard6);
		InvoiceLineItem invoiceLineItem6 = new InvoiceLineItem(invoiceDate, Consultant6, Skill.SOFTWARE_TESTER, hours);
		expTimeList1.add(invoiceLineItem6);
		invoice.addLineItem(invoiceLineItem6);
        
		assertNotNull(invoice.getTotalHours());
		assertNotNull(invoice.getTotalCharges());
		
		assertNotNull(invoice.toReportString());
		
		expTimeList1 = null;
		
		assertNotNull(invoice.toReportString());
	}
	
	/**
	 * Test method for {@link com.scg.domain.Invoice#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(invoice.toString());
		
	}

}