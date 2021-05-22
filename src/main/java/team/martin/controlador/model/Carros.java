package team.martin.controlador.model;

import javax.persistence.*;

@Entity
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String ano;

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }
}
