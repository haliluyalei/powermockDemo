package demo.mock.localVariable;

public class EmployeeServiceB {
	

	public int getTotalEmployee()
	{
		
	//没有采用 hello world 中通过构造方法注入 dao 的方式，而是在方法内部 new出一个 EmployeeDao
	EmployeeDaoB employeeDao = new EmployeeDaoB();
	return employeeDao.getTotal();
	
	}

}
