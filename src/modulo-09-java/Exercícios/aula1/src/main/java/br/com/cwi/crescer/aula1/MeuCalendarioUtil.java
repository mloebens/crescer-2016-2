package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;

public class MeuCalendarioUtil {
    public void diaDaSemana(String data) {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = simpleDateFormat.parse(data);

            SimpleDateFormat FormatarDiaDaSemana = new SimpleDateFormat("EEEE");
            String diaDaSemana = FormatarDiaDaSemana.format(date);
            System.out.println(diaDaSemana);
        } catch (ParseException e) {
            System.out.println("erro");
        }
    }
}
