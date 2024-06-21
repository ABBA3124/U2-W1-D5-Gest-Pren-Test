package davide.U2_W1_D5_Gest_Pren_Test.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table (name = "edifici")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String indirizzo;
    private String città;

    public Edificio(String città, String indirizzo, String nome) {
        this.città = città;
        this.indirizzo = indirizzo;
        this.nome = nome;
    }
}
