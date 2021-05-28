package team.martin.controlador.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import team.martin.controlador.entity.enums.DiaRodizio;
import team.martin.controlador.utils.StringUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carroID;


    @JsonProperty(value = "CodigoFipe")
    private String codigoFipe;

    @JsonProperty(value = "Marca")
    private String marca;

    @JsonProperty(value = "Modelo")
    private String modelo;

    @JsonProperty(value = "AnoModelo")
    private Integer ano;

    @JsonProperty(value = "Combustivel")
    private String combustivel;

    @JsonProperty(value = "MesReferencia")
    private String mesReferencia;

    @JsonProperty(value = "SiglaCombustivel")
    private String siglaCombustivel;

    @JsonProperty(value = "Valor")
    private String valor;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @Transient
    private boolean rodizio;

    @Transient
    private DiaRodizio diaRodizio;

    public Carro(Long carroID, String marca, String modelo, String valor) {
    }
    public Carro(){

    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return codigoFipe.equals(carro.codigoFipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoFipe);
    }

    public Long getId() {
        return carroID;
    }

    public void setId(Long id) {
        this.carroID = id;
    }

    public DiaRodizio getDiaRodizio() {
        return DiaRodizio.getFromRange(StringUtils.getLastStringFromValue(this.ano.toString()));
    }

    public boolean isRodizio() {
        LocalDate today = LocalDate.now();
        return DiaRodizio.getFromDayOfWeek(today.getDayOfWeek().getValue()) == this.getDiaRodizio();
    }
}
