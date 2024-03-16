package web.tcs.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.tcs.model.request.MonedaRequest;
import web.tcs.service.TipoCambioService;
import web.tcs.utils.ResponseHandler;

@RestController
@RequestMapping("api/tipoCambio")
@Log
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    @PostMapping("/cambiarMoneda")
    public ResponseEntity<Object> cambiarMoneda(@RequestBody MonedaRequest monedaRequest) {
        log.info("[INICIO]");
        return tipoCambioService.cambiar(monedaRequest);
    }

    @PostMapping("/cambiarTipoCambio")
    public ResponseEntity<Object> actualizar(@RequestBody MonedaRequest monedaRequest) {
        log.info("[INICIO]");
        return tipoCambioService.actualizar(monedaRequest);
    }

}
