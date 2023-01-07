package br.com.ada.modulo2.trabalho1;

import java.util.ArrayList;

public class Professor {

    private String nome;
    private int ID;

    private static ArrayList<Professor> professores;
    private static int contadorDeID = 0;


    private Professor(String nome) {
        this.nome = nome;
        this.ID = contadorDeID++;
    }

    //    TODO
//    public static Double calcularMediaGlobal(Aluno aluno) {
//
//    }

    public static void contratarProfessor(String nome) {
        professores.add(new Professor(nome));
    }

    public static void demitirProfessor(Professor professor) {

    }

    public static void demitirProfessor(int ID) {
        demitirProfessor(Professor.ID(ID));
    }

    public static Professor ID(int ID) {
        return professores.get(ID-1);
    }
}
