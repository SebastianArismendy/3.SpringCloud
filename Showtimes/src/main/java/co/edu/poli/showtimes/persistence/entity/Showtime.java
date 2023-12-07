package co.edu.poli.showtimes.persistence.entity;


import co.edu.poli.showtimes.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
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
    private List<Long> movieIds;

  /*
    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ShowTimeItem> movies;
    */

}
