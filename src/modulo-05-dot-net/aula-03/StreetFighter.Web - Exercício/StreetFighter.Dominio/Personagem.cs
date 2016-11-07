using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get;}
        public string Nome { get; }
        public DateTime Nascimento { get; }
        public int? Altura { get;}
        public decimal Peso { get;}
        public string Origem { get; }
        public string GolpesEspeciais { get; }
        public bool PersonagemOculto { get; }
        public string Imagem { get; }

        public Personagem(int id, string nome, DateTime nascimento, int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto, string imagem)
            : this(nome, nascimento, altura, peso, origem, golpesEspeciais, personagemOculto, imagem)
        {
            this.Id = id;
        }

        public Personagem(string nome, DateTime nascimento, int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto, string imagem)
        {
            try { 
            this.Restricoes(nome,origem);
            } catch (RegraNegocioException e)
            {
                throw e;
            }

            this.Nome = nome;
            this.Nascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.Imagem = imagem;
        }



        //retorna o Personagem em formato CSV
        //Caso o Id seja 0, não adiciona o Id
        public override string ToString()
        {
            string texto = this.Id != 0 ? $"{this.Id};" : "";
            texto += $"{this.Nome};{this.Nascimento};{this.Altura};{this.Peso};{this.Origem};{this.GolpesEspeciais};{this.PersonagemOculto};{this.Imagem}";

            return texto;
        }

        private void Restricoes(string nome, string origem)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar um personagem overpowered.");

            if (origem == "MP" && !nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException($"Somente um personagem pode ser dessa região e esse personagem não é o { nome }.");
        }
    }
}
