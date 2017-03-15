package demo.mock.moreVerify;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import fixture.category.Small;

@Category(Small.class)
@PrepareForTest(EmployeeServiceD.class)
public class testMoreVerify {

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void testSaveOrUpdateCountLessZero() {
		try {
			EmployeeDaoD employeeDao = PowerMockito.mock(EmployeeDaoD.class);
			PowerMockito.whenNew(EmployeeDaoD.class).withNoArguments().thenReturn(employeeDao);
			
			EmployeeD employee = new EmployeeD();
			PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
			EmployeeServiceD employeeService = new EmployeeServiceD();
			employeeService.saveOrUpdate(employee);
			
			//more Verify
			Mockito.verify(employeeDao).saveEmployee(employee);
			Mockito.verify(employeeDao, Mockito.never()).updateEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSaveOrUpdateCountMoreThanZero() {
		EmployeeDaoD employeeDao = PowerMockito.mock(EmployeeDaoD.class);
		try {
			PowerMockito.whenNew(EmployeeDaoD.class).withNoArguments().thenReturn(employeeDao);
			EmployeeD employee = new EmployeeD();
			PowerMockito.when(employeeDao.getCount(employee)).thenReturn(1L);
			
			EmployeeServiceD employeeService = new EmployeeServiceD();
			employeeService.saveOrUpdate(employee);
			
			//more Verify
			Mockito.verify(employeeDao).updateEmployee(employee);
			Mockito.verify(employeeDao, Mockito.never()).saveEmployee(employee);
		} catch (Exception e) {
			fail();
		}
	}

}
