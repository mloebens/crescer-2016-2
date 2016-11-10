using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Loja.Dominio;
using Loja.Tests.Mocks;
using System.Collections.Generic;
using FakeItEasy;

namespace Loja.Tests
{
    [TestClass]
    public class ProdutoServicoTest
    {
        [TestMethod]
        public void ProdutoBuscarTodosOsProdutos()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.BuscarProdutos(null);

            Assert.AreEqual(3, produtos.Count);
        }

        [TestMethod]
        public void ProdutoBuscarPorFiltroEEncontrar()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.BuscarProdutos("tecl");

            Assert.AreEqual(1, produtos.Count);
            Assert.AreEqual(3, produtos[0].Id);
        }

        [TestMethod]
        public void ProdutoBuscarPorFiltroENaoEncontrar()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            IList<Produto> produtos = produtoServico.BuscarProdutos("televisao");

            Assert.AreEqual(0, produtos.Count);
        }

        [TestMethod]
        public void ProdutoBuscarPorNomeEEncontrar()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = produtoServico.BuscarProdutoPeloNome("teclado");

            Assert.IsNotNull(produto);
        }

        [TestMethod]
        public void ProdutoBuscarPorNomeENEncontrar()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = produtoServico.BuscarProdutoPeloNome("televisão");

            Assert.IsNull(produto);
        }


        [TestMethod]
        public void ProdutoEditarComSucesso()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 1,
                Nome = "Omo",
                Valor = 2.50M
            };

            produtoServico.Editar(produto);
            Produto produtoEditado = produtoServico.BuscarProdutoPeloNome("Omo");

            Assert.IsNotNull(produtoEditado);
        }

        [TestMethod]
        public void ProdutoInserirComSucesso()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 4,
                Nome = "Omo",
                Valor = 2.50M
            };

            produtoServico.Inserir(produto);
            Produto produtoEditado = produtoServico.BuscarProdutoPeloNome("Omo");

            Assert.IsNotNull(produtoEditado);
        }

        [TestMethod]
        public void ProdutoDeletadoComSucesso()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 1,
                Nome = "Ajax",
                Valor = 2.50M
            };

            produtoServico.Excluir(1);
            Produto produtoExcluido = produtoServico.BuscarProdutoPeloNome("Ajax");

            Assert.IsNull(produtoExcluido);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoException))]
        public void ProdutoNomeDeveSerMaiorQueUmCaracter()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 4,
                Nome = "a",
                Valor = 2.50M
            };
            produtoServico.Inserir(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoException))]
        public void ProdutoValorDeveSerMaiorQueZero()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 4,
                Nome = "Omo",
                Valor = 0M
            };
            produtoServico.Inserir(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ProdutoException))]
        public void ProdutoNaoPodeSerCadastradoComMesmoNome()
        {
            ProdutoServico produtoServico =
                new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto()
            {
                Id = 4,
                Nome = "Ajax",
                Valor = 1M
            };
            produtoServico.Inserir(produto);
        }
    }
}
