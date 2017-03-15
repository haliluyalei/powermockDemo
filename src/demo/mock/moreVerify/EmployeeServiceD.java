package demo.mock.moreVerify;

public class EmployeeServiceD {

	public void saveOrUpdate(EmployeeD employee) {
		final EmployeeDaoD employeeDao = new EmployeeDaoD();
		long count = employeeDao.getCount(employee);
		if (count > 0)
			employeeDao.updateEmployee(employee);
		else
			employeeDao.saveEmployee(employee);
	}

}
