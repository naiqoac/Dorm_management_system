package Object;

public class Admin {
	private String adminAccount;
	private String adminPassword;
	private String adminName;
	public Admin() {}
	public Admin(String adminAccount, String adminPassword) {
		this.adminAccount=adminAccount;
		this.adminPassword=adminPassword;
	}
	
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
