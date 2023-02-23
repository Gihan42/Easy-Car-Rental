package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.BookingDto;

public interface BookingService {

    void saveBooking(BookingDto dto);
    String generateBookingId();
}
