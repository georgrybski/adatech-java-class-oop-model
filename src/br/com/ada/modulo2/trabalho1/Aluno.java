package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private ArrayList<DisciplinaCursada> disciplinas = new ArrayList<>();
    private static int contadorDeID = 1;
    static ArrayList <Aluno> alunos = new ArrayList<>();

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;

    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<DisciplinaCursada> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
