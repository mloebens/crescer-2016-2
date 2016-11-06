using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(string nome, string[] permissoes = null)
        {
            this.Nome = nome;
            this.Permissoes = permissoes;
        }

        [Required]
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }
    }
}