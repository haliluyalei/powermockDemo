package demo.mock.helloword;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.rule.PowerMockRule;

import fixture.category.Small;

@Category(Small.class)
public class testcaseHelloWorld {
	
	@Rule
	public PowerMockRule rule = new PowerMockRule(); //���@RunWith(PowerMockRunner.class)ע��
	
	//演示DAO因数据库无法连接时，测试service的逻辑
	//EmployeeServiceA ------>getTotalEmployee
	//								 |
	//							     \/
	//        EmployeeDaoA ----->getTotal(MOCK)
	@Test
	public void testDaoWithMock() {
		
	//powermock 准备
	EmployeeDaoA employeeDao = PowerMockito.mock(EmployeeDaoA.class);
	//mock掉DAO因为环境约束导致的失败
	//do..when..then
	PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
	
	//业务调用
	EmployeeServiceA service = new EmployeeServiceA(employeeDao);
	int total = service.getTotalEmployee();
	
	System.out.println(total);
	assertEquals(10, total);
	}
	

	/**
	 * 演示 测试void类型方法时 ，确认是否被调用
	 */
	@Test
	public void testUseVerify() {
	EmployeeDaoA employeeDao = PowerMockito.mock(EmployeeDaoA.class);
	EmployeeA employee = new EmployeeA();
	
	//do..when..then
	PowerMockito.doNothing().when(employeeDao).addEmployee(employee);
	EmployeeServiceA service = new EmployeeServiceA(employeeDao);
	service.createEmployee(employee);
	
	//只想确认某个函数是否被调用 用  verify
	Mockito.verify(employeeDao).addEmployee(employee);
	}

}
