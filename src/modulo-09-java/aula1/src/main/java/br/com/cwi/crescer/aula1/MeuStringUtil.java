package br.com.cwi.crescer.aula1;

import java.lang.reflect.Method;
import java.text.Normalizer;

public class MeuStringUtil {

    public boolean stringVazia(String texto) {
        return texto.isEmpty();
    }

    public int contarVogais(String palavra) {
        String palavaSemConsoantes = palavra.toLowerCase().replaceAll("[aeiou]", "");
        int quantidadeVogais = palavra.length() - palavaSemConsoantes.length();
        return quantidadeVogais;
    }

    public String inverterString(String palavra) {
        StringBuilder sb = new StringBuilder(palavra);
        return sb.reverse().toString();
    }

    public boolean ehPalindromo(String palavra) {
        String palavraNormalizada = normalize(palavra).replaceAll("[ -]", "");
        StringBuilder sb = new StringBuilder(palavraNormalizada);
        String palavraNormalizadaInvertida = sb.reverse().toString();
        boolean ehPalindrome = palavraNormalizada.equals(palavraNormalizadaInvertida);

        return ehPalindrome;
    }

    private String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static void main(String args[]) {      
        Method[] methods = new MeuStringUtil().getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
