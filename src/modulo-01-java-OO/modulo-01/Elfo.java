public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;

    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Item getArco() {
        return arco;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Item getFlecha() {
        return flecha;
    }

    public void atirarFlecha() {
        boolean temFlecha = flecha.getQuantidade() > 0;
        if (temFlecha) {
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        }
    }

    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

