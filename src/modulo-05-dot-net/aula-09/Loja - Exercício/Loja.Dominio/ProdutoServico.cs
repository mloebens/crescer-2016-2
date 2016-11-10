using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }


        public Produto BuscarProdutoPeloId(int id)
        {
            return produtoRepositorio.BuscarProdutoPeloId(id);
        }

        public IList<Produto> BuscarProdutos(string filtro = null)
        {
            return produtoRepositorio.BuscarProdutos(filtro);
        }

        public Produto BuscarProdutoPeloNome(string nome)
        {
            return produtoRepositorio.BuscarProdutoPeloNome(nome);
        }


        public void Persistir(Produto produto)
        {
            this.ValidarProduto(produto);

            if(produto.Id == 0)
            {
                bool produtoJaExiste = this.BuscarProdutoPeloNome(produto.Nome) != null;
                if (produtoJaExiste)
                    throw new ProdutoException($"Não é possível cadastrar produtos com nome duplicado.");

                produtoRepositorio.Inserir(produto);
            }
            else
            {
                produtoRepositorio.Editar(produto);
            }
        }


        public void Excluir(int id)
        {
            Produto produto = produtoRepositorio.BuscarProdutoPeloId(id);
            produtoRepositorio.Excluir(produto);
        }


        private void ValidarProduto(Produto produto)
        {
            bool nomeValido =  !String.IsNullOrEmpty(produto.Nome) && produto.Nome.Length >= 2;
            if (!nomeValido)
                throw new ProdutoException("O nome do produto deve possuir pelo menos 2 caracteres.");

            bool valorValido = produto.Valor > 0;
            if (!valorValido)
                throw new ProdutoException("O valor do produto deve ser maior que 0.");
        }
    }
}
