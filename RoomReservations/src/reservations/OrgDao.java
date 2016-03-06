package reservations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrgDao {
	private static int nextId = 1;
	Map<Integer, Org> orgs = new HashMap<Integer, Org>();
	
	public OrgDao() {
		System.out.println("@OrdDao()");
	}
	
	public Org create(String name, String leader) {
		Org org = new Org(nextId++, name, leader);
		return org;
	}
	
	public void insert(Org org) {
		orgs.put(org.getId(), org);
	}
	
	public void delete(Org org) {
		if(orgs.containsKey(org.getId())) {			
			orgs.remove(org.getId());
		}
	}
	
	public Org find(int id) {
		return orgs.get(id);
	}
	
	public List<Org> findByName(String name) {
		List<Org> found = new ArrayList<Org>();
		if (name == null) {
			return found;
		}
		
		for( Org o : orgs.values()) {
			if (name.equals(o.getName())) {
				found.add(o);
			}
		}	
		
		return found;
	}
	
	public List<Org> findByLeader(String leader) {
		List<Org> found = new ArrayList<Org>();
		if (leader == null) {
			return found;
		}
		
		for( Org o : orgs.values()) {
			if (leader.equals(o.getLeader())) {
				found.add(o);
			}
		}	
		
		return found;
	}
}
