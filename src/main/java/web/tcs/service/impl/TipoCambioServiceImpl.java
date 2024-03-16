package web.tcs.service.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.tcs.model.TipoCambio;
import web.tcs.model.reponse.MonedaResponse;
import web.tcs.model.request.MonedaRequest;
import web.tcs.repository.MonedaRepository;
import web.tcs.repository.TipoCambioRepository;
import web.tcs.service.TipoCambioService;
import web.tcs.utils.ResponseHandler;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class TipoCambioServiceImpl implements TipoCambioService {
    @Autowired
    private TipoCambioRepository tipoCambioRepository;
    ResponseEntity<Object> response;

    public ResponseEntity<Object> cambiar(MonedaRequest monedaRequest) {
        log.info("[INFO] Metodo Cambiar Monto");

        if (monedaRequest.getMonto() == null || monedaRequest.getMonedaDestino() == null || monedaRequest.getMonedaOrigen() == null) {
            log.severe("[ERROR] Faltan datos en el request");
            log.info("[FIN]");
            return ResponseHandler.generateResponse("Datos incompletos", HttpStatus.PARTIAL_CONTENT, null);
        }
        if (monedaRequest.getMonto().isEmpty() || monedaRequest.getMonedaDestino().isEmpty() || monedaRequest.getMonedaOrigen().isEmpty()) {
            log.severe("[ERROR] Algunos atributos no cuentan con información");
            log.info("[FIN]");
            return ResponseHandler.generateResponse("Atributos Vacíos", HttpStatus.PARTIAL_CONTENT, null);
        }
        log.info("[INFO] Monto: " + monedaRequest.getMonto());
        log.info("[INFO] Moneda de Origen: " + monedaRequest.getMonedaOrigen());
        log.info("[INFO] Moneda de Destino: " + monedaRequest.getMonedaDestino());


        try {
            MonedaResponse obj = new MonedaResponse();
            log.info("[INFO] Buscando Tipo de Cambio");

            TipoCambio objTipoCambio = tipoCambioRepository.findTipoCambioByNombre(monedaRequest.getMonedaOrigen(), monedaRequest.getMonedaDestino());


            if (objTipoCambio == null) {
                log.info("[ERROR] Tipo de Cambio no encontrado");
                log.info("[FIN]");
                return ResponseHandler.generateResponse("Tipo de Cambio no encontrado", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }

            log.info("[INFO] Tipo de Cambio: " + objTipoCambio.toString());

            obj.setMonedaOrigen(objTipoCambio.getMonedaOrigen().getNombre());
            obj.setMonedaDestino(objTipoCambio.getMonedaDestino().getNombre());
            obj.setMonto(monedaRequest.getMonto());
            obj.setTipoCambio(String.valueOf(objTipoCambio.getCambio()));
            obj.setMontoTipoCambio(String.valueOf(objTipoCambio.getCambio() * Double.parseDouble(monedaRequest.getMonto())));
            log.info("[INFO] Response: " + obj.toString());

            log.info("[INFO] Monto cambiado");

            response = ResponseHandler.generateResponse("Monto cambiado", HttpStatus.OK, obj);
        } catch (NumberFormatException numberFormatException) {
            log.info("[ERROR] Valores Erróneos");
            response = ResponseHandler.generateResponse("Valores Erróneos", HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            log.info("[ERROR] Error del Servidor");
            response = ResponseHandler.generateResponse("Error", HttpStatus.NO_CONTENT, null);
        }
        log.info("[FIN]");
        return response;
    }

    public ResponseEntity<Object> actualizar(MonedaRequest monedaRequest) {
        log.info("[INFO] Metodo Actualizar Tipo de Cambio");

        if (monedaRequest.getMonto() == null || monedaRequest.getMonedaDestino() == null || monedaRequest.getMonedaOrigen() == null) {
            log.severe("[ERROR] Faltan datos en el request");
            log.info("[FIN]");
            return ResponseHandler.generateResponse("Datos incompletos", HttpStatus.PARTIAL_CONTENT, null);
        }
        if (monedaRequest.getMonto().isEmpty() || monedaRequest.getMonedaDestino().isEmpty() || monedaRequest.getMonedaOrigen().isEmpty()) {
            log.severe("[ERROR] Algunos atributos no cuentan con información");
            log.info("[FIN]");
            return ResponseHandler.generateResponse("Atributos Vacíos", HttpStatus.PARTIAL_CONTENT, null);
        }

        log.info("[INFO] Monto: " + monedaRequest.getMonto());
        log.info("[INFO] Moneda de Origen: " + monedaRequest.getMonedaOrigen());
        log.info("[INFO] Moneda de Destino: " + monedaRequest.getMonedaDestino());

        try {
            TipoCambio obj = tipoCambioRepository.findTipoCambioByNombre(monedaRequest.getMonedaOrigen(), monedaRequest.getMonedaDestino());

            if (obj == null) {
                log.info("[ERROR] Tipo de Cambio no encontrado");
                log.info("[FIN]");
                return ResponseHandler.generateResponse("Tipo de Cambio no encontrado", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }

            log.info("[INFO] Tipo de Cambio: " + obj.toString());

            obj.setCambio(Double.parseDouble(monedaRequest.getMonto()));

            TipoCambio tipoCambio = tipoCambioRepository.save(obj);
            log.info("[INFO] Tipo de Cambio a actualizar: " + tipoCambio.toString());

            response = ResponseHandler.generateResponse("Tipo de Cambio Actualizado", HttpStatus.OK, tipoCambio);
            log.info("[INFO] Tipo de Cambio Actualizado");

        } catch (NumberFormatException numberFormatException) {
            log.info("[ERROR] Valores Erróneos");
            response = ResponseHandler.generateResponse("Valores Erróneos", HttpStatus.BAD_REQUEST, null);
        } catch (Exception e) {
            log.info("[ERROR] Error del Servidor");
            response = ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NO_CONTENT, null);
        }
        log.info("[FIN]");
        return response;
    }

    @Override
    public List<TipoCambio> getTipoCambio() {
        return tipoCambioRepository.findAll();
    }

}
