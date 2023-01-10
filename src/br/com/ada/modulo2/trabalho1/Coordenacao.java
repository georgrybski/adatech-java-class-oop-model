package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;

import java.util.ArrayList;

public class Coordenacao {

    private Coordenacao() {}

    public static void matricularAluno(String nome) {
        Aluno.getAlunos().add(new Aluno(nome));
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
        Turma turma = new Turma(nome, professor);
         Turma.getTurmas().add(turma);
         professor.getTurmas().add(turma);
    }

    public static void listarTurmas() {
        for (Turma turma : Turma.getTurmas()) {
            Impressora.imprimirMensagemFormatada(turma.toString());
        }
        Impressora.imprimirMensagemFormatada("^ Lista de Turmas ^");
    }

    public static void adicionarAlunoATurma(Aluno aluno, Turma turma){
        if(!turma.getAlunos().contains(aluno)) {
            turma.getAlunos().add(aluno);
        } else {
            Impressora.imprimirMensagemFormatada(aluno.getNome() + " já está na turma " + turma.getNome());
        }
    }
}


