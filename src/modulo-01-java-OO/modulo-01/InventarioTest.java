import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest
{
    @Test
    public void adicionarUmItem(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada Z",1));

        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertEquals("Espada Z", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade());  
    }

    @Test
    public void adicionarDoisItens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada Z",1));
        inventario.adicionarItem(new Item("Espada Comum",2));

        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertEquals("Espada Z", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade()); 
        assertEquals("Espada Comum", todosItensDoInventario.get(1).getDescricao());
        assertEquals(2, todosItensDoInventario.get(1).getQuantidade()); 

    }

    @Test
    public void adicionarSeisItens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada Z",1));
        inventario.adicionarItem(new Item("Massamune",1));
        inventario.adicionarItem(new Item("Arco",4));
        inventario.adicionarItem(new Item("Cajado",3));
        inventario.adicionarItem(new Item("Bastão",10));
        inventario.adicionarItem(new Item("Flechas",5));

        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertEquals("Espada Z", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade()); 
        assertEquals("Massamune", todosItensDoInventario.get(1).getDescricao());
        assertEquals(1, todosItensDoInventario.get(1).getQuantidade()); 
        assertEquals("Arco", todosItensDoInventario.get(2).getDescricao()); 
        assertEquals(4, todosItensDoInventario.get(2).getQuantidade()); 
        assertEquals("Cajado", todosItensDoInventario.get(3).getDescricao());
        assertEquals(3, todosItensDoInventario.get(3).getQuantidade()); 
        assertEquals("Bastão", todosItensDoInventario.get(4).getDescricao());
        assertEquals(10, todosItensDoInventario.get(4).getQuantidade()); 
        assertEquals("Flechas", todosItensDoInventario.get(5).getDescricao()); 
        assertEquals(5, todosItensDoInventario.get(5).getQuantidade()); 
    }

    @Test
    public void removerUmItemDeUm(){
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z",1);

        inventario.adicionarItem(espadaZ);
        inventario.removerItem(espadaZ);
        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertFalse(todosItensDoInventario.contains(espadaZ));
    }

    @Test
    public void removerUmItemDeDois(){
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z",1);
        Item espadaBronze = new Item("Espada de Bronze",5);

        inventario.adicionarItem(espadaZ);
        inventario.adicionarItem(espadaBronze);
        inventario.removerItem(espadaZ);
        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertFalse(todosItensDoInventario.contains(espadaZ));
    }

    @Test
    public void removerTresItemDeSeis(){
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z",1);
        Item espadaBronze = new Item("Espada de Bronze",5);
        Item bastao = new Item("Bastão",10);

        inventario.adicionarItem(espadaZ);
        inventario.adicionarItem(new Item("Arco",4));
        inventario.adicionarItem(new Item("Cajado",3));
        inventario.adicionarItem(espadaBronze);
        inventario.adicionarItem(bastao);
        inventario.adicionarItem(new Item("Flechas",5));

        inventario.removerItem(espadaZ);
        inventario.removerItem(espadaBronze);
        inventario.removerItem(bastao);

        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertFalse(todosItensDoInventario.contains(espadaZ));
        assertFalse(todosItensDoInventario.contains(espadaBronze));
        assertFalse(todosItensDoInventario.contains(bastao));
    }

    @Test
    public void imprimirDescricoesDoisItens(){
        Inventario inv = new Inventario();

        inv.adicionarItem(new Item("Machado",1));
        inv.adicionarItem(new Item("Escudo",1));

        assertEquals("Machado,Escudo",inv.getDescricoesItens());  
    }

    @Test
    public void imprimirDescricoesTresItens(){
        Inventario inv = new Inventario();

        inv.adicionarItem(new Item("Machado",1));
        inv.adicionarItem(new Item("Escudo",1));
        inv.adicionarItem(new Item("Martelo",1));

        assertEquals("Machado,Escudo,Martelo",inv.getDescricoesItens());  
    }

    @Test
    public void imprimirDescricoesNenhumItens(){
        Inventario inv = new Inventario();
        assertEquals("",inv.getDescricoesItens());  
    }

    @Test
    public void itemMaisPopularSemItem(){
        Inventario inventario = new Inventario();

        assertEquals(null, inventario.getItemMaisPopular());
    }

    @Test
    public void itemMaisPopularDeDoisItens(){
        Inventario inventario = new Inventario();
        Item excalibur = new Item("Excalibur",1);
        Item sementeDeuses = new Item("Semente dos Deuses",55);
        
        inventario.adicionarItem(excalibur);
        inventario.adicionarItem(sementeDeuses);
        
        assertEquals(sementeDeuses, inventario.getItemMaisPopular());
    }
    
     @Test
    public void itemMaisPopularDeQuatroItens(){
        Inventario inventario = new Inventario();
        Item excalibur = new Item("Excalibur",1);
        Item sementeDeuses = new Item("Semente dos Deuses",55);
        Item flecha = new Item("Flecha",20);
        Item lanca = new Item("Lança",54);
        
        inventario.adicionarItem(excalibur);
        inventario.adicionarItem(sementeDeuses);
        inventario.adicionarItem(flecha);
        inventario.adicionarItem(lanca);
        
        assertEquals(sementeDeuses, inventario.getItemMaisPopular());
    }
}
