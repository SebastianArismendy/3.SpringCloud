package co.edu.poli.bookings.persistence.entity;


import co.edu.poli.bookings.model.Movie;
import co.edu.poli.bookings.model.Showtime;
import co.edu.poli.bookings.model.User;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long usuario;

    @NotNull
    private Long showtimeid;


    @ElementCollection
    private List<Long> moviesList;


    @Transient
    @Schema(hidden = true)
    private User user;

    @Transient
    @Schema(hidden = true)
    private Showtime showtime;

    @Transient
    @Schema(hidden = true)
    private List<Movie> movies;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
