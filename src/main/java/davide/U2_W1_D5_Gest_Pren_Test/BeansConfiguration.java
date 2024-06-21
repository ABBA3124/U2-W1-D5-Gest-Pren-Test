package davide.U2_W1_D5_Gest_Pren_Test;



import com.github.javafaker.Faker;
import davide.U2_W1_D5_Gest_Pren_Test.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Configuration
public class BeansConfiguration {

Faker faker = new Faker();


public static TipoPostazione getRandomTipoPostazione () {
Random rdmn = new Random();
    TipoPostazione[] values = TipoPostazione.values();
    int index = rdmn.nextInt(values.length);
    return values[index];
}


    //<------------ Edificio ------------>
            @Bean
            //@Scope("prototype")
            public Edificio edificio () {
            return new Edificio(faker.address().cityName(), faker.address().streetAddress(),faker.company().name());
    }


    //<------------ Postazione ------------>
    @Bean
    public Postazione postazione () {
    return new Postazione(faker.code().asin(),faker.lorem().sentence(),getRandomTipoPostazione(), (int) faker.number().randomNumber(),edificio());
    }



    //<------------ Utenti ------------>
    @Bean
    public Utente utente () {
    return new Utente(faker.name().username(),faker.name().name(),faker.internet().emailAddress());
    }

    //<------------ Prenotazioni ------------>

    @Bean
    public Prenotazione prenotazione () {
    return new Prenotazione(utente(),postazione(), LocalDate.now());
    }

}
