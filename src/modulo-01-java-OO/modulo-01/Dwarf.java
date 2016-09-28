public class Dwarf
{
    private String nome;
    private int vida;
    
    public Dwarf(String nome)
    {
        this.nome = nome;
        this.vida = 110;
    }
    
    public void levarFlechada(){
        if(this.vida > 0){
            this.vida -= 10;
        }
    }
    
    public String getNome(){
        return this.nome;
    }

    public int getVida(){
        return this.vida;
    }
}
