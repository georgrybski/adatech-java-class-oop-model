package br.com.ada.modulo2.trabalho1.utilidades;


import br.com.ada.modulo2.trabalho1.Professor;
import br.com.ada.modulo2.trabalho1.Turma;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Classe que lida com chamadas de métodos
 * relacionadas a menus destinados ao usuario.
 */
public class Menu {


    private static final String[] OPCOES1 =
            {"1 - Cadastrar Professor", "2 - Cadastrar Aluno",
            "3 - Lista de Professores", "4 - Lista de Alunos",
            "5 - Criar Turma", "6 - Lista de Turmas", "7 - Começar Aula" ,"8 - Imprimir Professor" , "9 - Sair"};


    private static String[] opcoesDeMenuDinamico(ArrayList<Professor> professores) {
        return professores.stream().map(Professor::toString).collect(Collectors.toList()).toArray(String[]::new);
    }

    public static Professor professores(){
        return Professor.ID(receberInt(opcoesDeMenuDinamico(Professor.getProfessores())));
    }

    public static void darAula() {
        var professor = professores();
        var turma = professor.
    }


    private Menu() {}

    public static int menuInicial() {
        return receberInt(OPCOES1);
    }

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
