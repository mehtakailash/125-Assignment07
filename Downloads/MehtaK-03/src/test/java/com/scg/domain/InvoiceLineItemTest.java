package com.scg.domain;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.scg.util.PersonalName;

/**
 * @author kailashm
 *
 */
class InvoiceLineItemTest {
	
	private LocalDate invoiceDate = LocalDate.of(2019, 05, 1);
	private String firstName = "First";
	private String lastName = "Last";
	private String middleName = "Middle";
	private Skill skill; 
	private int hours;
	PersonalName pName = new PersonalName(firstName,lastName,middleName);
	Consultant Consultant = new Consultant(pName);
	
	InvoiceLineItem invoiceLineItem = new InvoiceLineItem(invoiceDate, Consultant, skill, hours);

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#InvoiceLineItem(java.time.LocalDate, com.scg.domain.Consultant, com.scg.domain.Skill, int)}.
	 */
	@Test
	void testInvoiceLineItem() {
		assertNotNull(invoiceLineItem);
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#getDate()}.
	 */
	@Test
	void testGetDate() {
		assertNotNull(invoiceLineItem.getDate());
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#getConsultant()}.
	 */
	@Test
	void testGetConsultant() {
		assertNotNull(invoiceLineItem.getConsultant());
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#getSkill()}.
	 */
	@Test
	void testGetSkill() {
		assertNotNull(invoiceLineItem.getSkill());
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#getHours()}.
	 */
	@Test
	void testGetHours() {
		assertNotNull(invoiceLineItem.getHours());
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#getCharge()}.
	 */
	@Test
	void testGetCharge() {
		assertNotNull(skill.getRate());
		assertNotNull(invoiceLineItem.getCharge());
	}

	/**
	 * Test method for {@link com.scg.domain.InvoiceLineItem#toString()}.
	 */
	@Test
	void testToString() {
		assertNotNull(invoiceLineItem.toString());
	}

}
