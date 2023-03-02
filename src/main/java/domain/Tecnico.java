package domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("TECNICO")
@NamedQueries({
        @NamedQuery(name = "tecnico.findAll", query = "select t from Tecnico t")
})
public class Tecnico extends Profissional {

    @OneToOne
    private Equipe equipe;
}
