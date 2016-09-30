import java.util.*;

//Incompleto
public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> dividas){
        for(ArrayList<Integer> subArray : dividas){
            for(Integer valor : subArray){
                
            }
        }
    }
    
    public int calcularMMC(int valor1, int valor2){
        
        int resultado = 1;
        int coeficienteDivisao = 2;
        
        while(valor1 > 1 && valor2 > 1){
            boolean calculou = false;
            
            if (valor1 % coeficienteDivisao == 0){
                calculou = true;
            }
            if (valor2 % coeficienteDivisao == 0){
                calculou = true;
            }
            
            if(calculou){
                resultado * coeficienteDivisao;
            }
        }
    }
    
    return resultado;
}
