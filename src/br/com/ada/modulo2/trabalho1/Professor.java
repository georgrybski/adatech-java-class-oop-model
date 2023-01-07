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
}
