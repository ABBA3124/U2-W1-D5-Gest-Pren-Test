package davide.U2_W1_D5_Gest_Pren_Test.repositories;

import davide.U2_W1_D5_Gest_Pren_Test.entities.Postazione;
import davide.U2_W1_D5_Gest_Pren_Test.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.città = :città")
    List<Postazione> findByTipoAndCittà(@Param("tipo") TipoPostazione tipo, @Param("città") String città);


}