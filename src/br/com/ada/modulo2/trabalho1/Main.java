package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;
import br.com.ada.modulo2.trabalho1.utilidades.Input;
import br.com.ada.modulo2.trabalho1.utilidades.Menu;

public class Main {
    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando){
            switch (Menu.menuInicial()) {

                // Cadastrar Professor
                case 1:
                    Coordenacao.contratarProfessor(Input.receberString("Insira o nome do(a) Professor(a)"));
                    break;

                // Cadastrar Aluno
                case 2:
                    Coordenacao.matricularAluno(Input.receberString("Insira o nome do(a) aluno(a)"));
                    break;

                // Cadastrar Turma
                case 3:
                    if(Professor.getProfessores().isEmpty()) {
                        Impressora.imprimirMensagemFormatada("Cadastre um professor antes de tentar criar uma turma");
                    } else {
                        Coordenacao.criarTurma(
                                Input.receberString("Insira o nome da turma"),
                                Professor.ID(
                                        Input.receberInt(1, Professor.getContadorDeID(),
                                                "Insira o ID do(a) professor(a)",
                                                ("Valor inválido, insira um ID entre + " +
                                                        1 + " e " + Professor.getContadorDeID())
                                        )
                                )
                        );
                    }

                // Listar Professores
                case 4:
                    Coordenacao.listarProfessores();
                    break;

                // Listar Alunos
                case 5:
                    Coordenacao.listarAlunos();
                    break;

                // Listar Turmas
                case 6:
                    Coordenacao.listarTurmas();
                    break;

                // Iniciar Aula
                case 7:
                    if(Professor.getProfessores().isEmpty()) {
                        Impressora.imprimirMensagemFormatada("Cadastre um professor antes de tentar começar uma aula");
                    } else {
                        Menu.iniciarAula();
                    }
                    break;

                // Sair
                case 8:
                    rodando = false;
                    Impressora.imprimirMensagemFormatada("Encerrando serviço");

            }
        }
    }



}
