package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int ID;
    private ArrayList<DisciplinaCursada> disciplinas = new ArrayList<>();
    private static ArrayList <Aluno> alunos = new ArrayList<>();

    private static int contadorDeAlunos = 1;

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

    public static Aluno ID(int ID){
        return alunos.get(ID-1);
    }
    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Aluno ID: " + ID + " | " + nome;
    }
}
