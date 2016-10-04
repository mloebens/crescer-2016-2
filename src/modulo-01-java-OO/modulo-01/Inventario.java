import java.util.*;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item){
        this.itens.add(item);
    }
    
    //restricaoDeItens: somente os itens deste array podem ser adicionados no inventário.
    public void adicionarItem(Item item, ArrayList<String> restricaoDeItens){
        for(String nomeItemRestrito : restricaoDeItens){
            String nomeItemNovo = item.getDescricao(); 
            if (nomeItemNovo != null && nomeItemNovo.equals(nomeItemRestrito)){
                adicionarItem(item);
                break;
            }
        }
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

    public void aumentarUnidadesDosItens(int unidades, boolean fatorSoma){
        for (Item item: itens){
            item.aumentarUnidades(unidades, fatorSoma);
        }
    }

    public void ordenarItens(){
        ordenarItens(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenarItens(TipoOrdenacao ordenacao){
        int quantidadeItens = itens.size();

        for(int i = 0; i < quantidadeItens ; i++){
            for(int j = 0; j < quantidadeItens-1; j++){

                
                if( itens.get(j).getQuantidade() > itens.get(j+1).getQuantidade() && ordenacao == TipoOrdenacao.ASCENDENTE){
                    inverterPosicaoDoItem(j,j+1);
                }

                if( itens.get(j).getQuantidade() < itens.get(j+1).getQuantidade() && ordenacao == TipoOrdenacao.DESCENDENTE){
                    inverterPosicaoDoItem(j+1,j);
                }
            }
        }      
    }

    public void inverterPosicaoDoItem(int posicaoItem1, int posicaoItem2){
        Item aux = itens.get(posicaoItem1);
        itens.set(posicaoItem1, itens.get(posicaoItem2));
        itens.set(posicaoItem2, aux);
    }

}
