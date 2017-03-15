package demo.mock.mockConstructors;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import demo.mock.mockConstructors.EmployeeDaoF.Dialect;
import fixture.category.Small;

@Category(Small.class)
@PrepareForTest(EmployeeServiceF.class)
public class testConstructor {

	// 测试的重点是看看如何构造出来 EmployeeDao，而不再关注其中方法的调用

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void test() {
		EmployeeDaoF employeeDao = PowerMockito.mock(EmployeeDaoF.class);// (1)
		try {
			//当碰到 new 这个关键字时，返回 某个被 Mock 的对象而不是让真的 new 行为发生
			PowerMockito.whenNew(EmployeeDaoF.class).withArguments(false, Dialect.MYSQL).thenReturn(employeeDao);// (2)
			
			EmployeeServiceF employeeService = new EmployeeServiceF();
			EmployeeF employee = new EmployeeF();
			employeeService.createEmployee(employee);
			
			Mockito.verify(employeeDao).insertEmploye(employee);// (3)
		} catch (Exception e) {
			fail();
		}
	}

}
