package Object;


public class Guest {
	private String ID;
	private String name;
	public Guest() {}
	public Guest(String iD, String name) {
		ID = iD;
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
