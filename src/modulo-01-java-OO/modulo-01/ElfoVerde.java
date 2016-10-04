import java.util.*;

public class ElfoVerde extends Elfo
{
    ArrayList<String> restricaoDeItens;

    public ElfoVerde(String nome) {
        this(nome,42);
    }

    public ElfoVerde(String nome, int quantidadeFlechas){
        super(nome, quantidadeFlechas, "Arco de Vidro", "Flecha de Vidro");
        restricaoDeItens = new ArrayList<String>(Arrays.asList("Arco de Vidro","Flecha de Vidro","Espada de aço valiriano"));
    }

    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item,restricaoDeItens);
    }

    public boolean atirarFlecha(Dwarf dwarf) {
        return atirarFlecha(dwarf, 2);
    }
}
