package tn.esprit.tpfoyer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.Service.ChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {
    @Autowired
    private ChambreService chambreService;

    @PostMapping("/addChambre")
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre) {
        System.out.println("Received Chambre: " + chambre);
        Chambre savedChambre = chambreService.saveChambre(chambre);
        return ResponseEntity.ok(savedChambre);
    }


    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }

    @DeleteMapping("/remove-chambre/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        return chambreService.modifyChambre(c);
    }
    }
