package demo.mock.useMatcher;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.rule.PowerMockRule;

public class testMatcher {

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void testGetEmail() {
		EmployeeServiceG employeeService = PowerMockito.mock(EmployeeServiceG.class);
		
		
//		实现一个匿名 ArgumentMatcher 类，
//		然后就实现了根据不同参数获得不同的返回结果预期，这样我们就可以少些很多
//		when...then..Return 模式
		//丰富了when 的逻辑
		PowerMockito.when(employeeService.findEmailByUserName(Mockito.argThat(new ArgumentMatcher<String>() {
			@Override
			public boolean matches(Object argument) {
				String arg = (String) argument;
				if (arg.startsWith("wangwenjun") || arg.startsWith("wwj"))
					return true;
				else
					throw new RuntimeException();
			}
		}))).thenReturn("wangwenjun@gmail.com");
		try {
			//与上面的
			PowerMockito.whenNew(EmployeeServiceG.class).withAnyArguments().thenReturn(employeeService);
			EmployeeController controller = new EmployeeController();
			
			String email = controller.getEmail("wangwnejun");
			assertEquals("wangwenjun@gmail.com", email);
			
			controller.getEmail("liudehua");
			fail("should not process to here.");
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
		}
	}

}
