package web.tcs.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonedaRequest {
    private String monto;
    private String monedaOrigen;
    private String monedaDestino;

    @Override
    public String toString() {
        return "MonedaRequest{" +
                "monto=" + monto +
                ", monedaOrigen='" + monedaOrigen + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                '}';
    }
}
