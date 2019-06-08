package com.scg.domain;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
* Class for invoice.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-05-01 
*/
class InvoiceHeaderTest {
	
	private String businessName = "testBusiness";
	private LocalDate invoiceDate = LocalDate.of(2019, 05, 1);
	private LocalDate invoiceForMonth = invoiceDate;
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
	

	InvoiceHeader invoiceHeader = new InvoiceHeader(businessName,address,clientAccount,invoiceDate, invoiceForMonth);
	
	/**
	 * Test method for {@link com.scg.domain.InvoiceHeader#InvoiceHeader(java.lang.String, com.scg.util.Address, com.scg.domain.ClientAccount, java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test
	void testInvoiceHeader() {
		
		assertNotNull(invoiceHeader);
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceHeader#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(invoiceHeader.toString());
	}

}
