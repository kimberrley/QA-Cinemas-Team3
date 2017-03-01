package com.qa.cinema.entityTests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.qa.cinema.persistence.SeatType;
import com.qa.cinema.persistence.TicketType;

public class SeatTypeEntityTest {

	SeatType seatType = new SeatType();
	
	@Test
	public void testSeatType() {
		assertNotNull(seatType);
	}
	
	@Test
	public void testSeatTypeId() {
		seatType.setTypeId(4L);
		assertSame(4L, seatType.getTypeId());
	}
	
	@Test
	public void testSeatTypeName() {
		SeatType seatType = SeatType.STANDARD;
		seatType.setName(seatType);
		assertEquals(seatType, seatType.getName());
	}

	@Test
	public void testSeatTypePrice() {
		BigDecimal dd = new BigDecimal("10.00");
		seatType.setPrice(dd);
		boolean same = seatType.getPrice() == dd ? true : false;
		assertTrue(same);
	}

}
