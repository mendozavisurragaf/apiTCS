package web.tcs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipoCambio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Moneda monedaOrigen;
    @ManyToOne
    private Moneda monedaDestino;
    @Column
    private Double cambio;

    @Override
    public String toString() {
        return "TipoCambio{" +
                "id=" + id +
                ", monedaOrigen=" + monedaOrigen.getNombre() +
                ", monedaDestino=" + monedaDestino.getNombre() +
                ", cambio='" + cambio + '\'' +
                '}';
    }
}
