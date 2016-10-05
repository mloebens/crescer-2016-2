import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoElfosTest {

    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void alistarEBuscarElfoVerdePeloNome(){
        ExercitoElfos exercito = new ExercitoElfos();

        exercito.alistar(new ElfoVerde("Legolas"));
        assertEquals("Legolas", exercito.buscar("Legolas").getNome());
    }

    @Test
    public void alistarEBuscarElfoNoturnoPeloNome(){
        ExercitoElfos exercito = new ExercitoElfos();

        exercito.alistar(new ElfoNoturno("Legolas"));
        assertEquals("Legolas", exercito.buscar("Legolas").getNome());
    }

    @Test
    public void alistarElfoNaoDeveFuncionar(){
        ExercitoElfos exercito = new ExercitoElfos();

        exercito.alistar(new Elfo("Legolas"));
        assertNull(exercito.buscar("Legolas"));
    }

    @Test
    public void alistarEBuscarElfosPeloNome(){
        ExercitoElfos exercito = new ExercitoElfos();

        exercito.alistar(new ElfoNoturno("Elfo Noturno"));
        exercito.alistar(new ElfoVerde("Elfo Verde"));

        assertEquals("Elfo Noturno", exercito.buscar("Elfo Noturno").getNome());
        assertEquals("Elfo Verde", exercito.buscar("Elfo Verde").getNome());
    }

    @Test
    public void buscarPrimeiroElfoQuandoNomesIguais(){
        ExercitoElfos exercito = new ExercitoElfos();

        ElfoVerde recruta = new ElfoVerde("Elfo");
        exercito.alistar(recruta);
        exercito.alistar(new ElfoVerde("Elfo"));

        assertEquals(recruta, exercito.buscar("Elfo"));

    }

    @Test
    public void buscarElfoVivo(){
        ExercitoElfos exercito = new ExercitoElfos();

        Elfo recruta1 = new ElfoVerde("Elfo 1");
        Elfo recruta2 = new ElfoVerde("Elfo 2");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);

        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);

        assertEquals(2, elfos.size());
        assertEquals(recruta1, elfos.get(0));
        assertEquals(recruta2, elfos.get(1));

    }

    @Test
    public void buscarElfoMorto(){
        ExercitoElfos exercito = new ExercitoElfos();

        Elfo recruta1 = new ElfoNoturno("Elfo 1",200);
        Elfo recruta2 = new ElfoVerde("Elfo 2");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);

        Dwarf dwarfAlvo = new Dwarf();
        while(recruta1.getStatus() == Status.VIVO){
            recruta1.atirarFlecha(dwarfAlvo);
        }

        ArrayList<Elfo> elfos = exercito.buscar(Status.MORTO);

        assertEquals(1, elfos.size());
        assertEquals(recruta1, elfos.get(0));
    }

}
