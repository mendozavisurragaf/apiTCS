package web.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.tcs.model.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {

    @Query("SELECT m.id FROM Moneda m where m.abreviatura = :abrv")
    Long findMonedaByAbreviatura(@Param("abrv") String abrv);

}
