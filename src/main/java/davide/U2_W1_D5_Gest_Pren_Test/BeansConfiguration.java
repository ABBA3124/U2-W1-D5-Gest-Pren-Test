package davide.U2_W1_D5_Gest_Pren_Test;



import com.github.javafaker.Faker;
import davide.U2_W1_D5_Gest_Pren_Test.entities.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

Faker faker = new Faker();

    //<------------ Edificio ------------>
            @Bean
            private Edificio edificio () {
            return new Edificio(faker.address().city(), faker.address().streetAddress(),faker.company().name());
    }


    //<------------ Postazione ------------>

    //<------------ Utenti ------------>

    //<------------ Prenotazioni ------------>

}
