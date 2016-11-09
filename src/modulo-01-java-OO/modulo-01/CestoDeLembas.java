public class CestoDeLembas
{
    private int numeroPaes;
    
    public CestoDeLembas(int numeroPaes)
    {
        this.numeroPaes = numeroPaes;
    }

    /**
     * Simula a divisão das lembas por 2 onde a mesma deve respeitar os seguintes critérios
     * 1 <= n <= 100
     * Ambas as partes devem ser número par
     */
    public boolean podeDividirEmPares(){
        return (numeroPaes > 2 && numeroPaes <= 100 && numeroPaes % 2 == 0);
    }
    
    public int getNumeroPaes(){
        return numeroPaes;
    }
}
