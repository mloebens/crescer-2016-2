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
    public void dwarfNasceCom110VidaENome(){
        // Act
        Dwarf dwarf = new Dwarf("Legolas", new DataTerceiraEra(1,10,2000));
        // Assert
        assertEquals(110, dwarf.getVida());
        assertEquals("Legolas", dwarf.getNome());
    } 

    @Test
    public void dwarfNascidoDia12Mes12Ano1000(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(13,12,1000);
        Dwarf dwarf = new Dwarf("Legolas", dataNascimento);

        assertEquals(13, dwarf.getDataNascimento().getDia());
        assertEquals(12, dwarf.getDataNascimento().getMes());
        assertEquals(1000, dwarf.getDataNascimento().getAno());
    }

    @Test
    public void dwarfNascidoDia1Mes10Ano2000(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,10,2000);
        Dwarf dwarf = new Dwarf("Legolas", dataNascimento);

        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(10, dwarf.getDataNascimento().getMes());
        assertEquals(2000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfNascidoDia111Mes50Ano2000Negativo(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(111,50,-2000);
        Dwarf dwarf = new Dwarf("Legolas", dataNascimento);

        assertEquals(111, dwarf.getDataNascimento().getDia());
        assertEquals(50, dwarf.getDataNascimento().getMes());
        assertEquals(-2000, dwarf.getDataNascimento().getAno());
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
