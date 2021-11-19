package team.martin.controlador.utils.exceptions;

public class DadosInvalidos extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DadosInvalidos(String mensagem){
        super(mensagem);
    }
}
