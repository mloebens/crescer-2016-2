import java.util.ArrayList;

public class ExercitoElfos
{
    private ArrayList<Elfo> exercito;

    public ExercitoElfos(){
        exercito = new ArrayList<>();
    }

    public void alistar(Elfo elfo){
        
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        
        if(podeAlistar){
            exercito.add(elfo);
        }
    }

    public Elfo buscar(String nomeElfo){
        for(Elfo elfo : exercito){
            if(nomeElfo != null && nomeElfo.equals(elfo.getNome())){
                return elfo;
            }
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> resultado = new ArrayList<>();

        for(Elfo elfo : exercito){
            if(elfo.getStatus() == status){
                resultado.add(elfo);
            }
        }
        return resultado;
    }
}
