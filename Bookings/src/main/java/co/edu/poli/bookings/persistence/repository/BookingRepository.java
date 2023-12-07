package co.edu.poli.bookings.persistence.repository;

import co.edu.poli.bookings.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
