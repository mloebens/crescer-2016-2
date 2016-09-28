import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }

    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }

    @Test
    public void elfoNasceComFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoAtiraFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf dwarf = new Dwarf("Tyrion");
        
        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoAtiraVariasFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf dwarf = new Dwarf("Tyrion");
        
        elfoDoTeste.atirarFlecha(dwarf);
        elfoDoTeste.atirarFlecha(dwarf);
        elfoDoTeste.atirarFlecha(dwarf);
        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
        assertEquals(38, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(4, elfoDoTeste.getExperiencia());
    }

    @Test
    public void elfoNaoAtiraFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        // Assert
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNaoTemFlechaNegativa(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf dwarfTyrion = new Dwarf("Tyrion");
        Dwarf dwarfMinimim = new Dwarf("Minimim");
        Dwarf dwarfGimli = new Dwarf("Gimli");
        
        // Podia liberar laço de repetição...
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
}