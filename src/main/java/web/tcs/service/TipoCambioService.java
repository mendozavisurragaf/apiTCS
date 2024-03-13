package web.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.tcs.model.TipoCambio;
import web.tcs.model.reponse.MonedaResponse;
import web.tcs.model.request.MonedaRequest;
import web.tcs.repository.MonedaRepository;
import web.tcs.repository.TipoCambioRepository;

import java.util.Optional;

public interface TipoCambioService {

    TipoCambio getMonedaById(Long id);
    MonedaResponse cambiar(MonedaRequest monedaRequest);
    TipoCambio actualizar(MonedaRequest monedaRequest);
}
