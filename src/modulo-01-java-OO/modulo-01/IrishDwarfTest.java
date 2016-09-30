import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class IrishDwarfTest
{  
    @Test
    public void irishDwarfNasceCom110Vida(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf();
        // Assert
        assertEquals(110, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfNasceCom110VidaENome(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Legolas", new DataTerceiraEra(1,10,2000));
        // Assert
        assertEquals(110, irishDwarf.getVida());
        assertEquals("Legolas", irishDwarf.getNome());
    }

    @Test
    public void irishDwarfNasceVivo(){
        IrishDwarf irishDwarf = new IrishDwarf();

        assertEquals(Status.VIVO, irishDwarf.getStatus());
    }

    @Test
    public void irishDwarfNascidoDia12Mes12Ano1000(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(13,12,1000);
        IrishDwarf irishDwarf = new IrishDwarf("Legolas", dataNascimento);

        assertEquals(13, irishDwarf.getDataNascimento().getDia());
        assertEquals(12, irishDwarf.getDataNascimento().getMes());
        assertEquals(1000, irishDwarf.getDataNascimento().getAno());
    }

    @Test
    public void irishDwarfNascidoDia1Mes10Ano2000(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,10,2000);
        IrishDwarf irishDwarf = new IrishDwarf("Legolas", dataNascimento);

        assertEquals(1, irishDwarf.getDataNascimento().getDia());
        assertEquals(10, irishDwarf.getDataNascimento().getMes());
        assertEquals(2000, irishDwarf.getDataNascimento().getAno());
    }

    @Test
    public void irishDwarfNascidoDia111Mes50Ano2000Negativo(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(111,50,-2000);
        IrishDwarf irishDwarf = new IrishDwarf("Legolas", dataNascimento);

        assertEquals(111, irishDwarf.getDataNascimento().getDia());
        assertEquals(50, irishDwarf.getDataNascimento().getMes());
        assertEquals(-2000, irishDwarf.getDataNascimento().getAno());
    }

    @Test
    public void irishDwarfMeirelesNaoBissextoNaoPerdeuVida(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Meireles", new DataTerceiraEra(1,01,2001));
        irishDwarf.perderVida();
        // Assert
        assertEquals(110, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfMeirelesBissextoPerdeuVida(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Meireles", new DataTerceiraEra(1,01,2000));
        irishDwarf.perderVida();
        // Assert
        assertEquals(100, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfSeixasBissextoPerdeuVida(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1,01,2000));
        irishDwarf.perderVida();
        // Assert
        assertEquals(100, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfSeixasNaoBissextoNaoPerdeuVida(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1,01,2001));
        irishDwarf.perderVida();
        // Assert
        assertEquals(110, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfBissextoPerdeuVidaUmaVezs(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,01,2000));
        irishDwarf.perderVida();
        // Assert
        assertEquals(100, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfBissextoPerde20DeVidaEGanhou8Experiencia(){
        // Act
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,01,2000));
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();

        // Assert
        assertEquals(90, irishDwarf.getVida());
        assertEquals(8, irishDwarf.getExperiencia());
    }

    @Test
    public void irishDwarfBissextoNumeroSorteVida110(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,01,2000));

        assertEquals(101.0, irishDwarf.getNumeroSorte(),0);
    }

    @Test
    public void irishDwarfBissextoNumeroSorteVida80(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,01,2000));

        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();

        assertEquals(-3333.0, irishDwarf.getNumeroSorte(),0);
    }

    @Test
    public void irishDwarfNaoBissextoNumeroSorteNomeGimli(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,01,2001));

        assertEquals(101.0, irishDwarf.getNumeroSorte(),0);
    }

    @Test
    public void irishDwarfNaoBissextoNumeroSorteNomeMeireles(){
        IrishDwarf irishDwarf = new IrishDwarf("Meireles", new DataTerceiraEra(1,01,2001));

        assertEquals(33.0, irishDwarf.getNumeroSorte(),0);
    }

    @Test
    public void irishDwarfNaoBissextoNumeroSorteNomeSeixas(){
        IrishDwarf irishDwarf = new IrishDwarf("Seixas", new DataTerceiraEra(1,01,2001));

        assertEquals(33.0, irishDwarf.getNumeroSorte(),0);
    }

    @Test
    public void irishDwarfMorreuComDano100(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));

        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();

        assertEquals(Status.MORTO, irishDwarf.getStatus());
        assertEquals(0, irishDwarf.getVida());

    }

    @Test
    public void irishDwarfMorreuComDano200(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));

        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();

        assertEquals(Status.MORTO, irishDwarf.getStatus());
        assertEquals(0, irishDwarf.getVida());   
    }

    @Test
    public void irishDwarfMorreuComDano400(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));

        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();

        assertEquals(Status.MORTO, irishDwarf.getStatus());
        assertEquals(0, irishDwarf.getVida());
    }

    @Test
    public void irishDwarfGanhouUmItem(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));
        irishDwarf.adicionarItem(new Item("Martelo",1));

        ArrayList<Item> todosItensDoInventario = irishDwarf.getInventario().getItens();

        assertEquals("Martelo", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade());  
    }

    @Test
    public void irishDwarfGanhouDoisItens(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));
        irishDwarf.adicionarItem(new Item("Martelo",1));
        irishDwarf.adicionarItem(new Item("Escudo",2));

        ArrayList<Item> todosItensDoInventario = irishDwarf.getInventario().getItens();

        assertEquals("Martelo", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade()); 
        assertEquals("Escudo", todosItensDoInventario.get(1).getDescricao());
        assertEquals(2, todosItensDoInventario.get(1).getQuantidade()); 

    }

    @Test
    public void adicionarSeisItens(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));
        irishDwarf.adicionarItem(new Item("Martelo",1));
        irishDwarf.adicionarItem(new Item("Escudo",2));
        irishDwarf.adicionarItem(new Item("Arco",4));
        irishDwarf.adicionarItem(new Item("Cajado",3));
        irishDwarf.adicionarItem(new Item("Bastão",10));
        irishDwarf.adicionarItem(new Item("Flechas",5));

        ArrayList<Item> todosItensDoInventario = irishDwarf.getInventario().getItens();

        assertEquals("Martelo", todosItensDoInventario.get(0).getDescricao());
        assertEquals(1, todosItensDoInventario.get(0).getQuantidade()); 
        assertEquals("Escudo", todosItensDoInventario.get(1).getDescricao());
        assertEquals(2, todosItensDoInventario.get(1).getQuantidade()); 
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
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));
        Item martelo = new Item("Martelo",1);
        
        irishDwarf.adicionarItem(martelo);
        irishDwarf.perderItem(martelo);
        
        ArrayList<Item> todosItensDoInventario = irishDwarf.getInventario().getItens();

        assertFalse(todosItensDoInventario.contains(martelo));
    }

    @Test
    public void removerUmItemDeDois(){
       IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));
        Item martelo = new Item("Martelo",1);
        
        irishDwarf.adicionarItem(martelo);
        irishDwarf.adicionarItem(new Item("Escudo", 1));
        irishDwarf.perderItem(martelo);
        
        ArrayList<Item> todosItensDoInventario = irishDwarf.getInventario().getItens();

        assertFalse(todosItensDoInventario.contains(martelo));
    }

    @Test
    public void removerTresItemDeSeis(){
        IrishDwarf irishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,1));
        Item martelo = new Item("Martelo",1);
        Item escudo = new Item("Escudo",5);
        Item bastao = new Item("Bastão",10);

        irishDwarf.adicionarItem(martelo);
        irishDwarf.adicionarItem(new Item("Arco",4));
        irishDwarf.adicionarItem(new Item("Cajado",3));
        irishDwarf.adicionarItem(escudo);
        irishDwarf.adicionarItem(bastao);
        irishDwarf.adicionarItem(new Item("Flechas",5));

        irishDwarf.perderItem(martelo);
        irishDwarf.perderItem(escudo);
        irishDwarf.perderItem(bastao);

        ArrayList<Item> todosItensDoInventario = irishDwarf.getInventario().getItens();

        assertFalse(todosItensDoInventario.contains(martelo));
        assertFalse(todosItensDoInventario.contains(escudo));
        assertFalse(todosItensDoInventario.contains(bastao));
    }
    
    @Test
    public void aumentar1000Unidades3Itens() {
        IrishDwarf irishDwarf = new IrishDwarf("Sortudo", new DataTerceiraEra(1, 1, 2016));
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.perderVida();
        irishDwarf.adicionarItem(new Item("Espada de aço", 2));
        irishDwarf.adicionarItem(new Item("Poção polissuco", 45));
        irishDwarf.adicionarItem(new Item("Lucky egg", 3));
        irishDwarf.tentarSorte();
        ArrayList<Item> itens = irishDwarf.getInventario().getItens();
        assertEquals(1002, itens.get(0).getQuantidade());
        assertEquals(1045, itens.get(1).getQuantidade());
        assertEquals(1003, itens.get(2).getQuantidade());
    }
}
