package co.edu.poli.bookings.controller;



import co.edu.poli.bookings.persistence.entity.Booking;
import co.edu.poli.bookings.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@Valid @RequestBody  Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/user/{id}")
    public List<Booking> getBookingByUserId(@PathVariable Long id) {
        return bookingService.getBookingByUserId(id);
    }


    @GetMapping("/user/valid/{id}")
    public Boolean hasBooking(@PathVariable Long id) {
        return bookingService.hasBooking(id);
    }

}
