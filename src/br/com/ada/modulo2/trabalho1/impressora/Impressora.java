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

            boolean ultimaIteracaoOuOpcaoNaoCabe = (!opcaoCabeNaLinha || i == matrizDeOpcoes.length - 1);
            if (ultimaIteracaoOuOpcaoNaoCabe) {
                String diferencialParOuImpar =
                        " ".repeat((comprimentoDelinha - linhaInternaDosBotoes.trim().length()) % 2);
                String espacosDeCadaLado =
                        " ".repeat((comprimentoDelinha - linhaInternaDosBotoes.trim().length()) / 2);

                imprimirLinhaComOpcoes(espacosDeCadaLado, linhaInternaDosBotoes,
                        linhaExternaDosBotoes, diferencialParOuImpar);

                String textoDaOpcao = matrizDeOpcoes[i][0], delimitadorDaOpcao = matrizDeOpcoes[i][1];
                linhaExternaDosBotoes = "" + delimitadorDaOpcao + " ".repeat(2);
                linhaInternaDosBotoes = "" + textoDaOpcao + " ".repeat(2);

                // Checar ultima iteração evita duplicidade de valores na quarta linha de botões
                boolean ultimaIteracao = (i == matrizDeOpcoes.length -1);

                // Checar se são mais de duas opções evita duplicidade de valores caso o menu tenha apenas duas opções
                // que normalmente não ocupariam a terceira linha.
                boolean maisDeDuasOpcoes = (matrizDeOpcoes.length >2);

                // Checar se o número de opções é impar ajuda a evitar duplicidade de valores na ultima linha em menu
                // com número de opções impar maior que 3.
                boolean numeroImparDeOpcoes = (i % 2 != 0);

                // Checar se o número de iterações é diferente do número de opções adicionada tinha o objetivo de evitar
                // que opções não fossem impressas, porém, nos ultimos testes utilizados não houve diferença.
                boolean numberodeOpcoesAdicionaisDiferenteDeNumeroDeIteracoes = (opcoesAdicionadas != i);

                boolean condicao = (ultimaIteracao && maisDeDuasOpcoes && numeroImparDeOpcoes
                        && numberodeOpcoesAdicionaisDiferenteDeNumeroDeIteracoes);

                if(condicao) {
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

    private static void imprimirLinhaComOpcoes(String espacosDeCadaLado, String linhaInternaDosBotoes, String linhaExternaDosBotoes, String diferencialParOuImpar) {
        String linhaExterna = "|" + espacosDeCadaLado + linhaExternaDosBotoes.trim() + espacosDeCadaLado +diferencialParOuImpar + "|";
        String linhaInterna = "|" + espacosDeCadaLado + linhaInternaDosBotoes.trim() + espacosDeCadaLado +diferencialParOuImpar + "|";

        System.out.println(linhaExterna);
        System.out.println(linhaInterna);
        System.out.println(linhaExterna);
    }

    private static String[][] retornarMatrizDeComponentesParaMenu(String[] opcoes) {
        String[][] matriz = new String[opcoes.length][2];
        for (int i = 0; i < opcoes.length; i++) {
            String opcao = opcoes[i];
            matriz[i][0] = "| " + opcao + " |";
            matriz[i][1] = "+" + "-".repeat(opcao.length() +2) + "+";
        }
        return matriz;
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
