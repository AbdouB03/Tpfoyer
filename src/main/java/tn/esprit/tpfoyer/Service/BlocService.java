package tn.esprit.tpfoyer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.Repository.BlocRepository;

import java.util.List;

@Service
public class BlocService {
    @Autowired
    private BlocRepository blocRepository;

    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
}
