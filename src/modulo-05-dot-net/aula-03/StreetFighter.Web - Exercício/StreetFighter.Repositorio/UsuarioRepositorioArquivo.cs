using StreetFighter.Dominio;
using StreetFighter.Infra;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorioArquivo : IUsuarioRepositorio
    {

        private const string ArquivoDeUsuarios=
            @"D:\Crescer\github\crescer20162\src\modulo-05-dot-net\aula-03\StreetFighter.Web - Exercício\usuarios.csv";

        public Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {

            List<Usuario> listaDeUsuarios = LeUsuariosDoArquivo();

            Usuario usuarioEncontrado = listaDeUsuarios.FirstOrDefault(
                usuario => usuario.Nome.Equals(nome));

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }

        //Le o arquivo de texto CSV e retorna lista de personagens
        private List<Usuario> LeUsuariosDoArquivo()
        {
            return File.ReadAllLines(ArquivoDeUsuarios)
                    .Select(usuario => new Usuario(usuario.Split(';')))
                    .ToList();
        }

    }
}
