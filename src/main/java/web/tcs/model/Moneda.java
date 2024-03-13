package web.tcs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "moneda")
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String abreviatura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
