package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import reservations.Org;
import reservations.OrgDao;

public class OrgDaoTest {
	OrgDao testDao;
	Org testOrg;

	@Before
	public void setUp() {
		testDao = new OrgDao();
		testDao.init();
	}

	@Test
	public void testCreate() {
		Org o = testDao.create("testName", "testLeader");
		assertEquals("testName", o.getName());
		assertEquals("testLeader", o.getLeader());
	}

	@Test
	public void testInsert() {
		Org o1 = testDao.create("testName", "testLeader");
		testDao.insert(o1);
		Org o2 = testDao.find(o1.getId());
		assertEquals(o1, o2);
	}

	@Test
	public void testDelete() {
		Org o1 = testDao.create("testName", "testLeader");
		testDao.insert(o1);
		testDao.delete(o1);
		Org o2 = testDao.find(o1.getId());
		assertNull(o2);
	}

	@Test
	public void testFind() {
		Org o1 = testDao.create("testName", "testLeader");
		testDao.insert(o1);
		Org o2 = testDao.find(o1.getId());
		assertEquals(o1, o2);
		
		o2 = testDao.find(-1);
		assertNull(o2);
	}

	@Test
	public void testFindByName() {
		Org o1 = testDao.create("testName", "testLeader");
		testDao.insert(o1);
		List<Org> orgs = testDao.findByName(o1.getName());
		assertEquals(1, orgs.size());
		Org o2 = orgs.get(0);
		assertEquals("testName", o2.getName());
		
		orgs = testDao.findByName("illegal name");
		assertEquals(0, orgs.size());
	}

	@Test
	public void testFindByLeader() {
		Org o1 = testDao.create("testName", "testLeader");
		testDao.insert(o1);
		
		List<Org> orgs = testDao.findByLeader(o1.getLeader());
		assertEquals(1, orgs.size());
		Org o2 = orgs.get(0);
		assertEquals("testLeader", o2.getLeader());
		
		orgs = testDao.findByLeader("not there");
		assertEquals(0, orgs.size());
	}
}
