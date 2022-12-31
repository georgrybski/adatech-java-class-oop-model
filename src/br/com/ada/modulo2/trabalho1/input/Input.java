package br.com.ada.modulo2.trabalho1.input;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private Input() {}
    
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
                    scn.nextDouble();
                default:
                    return null;
            }
        } catch (InputMismatchException e) {
            return null;
        }
    }

    public static String receberString() {
        String string = (String) inputTipo("String");
        if (string != null) {
            return string;
        }
        return receberString();
    }

    public static int receberInt() {
        Integer integer = (Integer) inputTipo("int");
        if (integer != null) {
            return integer.intValue();
        }
        return receberInt();
    }

    public static double receberDouble() {
        Double doub = (Double) inputTipo("double");
        if (doub != null) {
            return doub.doubleValue();
        }
        return receberDouble();
    }

}
