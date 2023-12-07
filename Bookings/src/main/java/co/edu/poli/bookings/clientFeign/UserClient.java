package co.edu.poli.bookings.clientFeign;

import co.edu.poli.bookings.helper.Response;
import co.edu.poli.bookings.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/api/v1/poli/users/{id}")
    User findByID(@PathVariable("id") Long id);
}
