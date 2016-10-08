import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest
{
    @Test
    public void ordenarNenhumElfo() throws ContingenteDesproporcionalException {
        Estrategia estrategia = new AtaqueIntercalado();

        List<Elfo> elfos = new ArrayList<>();
        List<Dwarf> dwarves = new ArrayList<>();

        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);
        assertTrue(resultado.isEmpty());
    }

    @Test(expected=ContingenteDesproporcionalException.class)
    public void ordenarUmElfoVerde() throws ContingenteDesproporcionalException {
        Estrategia estrategia = new AtaqueIntercalado();

        List<Elfo> elfos = new ArrayList<>(Arrays.asList(new ElfoVerde("Legolas")));
        List<Dwarf> dwarves = new ArrayList<>();

        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void ordenarDoisElfoVerdesEDoisNoturnos() throws ContingenteDesproporcionalException {
        Estrategia estrategia = new AtaqueIntercalado();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoVerde("Verde 1"));
        elfos.add(new ElfoVerde("Verde 2"));
        elfos.add(new ElfoNoturno("Noturno 1"));
        elfos.add(new ElfoNoturno("Noturno 2"));        
        List<Dwarf> dwarves = new ArrayList<>();

        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);
        
        assertTrue(resultado.get(0) instanceof ElfoVerde);
        assertTrue(resultado.get(1) instanceof ElfoNoturno);
        assertTrue(resultado.get(2) instanceof ElfoVerde);
        assertTrue(resultado.get(3) instanceof ElfoNoturno);
    }
}
