public class Dwarf
{
    private String nome;
    private int vida;
    private DataTerceiraEra dataNascimento;
    private int experiencia;
    private Status status;

    
    public Dwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.vida = 110;
        this.status = Status.VIVO;
    }

    public void perderVida(){
        double numeroSorte = getNumeroSorte();

        if(numeroSorte < 0){
            this.experiencia += 2;
        }
        
        if(numeroSorte > 100 && this.vida > 0){
            this.vida -= 10;
            
            if(this.vida <= 0) {
                this.status = Status.MORTO;
            }
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
    
    public Status getStatus(){
        return this.status;
    }
}
