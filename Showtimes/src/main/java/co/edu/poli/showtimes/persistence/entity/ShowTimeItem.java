package co.edu.poli.showtimes.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import co.edu.poli.showtimes.model.Movie;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtime_items")
public class ShowTimeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Transient
    private Movie movie;
}
