package com.sw.wight.tom.roomreservations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrgDao {
	private static String ORG_TABLE_NAME = "ORG_TABLE";
	private static int nextId = 1;
	Map<Integer, Org> orgs = new HashMap<Integer, Org>();
	Connection orgConnect;
	PreparedStatement orgStatement;
	
	public OrgDao() {
		System.out.println("@OrdDao()");
	}
	
	public void init() {
		 try {
		     Class.forName("org.hsqldb.jdbc.JDBCDriver" );
		 } catch (Exception e) {
		     System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
		     e.printStackTrace();
		     return;
		 }

		 try {
			 orgConnect = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void close() {
		 try {
			 Connection c = DriverManager.getConnection(
			         "jdbc:hsqldb:file:/opt/db/testdb;shutdown=true", "SA", "");		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Org create(String name, String leader) {
//	 try {
//		orgStatement = orgConnect.prepareStatement("INSERT INTO ? ? ?");
//		orgStatement.setString(1, ORG_TABLE_NAME);
//		orgStatement.setString(2,  name);
//		orgStatement.setString(3, leader);
//		orgStatement.executeUpdate();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
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
