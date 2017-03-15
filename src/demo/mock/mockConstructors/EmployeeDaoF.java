package demo.mock.mockConstructors;

public class EmployeeDaoF {

	public enum Dialect {
		MYSQL, ORACLE
	}

	public EmployeeDaoF(boolean lazy, Dialect dialect) {
		throw new UnsupportedOperationException();
	}

	public void insertEmploye(EmployeeF employee) {
		throw new UnsupportedOperationException();
	}

}
