package net.fai.daems.data;

public class DummyAccessor implements DataAccessor {
	
	private static String password;

	@Override
	public String getUserPassword() {
		return password;
	}

	@Override
	public void setUserPassword(String password) {
		DummyAccessor.password = password;
	}

}
