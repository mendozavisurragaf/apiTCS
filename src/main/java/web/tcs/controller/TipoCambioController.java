package web.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.tcs.utils.ResponseHandler;
import web.tcs.model.TipoCambio;
import web.tcs.model.reponse.MonedaResponse;
import web.tcs.model.request.MonedaRequest;
import web.tcs.service.TipoCambioService;

@RestController
@RequestMapping("api/tipoCambio")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;


    @GetMapping("{id}")
    public TipoCambio searchMonedaById(@PathVariable Long id){
        return tipoCambioService.getMonedaById(id);
    }


    @PostMapping("/cambiarMoneda")
    public ResponseEntity<Object> cambiarMoneda(@RequestBody MonedaRequest monedaRequest){

        try{
            MonedaResponse obj= tipoCambioService.cambiar(monedaRequest);

            return ResponseHandler.generateResponse("Monto cambiado", HttpStatus.OK, obj);

        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.NO_CONTENT, null);
        }


    }

    @PostMapping("/cambiarTipoCambio")
    public ResponseEntity<Object> actualizar(@RequestBody MonedaRequest monedaRequest){
        try{
            TipoCambio obj= tipoCambioService.actualizar(monedaRequest);

            return ResponseHandler.generateResponse("Monto cambiado", HttpStatus.OK, obj);

        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.NO_CONTENT, null);
        }
    }

}
