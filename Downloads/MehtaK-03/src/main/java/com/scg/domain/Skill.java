package com.scg.domain;

/**
* Enum to store Skills.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public enum Skill {
	PROJECT_MANAGER("Project Manager", 250),
	SYSTEM_ARCHITECT("System Architect", 200),
	SOFTWARE_ENGINEER("Software Engineer", 150),
	SOFTWARE_TESTER("Software Tester", 100),
	UNKNOWN_SKILL("Unknown Skill", 0);
	
	private String description;
	private int rate;
	
	private Skill( String description, int rate ) {
		this.description = description;
		this.rate = rate;
	}
	
	public int getRate() {
		return rate;
	}
	
	public String toString() {
		return description;
	}
	//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		Skill[] skills    = Skill.values();
//	    for ( Skill skill : skills  )
//	    {
//	        int  name    = skill.getRate();
//			String  description    = skill.toString();
//	        System.out.printf( name + " " + description + "\n");
//	    }
//	}
}
