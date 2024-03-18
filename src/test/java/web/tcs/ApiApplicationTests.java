package web.tcs;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import web.tcs.model.Moneda;
import web.tcs.model.TipoCambio;
import web.tcs.model.reponse.MonedaResponse;
import web.tcs.model.request.MonedaRequest;
import web.tcs.repository.TipoCambioRepository;
import web.tcs.service.TipoCambioService;
import web.tcs.utils.ResponseHandler;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

    @Autowired
    TipoCambioService tipoCambioService;

    @Autowired
    TipoCambioRepository tipoCambioRepository;

    @Test
    public void getTipoCambioTestNull() {
        MonedaRequest objRequest = new MonedaRequest("2.50", null, "PEN");

        assertEquals(ResponseHandler.generateResponse("Datos incompletos", HttpStatus.PARTIAL_CONTENT, null),
                tipoCambioService.cambiar(objRequest));
    }

    @Test
    public void getTipoCambioTestEmpty() {
        MonedaRequest objRequest = new MonedaRequest("2.50", "", "");

        assertEquals(ResponseHandler.generateResponse("Atributos Vacíos", HttpStatus.PARTIAL_CONTENT, null),
                tipoCambioService.cambiar(objRequest));
    }

    @Test
    public void getTipoCambioTestWrongBadge() {
        MonedaRequest objRequest = new MonedaRequest("2.50", "USB", "PEN");

        assertEquals(ResponseHandler.generateResponse("Tipo de Cambio no encontrado", HttpStatus.INTERNAL_SERVER_ERROR, null),
                tipoCambioService.cambiar(objRequest));
    }

    @Test
    public void getTipoCambioTestWrongValues() {
        MonedaRequest objRequest = new MonedaRequest("2.5O", "USD", "PEN");

        assertEquals(ResponseHandler.generateResponse("Valores Erróneos", HttpStatus.BAD_REQUEST, null),
                tipoCambioService.cambiar(objRequest));
    }

    @Test
    public void getTipoCambioTestGeneralError() {
        MonedaRequest objRequest = new MonedaRequest("2.50", "USD", "PEN");

        assertEquals(ResponseHandler.generateResponse("Error", HttpStatus.NO_CONTENT, null),
                tipoCambioService.cambiar(objRequest));
    }
    @Test
    public void getTipoCambioTestNoErrors() {
        MonedaRequest objRequest = new MonedaRequest("2.50", "USD", "PEN");

        MonedaResponse obj = new MonedaResponse("2.50", "9.23", "Dolar Estadounidense", "Nuevo Sol Peruano", "3.692");

        assertEquals(ResponseHandler.generateResponse("Monto cambiado", HttpStatus.OK, obj),
                tipoCambioService.cambiar(objRequest));
    }

    @Test
    public void updateTipoCambioTestNull() {
        MonedaRequest objRequest = new MonedaRequest("3.692", null, "PEN");

        assertEquals(ResponseHandler.generateResponse("Datos incompletos", HttpStatus.PARTIAL_CONTENT, null),
                tipoCambioService.actualizar(objRequest));
    }

    @Test
    public void updateTipoCambioTestEmpty() {
        MonedaRequest objRequest = new MonedaRequest("3.692", "", "");

        assertEquals(ResponseHandler.generateResponse("Atributos Vacíos", HttpStatus.PARTIAL_CONTENT, null),
                tipoCambioService.actualizar(objRequest));
    }

    @Test
    public void updateTipoCambioTestWrongBadge() {
        MonedaRequest objRequest = new MonedaRequest("3.692", "USB", "PEN");

        assertEquals(ResponseHandler.generateResponse("Tipo de Cambio no encontrado", HttpStatus.INTERNAL_SERVER_ERROR, null),
                tipoCambioService.actualizar(objRequest));
    }

    @Test
    public void updateTipoCambioTestWrongValues() {
        MonedaRequest objRequest = new MonedaRequest("3.69O", "USD", "PEN");

        assertEquals(ResponseHandler.generateResponse("Valores Erróneos", HttpStatus.BAD_REQUEST, null),
                tipoCambioService.actualizar(objRequest));
    }

    @Test
    public void updateTipoCambioTestGeneralError() {
        MonedaRequest objRequest = new MonedaRequest("3.692", "USD", "PEN");

        assertEquals(ResponseHandler.generateResponse("Error", HttpStatus.NO_CONTENT, null),
                tipoCambioService.actualizar(objRequest));
    }
    @Test
    public void updateTipoCambioTestNoErrors() {
        MonedaRequest objRequest = new MonedaRequest("3.692", "USD", "PEN");

        TipoCambio obj = new TipoCambio(5L, new Moneda(2L, "Dolar Estadounidense", "USD"), new Moneda(1L, "Nuevo Sol Peruano", "PEN"), 3.692);

        assertEquals(ResponseHandler.generateResponse("Tipo de Cambio Actualizado", HttpStatus.OK, obj),
                tipoCambioService.actualizar(objRequest));
    }
}
