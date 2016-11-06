using StreetFighter.Dominio;
using StreetFighter.Repositorio;

namespace StreetFighter.Aplicacao
{
    public class ServicoDeUsuarioAplicativo
    {

        private readonly IUsuarioRepositorio repositorio;

        public ServicoDeUsuarioAplicativo()
        {
            this.repositorio = new UsuarioRepositorio();
        }

        internal ServicoDeUsuarioAplicativo(IUsuarioRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            return repositorio.BuscarUsuarioAutenticado(nome, senha);
        }
    }
}
