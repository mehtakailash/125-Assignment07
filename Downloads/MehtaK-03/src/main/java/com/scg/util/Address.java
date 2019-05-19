package com.scg.util;

import java.util.Objects;

/**
* Class to store the address.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class Address {
	
	/** The street address. */
	private String street;
	/** The city. */
	private String city;
	/** The state. */
	private StateCode state;
	/** The zip code. */
	private String postalCode;
	
	/**
	  * Address constructor representing address.  
	  * Street, City, State and Postal may not be null.
	  * @param street.
	  * @param city.
	  * @param state.
	  * @param postalCode.
	  * @throws NullPointerException if any of address fields are null.
	  */
	public Address( String street, String city, StateCode state, String postalCode ) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
//		
//		if (this.street == null) {
//		      throw new NullPointerException(
//		          "Street is null");
//		    }
//		if (this.city == null) {
//		      throw new NullPointerException(
//		          "City is null");
//		    }
//		if (this.state == null) {
//		      throw new NullPointerException(
//		          "State is null");
//		    }
//		
//		if (this.postalCode == null) {
//		      throw new NullPointerException(
//		          "Postal code is null");
//		    }
	}
	
	/**
	 * Returns the street name.
	 * @return street
	 */
	public String getStreetNumber() {
		return street;
	}
	
	/**
	 * Returns the City name.
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Returns the State name.
	 * @return state
	 */
	public StateCode getState() {
		return state;
	}
	
	/**
	 * Returns the Postal Code.
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	 @Override
	 public int hashCode()
	 {
	     int hash    = Objects.hash( street, city, state, postalCode );
	     return hash;
	 }
	 
	@Override
	public String toString() {
		final String    ENDL    = System.lineSeparator();
        StringBuilder   bldr    = new StringBuilder();
        bldr.append( street ).append( ENDL );
        bldr.append( city ).append( ", " );
        bldr.append( state ).append( " " ).append( postalCode );
        
        return bldr.toString();
	}
	
	 /**
     * Compare two objects.
     * 
     * @param obj   The given object.
     * 
     * @return true if the given object is equal to this object
     */
    @Override
    public boolean equals( Object obj ) {
        boolean rcode   = false;
        
        if ( obj == null )
            rcode = false;
        else if ( this == obj )
            rcode = true;
        else if ( !(obj instanceof Address) )
            rcode = false;
        else
        {
            Address that    = (Address)obj;
            rcode   =
                testObjectEquality( this.street, that.street )
                && testObjectEquality( this.city, that.city )
                && this.state == that.state
                && testObjectEquality( this.postalCode, that.postalCode );
        }
        
        return rcode;
    }
    
    /**
     * Test two objects for equality. 
     * @param   obj1    The first object to compare.
     * @param   obj2    The second object to compare.
     * 
     * @return true if equal, false otherwise.
     */
    private boolean testObjectEquality( Object obj1, Object obj2 )
    {
        boolean rcode   = false;
        
        if ( obj1 == obj2 )
            rcode = true;
        else if ( obj1 == null )
            rcode = false;
        else
            rcode = obj1.equals( obj2 );
        
        return rcode;
    }
	
//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		state = state.WA;
//		Address a = new Address("apple Mock Lane","bell",state,"98204");
//		System.out.println(a.toString());
//	}
}
