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
    public void elfoNasceCom42Flechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoAtiraUmaFlechaEmUmDwarf(){
        // Act
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf dwarf = new Dwarf();
        
        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void elfoAtiraDuasFlechasEmUmDwarf(){
        // Arrange
        Elfo elfoDoTeste = new Elfo("Legolas");
        Dwarf dwarf = new Dwarf();
        // Act
        elfoDoTeste.atirarFlecha(dwarf);
        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(2, elfoDoTeste.getExperiencia());
        assertEquals(90, dwarf.getVida());
    }

        @Test
    public void elfoAtira42FlechasEm3Dwarves(){
        // Arrange
        Elfo elfoDoTeste = new Elfo("Legolas");
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
        assertEquals(42, elfoDoTeste.getExperiencia());
        assertEquals(-50, dwarfTyrion.getVida());
        assertEquals(-30, dwarfGimli.getVida());
        assertEquals(-10, dwarfMinimim.getVida());
    }
    
    @Test
    public void elfoNaoTemFlechaNegativa(){
        // Arrange
        Elfo elfoDoTeste = new Elfo("Legolas");
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
        Elfo elfoDoTeste = new Elfo("Legolas");
        // Assert
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(0, elfoDoTeste.getExperiencia());
    }
}