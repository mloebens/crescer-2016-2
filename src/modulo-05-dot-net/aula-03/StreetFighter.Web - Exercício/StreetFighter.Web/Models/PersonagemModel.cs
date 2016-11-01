using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class PersonagemModel
    {
        [DisplayName("Nome:")]
        public string Nome { get; set; }
        [DisplayName("Nascimento:")]
        public DateTime Nascimento { get; set; }
        [DisplayName("Altura")]
        public int? Altura { get; set; }
        [DisplayName("Peso")]
        public decimal Peso { get; set; }
        [DisplayName("Origem")]
        public string Origem { get; set; }
        public string GolpesEspeciaisFamosos { get; set; }
        public bool PersonagemOculto { get; set; }
        public string Imagem { get; set; }
    }
}