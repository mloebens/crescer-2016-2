public class ContingenteDesproporcionalException extends Exception {
    
    public ContingenteDesproporcionalException(){
        System.out.println("A composição do pelotão de ataque deve ter obrigatoriamente 50% de Elfos Verdes e 50% de Elfos Noturnos");
    }
    
    public ContingenteDesproporcionalException(String mensagem){
        super(mensagem);
    }
}
