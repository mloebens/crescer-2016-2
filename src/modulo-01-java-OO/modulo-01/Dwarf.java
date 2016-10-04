public class Dwarf extends Personagem
{
    protected DataTerceiraEra dataNascimento;

    public Dwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome);
        this.vida = 110;
        this.dataNascimento = dataNascimento;        
    }

    public void perderVida(){
        if(this.status == Status.MORTO) return;
        
        double numeroSorte = getNumeroSorte();

        if(numeroSorte < 0){
            this.experiencia += 2;
        }
        
        if(numeroSorte > 100){
            this.vida -= 10;
            
            if(this.vida <= 0) {
                this.status = Status.MORTO;
            }
        }
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
    
    public void tentarSorte(){
        boolean teveSorte = getNumeroSorte() == -3333.0;
        
        if(teveSorte){
            inventario.aumentarUnidadesDosItens(1000);
        }
    }
    
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventario.removerItem(item);
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
}
