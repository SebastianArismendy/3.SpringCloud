package co.edu.poli.movies.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name = "movie") // Especifica el nombre de la tabla
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "title")
    @NotBlank
    private String title;


    @Column(name = "director")
    @NotBlank
    private String director;


    @Column(name = "rating")
    @Min(value = 1)
    @Max(value = 5)
    private int rating;

    // getters and setters

    // toString, hashCode, equals, etc.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return rating == movie.rating && Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, director, rating);
    }
}
