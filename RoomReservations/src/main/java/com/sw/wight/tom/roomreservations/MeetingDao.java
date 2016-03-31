package com.sw.wight.tom.roomreservations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingDao {
	private static int nextId = 1;
	Map<Integer, Meeting> meetings = new HashMap<Integer, Meeting>();
	
	public MeetingDao() {
		System.out.println("@MeetingDao()");
	}
	
	public Meeting create(int org_id, int room_id, String name, LocalDateTime dateTime, int duration) {
		Meeting meeting = new Meeting(nextId++, org_id, room_id, name, dateTime, duration);
		return meeting;
	}
	
	public void insert(Meeting meeting) {
		meetings.put(meeting.getId(), meeting);
	}
	
	public void delete(Meeting meeting) {
		if(meetings.containsKey(meeting.getId())) {			
			meetings.remove(meeting.getId());
		}
	}
	
	public Meeting find(int id) {
		return meetings.get(id);
	}
	
	public List<Meeting> findByOrgId(int orgId) {
		List<Meeting> found = new ArrayList<Meeting>();
		
		for( Meeting meeting : meetings.values()) {
			if (orgId == meeting.getOrgId()) {
				found.add(meeting);
			}
		}	
		
		return found;
	}
	
	public List<Meeting> findByRoomId(int roomId) {
		List<Meeting> found = new ArrayList<Meeting>();
		
		for( Meeting meeting : meetings.values()) {
			if (roomId == meeting.getRoomId()) {
				found.add(meeting);
			}
		}	
		
		return found;
	}
		
	public List<Meeting> findByName(String name) {
		List<Meeting> found = new ArrayList<Meeting>();
		if (name == null) {
			return found;
		}
		
		for( Meeting meeting : meetings.values()) {
			if (name.equals(meeting.getName())) {
				found.add(meeting);
			}
		}	
		
		return found;
	}
	
	public List<Meeting> findByDateTime(LocalDateTime dateTime) {
		List<Meeting> found = new ArrayList<Meeting>();
		if (dateTime == null) {
			return found;
		}
		
		for( Meeting meeting : meetings.values()) {
			if (dateTime.equals(meeting.getDateTime())) {
				found.add(meeting);
			}
		}	
		
		return found;
	}	
	
	public List<Meeting> findByDuration(int duration) {
		List<Meeting> found = new ArrayList<Meeting>();
		
		for( Meeting meeting : meetings.values()) {
			if (duration == meeting.getDuration()) {
				found.add(meeting);
			}
		}	
		
		return found;
	}
}
