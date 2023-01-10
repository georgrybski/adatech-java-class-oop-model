package br.com.ada.modulo2.trabalho1.utilidades;

import br.com.ada.modulo2.trabalho1.Professor;
import br.com.ada.modulo2.trabalho1.Turma;

import java.util.ArrayList;

/**
 * Classe que lida com chamadas de métodos
 * relacionadas a menus destinados ao usuario.
 */
public class Menu {


    private static final String[] OPCOES1 =
            {"1 - Cadastrar Professor", "2 - Cadastrar Aluno",
            "3 - Cadastrar Turma", "4 - Lista de Professores",
            "5 - Lista de Alunos", "6 - Lista de Turmas", "7 - Iniciar Aula" ,"8 - Sair"};

    private Menu() {}

    public static int menuInicial() {
        return receberInt(OPCOES1);
    }

    private static String[] opcoesDeProfessores(ArrayList<Professor> professores) {
        return professores.stream().map(Professor::toString).toList().toArray(String[]::new);
    }

    public static Professor menuDeProfessores(){
    Impressora.imprimirMensagemFormatada("");
        return Professor.ID(receberInt(opcoesDeProfessores(Professor.getProfessores())));
    }

    private static String[] opcoesDeTurmas(ArrayList<Turma> turmas) {
        return turmas.stream().map(turma -> turma.getID() + " | Turma " + turma.getNome() ).toList().toArray(String[]::new);
    }

    public static Turma menuDeTurmas(ArrayList<Turma> turmas) {
        return Turma.ID(receberInt(opcoesDeTurmas(turmas)));
    }

    public static void iniciarAula() {
        Impressora.imprimirMensagemFormatada("Selecione um(a) professor(a) abaixo:");
        var professor = menuDeProfessores();
        var turmas = professor.getTurmas();
        if (!turmas.isEmpty()) {
            Impressora.imprimirMensagemFormatada("Selecione uma turma abaixo:");
            professor.darAula(menuDeTurmas(turmas));
        } else {
            Impressora.imprimirMensagemFormatada(professor.getNome() + " não está alocado a nenhuma turma");
        }
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
