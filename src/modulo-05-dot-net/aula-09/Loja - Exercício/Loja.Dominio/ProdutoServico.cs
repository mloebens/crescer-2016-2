using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRespositorio produtoRepositorio;

        public ProdutoServico(IProdutoRespositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public IList<Produto> BuscarProdutos(string filtro = null)
        {
            return produtoRepositorio.BuscarProdutos(filtro);
        }
    }
}
