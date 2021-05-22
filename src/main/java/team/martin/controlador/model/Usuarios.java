package team.martin.controlador.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String cpf;
    private LocalDate nascimento;

    public String getCpf() {
        return cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return id.equals(usuarios.id) && email.equals(usuarios.email) && cpf.equals(usuarios.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, cpf);
    }
}
