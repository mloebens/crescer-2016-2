public class Dwarf
{
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    private int experiencia;

    public Dwarf()
    {
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void perderVida(){
        double numeroSorte = getNumeroSorte();

        if(numeroSorte < 0){
            this.experiencia += 2;
        }
        
        if(numeroSorte > 100){
            this.vida -= 10;
        }
        
    }

    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }

    public double getNumeroSorte(){
        double valorInicial = 101.0;

        if(dataNascimento.ehBissexto()){
            if (this.vida >= 80 && this.vida <= 90){
                return valorInicial * (-33);
            }
        } else {
            if("Seixas".equals(this.nome) || "Meireles".equals(this.nome)){
                return (valorInicial * 33) % 100;
            }
        }
        return valorInicial;
    }

    public String getNome(){
        return this.nome;
    }

    public int getVida(){
        return this.vida;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}
