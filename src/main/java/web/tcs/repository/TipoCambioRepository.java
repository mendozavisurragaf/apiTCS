package web.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.tcs.model.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

    @Query("SELECT t FROM TipoCambio t where t.monedaOrigen.abreviatura = :monOrigen and t.monedaDestino.abreviatura = :monDestino")
    TipoCambio findTipoCambioByNombre(@Param("monOrigen") String monOrigen, @Param("monDestino") String monDestino);

}
