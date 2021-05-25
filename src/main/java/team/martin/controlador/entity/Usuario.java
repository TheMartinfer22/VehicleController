package team.martin.controlador.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "usuario")
public class Usuario {

    public Usuario(){
        // Solução para o problema "org.hibernate.InstantiationException: No default constructor for entity"
        // http://www.mauda.com.br/?p=632
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Size(max = 20)
    private String email;

    @NotBlank
    @Size(max = 12)
    private String cpf;
    private LocalDate nascimento;

    @OneToMany
    private Set<Carro> carros;

    public Usuario(Set<Carro> carros) {
        this.carros = carros;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) && email.equals(usuario.email) && cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, cpf);
    }
}
