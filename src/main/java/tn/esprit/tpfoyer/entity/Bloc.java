package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;

    @ManyToOne
    @JoinColumn(name = "idFoyer", referencedColumnName = "idFoyer") // Foreign key reference
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chambre> chambres;
}
