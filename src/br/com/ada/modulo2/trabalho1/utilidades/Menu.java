package br.com.ada.modulo2.trabalho1.utilidades;


/**
 * Classe que lida com chamadas de métodos
 * relacionadas a menus destinados ao usuario.
 */
public class Menu {

    /**
     * Imprime um menu e retorna valor inserido pelo usuário.
     * @param opcoes: Array de String, com cada String representando uma opção para o menu
     *              (Ex: {"1- Opção 1", "2- Opção 2", "3- Opção 3"}
     *              Serão aceitos valores de 1 até opcoes.length().
     * @return int
     */
    public static int receberInt(String[] opcoes) {
        String prompt = "Insira um valor entre " + 1 + " e " + opcoes.length;
        String msgValorInvalido = "Valor inválido! " + prompt;
        return  Input.receberIntEmMenu(opcoes, 1, opcoes.length, prompt,
                                       msgValorInvalido, true);
    }

}
