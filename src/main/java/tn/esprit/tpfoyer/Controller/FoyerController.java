package tn.esprit.tpfoyer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.Service.FoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {
    @Autowired
    private FoyerService foyerService;

    @PostMapping("/affecterFoyer")
    public Universite affecterFoyerAUniversite(@RequestParam long idFoyer, @RequestParam String nomUniversite) {
        return foyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PostMapping("/desaffecterFoyer")
    public Universite desaffecterFoyerAUniversite(@RequestParam long idUniversite) {
        return foyerService.desaffecterFoyerAUniversite(idUniversite);
    }

    @PostMapping("/affecterChambres")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambres, @RequestParam long idBloc) {
        return foyerService.affecterChambresABloc(numChambres, idBloc);
    }

    @PostMapping("/ajouterFoyer")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @RequestParam long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestParam long idChambre, @RequestParam long cinEtudiant) {
        return foyerService.ajouterReservation(idChambre, cinEtudiant);
    }
}