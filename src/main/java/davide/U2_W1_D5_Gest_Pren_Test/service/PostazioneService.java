package davide.U2_W1_D5_Gest_Pren_Test.service;


import davide.U2_W1_D5_Gest_Pren_Test.entities.Postazione;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.PostazioneRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {


    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione (Postazione postazione) {
        postazioneRepository.save(postazione);
        System.out.println("\n"+ postazione + "  "+ " ✔️salvata correttamente!✔️");

    }



}
