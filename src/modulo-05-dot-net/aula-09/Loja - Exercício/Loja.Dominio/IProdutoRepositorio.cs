using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        IList<Produto> BuscarProdutos(string filtro);
        Produto BuscarProdutoPeloNome(string nome);
        Produto BuscarProdutoPeloId(int id);
        void Inserir(Produto produto);
        void Editar(Produto produto);
        void Excluir(Produto produto);

    }
}
