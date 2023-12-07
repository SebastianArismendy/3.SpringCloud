package co.edu.poli.users.service;


import co.edu.poli.users.clientFeign.BookingClient;
import co.edu.poli.users.persistence.entity.User;
import co.edu.poli.users.persistence.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CircuitBreakerFactory cbFactory;
    private final BookingClient bookingClient;

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
        if (bookingClient.hasBooking(id)) {
            throw new IllegalStateException("No se puede eliminar un usuario con reservas asociadas");
        }

        userRepository.deleteById(id);
    }



}