package davide.U2_W1_D5_Gest_Pren_Test.service;


import davide.U2_W1_D5_Gest_Pren_Test.entities.Utente;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtenteService {


    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente (Utente utente){
        utenteRepository.save(utente);
        System.out.println("\n"+ utente + "  "+ " ✔️salvato correttamente!✔️");
    }



}
