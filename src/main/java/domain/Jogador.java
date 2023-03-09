package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("JOGADOR")
@NamedQueries({
        @NamedQuery(name = "jogador.findAll", query = "select j from Jogador j")
})
public class Jogador extends Profissional{

    private String posicao;

    private boolean isTitular;

    @ManyToOne
    private Equipe equipe;

}
