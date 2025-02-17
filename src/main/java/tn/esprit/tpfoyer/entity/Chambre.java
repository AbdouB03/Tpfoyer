package tn.esprit.firstSBProject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chambre {
    @Id
    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeC typeC;

    @ManyToOne
    @JoinColumn(name = "idBloc")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
