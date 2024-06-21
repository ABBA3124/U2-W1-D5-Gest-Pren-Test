package davide.U2_W1_D5_Gest_Pren_Test.service;


import davide.U2_W1_D5_Gest_Pren_Test.entities.Prenotazione;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {


    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public void salvaPrenozione (Prenotazione prenotazione){
        prenotazioneRepository.save(prenotazione);
        System.out.println("\n"+ prenotazione + "  "+ " ✔️salvata correttamente!✔️");
    }

}
