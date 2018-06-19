package com.barosanu.app.model;

public class Employee implements IEmployee {

	private int id;
	private int age;
	private String name;
	private AccessLevel accessLevel;

	public Employee(int id, int age, String name, AccessLevel accessLevel) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.accessLevel = accessLevel;
	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", age=" + age + ", name=" + name + ", accessLevel=" + accessLevel + "]";

	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;

	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#getAge()
	 */
	@Override
	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + age;

		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (accessLevel != other.accessLevel)
			return false;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#setAge(int)
	 */
	@Override
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#getAccessLevel()
	 */
	@Override
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	/* (non-Javadoc)
	 * @see com.barosanu.app.model.IEmployee#setAccessLevel(com.barosanu.app.model.AccessLevel)
	 */
	@Override
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

}
