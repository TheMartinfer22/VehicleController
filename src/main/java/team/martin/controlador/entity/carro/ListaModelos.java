package team.martin.controlador.entity.carro;

import java.util.List;
import java.util.Objects;

public class ListaModelos {

    private List<Modelo> modelos;
    private List<Ano> anos;

    public List<Ano> getAnos() {
        return anos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setAnos(List<Ano> anos) {
        this.anos = anos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaModelos that = (ListaModelos) o;
        return Objects.equals(modelos, that.modelos) && Objects.equals(anos, that.anos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelos, anos);
    }

    @Override
    public String toString() {
        return "ListaModelos{" +
                "modelos=" + modelos +
                ", anos=" + anos +
                '}';
    }
}
