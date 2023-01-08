package br.com.ada.modulo2.trabalho1.utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Classe que lida com a manipulação de datas
 */
public class Tempo {

    public static boolean dataValida(String data) {
        try{
            var formatador =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data , formatador);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
