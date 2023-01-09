package br.com.ada.modulo2.trabalho1;

import br.com.ada.modulo2.trabalho1.utilidades.Impressora;
import br.com.ada.modulo2.trabalho1.utilidades.Input;
import br.com.ada.modulo2.trabalho1.utilidades.Menu;

public class Main {
    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando){
            switch (Menu.menuInicial()) {
                case 1:
                    Coordenacao.contratarProfessor(Input.receberString("Insira o nome do(a) Professor(a)"));
                    break;
                case 2:
                    Coordenacao.matricularAluno(Input.receberString("Insira o nome do(a) aluno(a)"));
                    break;
                case 3:
                    Coordenacao.listarProfessores();
                    break;
                case 4:
                    Coordenacao.listarAlunos();
                    break;
                case 5:
                    Coordenacao.listarProfessores();
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

                case 6:
                    Coordenacao.listarTurmas();
                    break;
                case 7:
                    rodando = false;
                    Impressora.imprimirMensagemFormatada("Encerrando serviço");
            }
        }
    }



}
