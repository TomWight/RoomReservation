package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import reservations.Meeting;
import reservations.MeetingDao;

public class MeetingDaoTest {
	MeetingDao testDao;
	Meeting testOrg;

	@Before
	public void setUp() {
		testDao = new MeetingDao();
	}
	@Test
	public void testCreate() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting o = testDao.create(1, 2, "testName", dateTime, 30);
		
		assertEquals(1, o.getOrgId());
		assertEquals(2, o.getRoomId());
		assertEquals("testName", o.getName());
		assertEquals(dateTime, o.getDateTime());
		assertEquals(30, o.getDuration());
	}

	@Test
	public void testInsert() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(1, 2, "testName", dateTime, 30);		
		testDao.insert(m1);
		
		Meeting m2 = testDao.find(m1.getId());
		assertEquals(m1, m2);
	}

	@Test
	public void testDelete() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(1, 2, "testName", dateTime, 30);		
		testDao.insert(m1);
		testDao.delete(m1);
		
		Meeting m2 = testDao.find(m1.getId());
		assertNull(m2);
	}

	@Test
	public void testFind() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(1, 2, "testName", dateTime, 30);		
		testDao.insert(m1);
		
		Meeting m2 = testDao.find(m1.getId());
		assertEquals(m1, m2);
		
		m2 = testDao.find(-1);
		assertNull(m2);
	}
	
	@Test
	public void testFindByOrgId() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(3, 4, "testName", dateTime, 30);		
		testDao.insert(m1);
		
		List<Meeting> meetings = testDao.findByOrgId(m1.getOrgId());
		assertEquals(1, meetings.size());
		
		Meeting m2 = meetings.get(0);
		assertEquals(3, m2.getOrgId());
		
		meetings = testDao.findByOrgId(0);
		assertEquals(0, meetings.size());
	}

	@Test
	public void testFindByRoomId() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(5, 6, "testName", dateTime, 30);		
		testDao.insert(m1);
		
		List<Meeting> meetings = testDao.findByRoomId(m1.getRoomId());
		assertEquals(1, meetings.size());
		
		Meeting m2 = meetings.get(0);
		assertEquals(6, m2.getRoomId());
		
		meetings = testDao.findByRoomId(0);
		assertEquals(0, meetings.size());
	}

	@Test
	public void testFindByName() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(7, 8, "testName", dateTime, 30);		
		testDao.insert(m1);
		
		List<Meeting> meetings = testDao.findByName(m1.getName());
		assertEquals(1, meetings.size());
		
		Meeting m2 = meetings.get(0);
		assertEquals("testName", m2.getName());
		
		meetings = testDao.findByName("illegal name");
		assertEquals(0, meetings.size());
	}

	@Test
	public void testFindByDateTime() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(9, 10, "testName", dateTime, 30);		
		testDao.insert(m1);
		
		List<Meeting> meetings = testDao.findByDateTime(m1.getDateTime());
		assertEquals(1, meetings.size());
		
		Meeting m2 = meetings.get(0);
		assertEquals(dateTime, m2.getDateTime());
		
		meetings = testDao.findByDateTime(LocalDateTime.now());
		assertEquals(0, meetings.size());
	}

	@Test
	public void testFindByDuration() {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 4);
		LocalTime time = LocalTime.of(6, 6);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Meeting m1 = testDao.create(5, 6, "testName", dateTime, 90);		
		testDao.insert(m1);
		
		List<Meeting> meetings = testDao.findByDuration(m1.getDuration());
		assertEquals(1, meetings.size());
		
		Meeting m2 = meetings.get(0);
		assertEquals(90, m2.getDuration());
		
		meetings = testDao.findByDuration(0);
		assertEquals(0, meetings.size());
	}

}
