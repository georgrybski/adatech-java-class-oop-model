package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;

public class Coordenacao {

    private Coordenacao() {}

    public static void matricularAluno(String nome, String matricula) {
        Aluno.getAlunos().add(new Aluno(nome, matricula));
    }

    public static void listarAlunos() {
        for (Aluno alunos : Aluno.getAlunos()) {
            Impressora.imprimirMensagemFormatada(alunos.toString());
        }
    }

    public static void contratarProfessor(String nome) {
        Professor.getProfessores().add(new Professor(nome));
    }

    public static void listarProfessores() {
        for (Professor professor : Professor.getProfessores()) {
            Impressora.imprimirMensagemFormatada(professor.toString());
        }
        Impressora.imprimirMensagemFormatada("^ Lista de professores ^");
    }

    public static void criarTurma(String nome, Professor professor) {
         Turma.getTurmas().add(new Turma(nome, professor));
    }

    public static void listarTurmas() {
        for (Turma turma : Turma.getTurmas()) {
            Impressora.imprimirMensagemFormatada(turma.toString());
        }
        Impressora.imprimirMensagemFormatada("^ Lista de Turmas ^");
    }

}


