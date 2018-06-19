package com.barosanu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.barosanu.app.model.AccessLevel;
import com.barosanu.app.model.Employee;
import com.barosanu.app.model.IEmployee;

public class TestEmployee {

	IEmployee employee;// Class under test

	@Before
	public void setUp() {
		employee = new Employee(1, 23, "John Doe", AccessLevel.NORMAL);
	}

	@Test
	public void testConstructor() {
		assertTrue(employee.getAccessLevel().equals(AccessLevel.NORMAL));
		assertTrue(employee.getAge() == 23);
		assertTrue(employee.getId() == 1);
		assertTrue(employee.getName() == "John Doe");
	}

}
