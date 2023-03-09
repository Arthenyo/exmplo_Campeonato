package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    private Tecnico tecnico;

    @ManyToMany
    @JoinTable
    private List<Campeonato> campeonatos;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private List<Jogador> jogadores;
}
