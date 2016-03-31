package com.sw.wight.tom.roomreservations;

public class Org {
	private int id;
	private String name;
	private String leader;
	
	Org(int id, String name, String leader) {
		this.id = id;
		this.name = name;
		this.leader = leader;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLeader() {
		return leader;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Org other = (Org) obj;
		if (id != other.id)
			return false;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
