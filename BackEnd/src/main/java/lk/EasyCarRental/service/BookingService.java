package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.BookingDto;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.entity.Booking;
import lk.EasyCarRental.entity.Driver;

import java.util.ArrayList;

public interface BookingService {

    void saveBooking(BookingDto dto);
    String generateBookingId();
    ArrayList<BookingDto> getAllBooking();
    long countBooking();
    BookingDto findBookingByDrivingId(String driverID);
    BookingDto findBookingbookingID(String bookingID);
    BookingDto findBookingByvehicleNum(String vehicleNum);
}
