public class Item {
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void aumentarUnidades(int unidades, boolean fatorSoma){
        this.quantidade += fatorSoma ? (unidades * fatorSoma()) : unidades;
        int i = 0;
    }

    private int fatorSoma(){
        int soma = 0;

        if(quantidade > 0){
            for(int i = 1; i <= quantidade; i++){
                soma += i;
            }
        }

        if(quantidade < 0){
            for(int i = -1; i >= quantidade; i--){
                soma -= i;
            }
        }
            return soma;
        }
    

}


