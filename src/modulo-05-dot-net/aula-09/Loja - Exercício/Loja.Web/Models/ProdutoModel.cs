using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int? Id { get; set; }

        [Required(ErrorMessage = "Campo nome é obrigatório.")]
        [MinLength(2, ErrorMessage = "O campo nome deve ter no mínimo 2 caracteres.")]
        public string Nome { get; set; }

        [Required(ErrorMessage = "Campo valor é obrigatório.")]
        public decimal Valor { get; set; }
    }
}