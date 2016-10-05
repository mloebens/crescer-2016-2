import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}
