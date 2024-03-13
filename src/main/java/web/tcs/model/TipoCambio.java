package web.tcs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoCambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Moneda monedaOrigen;
    @ManyToOne
    private Moneda monedaDestino;
    @Column
    private String cambio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(Moneda monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Moneda monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    @Override
    public String toString() {
        return "TipoCambio{" +
                "id=" + id +
                ", monedaOrigen=" + monedaOrigen +
                ", monedaDestino=" + monedaDestino +
                ", cambio='" + cambio + '\'' +
                '}';
    }
}
