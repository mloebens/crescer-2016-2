import java.util.*;

public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> dividas){
        int resultado = 0;

        for(ArrayList<Integer> subArray : dividas){
            int valor1 = subArray.get(0);
            int valor2 = subArray.get(1); 
            int produto = valor1 * valor2;
            resultado += produto - calcularMMC(valor1,valor2);
        }

        return resultado;
    }

    private int calcularMMC(int valor1, int valor2){
        return (valor1*valor2) / getMDC(valor1,valor2);
    }

    private int getMDC(int valor1, int valor2){
        while (valor2 != 0) {  
            int resto = valor1 % valor2;  
            valor1 = valor2;  
            valor2 = resto;  
        }  
        return valor1;
    }

    public int obterMaiorMultiploDeTresAte(int valor){
        int maior = 0;
        //Quando procurar o maior valor, é mais fácil começar a iteração com o menor valor e então decrementar o contador.
        for(int i = valor; i > 0; i--){
            if(i % 3 == 0){
                maior = i;
                //o continue ignora o resto da execução dentro do laço e pula para a proxima iteração do laço
                break;
            }
        }
        return maior;
    }

    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));

        //o limite do for deve ser o numero recebido como parametro, pois os multiplos devem ser até esse número
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0){
                //o break interrompe o laço, ou seja, na primeira vez que a condição fosse verdadeira, o laço seria interrompido.
                multiplos.add(i);
            }
        }

        return multiplos;
    }
}
