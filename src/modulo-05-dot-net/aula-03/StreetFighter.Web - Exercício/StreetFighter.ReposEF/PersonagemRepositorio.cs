using StreetFighter.Dominio;
using StreetFighter.ReposEF;
using System.Collections.Generic;
using System.Data.Entity;
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
                return context.Personagem.Where(personagem => filtroNome == null || personagem.Nome.Contains(filtroNome)).ToList();
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
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        //Editar Personagem
        public void EditarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

    
        //Excluir Personagem
        public bool ExcluirPersonagem(Personagem personagem)
        {
            int resultado = 0;
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Deleted;
                resultado = context.SaveChanges();
            }

            bool removeu = resultado > 0 ? true : false;
            return removeu;
        }
    }
}
