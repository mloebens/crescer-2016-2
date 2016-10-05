import java.util.ArrayList;

public class ExercitoElfo
{
    private ArrayList<Elfo> exercito;
    
    public ExercitoElfo(){
        exercito = new ArrayList<>();
    }
    
    public void alistar(Elfo elfo){
        exercito.add(elfo);
    }
    
    public Elfo buscar(String nomeElfo){
        for(Elfo elfo : exercito){
            if(nomeElfo != null && nomeElfo.equals(elfo.getNome())){
                return elfo;
            }
        }
        return null;
    }
}
