import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class BatalhaoEspecialDeElfosTest
{
    @Test
    public void alistarUmElfoVerde() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        batalhao.alistar(elfoVerde);
        assertEquals(elfoVerde, batalhao.getContingente()[0]);
    }

    @Test
    public void alistarUmElfoNoturno() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Night Elf");
        batalhao.alistar(elfoNoturno);
        assertEquals(elfoNoturno, batalhao.getContingente()[0]);
    }

    @Test
    public void alistarUmElfoNormal() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNormal = new Elfo("Elfo Normal");
        batalhao.alistar(elfoNormal);
        assertEquals(0, batalhao.getContingente().length);
    }

    @Test
    public void alistarDosTresTiposSoEntramVerdesENoturnos() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        Elfo elfoNormal = new Elfo("Elfo Normal");
        Elfo elfoNoturno = new ElfoNoturno("Night Elf");
        batalhao.alistar(elfoVerde);
        batalhao.alistar(elfoNormal);
        batalhao.alistar(elfoNoturno);
        assertEquals(2, batalhao.getContingente().length);
        assertEquals(elfoVerde, batalhao.getContingente()[1]);
        assertEquals(elfoNoturno, batalhao.getContingente()[0]);
    }

    @Test
    public void buscarbatalhaoVazio() {
        assertNull(new BatalhaoEspecialDeElfos().buscar("Nenhum"));
    }

    @Test
    public void buscarPorNomeTendoApenasUmComAqueleNome() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        batalhao.alistar(recruta1);
        batalhao.alistar(recruta2);
        batalhao.alistar(recruta3);
        assertEquals(recruta2, batalhao.buscar("Elfo Recruta 2"));
    }

    @Test
    public void buscarPorNomeTendoVariosComAqueleNome() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        batalhao.alistar(recruta1);
        batalhao.alistar(recruta2);
        batalhao.alistar(recruta3);
        assertEquals(2, batalhao.getContingente().length);
        assertEquals(recruta3, batalhao.buscar("Elfo Recruta"));
    }

    @Test
    public void buscarPorStatusVivo() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        batalhao.alistar(recruta1);
        batalhao.alistar(recruta2);
        batalhao.alistar(recruta3);
        ArrayList<Elfo> resultado = batalhao.buscar(Status.VIVO);
        assertEquals(2, resultado.size());
        assertEquals(recruta3, resultado.get(0));
        assertEquals(recruta2, resultado.get(1));
    }

    @Test
    public void buscarPorStatusMorto() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta1");
        Elfo recruta2 = criarElfoNoturnoEMatalo();
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        batalhao.alistar(recruta1);
        batalhao.alistar(recruta2);
        batalhao.alistar(recruta3);
        ArrayList<Elfo> resultado = batalhao.buscar(Status.MORTO);
        assertEquals(1, resultado.size());
        assertEquals(recruta2, resultado.get(0));
    }

    @Test
    public void buscarPorStatusMortoNenhumMorto() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta1");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        batalhao.alistar(recruta1);
        batalhao.alistar(recruta2);
        batalhao.alistar(recruta3);
        assertTrue(batalhao.buscar(Status.MORTO).isEmpty());
    }

    @Test
    public void buscarPorStatusVivoNenhumVivo() {
        BatalhaoEspecialDeElfos  batalhao = new BatalhaoEspecialDeElfos();
        Elfo recruta1 = criarElfoNoturnoEMatalo();
        Elfo recruta2 = criarElfoNoturnoEMatalo();
        Elfo recruta3 = criarElfoNoturnoEMatalo();
        batalhao.alistar(recruta1);
        batalhao.alistar(recruta2);
        batalhao.alistar(recruta3);
        assertTrue(batalhao.buscar(Status.VIVO).isEmpty());
    }

    private ElfoNoturno criarElfoNoturnoEMatalo() {
        ElfoNoturno suicida = new ElfoNoturno("Elfo kamikaze", 90);
        for (int i = 0; i < 90; i++)
            suicida.atirarFlecha(new Dwarf());
        return suicida;
    }
}
