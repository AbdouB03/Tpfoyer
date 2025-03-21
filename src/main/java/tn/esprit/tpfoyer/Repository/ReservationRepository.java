package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}