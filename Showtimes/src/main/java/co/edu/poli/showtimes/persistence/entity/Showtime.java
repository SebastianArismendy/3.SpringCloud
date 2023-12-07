package co.edu.poli.showtimes.persistence.entity;


import co.edu.poli.showtimes.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;



import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date date;

    @ElementCollection
    private List<Long> moviesList;

    @Transient
    @Schema(hidden = true)
    private List<Movie> movies;

}
