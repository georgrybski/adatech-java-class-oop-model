package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int ID;
    private ArrayList<DisciplinaCursada> disciplinas = new ArrayList<>();
    private static ArrayList <Aluno> alunos = new ArrayList<>();

    private static int contadorDeAlunos;

    public Aluno(String nome){
        this.nome = nome;
        this.ID = contadorDeAlunos++;

    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<DisciplinaCursada> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno ID: " + ID + " | " + nome;
    }
}
