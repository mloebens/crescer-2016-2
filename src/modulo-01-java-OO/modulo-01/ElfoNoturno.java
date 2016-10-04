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

    public boolean atirarFlecha(Dwarf dwarf) {
        boolean atirou = atirarFlecha(dwarf, 3);
        if(atirou){
            this.vida = this.vida - (this.vida * .05) ;
            return true;
        }
        return false;
    }

}
