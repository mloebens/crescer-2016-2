public class CestoDeLembas
{
    private int quantidade;
    
    public CestoDeLembas(int quantidade)
    {
        this.quantidade = quantidade;
    }

    /**
     * Simula a divisão das lembas por 2 onde a mesma deve respeitar os seguintes critérios
     * 1 <= n <= 100
     * Ambas as partes devem ser número par
     */
    public boolean podeDividirEmPares(){
        if(quantidade <= 3 || quantidade > 100 || quantidade % 2 != 0){
            return false;
        }
        return true;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
}
