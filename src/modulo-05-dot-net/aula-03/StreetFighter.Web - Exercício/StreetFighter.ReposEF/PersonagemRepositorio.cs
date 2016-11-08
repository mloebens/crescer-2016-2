using StreetFighter.Dominio;
using StreetFighter.ReposEF;
using System.Collections.Generic;
using System.Linq;


namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        //Listar Personagens
        //Caso nenhum parametro seja passado no filtroNome, retorna todos os personagens
        //Se não, retorna os personagens que contenham o nome passado pelo filtro
        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            using (var context = new DatabaseContext())
            {
                return context.Personagem.ToList();
            }
        }

        public Personagem BuscarPersonagem(int id)
        {
            using (var context = new DatabaseContext())
            {
                return context.Personagem.Find(id);
            }
        }


        //Incluir Personagem
        public void IncluirPersonagem(Personagem personagem)
        {
          
        }

        //Editar Personagem
        public void EditarPersonagem(Personagem personagem)
        {
          
        }

    
        //Excluir Personagem
        public bool ExcluirPersonagem(Personagem personagem)
        {
            return false;
        }
    }
}
