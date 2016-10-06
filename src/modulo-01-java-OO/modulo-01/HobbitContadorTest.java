import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{    

    @Test
    public void calcularDiferenca1ParNenhumValor(){

        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));

        HobbitContador contador = new HobbitContador();

        assertEquals(180, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferenca1Par(){

        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));

        HobbitContador contador = new HobbitContador();

        assertEquals(180, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferenca2Pares(){

        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));

        HobbitContador contador = new HobbitContador();

        assertEquals(180, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferenca3Pares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();

        assertEquals(840, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void obterMaiorMultiploDeTresAteTres(){
        HobbitContador contador = new HobbitContador();

        assertEquals(3, contador.obterMaiorMultiploDeTresAte(3));
    }

    @Test
    public void obterMaiorMultiploDeTresAteDez(){
        HobbitContador contador = new HobbitContador();

        assertEquals(9, contador.obterMaiorMultiploDeTresAte(10));
    }

    @Test
    public void obterMaiorMultiploDeTresAte20(){
        HobbitContador contador = new HobbitContador();

        assertEquals(18, contador.obterMaiorMultiploDeTresAte(20));
    }

    @Test
    public void obterMaiorMultiploDeTresAteUm(){
        HobbitContador contador = new HobbitContador();

        assertEquals(0, contador.obterMaiorMultiploDeTresAte(1));
    }

    @Test
    public void obterMultiplosDeTresAte10(){
        HobbitContador contador = new HobbitContador();

        assertEquals("[0, 3, 6, 9]", contador.obterMultiplosDeTresAte(10).toString());
    }

    @Test
    public void obterMultiplosDeTresAte23(){
        HobbitContador contador = new HobbitContador();

        assertEquals("[0, 3, 6, 9, 12, 15, 18, 21]", contador.obterMultiplosDeTresAte(23).toString());
    }

    @Test
    public void obterMultiplosDeTresAte30(){
        HobbitContador contador = new HobbitContador();

        assertEquals("[0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30]", contador.obterMultiplosDeTresAte(30).toString());
    }
    
        @Test
    public void obterMultiplosDeTresAteZero(){
        HobbitContador contador = new HobbitContador();

        assertEquals("[0]", contador.obterMultiplosDeTresAte(0).toString());
    }

    
    
    
    
    
    
    
    
    
    
}
