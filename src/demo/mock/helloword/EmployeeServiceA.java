package demo.mock.helloword;

public class EmployeeServiceA {
	
	private EmployeeDaoA employeeDao;
	public EmployeeServiceA(EmployeeDaoA employeeDao)
	{
	this.employeeDao = employeeDao;
	}
	
	public int getTotalEmployee()
	{
	return employeeDao.getTotal();
	}
	
	public void createEmployee(EmployeeA employee)
	{
	employeeDao.addEmployee(employee);
	}

}
