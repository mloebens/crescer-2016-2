package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class StringRun {
    public static void main(String[] args) {
//        if ("A" == new String("A")) {
//            System.out.println("0");
//        } else {
//            System.out.println("1");
//        }
        
//        String palavra = null;
//         try (final Scanner scanner = new Scanner(System.in)) {
//             System.out.println("Digitar uma palavra");
//                palavra = scanner.nextLine();	
//        } catch (Exception e) {
//            //...
//        }
         
        StringRun exercicio = new StringRun();
        //exercicio.contarVogais(palavra);
        //exercicio.inverterPalavra(palavra);
        //exercicio.exibirTodosEstados();
        exercicio.exibirDataDoSistema();
        exercicio.diaDaSemana("01/10/1987");
        
    }
    
    public void contarVogais(String palavra){
        String palavaSemConsoantes = palavra.toLowerCase().replaceAll("[aeiou]","");
        int quantidadeVogais = palavra.length() - palavaSemConsoantes.length();
        StringBuilder resposta = new StringBuilder();
        resposta.append("Contar vogais: ");
        resposta.append(quantidadeVogais);
        System.out.format(resposta.toString());
    }
    public void inverterPalavra(String palavra){
        StringBuilder str = new StringBuilder(palavra);
        System.out.format("Palavra invertida: %s \n", str.reverse());
    }
    
    public void exibirTodosEstados(){
        List<Estados> listaDeEstados = Arrays.asList(Estados.values());
        listaDeEstados.sort((a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));
        StringBuffer estados = new StringBuffer();
        for (int i = 0;  i < listaDeEstados.size();i++){
            estados.append(listaDeEstados.get(i).getNome());
            if(i < listaDeEstados.size()-1 ){
                estados.append(",");
            }
        }
        System.out.println(estados.toString());
    }
    
    public void exibirDataDoSistema(){
        Date dataAtual = new Date();
        
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
        String dataFormatada = simpleDateFormat.format(dataAtual);
        
        System.out.println(dataAtual);
        System.out.println(dataFormatada);
    }
    
    public void diaDaSemana(String data){
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        try{
            Date date = simpleDateFormat.parse(data);
            
            SimpleDateFormat FormatarDiaDaSemana = new SimpleDateFormat("EEEE"); 
            String diaDaSemana = FormatarDiaDaSemana.format(date);
            System.out.println(diaDaSemana);
        } catch (ParseException e){
            System.out.println("erro");
        }
    }
          
}