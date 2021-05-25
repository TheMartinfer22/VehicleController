package team.martin.controlador.dto;

public class UserDTO {
    private Long id;
    private String email;
    private String cpf;

    public UserDTO(Long id, String email, String cpf) { // SRP - Principio da responsabilidade única
        this.id = id;
        this.email = email;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
