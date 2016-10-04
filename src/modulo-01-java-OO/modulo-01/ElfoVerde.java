import java.util.*;

public class ElfoVerde extends Elfo
{
    ArrayList<String> restricaoDeItens;

    public ElfoVerde(String nome) {
        super(nome,new Item("Arco e Flecha de Vidro", 42));
        restricaoDeItens = new ArrayList<String>(Arrays.asList("Arco e Flecha de Vidro","Espada de aço valiriano"));
    }

    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item,restricaoDeItens);
    }

    public void atirarFlecha(Dwarf dwarf) {
        atirarFlecha(dwarf, 2);
    }
}
