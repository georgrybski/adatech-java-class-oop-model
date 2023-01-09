package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Input;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private Professor professor;
    private int ID;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Turma> turmas = new ArrayList<>();
    private static int contadorDeTurmas = 1;


    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        ID = contadorDeTurmas;
    }

    public String getNome() {
        return nome;
    }

    public static Turma ID(int id) {
        return turmas.get(id-1);
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

    public static int getContadorDeTurmas() {
        return contadorDeTurmas;
    }

    @Override
    public String toString() {
        return "Turma " + nome + " | ID " + ID  + " | Professor: " + professor.getNome() + " |  Número de alunos: " + alunos.size();
    }


}
