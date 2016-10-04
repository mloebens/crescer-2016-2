import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoNasceComNome1ArcoE42Flechas() {
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Elfo Noturno");

        assertEquals("Elfo Noturno", elfoDoTeste.getNome());
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
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
    public void elfoNoturnoNasceCom2Flechas() {
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Elfo Noturno",2);

        assertEquals(2, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNoturnoNasceSemFlechas() {
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Elfo Noturno",0);
        ArrayList<Item> todosItensDoInventario = elfoDoTeste.getInventario().getItens();

        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoAtiraUmaFlechaEmUmDwarf(){
        // Act
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Legolas");
        Dwarf dwarf = new Dwarf();

        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(3, elfoDoTeste.getExperiencia());
        assertEquals(100, dwarf.getVida(),0);
        assertEquals(95, elfoDoTeste.getVida(),0);
    }

    @Test
    public void elfoAtiraDuasFlechasEmUmDwarf(){
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Legolas");
        Dwarf dwarf = new Dwarf();
        // Act
        elfoDoTeste.atirarFlecha(dwarf);
        elfoDoTeste.atirarFlecha(dwarf);
        // Assert
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(6, elfoDoTeste.getExperiencia());
        assertEquals(90, dwarf.getVida(),0);
        assertEquals(90.25, elfoDoTeste.getVida(),0);
    }

    @Test
    public void elfoAtira42FlechasEmDwarf(){
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Legolas");
        Dwarf dwarfTyrion = new Dwarf();

        // Act
        for(int i = 1; i <= 45;i++){
            elfoDoTeste.atirarFlecha(dwarfTyrion);
        }
        // Assert
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(126, elfoDoTeste.getExperiencia());
        assertEquals(11.59822, elfoDoTeste.getVida(),0.00001);
        assertEquals(0, dwarfTyrion.getVida(),0);
    }

    @Test
    public void elfoNaoTemFlechaNegativa(){
        // Arrange
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Legolas");
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
        assertEquals(126, elfoDoTeste.getExperiencia());
        assertEquals(11.59822, elfoDoTeste.getVida(),0.00001);
    }

    @Test
    public void elfoNaoAtiraFlecha(){
        // Act
        ElfoNoturno elfoDoTeste = new ElfoNoturno("Legolas");
        // Assert
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(0, elfoDoTeste.getExperiencia());
    }
}
