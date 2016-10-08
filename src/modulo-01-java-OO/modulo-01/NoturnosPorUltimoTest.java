import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class NoturnosPorUltimoTest {

    @Test
    public void ordenarNenhumElfo() throws ContingenteDesproporcionalException{
        Estrategia estrategia = new NoturnosPorUltimo();

        List<Elfo> elfos = new ArrayList<>();
        List<Dwarf> dwarves = new ArrayList<>();
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);

        assertTrue(resultado.isEmpty());

    }

    @Test
    public void ordenarUmElfoNoturnoEUmElfoVerde() throws ContingenteDesproporcionalException{
        Estrategia estrategia = new NoturnosPorUltimo();

        List<Elfo> elfos = new ArrayList<>(
                Arrays.asList(new ElfoNoturno("Noturno"), new ElfoVerde("Verdinho"))
            );

        List<Dwarf> dwarves = new ArrayList<>();
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);

        assertTrue(resultado.get(0) instanceof ElfoVerde);
        assertTrue(resultado.get(1) instanceof ElfoNoturno);
    }

    @Test
    public void ordenarTresElfosNoturnoETresElfosVerde() throws ContingenteDesproporcionalException{
        Estrategia estrategia = new NoturnosPorUltimo();

        List<Elfo> elfos = new ArrayList<>(
                Arrays.asList(
                    new ElfoNoturno("Noturno"), 
                    new ElfoVerde("Verdinho"),
                    new ElfoVerde("Verdinho 2"),
                    new ElfoNoturno("Noturno 2"),
                    new ElfoNoturno("Noturno 3"),
                    new ElfoVerde("Verdinho 3") 
                )
            );

        List<Dwarf> dwarves = new ArrayList<>();
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);

        assertTrue(resultado.get(0) instanceof ElfoVerde);
        assertTrue(resultado.get(1) instanceof ElfoVerde);
        assertTrue(resultado.get(2) instanceof ElfoVerde);
        assertTrue(resultado.get(3) instanceof ElfoNoturno);
        assertTrue(resultado.get(4) instanceof ElfoNoturno);
        assertTrue(resultado.get(5) instanceof ElfoNoturno);
    }

    @Test
    public void ordenarDoisElfoNoturnoUmVivoEUmMortoEUmElfoVerde() throws ContingenteDesproporcionalException{
        Estrategia estrategia = new NoturnosPorUltimo();

        ElfoNoturno elfoNoturno = new ElfoNoturno("Noturno", 100);
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoVerde("Verdinho"));
        elfos.add(new ElfoNoturno("Noturno"));
        elfos.add(elfoNoturno);

        while(elfoNoturno.getStatus() == Status.VIVO){
            elfoNoturno.atirarFlecha(new Dwarf());
        }

        List<Dwarf> dwarves = new ArrayList<>();
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos,dwarves);

        assertTrue(resultado.get(0) instanceof ElfoVerde);
        assertEquals(2, resultado.size());
    }
}
