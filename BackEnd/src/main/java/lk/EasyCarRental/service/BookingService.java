package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.BookingDto;
import lk.EasyCarRental.entity.Booking;

import java.util.ArrayList;

public interface BookingService {

    void saveBooking(BookingDto dto);
    String generateBookingId();
    ArrayList<BookingDto> getAllBooking();

}
