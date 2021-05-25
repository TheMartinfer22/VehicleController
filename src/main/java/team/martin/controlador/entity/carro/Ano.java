package team.martin.controlador.entity.carro;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Ano {
    private String nome;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ano ano = (Ano) o;
        return Objects.equals(nome, ano.nome) && Objects.equals(codigo, ano.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo);
    }

    @Override
    public String toString() {
        return "Ano{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
