public class Elfo extends Personagem {

    public Elfo(String nome) {
        this(nome,42);
    }

    public Elfo(String nome, int quantidadeFlechas){
        this(nome, quantidadeFlechas, "Arco", "Flechas");
    }

    public Elfo(String nome, int quantidadeFlechas, String nomeArco, String nomeFlecha){
        super(nome,100);
        this.inventario.adicionarItem(new Item(nomeArco, 1));
        this.inventario.adicionarItem(new Item(nomeFlecha, quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }

    public boolean atirarFlecha(Dwarf dwarf) {
        return atirarFlecha(dwarf, 1);
    }

    public boolean atirarFlecha(Dwarf dwarf, int multiplicadorDeExperiencia) {
        Item flechas = getFlecha();
        int quantidadeFlechas = flechas.getQuantidade();

        if(quantidadeFlechas > 0){
            flechas.setQuantidade(--quantidadeFlechas);
            dwarf.perderVida();
            experiencia += 1 * multiplicadorDeExperiencia;
            return true;
        }
        return false;
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

