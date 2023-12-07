package co.edu.poli.movies.service;


import co.edu.poli.movies.persistence.entity.Movie;
import co.edu.poli.movies.persistence.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(@Valid Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        // Verificar si la película tiene programaciones o reservas asociadas
        // Lógica de negocio para evitar eliminar películas con programaciones o reservas (puedes ajustarla según tus necesidades)
        // Si tiene programaciones o reservas, puedes lanzar una excepción, enviar un mensaje personalizado, etc.
        // Si no tiene programaciones ni reservas, proceder con la eliminación
        if (hasShowtimesOrBookings(id)) {
            throw new IllegalStateException("No se puede eliminar una película con programaciones o reservas asociadas");
        }

        movieRepository.deleteById(id);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }


    // Método para verificar si una película tiene programaciones o reservas asociadas
    private boolean hasShowtimesOrBookings(Long movieId) {
        // Lógica para verificar si una película tiene programaciones o reservas asociadas
        // Puedes implementarla según tu modelo de datos y relaciones
        // En este ejemplo, asumimos que no tiene programaciones ni reservas
        return false;
    }


}
