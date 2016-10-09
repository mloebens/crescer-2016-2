import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class LittleMumuTest
{
    @Test
    public void ordenar2ElfosVerde(){
        LittleMumu estrategia = new LittleMumu();
        ArrayList<Elfo> elfos = new ArrayList<>();
        ArrayList<Dwarf> dwarves = new ArrayList<>();

        ElfoVerde elfoVerde1 = new ElfoVerde("Verde 2", 40 );
        ElfoVerde elfoVerde2 = new ElfoVerde("Verde 3", 50 );

        elfos.add(elfoVerde1);
        elfos.add(elfoVerde2);
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos, dwarves);

        assertEquals(2, resultado.size());
        assertEquals(elfoVerde2, resultado.get(0));
        assertEquals(elfoVerde1, resultado.get(1));
    }

    @Test
    public void ordenar2ElfosNoturno(){
        LittleMumu estrategia = new LittleMumu();
        ArrayList<Elfo> elfos = new ArrayList<>();
        ArrayList<Dwarf> dwarves = new ArrayList<>();

        ElfoNoturno elfoNoturno1 = new ElfoNoturno("Noturno 1", 3 );
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("Noturno 2", 12 );

        elfos.add(elfoNoturno1);
        elfos.add(elfoNoturno2);
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos, dwarves);

        assertEquals(0, resultado.size());
    }

    @Test
    public void ordenar3ElfosVerdeComUmSemFlechaE2ElfosNoturno(){
        LittleMumu estrategia = new LittleMumu();
        ArrayList<Elfo> elfos = new ArrayList<>();
        ArrayList<Dwarf> dwarves = new ArrayList<>();

        ElfoNoturno elfoNoturno1 = new ElfoNoturno("Noturno 1", 3 );
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("Noturno 2", 12 );
        ElfoVerde elfoVerde1 = new ElfoVerde("Verde 1", 0 );
        ElfoVerde elfoVerde2 = new ElfoVerde("Verde 2", 40 );
        ElfoVerde elfoVerde3 = new ElfoVerde("Verde 3", 50 );
        elfos.add(elfoNoturno1);
        elfos.add(elfoNoturno2);
        elfos.add(elfoVerde1);
        elfos.add(elfoVerde2);
        elfos.add(elfoVerde3);
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos, dwarves);

        assertEquals(3, resultado.size());
        assertEquals(elfoVerde3, resultado.get(0));
        assertEquals(elfoVerde2, resultado.get(1));
        assertEquals(elfoNoturno2, resultado.get(2));
    }

    @Test
    public void ordenar6ElfosVerdeComUmSemFlechaE2ElfosNoturno(){
        LittleMumu estrategia = new LittleMumu();
        ArrayList<Elfo> elfos = new ArrayList<>();
        ArrayList<Dwarf> dwarves = new ArrayList<>();

        ElfoNoturno elfoNoturno1 = new ElfoNoturno("Noturno 1", 3 );
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("Noturno 2", 12 );
        elfos.add(elfoNoturno1);
        elfos.add(elfoNoturno2);
        elfos.add(new ElfoVerde("Verde 1", 0 ));
        elfos.add(new ElfoVerde("Verde 2"));
        elfos.add(new ElfoVerde("Verde 3"));
        elfos.add(new ElfoVerde("Verde 4"));
        elfos.add(new ElfoVerde("Verde 5"));
        elfos.add(new ElfoVerde("Verde 6"));
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos, dwarves);

        assertEquals(7, resultado.size());
        assertEquals(elfoNoturno1, resultado.get(6));
        assertEquals(elfoNoturno2, resultado.get(5));
    }

    @Test
    public void ordenar6ElfosVerdeE3ElfosNoturnoComUmMorto(){
        LittleMumu estrategia = new LittleMumu();
        ArrayList<Elfo> elfos = new ArrayList<>();
        ArrayList<Dwarf> dwarves = new ArrayList<>();

        ElfoNoturno elfoNoturno1 = new ElfoNoturno("Noturno 1", 3 );
        ElfoNoturno elfoNoturno2 = new ElfoNoturno("Noturno 2", 100 );
        ElfoNoturno elfoNoturno3 = new ElfoNoturno("Noturno 2", 90 );
        elfos.add(elfoNoturno1);
        elfos.add(elfoNoturno2);
        elfos.add(elfoNoturno3);

        while(elfoNoturno2.getStatus() != Status.MORTO){
            elfoNoturno2.atirarFlecha(new Dwarf());
        }
        elfos.add(new ElfoVerde("Verde 1"));
        elfos.add(new ElfoVerde("Verde 2"));
        elfos.add(new ElfoVerde("Verde 3"));
        elfos.add(new ElfoVerde("Verde 4"));
        elfos.add(new ElfoVerde("Verde 5"));
        elfos.add(new ElfoVerde("Verde 6"));
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos, dwarves);

        assertEquals(8, resultado.size());
        assertEquals(elfoNoturno1, resultado.get(7));
        assertEquals(elfoNoturno3, resultado.get(0));
    }

}
