import java.util.ArrayList;

public class ExercitoElfos implements Exercito {
    private ArrayList<Elfo> contingente;

    public ExercitoElfos(){
        contingente = new ArrayList<>();
    }

    public Elfo[] getContingente() {
        return contingente.toArray(new Elfo[contingente.size()]);
    }

    public void alistar(Elfo elfo){

        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;

        if(podeAlistar){
            contingente.add(elfo);
        }
    }

    public Elfo buscar(String nomeElfo){
        for(Elfo elfo : contingente){
            if(nomeElfo != null && nomeElfo.equals(elfo.getNome())){
                return elfo;
            }
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> resultado = new ArrayList<>();

        for(Elfo elfo : contingente){
            if(elfo.getStatus() == status){
                resultado.add(elfo);
            }
        }
        return resultado;
    }
}
