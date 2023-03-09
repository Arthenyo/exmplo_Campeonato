package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "campeonato.findAll",query = "select c from Campeonato c"),
        @NamedQuery(name = "campeonato.byname",query = "select c from Campeonato c where c.nomeCampeonato = :nomeCampeonato")
})
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCampeonato;

    private LocalDate dataInicial;

    private LocalDate dataFinal;

}
