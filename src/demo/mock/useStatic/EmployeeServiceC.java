package demo.mock.useStatic;

public class EmployeeServiceC {

	public int getEmployeeCount() {
		return EmployeeUtils.getEmployeeCount();
	}

	public void createEmployee(EmployeeC employee) {
		EmployeeUtils.persistenceEmployee(employee);
	}

}
