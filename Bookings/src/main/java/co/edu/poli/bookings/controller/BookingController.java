package co.edu.poli.bookings.controller;



import co.edu.poli.bookings.persistence.entity.Booking;
import co.edu.poli.bookings.service.BookingService;
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
    public Booking createBooking(@RequestBody @Validated Booking booking) {
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

    /*
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId);
    }
    */
}
