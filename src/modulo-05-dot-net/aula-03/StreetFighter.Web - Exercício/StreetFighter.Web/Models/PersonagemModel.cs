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
    }
}