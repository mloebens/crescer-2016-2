public class Dwarf
{
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf()
    {
        this.vida = 110;
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void perderVida(){
        this.vida -= 10;
    }

    public String getNome(){
        return this.nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
}
