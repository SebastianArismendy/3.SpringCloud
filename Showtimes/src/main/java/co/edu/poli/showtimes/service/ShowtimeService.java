package co.edu.poli.showtimes.service;


import co.edu.poli.showtimes.clientFeign.MovieClient;
import co.edu.poli.showtimes.model.Movie;
import co.edu.poli.showtimes.persistence.entity.Showtime;
import co.edu.poli.showtimes.persistence.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeService {


   // private final MovieClient movieClient;
   //  private final CircuitBreakerFactory cbFactory;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime createShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    public Showtime updateShowtime(Long id, Showtime showtime) {
        // Implementar la lógica de actualización según tus necesidades
        Showtime existingShowtime = showtimeRepository.findById(id).orElse(null);
        if (existingShowtime != null) {
            // Actualizar los campos relevantes
            existingShowtime.setDate(showtime.getDate());
            // Actualizar las relaciones si es necesario
            // existingShowtime.setMovies(showtime.getMovies());
            return showtimeRepository.save(existingShowtime);
        }
        return null;
    }


    /*
    public Movie findByMovie(ModelMapper modelMapper, Long movieId){
        return cbFactory.create("findByIDMovie")
                .run(()->modelMapper.map(movieClient.findByID(movieId).getData(),Movie.class),
                        e-> new Movie() );
    }
    */

}
