package co.edu.poli.movies.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "showtime")
public interface ShowtimesClient {

    @GetMapping("/api/v1/poli/showtimes/movie/{id}")
    Boolean hasShowtimes(@PathVariable("id") Long id);
}

