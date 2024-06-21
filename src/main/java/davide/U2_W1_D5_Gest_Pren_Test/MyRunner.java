package davide.U2_W1_D5_Gest_Pren_Test;



import com.github.javafaker.Faker;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Edificio;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Postazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Prenotazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Utente;
import davide.U2_W1_D5_Gest_Pren_Test.service.EdificioService;
import davide.U2_W1_D5_Gest_Pren_Test.service.PostazioneService;
import davide.U2_W1_D5_Gest_Pren_Test.service.PrenotazioneService;
import davide.U2_W1_D5_Gest_Pren_Test.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

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
    @Autowired
    AnnotationConfigApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);
        Random rdmn = new Random();


            //<------------ Edifici ------------>


        Edificio edificio = (Edificio) context.getBean("edificio");
        //edificioService.salvaEdificio(edificio);




            //<------------ Postazione ------------>
        Postazione postazione = (Postazione) context.getBean("postazione");
        //postazioneService.salvaPostazione(postazione);




            //<------------ Utenti ------------>
        Utente utente = (Utente) context.getBean("utente");
        //utenteService.salvaUtente(utente);




            //<------------ Prenotazioni ------------>
        Prenotazione prenotazione = (Prenotazione) context.getBean("prenotazione");
        //prenotazioneService.salvaPrenozione(prenotazione);


        try {
        prenotazioneService.prenotaPostazione(UUID.fromString("1956d30a-0f9b-4eb5-9fd0-fe1ea8d396ad"), UUID.fromString("5d91d74e-befb-4e40-8a52-2acfb8f7c33d"), LocalDate.now());
        } catch (Exception e) {
            System.out.println("-->" + e.getMessage());
        }


        System.out.println("\n");
    }
}