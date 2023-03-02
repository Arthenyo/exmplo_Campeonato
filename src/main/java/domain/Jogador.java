package domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Data
@DiscriminatorValue("JOGADOR")
@NamedQueries({
        @NamedQuery(name = "jogador.findAll", query = "select j from Jogador j")
})
public class Jogador extends Profissional{

    private String posicao;

    private boolean isTitular;

}
