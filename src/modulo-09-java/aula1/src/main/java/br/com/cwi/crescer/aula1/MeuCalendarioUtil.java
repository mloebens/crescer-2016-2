package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void tempoDecorrido(Date data){
        long tempoDecorridoEmMilisegundos = new Date().getTime() - data.getTime();
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendario.setTimeInMillis(tempoDecorridoEmMilisegundos);
        
        StringBuilder sb = new StringBuilder();
        sb.append(calendario.get(Calendar.YEAR) - 1970);
        sb.append(" ano(s), ");
        sb.append(calendario.get(Calendar.MONTH));
        sb.append(" mese(s), ");
        sb.append(calendario.get(Calendar.DAY_OF_MONTH) -1);
        sb.append(" dia(s), ");
        
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        new MeuCalendarioUtil().tempoDecorrido(new Date());
    }
    
}
