using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Origem { get; set; }

        public Personagem(int id, string nome, string origem) 
            : this(nome,origem)
        {
            this.Id = id;
        }

        public Personagem(string nome, string origem)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
            {
                throw new RegraNegocioException("Não é possível cadastrar personagem overpower");
            }

            this.Nome = nome;
            this.Origem = origem;
        }
    }
}
