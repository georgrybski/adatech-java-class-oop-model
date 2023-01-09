package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private ArrayList<Aluno> alunos;
    private static ArrayList<Turma> turmas = new ArrayList<>();

    private Professor professor;

    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public static ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Turma " + nome + " | Professor: " + professor.getNome() + " |  Número de alunos: " + alunos.size();
    }


}
