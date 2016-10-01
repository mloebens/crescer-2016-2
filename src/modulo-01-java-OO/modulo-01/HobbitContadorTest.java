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
}
