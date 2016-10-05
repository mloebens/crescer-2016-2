import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoElfoTest {
    @Test
    public void alistarEBuscarElfoVerdePeloNome(){
        ExercitoElfo exercito = new ExercitoElfo();

        exercito.alistar(new ElfoVerde("Legolas"));
        assertEquals("Legolas", exercito.buscar("Legolas").getNome());
    }

    @Test
    public void alistarEBuscarElfoNoturnoPeloNome(){
        ExercitoElfo exercito = new ExercitoElfo();

        exercito.alistar(new ElfoNoturno("Legolas"));
        assertEquals("Legolas", exercito.buscar("Legolas").getNome());
    }

    @Test
    public void alistarEBuscarElfosPeloNome(){
        ExercitoElfo exercito = new ExercitoElfo();

        exercito.alistar(new ElfoNoturno("Elfo Noturno"));
        exercito.alistar(new ElfoVerde("Elfo Verde"));

        assertEquals("Elfo Noturno", exercito.buscar("Elfo Noturno").getNome());
        assertEquals("Elfo Verde", exercito.buscar("Elfo Verde").getNome());
    }

    @Test
    public void buscarPrimeiroElfoQuandoNomesIguais(){
        ExercitoElfo exercito = new ExercitoElfo();

        exercito.alistar(new ElfoVerde("Elfo",5));
        exercito.alistar(new ElfoVerde("Elfo"));
        Elfo elfoEncontrado = exercito.buscar("Elfo");

        assertEquals("Elfo", elfoEncontrado.getNome());
        assertEquals(5, elfoEncontrado.getFlecha().getQuantidade());

    }

    @Test
    public void buscarElfoVivo(){
        ExercitoElfo exercito = new ExercitoElfo();

        exercito.alistar(new ElfoVerde("Elfo 1"));
        exercito.alistar(new ElfoVerde("Elfo 2"));

        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);

        assertEquals(2, elfos.size());
        assertEquals("Elfo 1", elfos.get(0).getNome());
        assertEquals("Elfo 2", elfos.get(1).getNome());

    }

    @Test
    public void buscarElfoMorto(){
        ExercitoElfo exercito = new ExercitoElfo();

        Elfo elfoMorto = new ElfoNoturno("Elfo 1", 200);
        exercito.alistar(elfoMorto);
        exercito.alistar(new ElfoNoturno("Elfo 2"));
        
        Dwarf dwarfAlvo = new Dwarf();
        
       // while(elfoMorto.getStatus() == Status.VIVO){
         for(int i = 0; i < 100;i++){
           elfoMorto.atirarFlecha(dwarfAlvo);
        }
        
        System.out.println(elfoMorto.getVida());

        ArrayList<Elfo> elfos = exercito.buscar(Status.MORTO);

        assertEquals(1, elfos.size());
        assertEquals("Elfo 1", elfos.get(0).getNome());
    }

}
