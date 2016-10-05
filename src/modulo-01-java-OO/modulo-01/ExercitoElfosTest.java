import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoElfosTest {
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

        exercito.alistar(new ElfoVerde("Elfo 1"));
        exercito.alistar(new ElfoVerde("Elfo 2"));

        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);

        assertEquals(2, elfos.size());
        assertEquals("Elfo 1", elfos.get(0).getNome());
        assertEquals("Elfo 2", elfos.get(1).getNome());

    }

    @Test
    public void buscarElfoMorto(){
        ExercitoElfos exercito = new ExercitoElfos();

        Elfo elfoMorto = new ElfoNoturno("Elfo 1", 200);
        exercito.alistar(elfoMorto);
        exercito.alistar(new ElfoNoturno("Elfo 2"));
        
        Dwarf dwarfAlvo = new Dwarf();
        
       while(elfoMorto.getStatus() == Status.VIVO){
           elfoMorto.atirarFlecha(dwarfAlvo);
        }
        
        ArrayList<Elfo> elfos = exercito.buscar(Status.MORTO);

        assertEquals(1, elfos.size());
        assertEquals("Elfo 1", elfos.get(0).getNome());
    }

}
