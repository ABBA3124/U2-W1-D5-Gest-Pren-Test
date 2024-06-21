package davide.U2_W1_D5_Gest_Pren_Test.service;


import davide.U2_W1_D5_Gest_Pren_Test.entities.Edificio;
import davide.U2_W1_D5_Gest_Pren_Test.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {


    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio){
        edificioRepository.save(edificio);
        System.out.println("\n"+ edificio + "  "+ " ✔️salvato correttamente!✔️");

    }



}
