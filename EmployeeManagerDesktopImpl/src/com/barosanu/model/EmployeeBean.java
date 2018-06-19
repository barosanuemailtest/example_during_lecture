package com.barosanu.model;

import com.barosanu.app.model.AccessLevel;
import com.barosanu.app.model.IEmployee;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeBean implements IEmployee {

	private final SimpleIntegerProperty id = new SimpleIntegerProperty();
	private final SimpleIntegerProperty age = new SimpleIntegerProperty();
	private final SimpleStringProperty name = new SimpleStringProperty();
	private final SimpleObjectProperty<AccessLevel> accessLevel = new SimpleObjectProperty<AccessLevel>();

	public EmployeeBean(int Id, int Age, String Name, AccessLevel acc) {
		setId(Id);
		setAge(Age);
		setName(Name);
		setAccessLevel(acc);
	}

	public int getId() {
		return id.get();
	}

	public void setId(int value) {
		this.id.set(value);
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int Age) {
		this.age.set(Age);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String Name) {
		this.name.set(Name);
	}

	public AccessLevel getAccessLevel() {
		return accessLevel.get();
	}

	public void setAccessLevel(AccessLevel acc) {
		this.accessLevel.set(acc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBean other = (EmployeeBean) obj;
		if (accessLevel.get() != other.getAccessLevel())
			return false;
		if (age.get() != other.getAge())
			return false;
		if (id.get() != other.getId())
			return false;
		if (name.get() == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.get().equals(other.getName()))
			return false;
		return true;
	}

}
