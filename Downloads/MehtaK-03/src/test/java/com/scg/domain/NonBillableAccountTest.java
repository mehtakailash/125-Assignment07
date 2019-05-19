package com.scg.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests the NonBillableAccount class.
 */
public class NonBillableAccountTest
{
    
    /**
     * Test getName().
     */
    @Test
    public void testGetName()
    {
        assertEquals( "Business Development",
            NonBillableAccount.BUSINESS_DEVELOPMENT.getName()
          );
        assertEquals( "Sick Leave",
            NonBillableAccount.SICK_LEAVE.getName()
          );
        assertEquals( "Vacation",
            NonBillableAccount.VACATION.getName()
          );
    }

    /**
     * Test isBillable.()
     */
    @Test
    public void testIsBillable()
    {
        assertFalse( NonBillableAccount.BUSINESS_DEVELOPMENT.isBillable() );
        assertFalse( NonBillableAccount.SICK_LEAVE.isBillable() );
        assertFalse( NonBillableAccount.VACATION.isBillable() );
    }
    
    /**
     * Test getValues().
     */
    @Test
    public void testGetValues()
    {
        NonBillableAccount[]        all     = NonBillableAccount.values();
        assertEquals( 3, all.length );
        
        List<NonBillableAccount>    list    = 
            new ArrayList<>( Arrays.asList( all ) );
        
        assertTrue( list.contains( NonBillableAccount.BUSINESS_DEVELOPMENT ) );
        assertTrue( list.contains( NonBillableAccount.SICK_LEAVE ) );
        assertTrue( list.contains( NonBillableAccount.VACATION ) );
    }
    
    /**
     * Test valueOf().
     */
    @Test
    public void testValueOf()
    {
        assertEquals( NonBillableAccount.BUSINESS_DEVELOPMENT, 
            NonBillableAccount.valueOf( "BUSINESS_DEVELOPMENT" ) );
        assertEquals( NonBillableAccount.SICK_LEAVE, 
            NonBillableAccount.valueOf( "SICK_LEAVE" ) );
        assertEquals( NonBillableAccount.VACATION, 
            NonBillableAccount.valueOf( "VACATION" ) );
    }
}