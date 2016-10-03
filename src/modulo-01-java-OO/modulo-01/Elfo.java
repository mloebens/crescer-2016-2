public class Elfo extends Personagem {

    public Elfo(String nome) {
        this(nome,42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        super(nome);
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    
    
    public Item getArco() {
        return this.inventario.getItens().get(0);
    }
    
    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }

    public void atirarFlecha(Dwarf dwarf) {
        Item flechas = getFlecha();
        int quantidadeFlechas = flechas.getQuantidade();
        
        if(quantidadeFlechas > 0){
            flechas.setQuantidade(--quantidadeFlechas);
            
            dwarf.perderVida();
            
            experiencia++;
        }
    }
    
    public String toString(){
        Item flechas = getFlecha();
        boolean flechaNoSingular = flechas.getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
            this.nome, 
            flechas.getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis");
    }

    /*public void atirarFlechaRefactory() {
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}


