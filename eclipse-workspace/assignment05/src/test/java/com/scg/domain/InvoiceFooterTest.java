package com.scg.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * @author kailashm
 *
 */
class InvoiceFooterTest {

	private String businessName = "testBusiness";
	
	InvoiceFooter invoiceFooter = new InvoiceFooter(businessName);
	/**
	 * Test method for {@link com.scg.domain.InvoiceFooter#InvoiceFooter(java.lang.String)}.
	 */
	@Test
	void testInvoiceFooter() {
		invoiceFooter.incrementPageNumber();
		assertNotNull(invoiceFooter);
	}


	/**
	 * Test method for {@link com.scg.domain.InvoiceFooter#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(invoiceFooter.toString());
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceFooter#paddingForReport(java.lang.String, int)}.
	 */
	@Test
	void testPaddingForReport() {
		assertNotNull(InvoiceFooter.paddingForReport("=", 10));
	}

}
