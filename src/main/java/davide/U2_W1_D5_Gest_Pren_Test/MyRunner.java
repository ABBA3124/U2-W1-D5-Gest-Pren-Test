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

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

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
        edificioService.salvaEdificio(edificio);




            //<------------ Postazione ------------>
        Postazione postazione = (Postazione) context.getBean("postazione");
        postazioneService.salvaPostazione(postazione);




            //<------------ Utenti ------------>
        Utente utente = (Utente) context.getBean("utente");
        utenteService.salvaUtente(utente);




            //<------------ Prenotazioni ------------>
        Prenotazione prenotazione = (Prenotazione) context.getBean("prenotazione");
        //prenotazioneService.salvaPrenozione(prenotazione);



        //Controllo
        //verifica se una postazione è già prenotata per una data specifica
        //verifica se un utente ha già una prenotazione per una data specifica
        try {
        prenotazioneService.prenotaPostazione(UUID.fromString("1956d30a-0f9b-4eb5-9fd0-fe1ea8d396ad"), UUID.fromString("5d91d74e-befb-4e40-8a52-2acfb8f7c33d"), LocalDate.of(2024,06,21));
        } catch (Exception e) {
            System.out.println("\n\t--> " + e.getMessage());
        }


//cerca postazione per tipo  e per città
            TipoPostazione tipo = TipoPostazione.OPENSPACE;
            String città = "South Chris";

            // Stampa i parametri di ricerca
            System.out.println("Ricerca postazioni con tipo: " + tipo + " e città: " + città);

            List<Postazione> postazioni = postazioneService.cercaPostazione(tipo, città);

            // Stampa il numero di postazioni trovate

            if (postazioni.size() <= 0) {
            System.out.println("Postazioni Trovate per la tua ricerca --> " + postazioni.size());

            }
            System.out.println("\nPostazioni Trovate  --> " + postazioni.size());
            System.out.println("\nLista postazioni --> " + postazione.toString());


        System.out.println("\n\t");

// prova scanner (stavo giocando nulla di serissimo)
        Scanner scanner = new Scanner(System.in);
        System.out.println("<-- menu -->");
        System.out.println("Prenota tavolo --> 1 ");
        System.out.println("Esci --> 0 ");

        int ins = scanner.nextInt();
        switch (ins) {
            case 0:
                System.out.println("ciao");
                break;
            case 1:
                scanner.nextLine();
                System.out.println("inserisci username");
                String str1 = scanner.nextLine();
                System.out.println("inserisci nome completo");
                String str2 = scanner.nextLine();
                System.out.println("inserisci email");
                String str3 = scanner.nextLine();
                Utente utente3 = new Utente(str1,str2,str3);
                System.out.println("utente creato --> " + utente3.toString());
                System.out.println("vuoi salvere l'utente " + utente3.getNomeCompleto()  +" --> (Y/N)");
                String str4 = scanner.nextLine();
                if (str4.equals("y")||str4.equals("yes")||str4.equals("Y")||str4.equals("YES")) {
                    utenteService.salvaUtente(utente3);
                    System.out.println("Utente salvato con successo!");

                } else {
                    System.out.println("Creazione Utente Annullata");
                    break;
                }

                scanner.nextLine();
                System.out.println("\t<-- PRENOTAZIONE -->");
                System.out.println("inserisci anno");
                int anno = scanner.nextInt();

                System.out.println("inserisci mese");
                int mese = scanner.nextInt();

                System.out.println("inserisci giorno");
                int giorno = scanner.nextInt();

                Prenotazione prenotazione244 = new Prenotazione(utente3,postazione,LocalDate.of(anno,mese,giorno));

                System.out.println("Dettagli Prenotazione --> " + prenotazione244);
                scanner.nextLine();
                System.out.println("Vuoi confermare la prenotazione ---> (Y/N)");
                String str1516 = scanner.nextLine();
                if (str1516.equals("y")||str1516.equals("yes")||str1516.equals("Y")||str1516.equals("YES")) {
                    prenotazioneService.prenotaPostazione(postazione.getId(),utente3.getId(),LocalDate.of(anno,mese,giorno));
                    System.out.println("Prenotazione salvata con successo!");
                } else {
                    System.out.println("Prenotazione annullata");
                    break;
                }



                break;
        }

        System.out.println("\n\t");
    }
}