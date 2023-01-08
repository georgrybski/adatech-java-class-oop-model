package br.com.ada.modulo2.trabalho1.utilidades;

/**
 * Classe que lida com a impressão de menus e prompts para o usuario.
 */
public class Impressora {

    // Comprimento usado para imprimir os menus e mensagens.
    private static final int COMPRIMENTO_DE_LINHA =  82;

    private Impressora() {}


    /**
     * É um método que imprime uma String destinada ao usuario, de forma formatada.
     * Recebe uma String como argumento.
     */
    public static void imprimirMensagemFormatada(String mensagem) {
        imprimirLinhaDelimitadora();

        boolean mensagemMaiorQueLinha = (mensagem.length() > COMPRIMENTO_DE_LINHA - 6);
        if (mensagemMaiorQueLinha) {
            imprimirStringMultiLinhasFormatada(mensagem);
        } else {
            imprimirLinhaIndentadaFormatada(mensagem);
        }
        imprimirLinhaDelimitadora();
    }


    /**
     * É um método que imprime um menu formatado.
     * Recebe um array de Strings, onde cada String representa uma opção.
     * As opções são colocadas dentro de "caixas" e estas, são colocadas juntas em uma "caixa" maior.
     */
    public static void imprimirMenuComOpcoes(String[] opcoes) {

        String[][] matrizDeOpcoes = retornarMatrizDeComponentesParaMenu(opcoes);
        imprimirLinhaDelimitadora();
        String linhaExternaDosBotoes = "", linhaInternaDosBotoes = "";

        for (int i = 0, opcoesAdicionadas = 0; i < matrizDeOpcoes.length; i++) {

            boolean opcaoCabeNaLinha =
                    (matrizDeOpcoes[i][1].length() +linhaInternaDosBotoes.length() < COMPRIMENTO_DE_LINHA - 4);

            if (opcaoCabeNaLinha) {
                String textoDaOpcao = matrizDeOpcoes[i][0], delimitadorDaOpcao = matrizDeOpcoes[i][1];
                linhaInternaDosBotoes += textoDaOpcao + " ".repeat(2);
                linhaExternaDosBotoes += delimitadorDaOpcao + " ".repeat(2);
                opcoesAdicionadas++;
            }

            boolean ultimaIteracaoOuOpcaoNaoCabe = (!opcaoCabeNaLinha || i == matrizDeOpcoes.length - 1);
            if (ultimaIteracaoOuOpcaoNaoCabe) {
                String diferencialParOuImpar =
                        " ".repeat((COMPRIMENTO_DE_LINHA - linhaInternaDosBotoes.trim().length()) % 2);
                String espacosDeCadaLado =
                        " ".repeat((COMPRIMENTO_DE_LINHA - linhaInternaDosBotoes.trim().length()) / 2);

                imprimirLinhaComOpcoes(espacosDeCadaLado, linhaInternaDosBotoes,
                        linhaExternaDosBotoes, diferencialParOuImpar);

                String textoDaOpcao = matrizDeOpcoes[i][0], delimitadorDaOpcao = matrizDeOpcoes[i][1];
                linhaExternaDosBotoes = "" + delimitadorDaOpcao + " ".repeat(2);
                linhaInternaDosBotoes = "" + textoDaOpcao + " ".repeat(2);

                // Checar ultima iteração evita duplicidade de valores na quarta linha de botões.
                boolean ultimaIteracao = (i == matrizDeOpcoes.length -1);

                // Checar se são mais de duas opções, evita duplicidade de valores caso o menu tenha apenas duas opções
                // que normalmente não ocupariam a terceira linha.
                boolean maisDeDuasOpcoes = (matrizDeOpcoes.length >2);

                // Checar se o número de opções é impar ajuda a evitar duplicidade de valores na última linha em menu
                // com número de opções impar maior que 3.
                boolean numeroParDeIteracoes = (i % 2 != 0);

                // Checar se o número de iterações difere do número de opções adicionadas dependendo do caso evita
                // que opções não sejam impressas e também duplicidade de úlitma opção.
                boolean numberoDeOpcoesAdicionaisDiferenteDeNumeroDeIteracoes = (opcoesAdicionadas != i+1);

                // Checar se o número difere de 6 evita duplicidade da última opção em
                // linha que não deveria existir.
                boolean numeroDeOpcoesDiferenteDe6 = (matrizDeOpcoes.length != 6);

                // Checar se o número é multiplo de 5 evita com que última opção em multiplos de 5 não seja impressa.
                boolean multiploDe5 = (matrizDeOpcoes.length % 5 == 0);

                // Multiplos destes números teriam duplicidade da última opção em linha que não deveria existir.
                boolean naoMultiploDe10ou14ou16 = (matrizDeOpcoes.length % 10 != 0 &&
                                                   matrizDeOpcoes.length % 14 != 0 &&
                                                   matrizDeOpcoes.length % 16 != 0);

                boolean maisUmaLinhaDeOpcoesNecessaria = (ultimaIteracao && maisDeDuasOpcoes && numeroParDeIteracoes &&
                                    numberoDeOpcoesAdicionaisDiferenteDeNumeroDeIteracoes &&
                                    numeroDeOpcoesDiferenteDe6 && naoMultiploDe10ou14ou16)
                                    || (ultimaIteracao && multiploDe5 && naoMultiploDe10ou14ou16);

                if(maisUmaLinhaDeOpcoesNecessaria) {
                    diferencialParOuImpar =
                            " ".repeat((COMPRIMENTO_DE_LINHA - linhaInternaDosBotoes.trim().length()) % 2);
                    espacosDeCadaLado =
                            " ".repeat((COMPRIMENTO_DE_LINHA - linhaInternaDosBotoes.trim().length()) / 2);

                    imprimirLinhaComOpcoes(espacosDeCadaLado, linhaInternaDosBotoes,
                            linhaExternaDosBotoes, diferencialParOuImpar);
                }
            }
        }
        imprimirLinhaDelimitadora();
    }


    /**
     * Componente do método imprimirMenuComOpcoes.
     * Imprime as 3 linhas que compõe as "caixas" de opções necessárias para imprimir um menu formatado.
     */
    private static void imprimirLinhaComOpcoes(String espacosDeCadaLado, String linhaInternaDosBotoes, String linhaExternaDosBotoes, String diferencialParOuImpar) {
        String linhaExterna = "|" + espacosDeCadaLado + linhaExternaDosBotoes.trim() + espacosDeCadaLado +diferencialParOuImpar + "|";
        String linhaInterna = "|" + espacosDeCadaLado + linhaInternaDosBotoes.trim() + espacosDeCadaLado +diferencialParOuImpar + "|";

        System.out.println(linhaExterna);
        System.out.println(linhaInterna);
        System.out.println(linhaExterna);
    }


    /**
     * Componente do método imprimirMenuComOpcoes.
     * Recebe como argumento o Array de Strings de opções.
     * Retorna uma matriz, contendo as linhas internas e externas de cada caixa para cada opção.
     */
    private static String[][] retornarMatrizDeComponentesParaMenu(String[] opcoes) {
        String[][] matriz = new String[opcoes.length][2];
        for (int i = 0; i < opcoes.length; i++) {
            String opcao = opcoes[i];
            matriz[i][0] = "| " + opcao + " |";
            matriz[i][1] = "+" + "-".repeat(opcao.length() +2) + "+";
        }
        return matriz;
    }


    /**
     * Componente do método imprimirMenuComOpcoes e imprimirMensagemFormatada.
     * É usada para imprimir a linha externa superior e inferior das "caixas" em ambos os métodos.
     */
    private static void imprimirLinhaDelimitadora() {
        System.out.println("+" + "-".repeat(COMPRIMENTO_DE_LINHA) + "+");
    }


    /**
     * Componente do método imprimirMensagemFormatada.
     * É usada para imprimir uma String (usando quantas linhas for necessário).
     * A Impressão final também tem delimitadores em cada linha, para compor as laterais da "caixa".
     * Recebe uma String como argumento.
     */
    private static void imprimirStringMultiLinhasFormatada(String string) {
        String[] arrayDeStrings = string.trim().split(" ");
        String linhaAtual = "";

        for (int indice = 0; indice < arrayDeStrings.length; indice ++) {

            String palavra = arrayDeStrings[indice];

            boolean palavraCabeNaLinha =
                    (palavra.length() + linhaAtual.length() + 1 < COMPRIMENTO_DE_LINHA -6);

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


    /**
     * Componente do método imprimirStringMultiLinhasFormatada.
     * Lida com a impressão de cada linha requisitada pelo método imprimirStringMultiLinhasFormatada.
     * Recebe uma String como argumento.
     */
    private static void imprimirLinhaIndentadaFormatada(String linha) {
        int numDeEspacos = (COMPRIMENTO_DE_LINHA - linha.length());
        int espacosDeCadaLado = numDeEspacos / 2;
        int diferencialParOuImpar = numDeEspacos % 2;

        String linhaFormatada = "|" + " ".repeat(espacosDeCadaLado) +
                linha +
                " ".repeat(espacosDeCadaLado + diferencialParOuImpar) +"|";

        System.out.println(linhaFormatada);
    }

}
