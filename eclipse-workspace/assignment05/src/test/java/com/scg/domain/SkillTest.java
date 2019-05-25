package com.scg.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkillTest {

	@Test
	void testGetRate() {
		int rateValid =250;
		int rateInValid =25;
		Boolean validRate = false;
		Boolean inValidRate = false;
		
		String  descValid="Project Manager";
		String  descInValid="Artist Manager";
		Boolean validDesc= false;
		Boolean inValidDesc= false;
		Skill[] skills    = Skill.values();
		for(Skill skill : skills) {
			if(skill.getRate()==rateValid) {
				validRate = true;
			}
			if(skill.getRate()==rateInValid) {
				inValidRate = true;
			}
			if(skill.toString()==descValid) {
				validDesc = true;
			}
			if(skill.toString()==descInValid) {
				inValidDesc = true;
			}
		}
		assertTrue(validRate);
		assertFalse(inValidRate);
		assertTrue(validDesc);
		assertFalse(inValidDesc);
	}

}
