package com.wjahatadiltech.booking_service.service;

import com.wjahatadiltech.booking_service.entity.Booking;
import com.wjahatadiltech.booking_service.entity.BookingDetail;
import com.wjahatadiltech.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("Confirmed");

        if (booking.getBookingDetails() != null) {
            for (BookingDetail detail : booking.getBookingDetails()) {
                detail.setBooking(booking);
            }
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
    }
}
