public class IrishDwarf extends Dwarf
{
    public IrishDwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
        this.vida = 110;
    }
    
    public void tentarSorte(){
        boolean teveSorte = getNumeroSorte() == -3333.0;
        
        if(teveSorte){           
            inventario.aumentarUnidadesDosItens(1000,true);
        }
    }   
}
