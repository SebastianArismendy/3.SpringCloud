package co.edu.poli.bookings.clientFeign;

import co.edu.poli.bookings.helper.Response;
import co.edu.poli.bookings.model.Showtime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "showtime")
public interface ShowtimesClient {
    @GetMapping("/api/v1/poli/showtimes/{id}")
    Showtime findByID(@PathVariable("id") Long id);
}
