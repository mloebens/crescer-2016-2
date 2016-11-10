using AutoMapper;
using Loja.Dominio;
using Loja.Filters;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {

        [CwiAutorizador]
        public ActionResult Listar(string filtro = null)
        {
            var produtoServico = ServicoDeDependencias.MontarProdutoServico();
            IList<Produto> produtos = produtoServico.BuscarProdutos(filtro);

            return View("ListaDeProdutos", produtos);
        }

        [CwiAutorizador]
        public ActionResult Excluir(int id)
        {

            var produtoServico = ServicoDeDependencias.MontarProdutoServico();
            produtoServico.Excluir(id);

            return RedirectToAction("Listar");
        }

        [CwiAutorizador]
        public ActionResult Inserir()
        {
            return View("ProdutoPersistir");
        }

        [CwiAutorizador]
        public ActionResult Editar(int id)
        {

            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            Produto produto = produtoServico.BuscarProdutoPeloId(id);
            ProdutoModel produtoModel = Mapper.Map<Produto, ProdutoModel>(produto);

            return View("ProdutoPersistir", produtoModel);
        }

        [CwiAutorizador]
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(ProdutoModel produtoModel)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    Produto produto = Mapper.Map<ProdutoModel, Produto>(produtoModel);
                    ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
                    produtoServico.Persistir(produto);

                    return RedirectToAction("Listar");
                }
            } catch (ProdutoException e)
            {
                ModelState.AddModelError("", e.Message);
                return View("ProdutoPersistir", produtoModel);
            }
            

            ModelState.AddModelError("","Ocorreu um erro no preenchimento do formulário.");
            return View("ProdutoPersistir", produtoModel);
        }

    }
}