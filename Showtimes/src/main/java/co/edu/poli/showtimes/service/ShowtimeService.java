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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeService {


    private final MovieClient movieClient;
    private final CircuitBreakerFactory cbFactory;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime createShowtime(Showtime showtime) {

        if (showtime.getDate() == null) {
            throw new IllegalArgumentException("El campo 'date' no puede ser null");
        }

        return showtimeRepository.save(showtime);
    }

    public Showtime getShowtimeById(Long id) {

        Showtime showtime =  showtimeRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        List<Movie> movies = showtime.getMoviesList().stream()
                .map(showtimeMovie -> {
                    Movie movie;
                    movie = findByIDMovie(modelMapper,showtimeMovie);
                    return movie;
                }).collect(Collectors.toList());

        showtime.setMovies(movies);


        return showtime;

    }


    public List<Showtime> hasShowtimes(List<Long> movieList) {
        return showtimeRepository.findByMoviesListIn(movieList);
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

    public Movie findByIDMovie(ModelMapper modelMapper, Long movieId){
        return cbFactory.create("findByIDMovie")
                .run(()->modelMapper.map(movieClient.findByID(movieId), Movie.class),
                        e-> new Movie() );
    }

}
