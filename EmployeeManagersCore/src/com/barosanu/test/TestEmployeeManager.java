package com.barosanu.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.barosanu.app.EmployeeManager;
import com.barosanu.app.model.AccessLevel;
import com.barosanu.app.model.Employee;
import com.barosanu.app.model.IEmployee;

public class TestEmployeeManager {

	public EmployeeManager employeeManager;// Class under test

	@Before
	public void setUp() {
		employeeManager = new EmployeeManager();

		employeeManager.addEmployee(new Employee(1, 23, "John Doe", AccessLevel.NORMAL));
		employeeManager.addEmployee(new Employee(2, 29, "Ion Popescu", AccessLevel.EXTENDED));
		employeeManager.addEmployee(new Employee(3, 18, "Gigel Minel", AccessLevel.EXTENDED));
		employeeManager.addEmployee(new Employee(5, 56, "John Dolanescu", AccessLevel.ADMIN));
		employeeManager.addEmployee(new Employee(6, 40, "John Smith", AccessLevel.NORMAL));

		for (int i = 1; i < 10000; i++) {
			employeeManager.addEmployee(new Employee(i, 40, "John Smith", AccessLevel.NORMAL));
		}
	}

	@Test
	public void testAddEmployee() {
		assertFalse(employeeManager.addEmployee(null));

		Employee empl = new Employee(7, 25, "Vasile Vladutz", AccessLevel.NORMAL);
		assertTrue(employeeManager.addEmployee(empl));
		assertFalse(employeeManager.addEmployee(empl));
	}

	@Test
	public void testRemoveEmployee() {
		assertFalse(employeeManager.removeEmployee(null));

		Employee empl = new Employee(7, 25, "Vasile Vladutz", AccessLevel.NORMAL);
		employeeManager.addEmployee(empl);
		assertTrue(employeeManager.removeEmployee(empl));
		assertFalse(employeeManager.removeEmployee(empl));
	}

	@Test
	public void testGetAllAdminLevel() {
		List<IEmployee> admin = employeeManager.getAllAdminLevel();
		for (IEmployee empl : admin) {
			assertTrue(empl.getAccessLevel().equals(AccessLevel.ADMIN));
		}
	}

	@Test
	public void testGetAllExtendedLevel() {
		List<IEmployee> extended = employeeManager.getAllExtendedLevel();
		for (IEmployee empl : extended) {
			assertTrue(empl.getAccessLevel().equals(AccessLevel.EXTENDED));
		}
	}

	@Test
	public void testGetAllNormalLevel() {
		List<IEmployee> normal = employeeManager.getAllNormalLevel();
		for (IEmployee empl : normal) {
			assertTrue(empl.getAccessLevel().equals(AccessLevel.NORMAL));
		}
	}

}
