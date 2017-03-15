package demo.mock.mockConstructors;

import demo.mock.mockConstructors.EmployeeDaoF.Dialect;

public class EmployeeServiceF {

	public void createEmployee(final EmployeeF employee) {
		EmployeeDaoF employeeDao = new EmployeeDaoF(false, Dialect.MYSQL);
		employeeDao.insertEmploye(employee);
	}

}
