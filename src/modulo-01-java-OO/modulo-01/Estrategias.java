import java.util.List;

public interface Estrategias
{
   List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes, List<Dwarf> alvos);
}
