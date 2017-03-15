package demo.mock.useSpies;

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
@PrepareForTest(EmployeeServiceH.class)
public class testSpies {
	
	@Rule
	public PowerMockRule rule = new PowerMockRule(); //���@RunWith(PowerMockRunner.class)ע��

	@Test
	public void testDaoWithMock() throws Exception {
		
		//in this case we want to invoke the real  EmployeeService.
		//saveEmployee method but mock the  EmployeeService.createEmployee
		// 也就是 我们要对一个对象部分mock ，没有mock的部分仍然展现源代码的逻辑真实的运行。
		//PowerMockito.spy(new xxxxclass()) 
		final EmployeeServiceH spy = PowerMockito.spy(new EmployeeServiceH());
		
		
		final EmployeeH employeeMock = PowerMockito.mock(EmployeeH.class);
		System.out.println("this is fake1 createEmployee method.");
		PowerMockito.when(employeeMock.isNew()).thenReturn(true);
		System.out.println("this is fake2 createEmployee method.");
				
		//TODO  如果代碼前面不增加@PrepareForTest(EmployeeServiceH.class) 会报错  org.mockito.exceptions.misusing.UnfinishedStubbingException
		PowerMockito.doNothing().when(spy).createEmployee(employeeMock);
		System.out.println("this is fake3 createEmployee method.");
		
		spy.saveEmployee(employeeMock);
		System.out.println("this is fake4 createEmployee method.");
		
		//Verification is simple enough and
		//we have to use the standard syntax for it.
		Mockito.verify(spy).createEmployee(employeeMock);
	}
	

	

}
