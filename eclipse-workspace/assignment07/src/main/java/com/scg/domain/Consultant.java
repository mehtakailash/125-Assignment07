package com.scg.domain;

import java.io.Serializable;
//import java.util.Comparator;
import java.util.logging.Logger;

import com.scg.util.Address;
import com.scg.util.PersonalName;

/**
* Class to store Consultand information.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class Consultant implements Comparable<Consultant>, Serializable {
	
	@interface VisibleForTesting {

	}

	private static final Logger logger = Logger.getLogger("Consultant.class");

	private static final long serialVersionUID = -1119355287957807771L;
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

	public int compareTo(Consultant other) {
		int comparrissionValue = this.pName.compareTo( other.pName );
		return comparrissionValue;
	}

	@VisibleForTesting 
	Object writeReplace() {
        logger.info(String.format("Serializing: %s", pName));
        return new SerializationProxy(this);
    }

	@VisibleForTesting
    private static class SerializationProxy implements Serializable {

		private static final long serialVersionUID = -1996404132863385682L;
		private PersonalName name;

        private SerializationProxy(final Consultant consultant) {
            this.name = consultant.getName();
        }

        @VisibleForTesting
        private Object readResolve() {
            logger.info(String.format("De-serializing consultant: %s", name));
            return new Consultant(name);
        }    
        
    }
    
//  ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		PersonalName pName = new PersonalName("First","Last","Middle");
//		Consultant a = new Consultant( pName);
//		System.out.println(a.toString());
//	}
    
}
