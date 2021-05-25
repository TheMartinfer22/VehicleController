package team.martin.controlador.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import team.martin.controlador.entity.carro.Ano;
import team.martin.controlador.entity.carro.Marca;
import team.martin.controlador.entity.carro.Modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverrides( // Mapeamento
            {
                    @AttributeOverride(
                            name = "codigo",
                            column = @Column(name = "marca_codigo")
                    ),
                    @AttributeOverride(
                            name = "nome",
                            column = @Column(name = "marca_nome")
                    )
            }
    )

    @NotNull
    private Marca marca;
    @AttributeOverrides(
            {
                    @AttributeOverride(
                            name = "codigo",
                            column = @Column(name = "modelo_codigo")
                    ),
                    @AttributeOverride(
                            name = "nome",
                            column = @Column(name = "modelo_nome")
                    )
            }
    )
    @NotNull
    private Modelo modelo;
    @AttributeOverrides(
            {
                    @AttributeOverride(
                            name = "codigo",
                            column = @Column(name = "ano_codigo")
                    ),
                    @AttributeOverride(
                            name = "nome",
                            column = @Column(name = "ano_nome")
                    )
            }
    )

    @NotNull
    private Ano ano;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) && Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo) && Objects.equals(ano, carro.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, ano);
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAno(Ano ano) {
        this.ano = ano;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public Ano getAno() {
        return ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

//    @JsonProperty(value = "tem_rodizio")
    public boolean isRodizio(){

//        Calendar c = Calendar.getInstance();
//
//        if (getAno().getNome().startsWith("0",3) & (c.getTime().toString().startsWith("Mon"))){
//            return true;
//        }
//        if (getAno().getNome().startsWith("1",3) & (c.getTime().toString().startsWith("Mon"))){
//            return true;
//        }
//        if (getAno().getNome().startsWith("8",3) & (c.getTime().toString().startsWith("Mon"))){
//            return true;
//        }
        return false; //TODO
   }
}