package co.edu.poli.showtimes.clientFeign;

import co.edu.poli.showtimes.helper.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie")
public interface MovieClient {

    @GetMapping("/api/v1/poli/movie/{id}")
    Response findByID(@PathVariable("id") Long id);
}
