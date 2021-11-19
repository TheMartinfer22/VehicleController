package team.martin.controlador.utils;

public class CpfUltis {
    public static int trataCPF(String cpf) {
        String cpfTratado = cpf;
        if (cpfTratado.contains("-")) {
            cpfTratado.replace("-", "");
        } else if (cpfTratado.contains(".")) {
            cpfTratado.replace(".", "");
        }
        return Integer.parseInt(cpfTratado);
    }
}
