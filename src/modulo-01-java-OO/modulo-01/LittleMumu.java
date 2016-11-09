import java.util.*;

public class LittleMumu implements Estrategia {
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos){
        atacantes = this.getElfosAptos(atacantes);
        atacantes = this.ordenarPorQuantidadeFlechaDescendente(atacantes);
        atacantes = this.limitarQuantidadeDeElfosNoturno(atacantes);
        
        return atacantes;
    }

    private List<Elfo> getElfosAptos(List<Elfo> elfos){
        List<Elfo> elfosAptos = new ArrayList<>();
        for(Elfo elfo : elfos){
            boolean estaVivo = elfo.getStatus() == Status.VIVO;
            boolean temFlecha = elfo.getFlecha().getQuantidade() > 0;

            if(estaVivo && temFlecha){
                elfosAptos.add(elfo);
            }
        }
        return elfosAptos;
    }

    private int getQuantidadeElfosNoturno(List<Elfo> elfos){
        int quantidade = 0;
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoNoturno){
                quantidade++;
            }
        }
        return quantidade;
    }

    private List<Elfo> ordenarPorQuantidadeFlechaDescendente(List<Elfo> elfos){
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < elfos.size() - 1; j++) {
                int elfoAtualQuantidadeFlechas = elfos.get(j).getFlecha().getQuantidade();
                int proximoElfoQuantidadeFlechas = elfos.get(j + 1).getFlecha().getQuantidade();

                boolean precisaTrocar = elfoAtualQuantidadeFlechas < proximoElfoQuantidadeFlechas;

                if (precisaTrocar) {
                    Collections.swap(elfos, j, j+1);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
        return elfos;
    }

    public List<Elfo> limitarQuantidadeDeElfosNoturno(List<Elfo> elfos){
        ArrayList<Elfo> resultado = new ArrayList<>();
        int quantidadeDeElfos = elfos.size();
        int quantidadeDeElfosNoturno = this.getQuantidadeElfosNoturno(elfos);
        //30% do total é o maximo permitido de elfos verdes(considerar somente parte inteira do resultado)
        int quantidadeMaximaPermitida = (int) (quantidadeDeElfos * .30);

        int quantidadePermitida = quantidadeDeElfosNoturno < quantidadeMaximaPermitida ? quantidadeDeElfosNoturno : quantidadeMaximaPermitida;

        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoNoturno){
                if(quantidadePermitida > 0){
                    quantidadePermitida--;
                    resultado.add(elfo);
                }
            } else {
                resultado.add(elfo);
            }
        }
        return resultado;
    }
}