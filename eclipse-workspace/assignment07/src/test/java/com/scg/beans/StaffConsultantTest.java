
package com.scg.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.beans.PropertyVetoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.scg.util.PersonalName;

class StaffConsultantTest
{
    private int             testPayRate;
    private int             testSickLeaveHours;
    private int             testVacationHours;
    private PersonalName    testName;
    private StaffConsultant testConsultant;
    
    @BeforeEach
    void setUp()
    {
        testPayRate = 5000;
        testSickLeaveHours = 40;
        testVacationHours = 2 * testSickLeaveHours;
        testName = new PersonalName( "Eisenhower", "Dwight", "D" );
        testConsultant = 
            new StaffConsultant( 
                testName, 
                testPayRate, 
                testSickLeaveHours, 
                testVacationHours 
            );
    }

    @Test
    void testStaffConsultant()
    {
        assertEquals( testName, testConsultant.getName() );
        assertEquals( testPayRate, testConsultant.getPayRate() );
        assertEquals( testSickLeaveHours, testConsultant.getSickLeaveHours() );
        assertEquals( testVacationHours, testConsultant.getVacationHours() );
    }

    @Test
    void testGetPayRate()
    {
        assertEquals( testPayRate, testConsultant.getPayRate() );
    }

    @Test
    void testSetPayRate()
    {
        int newRate = 2 * testPayRate;
        try
        {
            testConsultant.setPayRate( newRate );
        }
        catch ( PropertyVetoException exc )
        {
            fail( "unexpected property veto exception" );
        }
        assertEquals( newRate, testConsultant.getPayRate() );
    }

    @Test
    void testGetSickLeaveHours()
    {
        assertEquals( testSickLeaveHours, testConsultant.getSickLeaveHours() );
    }

    @Test
    void testSetSickLeaveHours()
    {
        int newHours    = testSickLeaveHours + 1;
        testConsultant.setSickLeaveHours( newHours );
        assertEquals( newHours, testConsultant.getSickLeaveHours() );
    }

    @Test
    void testGetVacationHours()
    {
        assertEquals( testVacationHours, testConsultant.getVacationHours() );
    }

    @Test
    void testSetVacationHours()
    {
        int newHours    = testVacationHours + 1;
        testConsultant.setVacationHours( newHours );
        assertEquals( newHours, testConsultant.getVacationHours() );
    }

}
