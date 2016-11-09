using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(string nome)
        {
            this.Nome = nome;
        }

        [Required]
        public string Nome { get; private set; }
    }
}