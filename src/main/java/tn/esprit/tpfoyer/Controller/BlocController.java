package tn.esprit.tpfoyer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.Service.BlocService;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocController {
    @Autowired
    private BlocService blocService;

    @PostMapping
    public Bloc createBloc(@RequestBody Bloc bloc) {
        return blocService.saveBloc(bloc);
    }

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }
}
