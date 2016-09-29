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
    public void dwarfMeirelesNaoBissextoNaoPerdeuVida(){
        // Act
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,01,2001));
        dwarf.perderVida();
        // Assert
        assertEquals(110, dwarf.getVida());
    }

    @Test
    public void dwarfMeirelesBissextoPerdeuVida(){
        // Act
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,01,2000));
        dwarf.perderVida();
        // Assert
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void dwarfSeixasBissextoPerdeuVida(){
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,01,2000));
        dwarf.perderVida();
        // Assert
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void dwarfSeixasNaoBissextoNaoPerdeuVida(){
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,01,2001));
        dwarf.perderVida();
        // Assert
        assertEquals(110, dwarf.getVida());
    }

    @Test
    public void dwarfBissextoPerdeuVidaUmaVezs(){
        // Act
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,01,2000));
        dwarf.perderVida();
        // Assert
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void dwarfBissextoPerde20DeVidaEGanhou8Experiencia(){
        // Act
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,01,2000));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();

        // Assert
        assertEquals(90, dwarf.getVida());
        assertEquals(8, dwarf.getExperiencia());
    }

    @Test
    public void dwarfBissextoNumeroSorteVida110(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,01,2000));

        assertEquals(101.0, dwarf.getNumeroSorte(),0);
    }

    @Test
    public void dwarfBissextoNumeroSorteVida80(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,01,2000));

        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();

        assertEquals(-3333.0, dwarf.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNaoBissextoNumeroSorteNomeGimli(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,01,2001));

        assertEquals(101.0, dwarf.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNaoBissextoNumeroSorteNomeMeireles(){
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,01,2001));

        assertEquals(33.0, dwarf.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNaoBissextoNumeroSorteNomeSeixas(){
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,01,2001));

        assertEquals(33.0, dwarf.getNumeroSorte(),0);
    }

    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf = new Dwarf();

        assertEquals(Status.VIVO, dwarf.getStatus());
    }

    @Test
    public void dwarfMorreuComDano100(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,1));

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

        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida());

    }

    @Test
    public void dwarfMorreuComDano200(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,1));

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
        dwarf.perderVida();
        dwarf.perderVida();

        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida());   
    }

    @Test
    public void dwarfMorreuComDano400(){
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,1));

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
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();

        assertEquals(Status.MORTO, dwarf.getStatus());
        assertEquals(0, dwarf.getVida());
    }
}
