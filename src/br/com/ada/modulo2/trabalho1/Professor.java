package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;

import java.util.ArrayList;

public class Professor {

    private String nome;
    private int ID;

    private static ArrayList<Professor> professores = new ArrayList<>();
    private static int contadorDeID = 1;


    public Professor(String nome) {
        this.nome = nome;
        this.ID = contadorDeID++;
    }

    // TODO
    //public double calcularMediaGlobal(Aluno aluno) {
    //}

    //    TODO
    //    public void aplicarProva(Turma turma) {
    //    }

    public void darAula(Turma turma) {
        String mensagem = this.nome + " está dando aula para a turma " + turma.getNome();
        Impressora.imprimirMensagemFormatada(mensagem);
    }

    public static void contratarProfessor(String nome) {
        professores.add(new Professor(nome));
    }

    public static void demitirProfessor(Professor professor) {
        professores.remove(professor);
    }

    public static void demitirProfessor(int ID) {
        demitirProfessor(Professor.ID(ID-1));
    }

    public static Professor ID(int ID) {
        return professores.get(ID-1);
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public static ArrayList<Professor> getProfessores() {
        return professores;
    }

    public static int getContadorDeID() {
        return contadorDeID;
    }

    @Override
    public String toString() {
        return "Professor ID " + ID + " | " + nome;
    }
}

