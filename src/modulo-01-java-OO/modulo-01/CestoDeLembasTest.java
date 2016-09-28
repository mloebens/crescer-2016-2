import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CestoDeLembasTest
{
   @Test
   public void criarCestoDeLembas(){
       
        // Act
        CestoDeLembas lembas = new CestoDeLembas(15);
        // Assert
        assertEquals(15, lembas.getQuantidade());
    }
    
    @Test
    public void dividirDuasLembasEmPares(){
        // Act
        CestoDeLembas lembas = new CestoDeLembas(2);
        // Assert
        assertFalse(lembas.podeDividirEmPares());
    }
    
    @Test
    public void dividirUmaLembasEmPares(){
        // Act
        CestoDeLembas lembas = new CestoDeLembas(1);
        // Assert
        assertFalse(lembas.podeDividirEmPares());
    }
    
    @Test
    public void dividirZeroLembasEmPares(){
        // Act
        CestoDeLembas lembas = new CestoDeLembas(0);
        // Assert
        assertFalse(lembas.podeDividirEmPares());
    }
    
    @Test
    public void dividirCemLembasEmPares(){
        // Act
        CestoDeLembas lembas = new CestoDeLembas(100);
        // Assert
        assertTrue(lembas.podeDividirEmPares());
    }
    
    @Test
    public void dividirSessentaLembasEmPares(){
        // Act
        CestoDeLembas lembas = new CestoDeLembas(60);
        // Assert
        assertTrue(lembas.podeDividirEmPares());
    }
    
    @Test
    public void dividirCinquentaUmLembasEmPares(){
        // Act
        CestoDeLembas lembas = new CestoDeLembas(51);
        // Assert
        assertFalse(lembas.podeDividirEmPares());
    }
}
