package com.scg.beans;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.scg.util.PersonalName;

import util.LogReader;

class BenefitManagerTest
{
    private StaffConsultant consultant;
    private LocalDate       date;
    private BenefitManager  mgr;
    private LogReader       reader;

    @BeforeEach
    void setUpBeforeClass() throws Exception
    {
        PersonalName    name    = new PersonalName( "Clemens", "Sam" );
        reader = new LogReader();
        consultant  = new StaffConsultant( name, 10, 10, 10 );
        date        = LocalDate.now().plusDays( 1 );
        mgr         = new BenefitManager();
    }

    @AfterEach
    void tearDown() throws Exception
    {
        if ( reader != null )
            reader.close();
    }

    @Test
    void testMedicalEnrollment()
    {
        BenefitEvent    event   = BenefitEvent.enrollMedical(consultant, date);
        mgr.benefitChange(event);
        
        String          line        = reader.nextMessage().toLowerCase();
        assertTrue( line.contains( "medical" ) );
        assertTrue( line.contains( "enrol" ) );
        assertTrue( line.contains( consultant.toString().toLowerCase() ) );
        assertTrue( line.contains( date.toString() ) );
        
        assertFalse( line.contains( "dent" ) );
        assertFalse( line.contains( "canc" ) );
    }

    @Test
    void testMedicalCancellation()
    {
        BenefitEvent    event   = BenefitEvent.cancelMedical(consultant, date);
        mgr.benefitChange(event);
        
        String          line        = reader.nextMessage().toLowerCase();
        assertTrue( line.contains( "medical" ) );
        assertTrue( line.contains( consultant.toString().toLowerCase() ) );
        assertTrue( line.contains( date.toString() ) );
        
        assertFalse( line.contains( "dent" ) );
    }



    @Test
    void testPropertyChange()
    {
        Integer             oldVal  = 10;
        Integer             newVal  = 2 * oldVal;
        String              prop    = 
                StaffConsultant.SICK_LEAVE_HOURS_PROPERTY_NAME.toLowerCase();
        PropertyChangeEvent event   = 
            new PropertyChangeEvent( consultant, prop, oldVal, newVal );
        mgr.propertyChange( event );
        
        String              line    = reader.nextMessage().toLowerCase();
        System.out.println( consultant );
        System.out.println( line );
        assertTrue( line.contains( prop ) );
        assertTrue( line.contains( consultant.toString().toLowerCase() ) );
        assertTrue( line.contains( oldVal.toString() ) );
        assertTrue( line.contains( newVal.toString() ) );
    }
}