public class Personagem
{
    protected String nome;
    protected Inventario inventario;
    protected Status status;
    protected int experiencia;
    protected int vida;

    public Personagem(String nome, int vida)
    {
        this.nome = nome;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
        this.vida = vida;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome(){
        return this.nome;
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public Status getStatus(){
        return this.status;
    }

    public int getExperiencia(){
        return experiencia;
    }
    
        public int getVida(){
        return this.vida;
    }
}
