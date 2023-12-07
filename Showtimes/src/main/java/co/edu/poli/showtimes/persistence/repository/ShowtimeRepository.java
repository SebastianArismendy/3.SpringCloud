package co.edu.poli.showtimes.persistence.repository;

import co.edu.poli.showtimes.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMoviesListIn(List<Long> moviesList);
}
