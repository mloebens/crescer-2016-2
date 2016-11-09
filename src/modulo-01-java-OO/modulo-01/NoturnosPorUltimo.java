import java.util.*;
public class NoturnosPorUltimo implements Estrategia {

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos){
        List<Elfo> resultado = new ArrayList<>();

        for(Elfo elfo : atacantes){
            boolean elfoVivo = elfo.getStatus() == Status.VIVO;

            if(elfoVivo){
                if(elfo instanceof ElfoVerde){
                    resultado.add(0, elfo);
                }
                if(elfo instanceof ElfoNoturno){
                    resultado.add(elfo);                
                }               
            }
        }
        return resultado;
    }
}
