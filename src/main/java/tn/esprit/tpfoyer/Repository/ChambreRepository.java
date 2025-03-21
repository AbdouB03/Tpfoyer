package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
