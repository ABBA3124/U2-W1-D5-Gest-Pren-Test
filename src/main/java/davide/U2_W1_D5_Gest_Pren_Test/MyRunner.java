package davide.U2_W1_D5_Gest_Pren_Test;



import com.github.javafaker.Faker;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Edificio;
import davide.U2_W1_D5_Gest_Pren_Test.service.EdificioService;
import davide.U2_W1_D5_Gest_Pren_Test.service.PostazioneService;
import davide.U2_W1_D5_Gest_Pren_Test.service.PrenotazioneService;
import davide.U2_W1_D5_Gest_Pren_Test.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {


    //Istanzio i service
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    //bean
    //@Autowired
    //AnnotationConfigApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);
        Random rdmn = new Random();


            //<------------ Edifici ------------>
        Edificio edificio = new Edificio(faker.address().city(), faker.address().streetAddress(),faker.company().name());
        edificioService.salvaEdificio(edificio);

            //<------------ Postazione ------------>

            //<------------ Utenti ------------>

            //<------------ Prenotazioni ------------>

    }
}