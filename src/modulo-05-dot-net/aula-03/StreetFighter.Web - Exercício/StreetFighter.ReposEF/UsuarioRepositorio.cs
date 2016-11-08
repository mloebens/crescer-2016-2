using StreetFighter.Dominio;
using StreetFighter.Infra;
using StreetFighter.ReposEF;
using System.Linq;

namespace StreetFighter.RepositorioEF
{
    public class UsuarioRepositorio :  IUsuarioRepositorio
    {

        public Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            using (var context = new DatabaseContext())
            {

                Usuario usuario = context.Usuario.FirstOrDefault(u => u.Nome.Equals(nome) && u.Senha.Equals(senhaDeComparacao));
                return usuario;
            }
        }
    }
}
