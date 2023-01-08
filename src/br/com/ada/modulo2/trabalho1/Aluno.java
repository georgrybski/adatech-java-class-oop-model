package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private ArrayList<DisciplinaCursada> disciplinas = new ArrayList<>();
    static ArrayList <Aluno> aluno = new ArrayList<>();

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;

    }

    static public void adicionarAluno(Aluno recebeAluno){
        aluno.add(recebeAluno);
    }

    public void imprimirAlunos(){
        for (Aluno s: aluno){
            System.out.println(s.nome +" "+ s.matricula);
        }
    }
}
