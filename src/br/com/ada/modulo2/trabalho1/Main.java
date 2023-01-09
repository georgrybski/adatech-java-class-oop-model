package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Menu;

public class Main {
    public static void main(String[] args) {
        Coordenacao.contratarProfessor("Georg");
        Coordenacao.contratarProfessor("Marcus");
        Coordenacao.contratarProfessor("João");
        Coordenacao.contratarProfessor("Roberto");
        Coordenacao.contratarProfessor("Cláudia");

        Coordenacao.listarProfessores();

        Coordenacao.criarTurma("Back End 924", Professor.ID(1));
        Coordenacao.criarTurma("Back End 925", Professor.ID(2));
        Coordenacao.criarTurma("Back End 926", Professor.ID(3));

        Coordenacao.listarTurmas();
    }
}
