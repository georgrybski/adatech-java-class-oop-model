package br.com.ada.modulo2.trabalho1.input;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que lida com todas as entradas pelo usuario.
 */
public class Input {

    private Input() {}

    // TODO: Avaliar necessidade de adicionar chamadas do Impressora dentro dos
    //  métodos (Imprimir os prompts e ou menus relacioados ao input pedido.

    /**
     * Método que chama inputTipo passando o argumento "String".
     * Checa se o valor retornado é valido, caso seja, o retorna, caso não, faz chamada recursiva do prórprio método.
     * @return String
     */
    public static String receberString() {
        String string = (String) inputTipo("String");
        if (string != null) {
            return string;
        }
        return receberString();
    }

    /**
     * Método que chama inputTipo passando o argumento "int".
     * Checa se o valor retornado é valido, caso seja, o retorna, caso não, faz chamada recursiva do prórprio método.
     * @return int
     */
    public static int receberInt() {
        Integer integer = (Integer) inputTipo("int");
        if (integer != null) {
            return integer.intValue();
        }
        return receberInt();
    }

    /**
     * Método que chama inputTipo passando o argumento "double".
     * Checa se o valor retornado é valido, caso seja, o retorna, caso não, faz chamada recursiva do prórprio método.
     * @return double
     */
    public static double receberDouble() {
        Double doub = (Double) inputTipo("double");
        if (doub != null) {
            return doub.doubleValue();
        }
        return receberDouble();
    }

    /**
     * Método base que lida com todas entradas.
     * escolhendo se recebe String, double ou int baseado no argumento tipo (String).
     * @param tipo (String)
     * @return Object
     */
    private static Object inputTipo(String tipo) {
        Scanner scn = new Scanner(System.in);
        Object input;
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
