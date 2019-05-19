package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.PersonalName;

/**
* Class to store Client Account information.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-19 
*/
public class ClientAccount implements Account{
	

	/**
     * Name of the client
     */
	private final String name;
	
	/**
     * Contact person for this client.
     */
	PersonalName contact;
	
	/**
     * Client's address
     */
	Address address;
	
	/**
	 * ClientAccount constructor reprgetNameesenting Client Account detail.  
	 * @param name.
     * @param contact.
     * @param address. 
	 */
	public ClientAccount( String name, PersonalName contact, Address address ) {
		this.name = name;
		this.contact = contact;
		this.address = address;
	}

	/**
	 * Setter for contact name.
	 * @param contact.
	 */
	public void setContact( PersonalName contact ) {
		this.contact = contact;
	}
	
	/**
	 * Returns contact name.
	 * @return contact
	 */
	public PersonalName getContact() {
		return contact;
	}
	
	/**
	 * Setter for address.
	 * @param address.
	 */
	public void setAddress( Address address ) {
		this.address = address;
	}
	
	/**toString()
	 * Returns Address.
	 * @return Address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Returns client account name.
	 * @return name
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isBillable() {
		return true;
	}
	
	@Override
	public boolean equals( Object obj ) {
		boolean rcode   = false;
        if ( obj == null )
            rcode = false;
        else if ( this == obj )
            rcode = true;
        else if ( !(obj instanceof ClientAccount ) )
            rcode = false;
        else
        {
            ClientAccount   that    = (ClientAccount)obj;
            rcode = this.contact.equals( that.contact )
                    && this.name.equals( that.name )
                    && this.address.equals( that.address );
        }
        
        return rcode;
	}
	
	
	@Override
	public int hashCode() {
//		Overrides Object.hashCode. This override is required because the class overrides Object.equals.
		int result = name.hashCode();
		
		return result;
	}
	
	/**
	 * Returns client name.
	 * @return name
	 */
	@Override
	public String toString() {
//		Overrides Object.toString. Returns the client name
		return String.format("%s%n%s%n%s%n", name, address.toString(), contact.toString());
	}
	
//	//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		StateCode state = StateCode.WA;
//		PersonalName contact = new PersonalName("First","Last","Middle"); 
//		Address address = new Address("apple Mock Lane","bell", state,"98204");
//		ClientAccount pName = new ClientAccount("Test", contact, address);
//		System.out.println(pName.toString());
//	}
}
