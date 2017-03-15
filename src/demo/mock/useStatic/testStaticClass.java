package demo.mock.useStatic;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import fixture.category.Small;

@Category(Small.class)
@PrepareForTest(EmployeeUtils.class)
public class testStaticClass {

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void testGetEmployeeCountWithMock() {
		// mockStatic
		PowerMockito.mockStatic(EmployeeUtils.class);
		PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
		final EmployeeServiceC employeeService = new EmployeeServiceC();

		int count = employeeService.getEmployeeCount();
		assertEquals(10, count);
	}

	@Test
	public void testCreateEmployeeWithMock() {
		// mockStatic
		PowerMockito.mockStatic(EmployeeUtils.class);
		EmployeeC employee = new EmployeeC();
		PowerMockito.doNothing().when(EmployeeUtils.class);

		final EmployeeServiceC employeeService = new EmployeeServiceC();
		employeeService.createEmployee(employee);
		PowerMockito.verifyStatic();
	}
}
