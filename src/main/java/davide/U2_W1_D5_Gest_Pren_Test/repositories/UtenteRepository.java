package davide.U2_W1_D5_Gest_Pren_Test.repositories;

import davide.U2_W1_D5_Gest_Pren_Test.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {
}
