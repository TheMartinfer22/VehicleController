package team.martin.controlador.utils;

public class CpfUltis {
    public static String trataCPF(String cpf) {
        String cpfTratado = cpf;
        if (cpfTratado.contains("-")) {
            cpfTratado.replace("-", "");
        } else if (cpfTratado.contains(".")) {
            cpfTratado.replace(".", "");
        }
        return cpfTratado;
    }
}
