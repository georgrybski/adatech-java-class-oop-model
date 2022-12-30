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


}
