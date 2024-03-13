package web.tcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.tcs.model.TipoCambio;
import web.tcs.model.reponse.MonedaResponse;
import web.tcs.model.request.MonedaRequest;
import web.tcs.repository.MonedaRepository;
import web.tcs.repository.TipoCambioRepository;
import web.tcs.service.TipoCambioService;

import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @Autowired
    private MonedaRepository monedaRepository;

    public TipoCambio getMonedaById(Long id){
        Optional<TipoCambio> optionalTipoCambio = tipoCambioRepository.findById(id);

        return optionalTipoCambio.get();
    }

    public MonedaResponse cambiar(MonedaRequest monedaRequest){
        MonedaResponse obj = new MonedaResponse();

        TipoCambio objTipoCambio = tipoCambioRepository.findTipoCambioByNombre(monedaRequest.getMonedaOrigen(), monedaRequest.getMonedaDestino());


        obj.setMonedaOrigen(objTipoCambio.getMonedaOrigen().getNombre());
        obj.setMonedaDestino(objTipoCambio.getMonedaDestino().getNombre());
        obj.setMonto(monedaRequest.getMonto());
        obj.setTipoCambio(objTipoCambio.getCambio());

        Double montoCambiado = Double.parseDouble(objTipoCambio.getCambio()) * Double.parseDouble(monedaRequest.getMonto());

        obj.setMontoTipoCambio(montoCambiado.toString());

        return obj;
    }
    public TipoCambio actualizar(MonedaRequest monedaRequest){
        TipoCambio obj = tipoCambioRepository.findTipoCambioByNombre(monedaRequest.getMonedaOrigen(), monedaRequest.getMonedaDestino());
        obj.setCambio(monedaRequest.getMonto());

        return tipoCambioRepository.save(obj);
    }

}
