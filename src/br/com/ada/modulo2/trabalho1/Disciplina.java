package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private ArrayList<Professor> professores = new ArrayList<>();

    static private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina(String nome) {
        this.nome = nome;
    }

    static void criarDisciplina(String nome){
        disciplinas.add(new Disciplina(nome));
    }
    static void criarDisciplina(String nome, Professor professor){
        Disciplina disciplina = new Disciplina(nome);
        disciplinas.add(disciplina);
        disciplina.professores.add(professor);
    }






}
