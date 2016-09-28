import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
  @Test
   public void dwarfNasceComNome(){
        // Arrange
        String nomeEsperado = "Minimim";
        // Act
        Dwarf dwarf = new Dwarf(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, dwarf.getNome());
    }
    
    @Test
    public void dwarfNasceComVida(){
        // Act
        Dwarf dwarf = new Dwarf("Minimim");
        // Assert
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void dwarfLevouFlechada(){
        // Act
        Dwarf dwarf = new Dwarf("Minimim");
        dwarf.levarFlechada();
        // Assert
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void dwarfLevouQuatroFlechadas(){
        // Act
        Dwarf dwarf = new Dwarf("Minimim");
        dwarf.levarFlechada();
        
        // Assert
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void dwarfLevouMaisFlechadasQueVida(){
        // Act
        Dwarf dwarf = new Dwarf("Minimim");
       
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        
         // Assert
        assertEquals(0, dwarf.getVida());
    }
}
