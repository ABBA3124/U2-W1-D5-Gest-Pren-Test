package davide.U2_W1_D5_Gest_Pren_Test;



import com.github.javafaker.Faker;
import davide.U2_W1_D5_Gest_Pren_Test.entities.*;
import davide.U2_W1_D5_Gest_Pren_Test.service.EdificioService;
import davide.U2_W1_D5_Gest_Pren_Test.service.PostazioneService;
import davide.U2_W1_D5_Gest_Pren_Test.service.PrenotazioneService;
import davide.U2_W1_D5_Gest_Pren_Test.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
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
        prenotazioneService.prenotaPostazione(UUID.fromString("1956d30a-0f9b-4eb5-9fd0-fe1ea8d396ad"), UUID.fromString("5d91d74e-befb-4e40-8a52-2acfb8f7c33d"), LocalDate.of(2024,06,21));
        } catch (Exception e) {
            System.out.println("\n\t--> " + e.getMessage());
        }





            TipoPostazione tipo = TipoPostazione.OPENSPACE;
            String città = "South Chris";

            // Stampa i parametri di ricerca
            System.out.println("Ricerca postazioni con tipo: " + tipo + " e città: " + città);

            List<Postazione> postazioni = postazioneService.cercaPostazione(tipo, città);

            // Stampa il numero di postazioni trovate

            if (postazioni.size() <= 0) {
            System.out.println("Postazioni Trovate per la tua ricerca --> " + postazioni.size());

            }
            System.out.println("Postazioni Trovate  --> " + postazioni.size());
            System.out.println("Lista postazioni --> " + postazione.getDescrizione());


    }
}