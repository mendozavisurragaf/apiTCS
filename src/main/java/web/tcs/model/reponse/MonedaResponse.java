package web.tcs.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonedaResponse {
    private String monto;
    private String montoTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private String tipoCambio;

    @Override
    public String toString() {
        return "MonedaResponse{" +
                "monto='" + monto + '\'' +
                ", montoTipoCambio='" + montoTipoCambio + '\'' +
                ", monedaOrigen='" + monedaOrigen + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                ", tipoCambio='" + tipoCambio + '\'' +
                '}';
    }
}
