package Object;

public class Room {
	private int roomNumber;
	private String roomState;
	
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomState() {
		return roomState;
	}
	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
}
