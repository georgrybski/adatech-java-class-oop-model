package br.com.ada.modulo2.trabalho1;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class DisciplinaCursada {

    Disciplina disciplina;

    private ArrayList<Double> notas = new ArrayList<>();

    String strDataInicial;

    String strDataFinal;

    public DisciplinaCursada(Disciplina disciplina, ArrayList<Double> notas, String strDataInicial, String strDataFinal) {
        this.disciplina = disciplina;
        this.notas = notas;
        this.strDataInicial = strDataInicial;
        this.strDataFinal = strDataFinal;
    }

    public boolean emCurso() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fimDaDisciplina = LocalDate.parse(strDataFinal, formatter);
        LocalDate inicioDaDisciplina = LocalDate.parse(strDataInicial, formatter);
        LocalDate dataAtual = LocalDate.now();

        boolean disciplinaEmCurso =
                (dataAtual.compareTo(fimDaDisciplina) > 0 && dataAtual.compareTo(inicioDaDisciplina) < 0);
        return disciplinaEmCurso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public String getStrDataInicial() {
        return strDataInicial;
    }

    public String getStrDataFinal() {
        return strDataFinal;
    }

    @Override
    public String toString() {
        return disciplina.getNome() +
                "| Data de início: " + strDataInicial + '\'' +
                "| Data de término: " + strDataFinal;
    }
}
