using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Loja.Dominio;
using Loja.Tests.Mocks;
using System.Collections.Generic;

namespace Loja.Tests
{
    [TestClass]
    public class ProdutoServicoTest
    {
        [TestMethod]
        public void BuscarTodosOsProdutos()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.BuscarProdutos(null);

            Assert.AreEqual(3, produtos.Count);
        }

        [TestMethod]
        public void BuscarTecladoEEncontrar()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.BuscarProdutos("teclado");

            Assert.AreEqual(1, produtos.Count);
            Assert.AreEqual(3, produtos[0].Id);
        }

        [TestMethod]
        public void BuscarTelevisaoENaoEncontrar()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.BuscarProdutos("televisao");

            Assert.AreEqual(0, produtos.Count);
        }
    }
}
