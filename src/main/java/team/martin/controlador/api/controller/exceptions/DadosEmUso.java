package team.martin.controlador.api.controller.exceptions;

public class DadosEmUso extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DadosEmUso(String mensagem){
        super(mensagem);
    }
}
