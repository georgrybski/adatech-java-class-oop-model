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
