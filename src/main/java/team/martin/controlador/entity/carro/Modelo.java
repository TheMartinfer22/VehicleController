package team.martin.controlador.entity.carro;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public
class Modelo {
    private String nome;
    private String codigo;

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(nome, modelo.nome) && Objects.equals(codigo, modelo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo);
    }
}
