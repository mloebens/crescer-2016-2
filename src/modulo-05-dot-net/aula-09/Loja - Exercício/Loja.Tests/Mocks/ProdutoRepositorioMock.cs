using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    class ProdutoRepositorioMock : IProdutoRepositorio
    {

        public IList<Produto> produtos;

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

        public Produto BuscarProdutoPeloId(int id)
        {
            return produtos.FirstOrDefault(p => p.Id == id);
        }

        public Produto BuscarProdutoPeloNome(string nome)
        {
            return produtos.FirstOrDefault(p => p.Nome.ToUpperInvariant().Equals(nome.ToUpperInvariant()));
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
            Produto produtoParaEditar = produtos.FirstOrDefault(p => p.Id == produto.Id);
            produtoParaEditar.Nome = produto.Nome;
            produtoParaEditar.Valor = produto.Valor;
        }

        public void Excluir(Produto produto)
        {
            produtos.Remove(produto);
        }

        public void Inserir(Produto produto)
        {
            produtos.Add(produto);
        }
    }
}
