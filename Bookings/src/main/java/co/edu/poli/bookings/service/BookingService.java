package co.edu.poli.bookings.service;


import co.edu.poli.bookings.clientFeign.MovieClient;
import co.edu.poli.bookings.clientFeign.ShowtimesClient;
import co.edu.poli.bookings.clientFeign.UserClient;
import co.edu.poli.bookings.model.Movie;
import co.edu.poli.bookings.model.Showtime;
import co.edu.poli.bookings.model.User;
import co.edu.poli.bookings.persistence.entity.Booking;
import co.edu.poli.bookings.persistence.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final UserClient userClient;
    private final ShowtimesClient showtimesClient;
    private final MovieClient movieClient;
    private final CircuitBreakerFactory cbFactory;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {

        Booking booking =  bookingRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();

        booking.setUser(findByIDUser(modelMapper,booking.getUsuario()));
        booking.setShowtime(findByIDShowtime(modelMapper,booking.getShowtimeid()));


        List<Movie> movies = booking.getMoviesList().stream()
                .map(bookingMovie -> {
                    Movie movie;
                    movie = findByIDMovie(modelMapper,bookingMovie);
                    return movie;
                }).collect(Collectors.toList());

       booking.setMovies(movies);


        return booking;
    }

    public List<Booking> getBookingByUserId(Long userId) {
        return bookingRepository.findByUsuario(userId);
    }

    public Boolean hasBooking(Long userId) {
        List<Booking> booking =  bookingRepository.findByUsuario(userId);
        if(booking.isEmpty()){
            return false;
        }else{
            return true;
        }

    }



    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }


    public User findByIDUser(ModelMapper modelMapper, Long userId){
        return cbFactory.create("findByIDUser")
                .run(()->modelMapper.map(userClient.findByID(userId),User.class),
                        e-> new User() );
    }

    public Showtime findByIDShowtime(ModelMapper modelMapper, Long showtimeId){
        return cbFactory.create("findByIDShowtime")
                .run(()->modelMapper.map(showtimesClient.findByID(showtimeId), Showtime.class),
                        e-> new Showtime() );
    }

    public Movie findByIDMovie(ModelMapper modelMapper, Long movieId){
        return cbFactory.create("findByIDMovie")
                .run(()->modelMapper.map(movieClient.findByID(movieId), Movie.class),
                        e-> new Movie() );
    }


}
