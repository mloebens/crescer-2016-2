import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{  
    @Test
    public void dwarfNasceCom110Vida(){
        // Act
        Dwarf dwarf = new Dwarf();
        // Assert
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void dwarfPerdeuVidaUmaVez(){
        // Act
        Dwarf dwarf = new Dwarf();
        dwarf.perderVida();
        // Assert
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void dwarfPerdeuVidaDuasVezes(){
        // Act
        Dwarf dwarf = new Dwarf();
        dwarf.perderVida();
        dwarf.perderVida();
        // Assert
        assertEquals(90, dwarf.getVida());
    }
    
    @Test
    public void dwarfLevouMaisFlechadasQueVida(){
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        
         // Assert
        assertEquals(-90, dwarf.getVida());
    }
}
