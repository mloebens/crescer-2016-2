public class Personagem
{
    protected String nome;
    protected Inventario inventario;
    protected Status status;
    protected int experiencia;

    public Personagem(String nome)
    {
        this.nome = nome;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
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
}
