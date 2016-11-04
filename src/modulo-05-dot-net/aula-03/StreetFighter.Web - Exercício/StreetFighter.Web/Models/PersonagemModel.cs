using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class PersonagemModel
    {
        public int Id { get; set; }

        [DisplayName("Nome:")]
        [Required(ErrorMessage = "Campo Nome é obrigatório.")]
        public string Nome { get; set; }

        [DisplayName("Nascimento:")]
        [Required(ErrorMessage = "Campo Nascimento é obrigatório.")]
        public DateTime Nascimento { get; set; }

        [DisplayName("Altura:")]
        [Required(ErrorMessage = "Campo Altura é obrigatório.")]
        public int? Altura { get; set; }

        [DisplayName("Peso:")]
        [Required(ErrorMessage = "Campo Peso é obrigatório.")]
        public decimal Peso { get; set; }

        [DisplayName("Origem:")]
        [Required(ErrorMessage = "Campo Origem é obrigatório.")]
        public string Origem { get; set; }
    
        [DisplayName("Golpes Especiais:")]
        [Required(ErrorMessage = "Campo Golpe Especial é obrigatório.")]
        public string GolpesEspeciais { get; set; }
       
        [DisplayName("Personagem Oculto:")]
        public bool PersonagemOculto { get; set; }
        
        [DisplayName("Imagem:")]
        public string Imagem { get; set; }

        public PersonagemModel(int id, string nome, DateTime nascimento, int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto, string imagem)
            : this(nome, nascimento, altura, peso, origem, golpesEspeciais, personagemOculto, imagem)
        {
            this.Id = id;
        }

        public PersonagemModel(string nome, DateTime nascimento, int altura, decimal peso, string origem, string golpesEspeciais, bool personagemOculto, string imagem)
        {
            this.Nome = nome;
            this.Nascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
            this.Imagem = imagem;
        }

        public PersonagemModel(string[] dadosPersonagem) : 
            this(Convert.ToInt32(dadosPersonagem[0]),
                            dadosPersonagem[1],
                            Convert.ToDateTime(dadosPersonagem[2]),
                            Convert.ToInt32(dadosPersonagem[3]),
                            Convert.ToDecimal(dadosPersonagem[4]),
                            dadosPersonagem[5],
                            dadosPersonagem[6],
                            Convert.ToBoolean(dadosPersonagem[7]),
                            dadosPersonagem[8])
        {
        }

        public override string ToString()
        {
            return $"{Id};{Nome};{Nascimento};{Altura};{Peso};{Origem};{GolpesEspeciais};{PersonagemOculto};{Imagem}";
        }
    }
}