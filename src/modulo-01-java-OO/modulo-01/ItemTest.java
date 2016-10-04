import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void aumentar1000unidadesItemFatorSomaFalse(){
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(1000);
        assertEquals(1007, elderScroll.getQuantidade());
    }

    @Test
    public void aumentar1000unidadesItemFatorSomaTrue(){
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarProporcionalQuantidade();
        assertEquals(28007, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItemFatorSomaFalse(){
        Item elderScroll = new Item("Elder Scroll", -8);
        elderScroll.aumentarUnidades(1000);
        assertEquals(992, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItemFatorSomaTrue(){
        Item elderScroll = new Item("Elder Scroll", -5);
        elderScroll.aumentarProporcionalQuantidade();
        assertEquals(14995, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarUnidadeNegativaItemFatorSomaFalse() {
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(-1);
        assertEquals(6, elderScroll.getQuantidade());
    }
    
    @Test
    public void igualdadeItens(){
        assertEquals(new Item("Espada Z", 1), new Item("Espada Z",1));
    }
    
    
    /*
    @Test
    public void aumentarUnidadeNegativaItemFatorSomaTrue() {
    Item elderScroll = new Item("Elder Scroll", 7);
    elderScroll.aumentarUnidades(-1, true);
    assertEquals(6, elderScroll.getQuantidade());
    }*/
}
