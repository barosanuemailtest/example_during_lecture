package com.barosanu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barosanu.app.EmployeeManager;
import com.barosanu.app.model.AccessLevel;
import com.barosanu.app.model.Employee;

/**
 * Servlet implementation class EmployeeManagerServlet
 */
@WebServlet("/EmployeeManagerServlet")
public class EmployeeManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EmployeeManager employeeManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeManagerServlet() {
		super();

		employeeManager = new EmployeeManager();

		employeeManager.addEmployee(new Employee(1, 23, "John Doe", AccessLevel.NORMAL));
		employeeManager.addEmployee(new Employee(2, 29, "Ion Popescu", AccessLevel.EXTENDED));
		employeeManager.addEmployee(new Employee(3, 18, "Gigel Minel", AccessLevel.EXTENDED));
		employeeManager.addEmployee(new Employee(5, 56, "John Dolanescu", AccessLevel.ADMIN));
		employeeManager.addEmployee(new Employee(6, 40, "John Smith", AccessLevel.NORMAL));
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ID = Integer.parseInt(request.getParameter("id"));
		int Age = Integer.parseInt(request.getParameter("age"));
		String Name = request.getParameter("name");
		AccessLevel acc = determineAccessLeve(request.getParameter("access"));

		employeeManager.addEmployee(new Employee(ID, Age, Name, acc));

		// Print employeess:
		PrintWriter writer = response.getWriter();
		for (Employee empl : employeeManager.getAllEmployess()) {
			writer.println(empl + "<br>");
		}
		writer.close();

	}

	private AccessLevel determineAccessLeve(String acc) {
		if (acc.equals("EXTENDED")) {
			return AccessLevel.EXTENDED;
		} else if (acc.equals("ADMIN")) {
			return AccessLevel.ADMIN;
		} else {
			return AccessLevel.NORMAL;
		}
	}

}
