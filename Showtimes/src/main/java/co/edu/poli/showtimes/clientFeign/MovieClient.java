package co.edu.poli.showtimes.clientFeign;

import co.edu.poli.showtimes.helper.Response;
import co.edu.poli.showtimes.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movies/{id}")
    Movie findByID(@PathVariable("id") Long id);
}
