package com.sw.wight.tom.roomreservations;

import java.time.LocalDateTime;

public class Meeting {
	private int id;
	private int orgId;
	private int roomId;
	private String name;
	private LocalDateTime dateTime; 
	private int duration; // meeting length in minutes

	public Meeting(int id, int orgId, int roomId, String name, LocalDateTime dateTime, int duration) {
		this.id = id;
		this.orgId = orgId;
		this.roomId = roomId;
		this.name = name;
		this.dateTime = dateTime;
		this.duration = duration;
	}
	
	public int getId() {
		return id;
	}

	public int getOrgId() {
		return orgId;
	}

	public int getRoomId() {
		return roomId;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + duration;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + orgId;
		result = prime * result + roomId;
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
		Meeting other = (Meeting) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (duration != other.duration)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orgId != other.orgId)
			return false;
		if (roomId != other.roomId)
			return false;
		return true;
	}
}
