package co.edu.poli.users.clientFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "booking")
public interface BookingClient {

    @GetMapping("/api/v1/poli/bookings/user/valid/{id}")
    Boolean hasBooking(@PathVariable("id") Long id);
}
