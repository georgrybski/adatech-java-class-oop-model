package br.com.ada.modulo2.trabalho1.utilidades;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que lida com todas as entradas pelo usuario.
 */
public class Input {

    private Input() {}

    public static String receberString(String prompt) {
        return receberString(prompt, true);
    }

    /**
     * Método que chama inputTipo passando o argumento "String".
     * Checa se o valor retornado é valido, caso seja, o retorna, caso não, faz chamada recursiva do prórprio método.
     * @return String
     */
    private static String receberString(String prompt, boolean primeiraTentativa) {
        String string = (String) inputTipo("String", "Entrada inváida, " + prompt, prompt, primeiraTentativa );
        if (string != null && !string.isEmpty() && !string.isBlank()) {
            return string;
        }
        return receberString(prompt, false);
    }

    /**
     * Imprime um prompt e recebe um valor int do usuario,
     * passa também uma mensagem a ser utilizada caso input não seja valido
     * Sobrecarga do método receberInt.
     * @param prompt: String a ser impressa apenas uma vez (durante ínicio) passando as instruções ao usuario
     * @param msgValorInvalido: String a ser impressa caso o valor nõo seja válido
     * @param min: valor mínimo aceito.
     * @param max: valor máximo aceito.
     * @return int
     */
    protected static int receberIntEmMenu(String[] opcoes, int min, int max, String prompt,
                                        String msgValorInvalido, boolean primeiraTentativa) {

        Impressora.imprimirMenuComOpcoes(opcoes);
        Integer input = (Integer) inputTipo("int", msgValorInvalido, prompt, primeiraTentativa);
        if (input != null) {
            if (input >= min && input <= max) {
                return input;
            }
        }
        return receberIntEmMenu(opcoes, min, max, prompt, msgValorInvalido, false);
    }

    /**
     * Retorna um int, imprimindo instruções quanto ao intervalo de valores aceitos
     * e imprimindo uma mensagem caso o valor recebido esteja fora dos parâmetros
     * Sobrecarga do método receberInt.
     * chama receberInt passando verdadeiro para o argumento primeiraTentativa
     * @param min: valor mínimo aceito.
     * @param max: valor máximo aceito.
     * @param prompt: String da mensagem que deve ser impressa na primeira chamada do método inputTipo
     * @param msgValorInvalido: String a ser impressa caso o valor nõo seja válido
     * @return int
     */
    public static int receberInt(int min, int max, String prompt, String msgValorInvalido) {
        return receberInt(min, max, prompt, msgValorInvalido, true);
    }

    /**
     * Sobrecarga do método receberInt.
     * Checa se o valor int retornado pelo receberInt está entre min e max (de forma inclusiva), caso seja, o retorna,
     * caso não, faz chamada recursiva do prórprio método.
     * @param min: valor mínimo aceito.
     * @param max: valor máximo aceito.
     * @param prompt: String da mensagem que deve ser impressa na primeira chamada do método inputTipo
     * @param msgValorInvalido: String a ser impressa caso o valor nõo seja válido
     * @param primeiraTentativa: verdadeiro caso seja a primeira vez que o método é chamado dentro de sua sobrecarga
     * @return int
     */
    private static int receberInt(int min, int max, String prompt, String msgValorInvalido, boolean primeiraTentativa) {
        Integer input = (Integer) inputTipo("int", msgValorInvalido, prompt, primeiraTentativa);
        if (input != null) {
            if (input >= min && input <= max) {
                return input;
            }
        }
        return receberInt(min, max, prompt, msgValorInvalido, false);
    }

    /**
     * Retorna um double, imprimindo instruções quanto ao intervalo de valores aceitos
     * e imprimindo uma mensagem caso o valor recebido esteja fora dos parâmetros
     * Sobrecarga do método receberInt.
     * chama receberDouble passando verdadeiro para o argumento primeiraTentativa
     * @param min: valor mínimo aceito.
     * @param max: valor máximo aceito.
     * @param prompt: String da mensagem que deve ser impressa na primeira chamada do método inputTipo
     * @param msgValorInvalido: String a ser impressa caso o valor nõo seja válido
     * @return int
     */

    public static Double receberDouble(double min, double max, String prompt, String msgValorInvalido) {
        return receberDouble(min, max, prompt, msgValorInvalido, true);
    }

    /**
     * Sobrecarga do método receberInt.
     * Checa se o valor double retornado pelo receberDouble está entre min e max (de forma inclusiva), caso seja, o retorna,
     * caso não, faz chamada recursiva do prórprio método.
     * @param min: valor mínimo aceito.
     * @param max: valor máximo aceito.
     * @return double
     */
    private static double receberDouble(double min, double max, String prompt, String msgValorInvalido, boolean primeiraTentativa) {
        Double input = (Double) inputTipo("double", msgValorInvalido, prompt, primeiraTentativa);
        if (input != null) {
            if (input >= min && input <= max) {
                return input;
            }
        }
        return receberDouble(min, max, prompt, msgValorInvalido, false);
    }

    /**
     * Método base que lida com todas entradas.
     * escolhendo se recebe String, double ou int baseado no argumento tipo (String).
     * @param tipo (String)
     * @return Object
     */
    private static Object inputTipo(String tipo, String msgValorInvalido, String prompt, boolean primeiraTentativa) {
        Scanner scn = new Scanner(System.in);
        String mensagem;
        if (!primeiraTentativa) {
            mensagem = msgValorInvalido;
        }
        else {
            mensagem = prompt;
        }
        Impressora.imprimirMensagemFormatada(mensagem);
        try {
            switch(tipo) {
                case ("String"):
                    return scn.nextLine();
                case ("int"):
                    return scn.nextInt();
                case("double"):
                    return scn.nextDouble();
                default:
                    return null;
            }
        } catch (InputMismatchException e) {
            return null;
        }
    }
}
