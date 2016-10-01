import java.util.*;

//Incompleto
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
}
