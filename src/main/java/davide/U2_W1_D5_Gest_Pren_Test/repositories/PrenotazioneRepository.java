package davide.U2_W1_D5_Gest_Pren_Test.repositories;

import davide.U2_W1_D5_Gest_Pren_Test.entities.Postazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Prenotazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {


//verifica se una postazione è già prenotata per una data specifica
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

//verifica se un utente ha già una prenotazione per una data specifica
    boolean existsByUtenteAndData(Utente utente, LocalDate data);

}
