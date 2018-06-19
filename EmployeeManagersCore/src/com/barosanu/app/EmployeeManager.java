package com.barosanu.app;

import java.util.ArrayList;
import java.util.List;

import com.barosanu.app.model.AccessLevel;
import com.barosanu.app.model.Employee;
import com.barosanu.app.model.IEmployee;

/**
 * @author jupan
 */
public class EmployeeManager {

	protected List<Employee> employeeList = new ArrayList<Employee>();

	public boolean addEmployee(Employee empl) {
		if (empl == null) {
			return false;
		} else if (employeeList.contains(empl)) {
			return false;
		} else {
			employeeList.add(empl);
			return true;
		}
	}

	public boolean removeEmployee(IEmployee empl) {
		if (empl == null) {
			return false;
		} else if (!employeeList.contains(empl)) {
			return false;
		} else {
			employeeList.remove(empl);
			return true;
		}
	}

	public List<IEmployee> getAllAdminLevel() {
		return getEmployessByLevel(AccessLevel.ADMIN);
	}

	public List<IEmployee> getAllExtendedLevel() {
		return getEmployessByLevel(AccessLevel.EXTENDED);
	}

	public List<IEmployee> getAllNormalLevel() {
		return getEmployessByLevel(AccessLevel.NORMAL);
	}

	public boolean setAccessLevelOnEmployee(AccessLevel acc, IEmployee empl) {
		if (empl == null) {
			return false;
		} else if (empl.getAccessLevel().equals(acc)) {
			return false;
		} else {
			empl.setAccessLevel(acc);
			return true;
		}
	}

	private List<IEmployee> getEmployessByLevel(AccessLevel acc) {
		List<IEmployee> admins = new ArrayList<IEmployee>();
		for (IEmployee empl : employeeList) {
			if (empl.getAccessLevel().equals(acc)) {
				admins.add(empl);
			}
		}
		return admins;
	}

	public List<Employee> getAllEmployess() {
		return employeeList;
	}

}
