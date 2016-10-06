import java.util.*;

public class BatalhaoEspecialDeElfos {
    private HashMap<String, Elfo> contingente;

    public BatalhaoEspecialDeElfos(){
        this.contingente = new HashMap<>();
    }

    public Elfo[] getContingente(){
        return this.contingente.values().toArray(new Elfo[this.contingente.size()]);
    }

    public void alistar(Elfo elfo){

        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;

        if(podeAlistar){
            this.contingente.put(elfo.getNome(), elfo);
        }
    }

    public Elfo buscar(String nomeElfo){
        return contingente.get(nomeElfo);
    }
    
    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> resultado = new ArrayList<>();
        
        contingente.forEach((indice,elfo)->{
            if (elfo.getStatus() == status ){
                resultado.add(elfo);
            }            
        });
        
        return resultado;
    }
}
