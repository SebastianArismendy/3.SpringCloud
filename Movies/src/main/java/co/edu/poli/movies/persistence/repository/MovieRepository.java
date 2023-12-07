package co.edu.poli.movies.persistence.repository;

import co.edu.poli.movies.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
