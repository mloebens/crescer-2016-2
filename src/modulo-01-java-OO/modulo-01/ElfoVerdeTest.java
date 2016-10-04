import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeNasceComNome1ArcoE42Flechas() {
        ElfoVerde elfoDoTeste = new ElfoVerde("Duende Verde");

        assertEquals("Duende Verde", elfoDoTeste.getNome());
        assertEquals("Arco de Vidro", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
        assertEquals("Flecha de Vidro", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNasceCom100DeVida() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
        assertEquals(100, elfoDoTeste.getVida(),0);
    }

    @Test
    public void adicionarUmItemComRestricoesComSucesso(){
        ElfoVerde elfoDoTeste = new ElfoVerde("Duende Verde");
        elfoDoTeste.adicionarItem(new Item("Espada de aço valiriano",1));

        assertEquals("Espada de aço valiriano", elfoDoTeste.getInventario().getItens().get(2).getDescricao());
        assertEquals(1, elfoDoTeste.getInventario().getItens().get(2).getQuantidade());  
    }

    @Test
    public void adicionarUmItemComRestricoesSemSucesso(){
        ElfoVerde elfoDoTeste = new ElfoVerde("Duende Verde");
        elfoDoTeste.adicionarItem(new Item("Espada Z",1));

        assertTrue(elfoDoTeste.getInventario().getItens().size() == 2);
    }

    @Test
    public void adicionar5ItensComRestricoesComSucesso(){
        ElfoVerde elfoDoTeste = new ElfoVerde("Duende Verde");
        elfoDoTeste.adicionarItem(new Item("Espada Z",1));
        elfoDoTeste.adicionarItem(new Item("Espada de aço valiriano",2));
        elfoDoTeste.adicionarItem(new Item("Bastão",4));
        elfoDoTeste.adicionarItem(new Item("Arco de Vidro",1));
        elfoDoTeste.adicionarItem(new Item("Flecha de Vidro",12));

        ArrayList<Item> todosItensDoInventario = elfoDoTeste.getInventario().getItens();

        assertEquals(5, todosItensDoInventario.size());
        assertEquals("Espada de aço valiriano", todosItensDoInventario.get(2).getDescricao());
        assertEquals(2, todosItensDoInventario.get(2).getQuantidade());
        assertEquals("Arco de Vidro", todosItensDoInventario.get(3).getDescricao());
        assertEquals(1, todosItensDoInventario.get(3).getQuantidade());  
        assertEquals("Flecha de Vidro", todosItensDoInventario.get(4).getDescricao());
        assertEquals(12, todosItensDoInventario.get(4).getQuantidade());  
    }

    @Test
    public void elfoAtiraUmaFlechaEmUmDwarf(){
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Legolas");
        Dwarf dwarf = new Dwarf();

        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
        assertEquals(100, dwarf.getVida(),0);
    }

    @Test
    public void elfoAtiraDuasFlechasEmUmDwarf(){
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Legolas");
        Dwarf dwarf = new Dwarf();
        // Act
        elfoDoTeste.atirarFlecha(dwarf);
        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(4, elfoDoTeste.getExperiencia());
        assertEquals(90, dwarf.getVida(),0);
    }

    @Test
    public void elfoAtira42FlechasEm3Dwarves(){
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Legolas");
        Dwarf dwarfTyrion = new Dwarf();
        Dwarf dwarfMinimim = new Dwarf();
        Dwarf dwarfGimli = new Dwarf();
        // Act
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(84, elfoDoTeste.getExperiencia());
        assertEquals(0, dwarfTyrion.getVida(),0);
        assertEquals(0, dwarfGimli.getVida(),0);
        assertEquals(0, dwarfMinimim.getVida(),0);
    }

    @Test
    public void elfoNaoTemFlechaNegativa(){
        // Arrange
        ElfoVerde elfoDoTeste = new ElfoVerde("Legolas");
        Dwarf dwarfTyrion = new Dwarf();
        Dwarf dwarfMinimim = new Dwarf();
        Dwarf dwarfGimli = new Dwarf();
        // Act
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfTyrion);
        elfoDoTeste.atirarFlecha(dwarfGimli);
        elfoDoTeste.atirarFlecha(dwarfMinimim);
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNaoAtiraFlecha(){
        // Act
        ElfoVerde elfoDoTeste = new ElfoVerde("Legolas");
        // Assert
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(0, elfoDoTeste.getExperiencia());
    }

}
