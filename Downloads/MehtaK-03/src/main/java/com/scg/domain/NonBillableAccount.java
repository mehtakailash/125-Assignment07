package com.scg.domain;

/**
* Enum to store Billing information.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public enum NonBillableAccount implements Account {
	BUSINESS_DEVELOPMENT( "Business Development"),
	SICK_LEAVE( "Sick Leave"),
	VACATION("Vacation"); 
	
	private String  name;
	
	private NonBillableAccount( String name ) {
		this.name= name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isBillable() {
		return false;
	}

	//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		NonBillableAccount[] nonBillableAccounts    = NonBillableAccount.values();
//	    for ( NonBillableAccount nonBillableAccount : nonBillableAccounts  )
//	    {
//	        String  name    = nonBillableAccount.getName();
//	        System.out.printf( name + "\n");
//	    }
//	}
}
