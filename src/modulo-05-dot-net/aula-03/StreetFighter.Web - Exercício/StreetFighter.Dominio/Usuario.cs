using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Usuario
    {
        public int Id { get; }
        public string Nome { get; }
        public string Senha { get; }
        public Usuario(string nome, string senha)
        {
            this.Nome = nome;
            this.Senha = senha;
        }

        public Usuario(string[] dadosDoUsuario) : this(dadosDoUsuario[0], dadosDoUsuario[1])
        {
        }

        public Usuario(int id, string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }
    }
}
