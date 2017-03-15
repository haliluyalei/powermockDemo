package demo.mock.useMatcher;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest(EmployeeController.class)
public class testAnswer {

	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void testGetEmail() {
		EmployeeServiceG employeeService = PowerMockito.mock(EmployeeServiceG.class);
		//使用Answer 来处理when ..then..模式 ，丰富了then的逻辑
		PowerMockito.when(employeeService.findEmailByUserName(Mockito.anyString())).then(new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				String argument = (String) invocation.getArguments()[0];
				if ("wangwenjun".equals(argument))
					return "wangwenjun@gmail.com";
				else if ("liudehua".equals(argument))
					return "andy@gmail.com";
				throw new NullPointerException();
			}
		});
		try {
			PowerMockito.whenNew(EmployeeServiceG.class).withNoArguments().thenReturn(employeeService);
			EmployeeController controller = new EmployeeController();
			
			String email = controller.getEmail("wangwenjun");
			assertEquals("wangwenjun@gmail.com", email);
			
			email = controller.getEmail("liudehua");
			assertEquals("andy@gmail.com", email);
			
			email = controller.getEmail("JackChen");
			fail("should not process to here.");
		} catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
		}
	}

}
