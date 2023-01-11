package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;
import br.com.ada.modulo2.trabalho1.utilidades.Menu;

import java.util.ArrayList;

public class Coordenacao {

    private Coordenacao() {}

    public static void matricularAluno(String nome) {
        Aluno.getAlunos().add(new Aluno(nome));
    }

    public static void listarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        switch (Menu.receberInt(new String[]{"1 - Todos Alunos", "2 - Alunos em uma turma específica"})) {
            case 1:
                alunos = Aluno.getAlunos();
                break;
            case 2:
                var turma = Menu.menuDeTurmas(Turma.getTurmas());
                alunos = turma.getAlunos();
                break;

        }
        if (alunos.isEmpty()) {
            Impressora.imprimirMensagemFormatada("Não exitem alunos cadastrados nesta turma");
            return;
        }
        for (Aluno aluno : alunos) {
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


