/*
 * 5.2 - Não morrerá, ficará infinitamente perto de 0 mas nunca chegará realmente ao zero
 * 
 */

public class ElfoNoturno extends Elfo
{

    public ElfoNoturno(String nome) {
        this(nome,42);
    }

    public ElfoNoturno(String nome, int quantidadeFlechas){
        super(nome, quantidadeFlechas);
    }

    public void atirarFlecha(Dwarf dwarf) {
        if(Status.VIVO == this.status && getFlecha().getQuantidade() > 0){
            super.atirarFlechas(dwarf, 3);
            this.vida -= (this.vida * .05) ;
            if(this.vida < 1.){
                this.status = Status.MORTO;
            }
        }
    }

}
