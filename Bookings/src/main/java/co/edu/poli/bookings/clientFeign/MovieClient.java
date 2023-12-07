package co.edu.poli.bookings.clientFeign;

import co.edu.poli.bookings.model.Movie;
import co.edu.poli.bookings.model.Showtime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movies/{id}")
    Movie findByID(@PathVariable("id") Long id);
}
