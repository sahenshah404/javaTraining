package com.medplus.employee.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArithmeticTest {

	Arithmetic arth = new Arithmetic();
	
	@Test
	public void testAdd() {
		assertEquals(10, arth.add(5, 5));
	}
	@Test
	public void testSub() {
		assertEquals(10, arth.sub(15, 5));
	}

}
