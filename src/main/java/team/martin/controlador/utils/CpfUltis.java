package team.martin.controlador.utils;

import java.util.InputMismatchException;

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
    public static boolean cpfValido(String cpf) {
        String cpfTratado = trataCPF(cpf);
        char digito10, digito11;
        int peso, num, sm, r, i;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpfTratado.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                digito10 = '0';
            else digito10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpfTratado.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                digito11 = '0';
            else digito11 = (char) (r + 48);

            if ((digito10 == cpfTratado.charAt(9)) && digito11 == cpfTratado.charAt(10))
                return true;
            else
                return false;
        } catch (InputMismatchException e) {
            return false;
        }
    }
}
