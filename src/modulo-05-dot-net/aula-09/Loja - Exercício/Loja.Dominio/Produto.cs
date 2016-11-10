using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class Produto
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public decimal Valor { get; set; }

        public override bool Equals(object obj)
        {
            var item = obj as Produto;

            if (item == null)
            {
                return false;
            }

            return this.Id.Equals(item.Id);
        }
    }
}
