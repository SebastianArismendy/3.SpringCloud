package co.edu.poli.users.service;


import co.edu.poli.users.persistence.entity.User;
import co.edu.poli.users.persistence.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }



    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        // Verificar si el usuario tiene reservas asociadas
        // Lógica de negocio para evitar eliminar usuarios con reservas (puedes ajustarla según tus necesidades)
        // Si tiene reservas, puedes lanzar una excepción, enviar un mensaje personalizado, etc.
        // Si no tiene reservas, proceder con la eliminación
        if (hasBookings(id)) {
            throw new IllegalStateException("No se puede eliminar un usuario con reservas asociadas");
        }

        userRepository.deleteById(id);
    }

    // Método para verificar si un usuario tiene reservas asociadas
    private boolean hasBookings(Long userId) {
        // Lógica para verificar si un usuario tiene reservas asociadas
        // Puedes implementarla según tu modelo de datos y relaciones
        // En este ejemplo, asumimos que no tiene reservas
        return false;
    }
}