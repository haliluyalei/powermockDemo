package demo.mock.localVariable;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;


//告诉PowerMock为我提前准备一个xxx的class
@PrepareForTest(EmployeeServiceB.class)
public class testLocalVariable {
	
	@Rule
	public PowerMockRule rule = new PowerMockRule(); 
	
	@Test
	public void test()
	{
		int total =1;
	EmployeeDaoB employeeDao = PowerMockito.mock(EmployeeDaoB.class);
		try {
			System.out.println(total);
		//do..when ..then
		PowerMockito.whenNew(EmployeeDaoB.class).withNoArguments().thenReturn(employeeDao);
		PowerMockito.when(employeeDao.getTotal()).thenReturn(10);

		EmployeeServiceB service = new EmployeeServiceB();		
		total = service.getTotalEmployee();

		assertEquals(10, total);
		} catch (Exception e) {
			System.out.println(total);
			fail("测试失败.");
		}
	}
}
