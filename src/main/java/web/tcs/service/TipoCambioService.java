package web.tcs.service;

import org.springframework.http.ResponseEntity;
import web.tcs.model.TipoCambio;
import web.tcs.model.request.MonedaRequest;

import java.util.List;

public interface TipoCambioService {

    ResponseEntity<Object> cambiar(MonedaRequest monedaRequest);
    ResponseEntity<Object> actualizar(MonedaRequest monedaRequest);

    List<TipoCambio> getTipoCambio();
}
