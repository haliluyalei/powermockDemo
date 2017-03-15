package demo.mock.finalClass;

public class EmployeeServiceE {

	private EmployeeDaoE employeeDao;

	public EmployeeServiceE(EmployeeDaoE employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void createEmployee(EmployeeE employee) {
		employeeDao.insertEmployee(employee);
	}

}
