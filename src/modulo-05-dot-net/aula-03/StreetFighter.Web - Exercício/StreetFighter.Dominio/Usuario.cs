using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Usuario
    {

        public string Nome { get; set; }
        public string Senha { get; set; }
        public string[] Permissoes { get; set; }
        public Usuario(string nome, string senha)
        {
            this.Nome = nome;
            this.Senha = senha;
        }

        public Usuario(string[] dadosDoUsuario) : this(dadosDoUsuario[0], dadosDoUsuario[1])
        {
        }
    }
}
