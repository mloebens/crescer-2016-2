package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeuCalendarioUtil {
    public String diaDaSemana(String data) {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String diaDaSemana = null;
        try {
            Date date = simpleDateFormat.parse(data);
            SimpleDateFormat FormatarDiaDaSemana = new SimpleDateFormat("EEEE");
            diaDaSemana = FormatarDiaDaSemana.format(date);
        } catch (ParseException e) {
            System.out.println("erro");
        }
        return diaDaSemana;
    }
    
    
}
