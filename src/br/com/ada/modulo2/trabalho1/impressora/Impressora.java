package br.com.ada.modulo2.trabalho1.impressora;

public class Impressora {

    private static int comprimentoDelinha =  82;

    private Impressora() {}

    public static void imprimirMensagemFormatada(String mensagem) {
        imprimirLinhaDelimitadora();

        boolean mensagemMaiorQueLinha = (mensagem.length() > comprimentoDelinha - 6);
        if (mensagemMaiorQueLinha) {
            imprimirStringMultiLinhasFormatada(mensagem);
        } else {
            imprimirLinhaIndentadaFormatada(mensagem);
        }
        imprimirLinhaDelimitadora();
    }

    public static void imprimirMenuComOpcoes(String[] opcoes) {

        String[][] matrizDeOpcoes = retornarMatrizDeComponentesParaMenu(opcoes);
        imprimirLinhaDelimitadora();
        String linhaExternaDosBotoes = "", linhaInternaDosBotoes = "";

        for (int i = 0, opcoesAdicionadas = 0; i < matrizDeOpcoes.length; i++) {

            boolean opcaoCabeNaLinha =
                    (matrizDeOpcoes[i][1].length() +linhaInternaDosBotoes.length() < comprimentoDelinha - 4);

            if (opcaoCabeNaLinha) {
                String textoDaOpcao = matrizDeOpcoes[i][0], delimitadorDaOpcao = matrizDeOpcoes[i][1];
                linhaInternaDosBotoes += textoDaOpcao + " ".repeat(2);
                linhaExternaDosBotoes += delimitadorDaOpcao + " ".repeat(2);
                opcoesAdicionadas++;
            }

            if (!opcaoCabeNaLinha || i == matrizDeOpcoes.length - 1) {
                String diferencialParOuImpar =
                        " ".repeat((comprimentoDelinha - linhaInternaDosBotoes.trim().length()) % 2);
                String espacosDeCadaLado =
                        " ".repeat((comprimentoDelinha - linhaInternaDosBotoes.trim().length()) / 2);

                imprimirLinhaComOpcoes(espacosDeCadaLado, linhaInternaDosBotoes,
                        linhaExternaDosBotoes, diferencialParOuImpar);

                String textoDaOpcao = matrizDeOpcoes[i][0], delimitadorDaOpcao = matrizDeOpcoes[i][1];
                linhaExternaDosBotoes = "" + delimitadorDaOpcao + " ".repeat(2);
                linhaInternaDosBotoes = "" + textoDaOpcao + " ".repeat(2);

                if(i == matrizDeOpcoes.length -1 && opcoesAdicionadas != i && i % 2 != 0 && matrizDeOpcoes.length >2) {
                    diferencialParOuImpar =
                            " ".repeat((comprimentoDelinha - linhaInternaDosBotoes.trim().length()) % 2);
                    espacosDeCadaLado =
                            " ".repeat((comprimentoDelinha - linhaInternaDosBotoes.trim().length()) / 2);

                    imprimirLinhaComOpcoes(espacosDeCadaLado, linhaInternaDosBotoes,
                            linhaExternaDosBotoes, diferencialParOuImpar);
                }
            }
        }
        imprimirLinhaDelimitadora();
    }

    private static void imprimirLinhaDelimitadora() {
        System.out.println("+" + "-".repeat(comprimentoDelinha) + "+");
    }

    private static void imprimirStringMultiLinhasFormatada(String string) {
        String arrayDeStrings[] = string.trim().split(" "), linhaAtual = "";

        for (int indice = 0; indice < arrayDeStrings.length; indice ++) {

            String palavra = arrayDeStrings[indice];

            boolean palavraCabeNaLinha =
                    (palavra.length() + linhaAtual.length() + 1 < comprimentoDelinha -6);

            if (palavraCabeNaLinha) {
                linhaAtual += palavra + " ";
            } else {
                imprimirLinhaIndentadaFormatada(linhaAtual);
                linhaAtual = palavra + " ";
            }

            boolean ultimaLinha = (indice == arrayDeStrings.length -1);
            if (ultimaLinha) {
                imprimirLinhaIndentadaFormatada(linhaAtual);
                return;
            }
        }
    }

    private static void imprimirLinhaIndentadaFormatada(String linha) {
        int numDeEspacos = (comprimentoDelinha - linha.length());
        int espacosDeCadaLado = numDeEspacos / 2;
        int diferencialParOuImpar = numDeEspacos % 2;

        String linhaFormatada = "|" + " ".repeat(espacosDeCadaLado) +
                linha +
                " ".repeat(espacosDeCadaLado + diferencialParOuImpar) +"|";

        System.out.println(linhaFormatada);
    }

}
