public class Elfo {
    private String nome;
    private Inventario inventario;
    private int experiencia;
    private Status status;

    public Elfo(String nome) {
        this(nome,42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        this.inventario = new Inventario();
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
        status = Status.VIVO;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public Item getArco() {
        return this.inventario.getTodosItens().get(0);
    }
    
    public Item getFlecha(){
        return this.inventario.getTodosItens().get(1);
    }

    public int getExperiencia(){
        return experiencia;
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


