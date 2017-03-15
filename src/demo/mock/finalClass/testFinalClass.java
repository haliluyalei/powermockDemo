package demo.mock.finalClass;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest(EmployeeDaoE.class)
public class testFinalClass {

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void test() {
		EmployeeDaoE employeeDao = PowerMockito.mock(EmployeeDaoE.class);
		EmployeeE employee = new EmployeeE();
		PowerMockito.when(employeeDao.insertEmployee(employee)).thenReturn(true);
		
		EmployeeServiceE employeeService = new EmployeeServiceE(employeeDao);
		employeeService.createEmployee(employee);
		
		Mockito.verify(employeeDao).insertEmployee(employee);
	}

}
