package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.*;
import tn.esprit.tpfoyer.Repository.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class FoyerService {
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    // affecter Foyer Université
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Optional<Foyer> foyerOpt = foyerRepository.findById(idFoyer);
        Optional<Universite> universiteOpt = universiteRepository.findByNom(nomUniversite);

        if (foyerOpt.isPresent() && universiteOpt.isPresent()) {
            Universite universite = universiteOpt.get();
            Foyer foyer = foyerOpt.get();
            universite.setFoyers((List<Foyer>) foyer);
            return universiteRepository.save(universite);
        }
        return null;
    }

    // désaffecter Foyer  Université
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Optional<Universite> universiteOpt = universiteRepository.findById(idUniversite);
        if (universiteOpt.isPresent()) {
            Universite universite = universiteOpt.get();
            universite.setFoyers(null);
            return universiteRepository.save(universite);
        }
        return null;
    }

    // affecter Chambres  bloc
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Optional<Bloc> blocOpt = blocRepository.findById(idBloc);
        if (blocOpt.isPresent()) {
            Bloc bloc = blocOpt.get();
            List<Chambre> chambres = chambreRepository.findAllById(numChambres);
            chambres.forEach(chambre -> chambre.setBloc(bloc));
            chambreRepository.saveAll(chambres);
            return bloc;
        }
        return null;
    }

    // Ajouter  Foyer  Blocs et  Université
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Optional<Universite> universiteOpt = universiteRepository.findById(idUniversite);
        if (universiteOpt.isPresent()) {
            Universite universite = universiteOpt.get();
            foyer.setUniversite(universite);
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));
            return foyerRepository.save(foyer);
        }
        return null;
    }

    // Ajouter  Réservation
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Optional<Chambre> chambreOpt = chambreRepository.findById(idChambre);
        Optional<Etudiant> etudiantOpt = etudiantRepository.findById(cinEtudiant);

        if (chambreOpt.isPresent() && etudiantOpt.isPresent()) {
            Chambre chambre = chambreOpt.get();
            Etudiant etudiant = etudiantOpt.get();
            if (chambre.getReservations().size() < chambre.getTypeC().getCapaciteMax()) {
                Reservation reservation = new Reservation();
                reservation.setChambre(chambre);
                reservation.setEtudiant(etudiant);
                reservation.setAnneelUniversitaire(new Date());
                reservation.setEstValide(true);
                reservationRepository.save(reservation);
                return reservation;
            }
        }
        return null;
    }
}
