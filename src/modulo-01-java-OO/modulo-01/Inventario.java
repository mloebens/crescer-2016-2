import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();
    
    public void adicionarItem(Item item){
        this.itens.add(item);
    }
 
    public void removerItem(Item item){
        this.itens.remove(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
    public String getDescricoesItens(){
        String descricaoItens = "";
        int quantidadeItens = itens.size();
        
        for(int i = 0; i < quantidadeItens; i++){
            String nomeItem = itens.get(i).getDescricao();
            //armazena descrição do item e só adiciona virgula se não for o último item da lista.
            descricaoItens += i < quantidadeItens-1  ?  String.format("%s,",nomeItem) : nomeItem;
        }
        
        return descricaoItens;
    }
    
    public Item getItemMaisPopular(){
        Item itemMaisPopular = null;
        int maiorQuantidadeItem = 0;
        
        for(int i = 1; i < itens.size() ; i++){
            if(itens.get(1).getQuantidade() > maiorQuantidadeItem){
                itemMaisPopular = itens.get(i);
                maiorQuantidadeItem = itens.get(1).getQuantidade();
            }
        }
        
        return itemMaisPopular;
    }
    
    public void aumentarUnidadesDosItens(int unidades){
        for (Item item: itens){
            item.aumentarUnidades(unidades);
        }
    }
}
