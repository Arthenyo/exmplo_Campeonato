package domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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

    @OneToMany
    private List<Jogador> jogadores;
}
