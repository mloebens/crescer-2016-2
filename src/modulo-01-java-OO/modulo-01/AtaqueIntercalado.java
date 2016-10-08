import java.util.*;
public class AtaqueIntercalado implements Estrategia {
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) throws ContingenteDesproporcionalException{
        List<Elfo> ordemDeAtaque = new ArrayList<>();
        String ultimoElfoAdicionado = null;

        //verifica se os elfos verde e notruno estão balanceados 50%/50%
        if(!elfosEstaoBalanceados(atacantes)){
            throw new ContingenteDesproporcionalException();
        }

        while(!atacantes.isEmpty()){
            //retira o elfo da lista original e armazena na variavel elfo
            Elfo elfo = atacantes.remove(0);

            boolean elfoVivo = elfo.getStatus() == Status.VIVO;
            boolean elfoVerdeOuNoturno = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;

            //Elfo deve ser Verde ou Noturno e estar vivo
            if(!elfoVivo || !elfoVerdeOuNoturno) continue;            

            //Elfo deve ser verde e o ultimo elfo adicionado deve ser null ou noturno
            boolean podeAdicionarVerde = elfo instanceof ElfoVerde && !"Verde".equals(ultimoElfoAdicionado);
            boolean podeAdicionarNoturno = elfo instanceof ElfoNoturno && !"Noturno".equals(ultimoElfoAdicionado);

            if(podeAdicionarVerde || podeAdicionarNoturno){
                ordemDeAtaque.add(elfo);
                ultimoElfoAdicionado = "Verde".equals(ultimoElfoAdicionado) ? "Noturno" : "Verde";
                continue;
            }

            //Caso o elfo seja do mesmo tipo do elfo adicionado anteriormente, adiciona novamente no final da fila;
            atacantes.add(elfo);
        }

        return ordemDeAtaque;
    }

    private boolean elfosEstaoBalanceados(List<Elfo> elfos){
        int quantidadeElfosVerde = 0;
        int quantidadeElfosNoturno = 0;

        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoVerde){
                quantidadeElfosVerde++;
                continue;
            }
            if(elfo instanceof ElfoNoturno){
                quantidadeElfosNoturno++;
            }
        }

        return quantidadeElfosVerde == quantidadeElfosNoturno ? true : false;
    }
}
