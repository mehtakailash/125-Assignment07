package com.scg.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
* Class to store Client Account information.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-19 
*/
public class ConsultantTime {
	private LocalDate date;
	private Account account;
	private Skill skill; 
	private int hours;
	
	 /**
	  * ConsultantTime constructor representing Consultant's Time detail.  that
	  * Name, Contact person, and Address. 
	  * @param date.
	  * @param account.
	  * @param skill. to the given object
	  * @param hours.
	  * @throws IllegalArgumentException if no of hours is 0 or less.that
	  */
	public ConsultantTime( LocalDate date, Account account, Skill skill, int hours ) {
			this.date = date;
			this.account = account;
			this.skill = skill;
			this.hours = hours;
		
			if (!this.isBillable()) {
				this.skill= Skill.UNKNOWN_SKILL;
			    }
			
			if (this.hours <= 0) {
			      throw new IllegalArgumentException("Zero working hours");
			    }
		}
	
	/**
	 * Setter for date.
	 * @param date.
	 */
	public void setDate(LocalDate date) {
//		The new date for this object.
		this.date = date;
	}
	
	/**
	 * Returns date.
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}
	 
	/**
	 * Setter for account.
	 * @param account.
	 */
	public void setAccount(Account account) {
//		The new account for this object. 
		this.account = account;
	}

	/**
	 * Returns account.
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * Setter for no of hours worked.
	 * @param hours.
	 */
	public void setHours(int hours) {
//		The new hours for this object. 
		this.hours = hours;
		
		if (this.hours <= 0) {
		      throw new IllegalArgumentException("Zero working hours");
		    }
	}
	
	/**
	 * Returns for no of hours worked.
	 * @return hours
	 */
	public int getHours() {
		return hours;
	}
	
	/**
	 * Setter for skill.
	 * @param skill.
	 */
	public void setSkill( Skill skill ) {
//		The new skill for this object. 
		this.skill = skill;
	}

	/**
	 * Returns skill.
	 * @return skill
	 */
	public Skill getSkill() {
		return skill;
	}
	
	/**
     * Determine whether or not this time is billable. 
     * 
     * @return true, if this time is billable, false otherwise.
     */
	public boolean isBillable() {
		return account.isBillable();
	}
	
	/**
     * Compare objects.
     * 
     * @param obj   The given object.
     * 
     * @return true if equal, false otherwise.
     */
	@Override
	public boolean equals( Object obj ) {
		boolean rcode   = false;
        
        if ( this == obj )
            rcode = true;
        else if ( obj == null )
            rcode = false;
        else if ( !(obj instanceof ConsultantTime) )
            rcode = false;
        {
            ConsultantTime  consultantTime    = (ConsultantTime)obj;
            rcode =
                this.date.equals( consultantTime.date )
                && this.account.equals( consultantTime.account )
                && this.skill == consultantTime.skill
                && this.hours == consultantTime.hours;
        }
        
        return rcode;
	}
	
	@Override
	public int hashCode() {
		int hashCode    = Objects.hash( date, account, skill, hours );
        return hashCode;
	}
	
	//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		LocalDate date = LocalDate.now();
//		Skill[] skill = Skill.values();
//		for ( Skill skills : skill  )
//		    {
//			  ConsultantTime a = new ConsultantTime( date, null, skills, 10);
//			  System.out.println(a.isBillable());
//		    }
//	}
} 
