package br.com.cwi.crescer.aula1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Máicon Loebens
 */
public class Parcelador {

    public Map<String, String> parcelar(BigDecimal valor, double taxaJuros, int parcelas, Date primeiroVencimento) {
        BigDecimal juros = BigDecimal.valueOf(taxaJuros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE);
        BigDecimal valorComJuros = valor.multiply(juros);
        BigDecimal valorDaParcela = valorComJuros.divide(BigDecimal.valueOf(parcelas), 2, RoundingMode.HALF_UP);
        BigDecimal resto = valorDaParcela.multiply(BigDecimal.valueOf(parcelas)).subtract(valorComJuros);

        Calendar dataInicial = Calendar.getInstance();
        dataInicial.setTime(primeiroVencimento);
        List<String> datas = gerarDatas(dataInicial, parcelas);
        
        NumberFormat formatadorMonetario = NumberFormat.getCurrencyInstance();
        Map<String, String> map = new LinkedHashMap<>();
        
        BigDecimal valorPacelaDoMes = valorDaParcela;
        for(int i = 0; i < parcelas; i++){
            if(parcelas-1 == i){
                valorPacelaDoMes = valorDaParcela.subtract(resto);
            }          
            map.put(
                    datas.get(i),
                    formatadorMonetario.format(valorPacelaDoMes)
                    );
        }
        
        return map;
    }

    private List<String> gerarDatas(Calendar dataInicial, int parcelas) {
        DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        List<String> datas = new ArrayList<>();
        int dia = dataInicial.get(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < parcelas; i++) {
            int mesAtual = dataInicial.get(Calendar.MONTH);
            datas.add(formatadorData.format(dataInicial.getTime()));
            
            dataInicial.add(Calendar.MONTH, 1);
            //atualiza o dia caso ele tenha sido alterado no mes anterior
            dataInicial.set(Calendar.DAY_OF_MONTH, dia);

            //Evitar que parcelas de dias como 31 o qual não existem todos os meses, 
            //pulem para o inicio do outro mes e sim continuem no final do mes seguinte
            boolean pulouDoisMeses = mesAtual + 2 == dataInicial.get(Calendar.MONTH);
            if (pulouDoisMeses) {
                dataInicial.set(Calendar.DAY_OF_MONTH, 1);
                dataInicial.add(Calendar.DAY_OF_MONTH, -1);
            }
        }
        return datas;
    }

    public static void main(String[] args) throws ParseException {
        DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatadorData.parse("31/12/2016");
        
        Map<String, String> map = new Parcelador().parcelar(BigDecimal.valueOf(100), 10, 6, date);
        
        map.forEach( (data,valor) -> System.out.println(data + " - " + valor));
    }
}
