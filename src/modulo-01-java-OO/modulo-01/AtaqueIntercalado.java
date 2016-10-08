import java.util.*;
public class AtaqueIntercalado implements Estrategia {
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos) throws ContingenteDesproporcionalException{
        List<Elfo> ordemDeAtaque = new ArrayList<>();
        String ultimoElfoAdicionado = null;

        //verifica se os elfos verde e notruno estão balanceados 50%/50%, caso não estejam, "joga" exception.
        if(!elfosEstaoBalanceados(atacantes)){
            throw new ContingenteDesproporcionalException();
        }

        while(!atacantes.isEmpty()){
            //retira o elfo da lista original e armazena na variavel elfo
            Elfo elfo = atacantes.remove(0);

            boolean elfoVivo = elfo.getStatus() == Status.VIVO;
            boolean elfoVerdeOuNoturno = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;

            //Elfo deve ser Verde ou Noturno e estar vivo, caso contrario, ignorar(descartar)
            if(!elfoVivo || !elfoVerdeOuNoturno) continue;            

            //Se elfo for verde, o ultimo elfo adicionado deve ser null ou noturno
            boolean podeAdicionarVerde = elfo instanceof ElfoVerde && !"Verde".equals(ultimoElfoAdicionado);
            //Se elfo for noturno, o ultimo elfo adicionado deve ser null ou verde
            boolean podeAdicionarNoturno = elfo instanceof ElfoNoturno && !"Noturno".equals(ultimoElfoAdicionado);

            if(podeAdicionarVerde || podeAdicionarNoturno){
                ordemDeAtaque.add(elfo);
				//se o verde foi adicionado, marca o ultimo como verde, se não marca o noturno
                ultimoElfoAdicionado = podeAdicionarVerde ? "Verde" : "Noturno";
                continue;
            }

            //Caso o elfo seja do mesmo tipo do elfo adicionado anteriormente, adiciona novamente no final da fila;
            atacantes.add(elfo);
        }

        return ordemDeAtaque;
    }

	
	//Este méotodo somente considera os elfos que estão vivos.
    private boolean elfosEstaoBalanceados(List<Elfo> elfos){
        int quantidadeElfosVerde = 0;
        int quantidadeElfosNoturno = 0;

        for(Elfo elfo : elfos){

            if(elfo.getStatus() == Status.VIVO){

                if(elfo instanceof ElfoVerde){
                    quantidadeElfosVerde++;
                    continue;
                }
                if(elfo instanceof ElfoNoturno){
                    quantidadeElfosNoturno++;
                }
            }
        }

        return quantidadeElfosVerde == quantidadeElfosNoturno ? true : false;
    }
}
