package demo.mock.useMatcher;

public class EmployeeController {

	public String getEmail(final String userName) {
		EmployeeServiceG employeeService = new EmployeeServiceG();
		String email = employeeService.findEmailByUserName(userName);
		return email;
	}

}
