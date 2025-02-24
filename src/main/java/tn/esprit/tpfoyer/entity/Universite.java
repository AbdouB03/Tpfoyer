package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite; // Primary key

    private String nomUniversite;

    @OneToMany(mappedBy = "universite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Foyer> foyers;
}
