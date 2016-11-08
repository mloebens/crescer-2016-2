using StreetFighter.Dominio;
using StreetFighter.RepositorioEF;
using System.Collections.Generic;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public bool Exluir(Personagem personagem)
        {
            return repositorio.ExcluirPersonagem(personagem);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem); 
            else
                repositorio.EditarPersonagem(personagem);
        }

        public Personagem BuscarPersonagem(int id)
        {
            return repositorio.BuscarPersonagem(id);
        }
    }
}
