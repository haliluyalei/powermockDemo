package demo.mock.localVariable;

public class EmployeeDaoB {
	
	public int getTotal()
	{
		//这里抛出异常 是模拟各种实际中缺少环境依赖所以失败的场景
		throw new UnsupportedOperationException();
	}

}
