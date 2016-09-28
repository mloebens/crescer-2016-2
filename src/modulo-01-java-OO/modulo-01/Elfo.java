public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;

    public Elfo(String nome) {
        this(nome,42);
    }
    
    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        this.arco = new Item("Arco", 1);
        this.flecha = new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return arco;
    }
    
    public Item getFlecha(){
        return flecha;
    }

    public int getExperiencia(){
        return experiencia;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        
        int quantidadeFlechas = flecha.getQuantidade();
        
        if(quantidadeFlechas > 0){
            flecha.setQuantidade(--quantidadeFlechas);
            
            dwarf.perderVida();
            
            experiencia++;
        }
    }
    
    public String toString(){
        
        boolean flechaNoSingular = this.flecha.getQuantidade() == 1;
        boolean experienciaNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
            this.nome, 
            this.flecha.getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis");
    }

    /*public void atirarFlechaRefactory() {
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}


