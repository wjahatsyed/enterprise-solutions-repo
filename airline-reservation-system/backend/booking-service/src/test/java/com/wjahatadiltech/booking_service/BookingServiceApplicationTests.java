package com.wjahatadiltech.booking_service;

import com.wjahatadiltech.booking_service.entity.Booking;
import com.wjahatadiltech.booking_service.entity.BookingDetail;
import com.wjahatadiltech.booking_service.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookingServiceApplicationTests {
	@Autowired
	private BookingService bookingService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateBooking() {
		BookingDetail bookingDetail = new BookingDetail();
		bookingDetail.setPassengerName("Nuzhat Khanum");
		bookingDetail.setSeatNumber("1A");
		Booking booking = new Booking();
		booking.setFlightId(1L);
		booking.setUserId("user456");
		booking.setTotalPrice(400.00);
		booking.setBookingDetails(List.of(
				bookingDetail
		));

		Booking savedBooking = bookingService.createBooking(booking);

		assertNotNull(savedBooking.getId());
		assertEquals(1L, savedBooking.getFlightId());
	}


}
