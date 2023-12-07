package co.edu.poli.movies.controller;


import co.edu.poli.movies.persistence.entity.Movie;
import co.edu.poli.movies.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {


    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie createMovie(@RequestBody @Valid Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getShowtimeById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    /*
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
     */
}
