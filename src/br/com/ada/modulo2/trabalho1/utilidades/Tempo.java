package br.com.ada.modulo2.trabalho1.utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Classe que lida com a manipulação de datas
 */
public class Tempo {

    /**
     * Método que checa se a String inserida é uma data válida
     * @param data
     * @return boolean
      */
    public static boolean dataValida(String data) {
        var formatador =
                DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
        try{
            LocalDate.parse(data, formatador);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    /**
     * Método que retorna uma String da data atual no formato dd/mm/aaaa
     * @return String
     */
    public static String dataAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return agora.format(formatter);
    }

    /**
     * Método que retorna o número de anos entre a data fornecida (String no formato dd/mm/aaaa)
     * e a data atual
     * @param dataDeNascimento
     * @return int
     */
    public static int idade(String dataDeNascimento) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(dataDeNascimento, formatador);
        LocalDate now = LocalDate.now();
        Period idade = Period.between(nascimento, now);
        return idade.getYears();
    }
}
