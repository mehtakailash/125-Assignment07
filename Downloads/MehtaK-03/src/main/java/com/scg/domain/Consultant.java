package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.PersonalName;

/**
* Class to store Consultand information.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class Consultant {
	PersonalName pName;
	Address address;
	
	/**
	  * Address constructor representing address.  
	  * Street, City, State and Postal may not be null.
	  * @param name'
	  * @throws NullPointerException if Name is null.
	  */ 
	//ToDo - Do we need to throw this here as we are throwing this in PersonalName.java too?
	public Consultant( PersonalName name ) {
		this.pName = name;
		if (this.pName == null) {
		      throw new NullPointerException(
		          "Name is null");
		    }
	}
	
	
	/**
	 * Returns consultant name.
	 * @return pName.
	 */
	public PersonalName getName(){
		return pName;
	}
	
	@Override
	public String toString() {
		return pName.toString();
	}
	
	@Override
	public boolean equals( Object obj ) {
		if (this == obj) return true;
        if (!(obj instanceof Consultant)) return false;

        Consultant consultant = (Consultant) obj;

        return pName.equals(consultant.pName);
	}
	
	@Override
	public int hashCode() {
		return pName.hashCode();
	}
	//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		PersonalName pName = new PersonalName("First","Last","Middle");
//		Consultant a = new Consultant( pName);
//		System.out.println(a.toString());
//	}
}
