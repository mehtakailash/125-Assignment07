package com.scg.util;

import java.util.Objects;

/**
* Class to the Personal Data.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class PersonalName {
	String first;
	String middle;
	String last;
	
	/**
	  * PersonalName constructors representing Personal Data.  
	  * First, Middle and Last Name may not be null, so substitute the empty string
	  */
	public PersonalName() {
		this.first = "";
		this.middle = "";
		this.last = "";
	}
	
	/**
	  * PersonalName constructors representing Personal Data.  
	  * Middle Name may not be null, so substitute the empty string
	  * @param firstName.
	  * @param lastName.
	  */
	public PersonalName( String lastName, String firstName ) {
		setLastName( lastName );
        setFirstName( firstName );
		middle = "";
//		this.first = firstName;
//		this.last = lastName;
//		if (this.first == null) {
//			first = "";
//		    }
//		if (this.last == null) {
//			last = "";
//		    }
	}
	
	/**
	  * PersonalName constructors representing Personal Data.  
	  * @param firstName.
	  * @param middleName.
	  * @param lastName.
	  */
	public PersonalName( String lastName, String firstName, String middleName ) {
		setLastName( lastName );
        setFirstName( firstName );
        setMiddleName( middleName );
//		this.first = firstName;
//		this.middle = middleName;
//		this.last = lastName;
//		if (this.first == null) {
//			first = "";
//		    }
//		if (this.middle == null) {
//			middle = "";
//		    }
//		if (this.last == null) {
//			last = "";
//		    }
	}
	
	/**
	 * Returns Last name.
	 * @return last.
	 */
	public String getLastName() {
		return last;
	}
	
	/**
	  * Setter for Last Name.
	  * @param lastName.
	  */
	public void setLastName(String lastName) {
		this.last = lastName;
		if (this.last == null) {
			last = "";
		    }
	} 
	
	/**
	 * Returns First name.
	 * @return first.
	 */
	public String getFirstName() {
		return first;
	}
	
	/**
	  * Setter for First Name.
	  *  @param firstName.
	  */
	public void setFirstName(String firstName) {
		this.first = firstName;
		if (this.first == null) {
			first = "";
		    }
	}
	
	/**
	 * Returns Middle name.
	 * @return middle
	 */
	public String getMiddleName() {
		return middle;
	}
	
	/**
	  * Setter for Middle Name.
	  *  @param middleName.
	  */
	public void setMiddleName(String middleName) {
		this.middle = middleName;
		if (this.middle == null) {
			middle = "";
		    }
	}
	
	/**
	  * Compare PersonalName object to a given object.
	  *  @param obj object that has to be compared.
	  *  @return true if equal; false otherwise.
	  */
	@Override
    public boolean equals( Object obj ) {
    	boolean rcode   = false;
    	if ( this == obj )
            rcode = true;
        else if ( obj == null )
            rcode = false;
        else if ( !(obj instanceof PersonalName) )
            rcode = false;
        else
        {
            PersonalName    personalName    = (PersonalName)obj;
            rcode = this.last.equals( personalName.last )
                 && this.first.equals( personalName.first )
                 && this.middle.equals( personalName.middle );
        }
        
        return rcode;
	}
	
	 @Override
	 public int hashCode() {
	        int hashCode = Objects.hash( last, first, middle );
	        return hashCode;
	 }
	
	@Override
	public String toString() {
		String lastName = last;
		String firstName = first;
//		String personalName;
		if (lastName=="") {
			lastName = "(no last name)";
		}
		if (firstName=="") {
			firstName = "(no first name)";
		}
//		personalName = lastName + "," + " " + firstName + " " + middle;
		
		StringBuilder strBldr = new StringBuilder( lastName );
		strBldr.append(", ").append(firstName);
		if (!middle.isEmpty()) {
			strBldr.append(" ").append(middle);
		}
		
		return strBldr.toString();
	}
//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		PersonalName a = new PersonalName(null,null,"Hello");
//		System.out.println(a.toString());
//	}
}
