using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public Produto BuscarProdutoPeloId(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Produto.FirstOrDefault(p => p.Id == id);
            }
        }

        public Produto BuscarProdutoPeloNome(string nome)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Produto.FirstOrDefault(p => p.Nome.Equals(nome));
            }
        }

        public IList<Produto> BuscarProdutos(string filtro)
        {
            using (var contexto = new ContextoDeDados())
            {

                IList<Produto> produtos = contexto.Produto.Where(p => filtro == null || p.Nome.Contains(filtro)).ToList();
                                            

                return produtos;
            }
        }

        public void Editar(Produto produto)
        {
            bool editou;

            using (var contexto = new ContextoDeDados())
            {
                contexto.Entry<Produto>(produto).State = EntityState.Modified;
                editou = contexto.SaveChanges() > 0;
            }

            if (!editou)
                throw new ProdutoException($"Não foi possível editar o produto '{produto.Nome}'.");

        }

        public void Excluir(Produto produto)
        {
            bool excluiu;
            using (var contexto = new ContextoDeDados())
            {
                contexto.Entry<Produto>(produto).State = EntityState.Deleted;
                excluiu = contexto.SaveChanges() > 0;
            }

            if (!excluiu)
                throw new ProdutoException($"Não foi possível excluir o produto '{produto.Nome}'.");
        }

        public void Inserir(Produto produto)
        {
            bool inseriu;
            using (var contexto = new ContextoDeDados())
            {
                contexto.Entry<Produto>(produto).State = EntityState.Added;
                inseriu = contexto.SaveChanges() > 0;
            }

            if (!inseriu)
                throw new ProdutoException($"Não foi possível cadastrar o produto '{produto.Nome}'.");
        }
    }
}
