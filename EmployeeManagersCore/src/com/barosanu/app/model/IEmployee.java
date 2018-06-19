package com.barosanu.app.model;

public interface IEmployee {

	int getId();

	void setId(int id);

	int getAge();

	void setAge(int age);

	String getName();

	void setName(String name);

	AccessLevel getAccessLevel();

	void setAccessLevel(AccessLevel accessLevel);

}