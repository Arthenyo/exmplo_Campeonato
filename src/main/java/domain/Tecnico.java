package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("TECNICO")
@NamedQueries({
        @NamedQuery(name = "tecnico.findAll", query = "select t from Tecnico t")
})
public class Tecnico extends Profissional {

    private String matriculaCBF;
}
