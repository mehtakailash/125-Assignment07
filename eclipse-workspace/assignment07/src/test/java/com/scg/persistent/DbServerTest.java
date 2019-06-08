package com.scg.persistent;

import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;


class DbServerTest {
	
	//@InjectMocks annotation is used to create and inject the mock object
//	   @InjectMocks 
	   DbServer dbServer = new DbServer("jdbc:derby://localhost:1527/memory:scgDb", "student", "student");

	   //@Mock annotation is used to create the mock object to be injected
//	   @Mock

	String name = "Test Name";
	private LocalDate weekStartingDate = LocalDate.now();
	private LocalDate invoiceDate = LocalDate.of(2019, 05, 1);
	private Month month = invoiceDate.getMonth();
	private int year = invoiceDate.getYear();
    Address address = new Address("123 test","Bellevue",StateCode.WA,"98207");
    
    PersonalName contact = new PersonalName("Mehta","Kail","BR");
    PersonalName contact2 = new PersonalName("Mehta2","Kail2","BR2");
    ClientAccount clientAccount = new ClientAccount(name,contact,address);
    Consultant Consultant = new Consultant(contact);
    Consultant Consultant2 = new Consultant(contact2);
    TimeCard timeCard = new TimeCard(Consultant,weekStartingDate);
    TimeCard timeCard2 = new TimeCard(Consultant,weekStartingDate);
 
	@Test
	void testClients() throws SQLException {
		dbServer.addClient(clientAccount);
	    assertNotNull(dbServer.getClients());
	}
	
	@Test
	void testConsultant() throws SQLException {
		dbServer.addConsultant(Consultant);
		dbServer.addConsultant(Consultant2);
	    assertNotNull(dbServer.getConsultants());
	}

	@Test
	void testTimeCard() throws SQLException {
		dbServer.addTimeCard(timeCard);
		dbServer.addTimeCard(timeCard2);
	    assertNotNull(dbServer.getInvoice(clientAccount, month, year));
	}
}
