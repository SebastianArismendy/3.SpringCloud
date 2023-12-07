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

    @NotEmpty(message = "El titulo no puede  estar en blanco")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "El director no puede  estar en blanco")
    @Column(name = "director")
    private String director;

    @Min(value = 1, message = "El rating debe ser minimo de 1")
    @Max(value = 5, message = "El rating debe ser maximo de 5")
    @Column(name = "rating")
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
