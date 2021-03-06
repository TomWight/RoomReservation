package com.sw.wight.tom.roomreservations;

public class Room {
	private int id;
	private String name;
	private int occupancyLimit;
	
	public Room(int id, String name, int occupancyLimit) {
		this.id = id;
		this.name = name;
		this.occupancyLimit = occupancyLimit;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getOccupancyLimit() {
		return occupancyLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + occupancyLimit;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (occupancyLimit != other.occupancyLimit)
			return false;
		return true;
	}
}
