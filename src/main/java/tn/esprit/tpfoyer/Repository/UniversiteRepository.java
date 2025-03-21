package tn.esprit.tpfoyer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.Optional;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Optional<Universite> findByNom(String nom);

}
