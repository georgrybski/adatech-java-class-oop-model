package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;
import br.com.ada.modulo2.trabalho1.utilidades.Input;
import br.com.ada.modulo2.trabalho1.utilidades.Menu;

public class Main {
    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando){
            switch (Menu.menuInicial()) {

                // CADASTRAR PROFESSOR
                case 1:
                    Coordenacao.contratarProfessor(Input.receberString("Insira o nome do(a) Professor(a)"));
                    break;

                // CADASTRAR ALUNO
                case 2:
                    Coordenacao.matricularAluno(Input.receberString("Insira o nome do(a) aluno(a)"));
                    break;

                // CADASTRAR TURMA
                case 3:
                    if(Professor.getProfessores().isEmpty()) {
                        Coordenacao.contratarProfessor(Input.receberString("Insira o nome do(a) Professor(a)"));
                    }
                    Coordenacao.criarTurma(
                            Input.receberString("Insira o nome da turma"),
                            Menu.menuDeProfessores());
                    break;

                // LISTAR PROFESSORES
                case 4:
                    Coordenacao.listarProfessores();
                    break;

                // LISTAR ALUNOS
                case 5:
                    Coordenacao.listarAlunos();
                    break;

                // LISTAR TURMAS
                case 6:
                    Coordenacao.listarTurmas();
                    break;

                // INICIAR AULA
                case 7:
                    if(Professor.getProfessores().isEmpty()) {
                        Impressora.imprimirMensagemFormatada("Cadastre um professor antes de tentar começar uma aula");
                    } else {
                        Menu.iniciarAula();
                    }
                    break;

                // ADICIONAR ALUNO A UMA TURMA
                case 8:
                    if(Aluno.getAlunos().isEmpty()) {
                        Coordenacao.matricularAluno(Input.receberString("Insira o nome do(a) aluno(a)"));
                    }
                    Menu.AdicionarAlunoATurma();
                    break;

                // SAIR
                case 9:
                    rodando = false;
                    Impressora.imprimirMensagemFormatada("Encerrando serviço");

            }
        }
    }

}
