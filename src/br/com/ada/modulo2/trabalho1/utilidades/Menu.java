package br.com.ada.modulo2.trabalho1.utilidades;

import br.com.ada.modulo2.trabalho1.Aluno;
import br.com.ada.modulo2.trabalho1.Coordenacao;
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

    /**
     * Converte o ArrayList de professores em um String[] que será usado para fazer um menu
     * @param professores: ArrayList contendo todos professores
     * @return Array de String contendo o nome e ID de cada professor
     */
    private static String[] opcoesDeProfessores(ArrayList<Professor> professores) {
        return professores.stream().map(Professor::toString).toList().toArray(String[]::new);
    }

    /**
     * Cria um menu apresentando todos professores e seus IDs
     * recebe do usuário o input numérico e converte ele no respectivo professor
     * @return: Professor selecionado pelo usuário
     */
    public static Professor menuDeProfessores(){
    Impressora.imprimirMensagemFormatada("");
        return Professor.ID(receberInt(opcoesDeProfessores(Professor.getProfessores())));
    }

    /**
     * Converte o ArrayList de turmas em um String[] que será usado para fazer um menu
     * @param turmas: ArrayList contendo todos professores
     * @return Array de String contendo o nome e ID de cada turma
     */
    private static String[] opcoesDeTurmas(ArrayList<Turma> turmas) {
        return turmas.stream().map(turma -> turma.getID() + " | Turma " + turma.getNome() ).toList().toArray(String[]::new);
    }

    private static String[] opcoesDeAlunos() {
        return Aluno.getAlunos().stream().map(aluno -> aluno.getID() + " |  " + aluno.getNome() ).toList().toArray(String[]::new);
    }

    /**
     * Cria um menu apresentando todas turmas e seus IDs
     * recebe do usuário o input numérico e converte ele na respectiva turma
     * @return: Turma selecionada pelo usuário
     */
    public static Turma menuDeTurmas(ArrayList<Turma> turmas) {
        return Turma.ID(receberInt(opcoesDeTurmas(turmas)));
    }

    public static Aluno menuDeAunos(){
        return Aluno.ID(receberInt(opcoesDeAlunos()));
    }

    /**
     * Cria menus e permite que o usuário selecione um professor e uma turma para representar uma aula
     * Imprime uma mensagem informando que a aula foi iniciada
     */
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

    public static void AdicionarAlunoATurma(){
        var aluno = menuDeAunos();
        Coordenacao.adicionarAlunoATurma(aluno,menuDeTurmas(Turma.getTurmas()));
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
