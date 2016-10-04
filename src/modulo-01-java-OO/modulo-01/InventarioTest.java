import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

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
    public void adicionarUmItemComRestricoesComSucesso(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada Z",1), new ArrayList<String>(Arrays.asList("Espada Z")));

        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertEquals("Espada Z", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade());  
    }

    @Test
    public void adicionarUmItemComRestricoesSemSucesso(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada Z",1), new ArrayList<String>(Arrays.asList("Espada")));

        assertTrue(inventario.getItens().isEmpty());
    }

    @Test
    public void adicionar5ItensComRestricoesComSucesso(){
        Inventario inventario = new Inventario();
        ArrayList<String> restricaoDeItens = new ArrayList<String>(
                Arrays.asList("Espada de aço valiriano","Arco de Vidro","Flecha de Vidro"));

        inventario.adicionarItem(new Item("Espada Z",1), restricaoDeItens);
        inventario.adicionarItem(new Item("Espada de aço valiriano",2), restricaoDeItens);
        inventario.adicionarItem(new Item("Bastão",4), restricaoDeItens);
        inventario.adicionarItem(new Item("Arco de Vidro",1), restricaoDeItens);
        inventario.adicionarItem(new Item("Flecha de Vidro",12), restricaoDeItens);

        ArrayList<Item> todosItensDoInventario = inventario.getItens();

        assertEquals(3, todosItensDoInventario.size());
        assertEquals("Espada de aço valiriano", todosItensDoInventario.get(0).getDescricao());
        assertEquals(2, todosItensDoInventario.get(0).getQuantidade());
        assertEquals("Arco de Vidro", todosItensDoInventario.get(1).getDescricao());
        assertEquals(1, todosItensDoInventario.get(1).getQuantidade());  
        assertEquals("Flecha de Vidro", todosItensDoInventario.get(2).getDescricao());
        assertEquals(12, todosItensDoInventario.get(2).getQuantidade());  
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
    public void imprimirDescricoesUmItens(){
        Inventario inv = new Inventario();

        inv.adicionarItem(new Item("Escudo",1));

        assertEquals("Escudo",inv.getDescricoesItens());  
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

    @Test
    public void ordernarInventarioUmItem(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));

        inventario.ordenarItens();

        assertEquals("Espada", inventario.getDescricoesItens());
    }

    @Test
    public void ordernarInventario3Item(){
        Inventario inventario = criarInventarioCom3Itens();

        inventario.ordenarItens();

        assertEquals("Espada de aço,Lucky egg,Poção polissuco", inventario.getDescricoesItens());
    }

    @Test
    public void ordernarInventarioUmItemAscendente(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));

        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);

        assertEquals("Espada", inventario.getDescricoesItens());

    }

    @Test
    public void ordernarInventario3ItemAscendente(){
        Inventario inventario = criarInventarioCom3Itens();

        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);

        assertEquals("Espada de aço,Lucky egg,Poção polissuco", inventario.getDescricoesItens());
    }

    @Test
    public void ordernarInventario5ItemAscendente(){
        Inventario inventario = criarInventarioCom3Itens();
        inventario.adicionarItem(new Item("Pedra",5));
        inventario.adicionarItem(new Item("Martelo", 1));

        inventario.ordenarItens(TipoOrdenacao.ASCENDENTE);

        assertEquals("Martelo,Espada de aço,Lucky egg,Pedra,Poção polissuco", inventario.getDescricoesItens());
    }

    @Test
    public void ordernarInventarioUmItemDescendente(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));

        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);

        assertEquals("Espada", inventario.getDescricoesItens());

    }

    @Test
    public void ordernarInventario3ItemDescendente(){
        Inventario inventario = criarInventarioCom3Itens();

        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);

        assertEquals("Poção polissuco,Lucky egg,Espada de aço", inventario.getDescricoesItens());
    }

    @Test
    public void ordernarInventario5ItemDescendente(){
        Inventario inventario = criarInventarioCom3Itens();
        inventario.adicionarItem(new Item("Pedra",5));
        inventario.adicionarItem(new Item("Martelo", 1));

        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);
        assertEquals("Poção polissuco,Pedra,Lucky egg,Espada de aço,Martelo", inventario.getDescricoesItens());
    }

    @Test
    public void aumentar1000unidadesItemFatorSomaFalse(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Elder Scroll", 7));

        ArrayList<Item> itens  = inventario.getItens();
        inventario.aumentarUnidadesDosItens(1000);

        assertEquals(1007, itens.get(0).getQuantidade());
    }

    @Test
    public void aumentar1000unidadesItemFatorSomaTrue(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Elder Scroll", 7));

        ArrayList<Item> itens  = inventario.getItens();
        itens.get(0).aumentarProporcionalQuantidade();

        assertEquals(28007, itens.get(0).getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItemFatorSomaFalse(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Elder Scroll", -8));

        ArrayList<Item> itens  = inventario.getItens();
        itens.get(0).aumentarUnidades(1000);

        assertEquals(992, itens.get(0).getQuantidade());
    }

    @Test
    public void aumentarMenosOitounidadesItemFatorSomaTrue(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Elder Scroll", -8));

        ArrayList<Item> itens  = inventario.getItens();
        inventario.aumentarUnidadesProporcionalQuantidadePorItem();

        assertEquals(35992, itens.get(0).getQuantidade());
    }

    @Test
    public void aumentarUnidadeNegativaItemFatorSomaFalse() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Elder Scroll", 7));

        ArrayList<Item> itens  = inventario.getItens();
        itens.get(0).aumentarUnidades(-1);

        assertEquals(6, itens.get(0).getQuantidade());
    }

    private Inventario criarInventarioCom3Itens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 45));
        inventario.adicionarItem(new Item("Lucky egg", 3));
        return inventario;
    }

}
