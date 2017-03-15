package demo.mock.useSpies;

public class EmployeeServiceH {

	public void saveEmployee(EmployeeH employee) {
		System.out.println("this is true saveEmployee method.");
		if (employee.isNew()) {
			createEmployee(employee);
			return;
		}
		employee.update();
	}

	
	//这个方法需要被mock， 真正执行必然抛出异常
	void createEmployee(EmployeeH employee) {
		System.out.println("this is true createEmployee method.");
		employee.setEmployeeId(111);
		employee.create();
		
		throw new UnsupportedOperationException();
	}

}
