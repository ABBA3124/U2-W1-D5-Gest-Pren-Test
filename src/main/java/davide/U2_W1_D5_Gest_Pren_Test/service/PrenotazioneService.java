package davide.U2_W1_D5_Gest_Pren_Test.service;


import davide.U2_W1_D5_Gest_Pren_Test.entities.Postazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Prenotazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Utente;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.PostazioneRepository;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.PrenotazioneRepository;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PrenotazioneService {


    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;


    public void salvaPrenozione (Prenotazione prenotazione){
        prenotazioneRepository.save(prenotazione);
        System.out.println("\n"+ prenotazione + "  "+ " ✔️salvata correttamente!✔️");
    }


    public Prenotazione prenotaPostazione(UUID postazioneId, UUID utenteId, LocalDate data) throws Exception {
        Postazione postazione = postazioneRepository.findById(postazioneId)
                .orElseThrow(() -> new Exception("Postazione non trovata"));

        Utente utente = utenteRepository.findById(utenteId)
              .orElseThrow(() -> new Exception("Utente non trovato"));

        if (prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
            throw new Exception("Postazione già prenotata per la data selezionata");
        }


        //inutile perchè basta quella di sopra
        if (prenotazioneRepository.existsByUtenteAndData(utente, data)) {
            throw new Exception("Utente ha già una prenotazione per la data selezionata");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);
        prenotazione.setData(data);

        return prenotazioneRepository.save(prenotazione);
    }
}


