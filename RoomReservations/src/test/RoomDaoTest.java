package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import reservations.Room;
import reservations.RoomDao;

public class RoomDaoTest {
	RoomDao testDao;

	@Before
	public void setUp() {
		testDao = new RoomDao();
	}

	@Test
	public void testCreate() {
		Room o = testDao.create("testName", 8);
		assertEquals("testName", o.getName());
		assertEquals(8, o.getOccupancyLimit());
	}

	@Test
	public void testInsert() {
		Room o1 = testDao.create("testName", 9);
		testDao.insert(o1);
		Room o2 = testDao.find(o1.getId());
		assertEquals(o1, o2);
	}

	@Test
	public void testDelete() {
		Room o1 = testDao.create("testName", 10);
		testDao.insert(o1);
		testDao.delete(o1);
		Room o2 = testDao.find(o1.getId());
		assertNull(o2);
	}

	@Test
	public void testFind() {
		Room o1 = testDao.create("testName", 11);
		testDao.insert(o1);
		Room o2 = testDao.find(o1.getId());
		assertEquals(o1, o2);
		
		o2 = testDao.find(-1);
		assertNull(o2);
	}

	@Test
	public void testFindByName() {
		Room o1 = testDao.create("testName", 12);
		testDao.insert(o1);
		List<Room> orgs = testDao.findByName(o1.getName());
		assertEquals(1, orgs.size());
		Room o2 = orgs.get(0);
		assertEquals("testName", o2.getName());
		
		orgs = testDao.findByName("illegal name");
		assertEquals(0, orgs.size());
	}

	@Test
	public void testFindByOccupancyLimit() {
		Room o1 = testDao.create("testName", 13);
		testDao.insert(o1);
		
		List<Room> orgs = testDao.findByOccupancyLimit(o1.getOccupancyLimit());
		assertEquals(1, orgs.size());
		Room o2 = orgs.get(0);
		assertEquals(13, o2.getOccupancyLimit());
		
		orgs = testDao.findByOccupancyLimit(0);
		assertEquals(0, orgs.size());
	}
}

