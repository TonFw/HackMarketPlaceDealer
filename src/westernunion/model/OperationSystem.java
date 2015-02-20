package westernunion.model;

public class OperationSystem {
	public String name;
	public String account;
	
	public OperationSystem() {
		this.name = this.name();
		this.account = this.account();
	}
	
	private String name() {
		return System.getProperty("os.name");
	}
	
	private String account() {
		return System.getProperty("user.name");
	}
}
