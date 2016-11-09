﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRespositorio
    {
        IList<Produto> BuscarProdutos(string filtro);
        void Inserir(Produto produto);
        void Editar(Produto produto);
        void Excluir(Produto produto);
    }
}
