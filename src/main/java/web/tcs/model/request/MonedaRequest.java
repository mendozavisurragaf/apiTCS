package web.tcs.model.request;

public class MonedaRequest {
    private String monto;
    private String monedaOrigen;
    private String monedaDestino;

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    @Override
    public String toString() {
        return "MonedaRequest{" +
                "monto='" + monto + '\'' +
                ", monedaOrigen='" + monedaOrigen + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                '}';
    }
}
