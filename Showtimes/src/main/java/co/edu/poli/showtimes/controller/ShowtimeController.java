package co.edu.poli.showtimes.controller;


import co.edu.poli.showtimes.persistence.entity.Showtime;
import co.edu.poli.showtimes.service.ShowtimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    @PostMapping
    public Showtime createShowtime(@Valid @RequestBody Showtime showtime) {
        return showtimeService.createShowtime(showtime);
    }

    @GetMapping("/{id}")
    public Showtime getShowtimeById(@PathVariable Long id) {

        return showtimeService.getShowtimeById(id);
    }

    @PutMapping("/{id}")
    public Showtime updateShowtime(@PathVariable Long id, @RequestBody @Valid Showtime showtime) {
        return showtimeService.updateShowtime(id, showtime);
    }

}
