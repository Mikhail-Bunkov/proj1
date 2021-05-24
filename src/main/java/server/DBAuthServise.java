package server;

public class DBAuthServise implements AuthServise {
	@Override
	public boolean creatingNewClient(String first_name, String last_name, String passport) {
		return DBHandler.creatingNewClient(first_name, last_name, passport);
	}
}
