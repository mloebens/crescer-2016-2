﻿using System;
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
        public DateTime Nascimento { get; set; }
        public int? Altura { get; set; }
        public decimal Peso { get; set; }
        public string Origem { get; set; }
        public string GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }
        public string Imagem { get; set; }


        public Personagem()
        {

        }

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

        private void Restricoes(string nome, string origem)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar um personagem overpowered.");

            if (origem == "MP" && !nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException($"Somente um personagem pode ser dessa região e esse personagem não é o { nome }.");
        }
    }
}
