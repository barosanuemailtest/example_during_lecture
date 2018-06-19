package com.barosanu.controller;

import com.barosanu.app.model.AccessLevel;
import com.barosanu.model.EmployeeBean;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeManagerDesktop {

	private final ObservableList<EmployeeBean> employeeList = FXCollections.observableArrayList(
			new EmployeeBean(1, 23, "John Doe", AccessLevel.NORMAL),
			new EmployeeBean(2, 29, "Ion Popescu", AccessLevel.EXTENDED),
			new EmployeeBean(3, 18, "Gigel Minel", AccessLevel.EXTENDED),
			new EmployeeBean(5, 56, "John Dolanescu", AccessLevel.ADMIN),
			new EmployeeBean(6, 40, "John Smith", AccessLevel.NORMAL));

	public boolean addEmployee(EmployeeBean empl) {
		if (empl == null) {
			return false;
		} else if (employeeList.contains(empl)) {
			return false;
		} else {
			employeeList.add(empl);
			return true;
		}
	}

	public boolean removeEmployee(EmployeeBean empl) {
		return employeeList.remove(empl);
	}

	public ObservableList<EmployeeBean> getEmployeeList() {
		return employeeList;
	}

}
