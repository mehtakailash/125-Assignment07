package com.scg.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

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
	}
	
	/**
	 * Test method for {@link com.scg.domain.Invoice#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(invoice.toString());
	}

}
