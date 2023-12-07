package co.edu.poli.users.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name = "users") // Especifica el nombre de la tabla
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "El nombre no puede  estar en blanco")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "El apellido no puede  estar en blanco")
    @Column(name = "lastname")
    private String lastname;

    // toString, hashCode, equals, etc.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }
}