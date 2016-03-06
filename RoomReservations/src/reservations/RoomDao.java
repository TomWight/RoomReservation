package reservations;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDao {
	private static int nextId = 1;
	Map<Integer, Room> rooms = new HashMap<Integer, Room>();
	
	public RoomDao() {
		System.out.println("@RoomDao()");
	}
	
	public Room create(String name, int occupancyLimit) {
		Room room = new Room(nextId++, name, occupancyLimit);
		return room;
	}
	
	public void insert(Room room) {
		rooms.put(room.getId(), room);
	}
	
	public void delete(Room room) {
		if(rooms.containsKey(room.getId())) {			
			rooms.remove(room.getId());
		}
	}
	
	public Room find(int id) {
		return rooms.get(id);
	}
	
	public List<Room> findByName(String name) {
		List<Room> found = new ArrayList<Room>();
		if (name == null) {
			return found;
		}
		
		for( Room room : rooms.values()) {
			if (name.equals(room.getName())) {
				found.add(room);
			}
		}	
		
		return found;
	}
	
	public List<Room> findByOccupancyLimit(int duration) {
		List<Room> found = new ArrayList<Room>();
		
		for( Room room : rooms.values()) {
			if (duration == room.getOccupancyLimit()) {
				found.add(room);
			}
		}	
		
		return found;
	}
}
