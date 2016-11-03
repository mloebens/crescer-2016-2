using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }
        public string Nome { get;  private set; }
        public DateTime Nascimento { get; set; }
        public int? Altura { get; set; }
        public decimal Peso { get; set; }
        public string Origem { get; private set; }
        public string GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }
        public string Imagem { get; set; }

        public Personagem(int id, string nome, DateTime nascimento, int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto, string imagem)
            : this(nome, nascimento, altura, peso, origem, golpesEspeciais, personagemOculto, imagem)
        {
            this.Id = id;
        }

        public Personagem(string nome, DateTime nascimento, int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto, string imagem)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar um personagem overpowered.");

            this.Nome = nome;
            this.Nascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.Imagem = imagem;
        }
    }
}
