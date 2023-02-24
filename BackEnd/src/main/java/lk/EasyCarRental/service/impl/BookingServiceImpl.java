package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.BookingDto;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.entity.Booking;
import lk.EasyCarRental.repo.BookingRepo;
import lk.EasyCarRental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveBooking(BookingDto dto) {
        if (repo.existsById(dto.getBookingID())){
            throw new RuntimeException("booking has already exists");
        }
        String s = generateBookingId();
        dto.setBookingID(s);
        Booking booking=mapper.map(dto,Booking.class);
        repo.save(booking);
    }

    @Override
    public String generateBookingId() {
        long l = repo.countAllBy();
        return "BID-"+(l+1);

    }

    @Override
    public ArrayList<BookingDto> getAllBooking() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<BookingDto>>(){}.getType());

    }


}
