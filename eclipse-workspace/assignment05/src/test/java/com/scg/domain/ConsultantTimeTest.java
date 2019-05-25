/**
 * 
 */
package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * @author kailashm
 *
 */
class ConsultantTimeTest {
	
	private LocalDate consultDate = LocalDate.now();
	
//	private ClientAccount clientAccount;
	private String name = "testClient";
	private Skill skill; 
	private int hours = 10;
	private static final String     STREET     = "123 test";
    private static final String     CITY       = "Bellevue";
    private static final StateCode  STATE      = StateCode.WA;
    private static final String     ZIP        = "98207";

    Address address = new Address(STREET,CITY,STATE,ZIP);
	
    private static final String     LAST   = "Mehta";
    private static final String     FIRST  = "Kail";
    private static final String     MIDDLE = "BR";
    
    PersonalName contact = new PersonalName(LAST,FIRST,MIDDLE);
    
    private Account account = new ClientAccount(name,contact,address);

	ConsultantTime consultantTime = new ConsultantTime(consultDate, account, Skill.SOFTWARE_TESTER, hours);
	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#ConsultantTime(java.time.LocalDate, com.scg.domain.Account, com.scg.domain.Skill, int)}.
	 */
	@Test
	void testConsultantTime() {
//		assertThrows(IllegalArgumentException.class, ()-> new consultantTime(consultDate, account, skill,0));
//		ConsultantTime consultantTime = new ConsultantTime(consultDate, account, skill, hours);
		assertNotNull(consultantTime);
		assertNotNull(new ConsultantTime(consultDate, account, null, hours));
		assertThrows(IllegalArgumentException.class, ()-> new ConsultantTime(consultDate, account, skill, 0));
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#getDate()}.
	 */
	@Test
	void testGetDate() {
		consultantTime.setDate(LocalDate.now());
		assertNotNull(consultantTime.getDate());
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#getAccount()}.
	 */
	@Test
	void testGetAccount() {
		consultantTime.setAccount(account);
		assertNotNull(consultantTime.getAccount());
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#getHours()}.
	 */
	@Test
	void testGetHours() {
//		int zeroHours = 0;
		
		assertThrows(IllegalArgumentException.class, ()-> consultantTime.setHours(0));
		consultantTime.setHours(hours);
		assertNotNull(consultantTime.getHours());
//		consultantTime.setHours(zeroHours);
//		assertThrows(IllegalArgumentException.class, ()-> new ConsultantTime(consultDate, account, skill, zeroHours));
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#getSkill()}.
	 */
	@Test
	void testGetSkill() {
		consultantTime.setSkill(skill);
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#isBillable()}.
	 */		
	@Test
	void testIsBillable() {
		assertNotNull(consultantTime.isBillable());
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#equals(java.lang.Object)}.
	 */

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEqualsObject() {
//		int newHours = 0;
		LocalDate newDate = LocalDate.now();
		assertEquals(this.consultantTime,consultantTime);
		ConsultantTime consultantTime1 = new ConsultantTime(newDate, account, consultantTime.getSkill(), hours);
		assertTrue(consultantTime.equals(consultantTime1));
		assertFalse(consultantTime1.equals(account));
		
		assertFalse(consultantTime.equals(null));
	}

	/**
	 * Test method for {@link com.scg.domain.ConsultantTime#hashCode()}.
	 */
	@Test
	void testHashCode() {
		assertNotNull(consultantTime.hashCode());
	}

}
