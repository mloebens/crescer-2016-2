import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void aumentar1000unidadesItem(){
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(1000);
        assertEquals(1007, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItem(){
        Item elderScroll = new Item("Elder Scroll", -8);
        elderScroll.aumentarUnidades(1000);
        assertEquals(992, elderScroll.getQuantidade());
    }

    @Test
    public void aumentarUnidadeNegativaItem() {
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(-1);
        assertEquals(6, elderScroll.getQuantidade());
    }
}
