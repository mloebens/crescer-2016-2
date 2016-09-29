import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void ehBissexto2000(){
        DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 10, 2000);

        assertTrue(dataTerceiraEra.ehBissexto());
    }

    @Test
    public void ehBissexto1384(){
        DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 10, 1384);

        assertTrue(dataTerceiraEra.ehBissexto());
    }

    @Test
    public void ehBissexto1216(){
        DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 10, 1216);

        assertTrue(dataTerceiraEra.ehBissexto());
    }

    @Test
    public void ehBissexto1900(){
        DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 10, 1900);

        assertFalse(dataTerceiraEra.ehBissexto());
    }

    @Test
    public void ehBissexto1217(){
        DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 10, 1217);

        assertFalse(dataTerceiraEra.ehBissexto());
    }

    @Test
    public void ehBissexto2017(){
        DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 10, 2017);

        assertFalse(dataTerceiraEra.ehBissexto());
    }
}
