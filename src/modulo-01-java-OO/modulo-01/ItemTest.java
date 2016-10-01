import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void aumentar1000unidadesItemFatorSomaFalse(){
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(1000,false);
        assertEquals(1007, elderScroll.getQuantidade());
    }

    @Test
    public void aumentar1000unidadesItemFatorSomaTrue(){
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(1000,true);
        assertEquals(28007, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItemFatorSomaFalse(){
        Item elderScroll = new Item("Elder Scroll", -8);
        elderScroll.aumentarUnidades(1000, false);
        assertEquals(992, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItemFatorSomaTrue(){
        Item elderScroll = new Item("Elder Scroll", -5);
        elderScroll.aumentarUnidades(1000, true);
        assertEquals(14995, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarUnidadeNegativaItemFatorSomaFalse() {
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(-1, false);
        assertEquals(6, elderScroll.getQuantidade());
    }
    
    /*
    @Test
    public void aumentarUnidadeNegativaItemFatorSomaTrue() {
    Item elderScroll = new Item("Elder Scroll", 7);
    elderScroll.aumentarUnidades(-1, true);
    assertEquals(6, elderScroll.getQuantidade());
    }*/
}
