using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    class ProdutoRepositorioMock : IProdutoRespositorio
    {
        private IList<Produto> produtos;

        public ProdutoRepositorioMock()
        {
            produtos = new List<Produto>();
            produtos.Add(new Produto()
            {
                Id = 1,
                Nome = "Ajax",
                Valor = 2.50M
            });
            produtos.Add(new Produto()
            {
                Id = 2,
                Nome = "Mouse",
                Valor = 33.50M
            });
            produtos.Add(new Produto()
            {
                Id = 3,
                Nome = "Teclado",
                Valor = 10M
            });
        }

        public IList<Produto> BuscarProdutos(string filtro)
        {
            return produtos.Where(p => filtro == null || 
                p.Nome.ToUpperInvariant()
                    .Contains(filtro.ToUpperInvariant()))
                    .ToList();
        }

        public void Editar(Produto produto)
        {
            
        }

        public void Excluir(Produto produto)
        {
            throw new NotImplementedException();
        }

        public void Inserir(Produto produto)
        {
            throw new NotImplementedException();
        }
    }
}
