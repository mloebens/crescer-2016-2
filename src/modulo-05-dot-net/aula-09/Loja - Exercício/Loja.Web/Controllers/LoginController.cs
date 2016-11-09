using AutoMapper;
using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using StreetFighter.Models;
using StreetFighter.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(UsuarioModel usuarioModel)
        {
            if(ModelState.IsValid)
            {
                UsuarioServico usuarioServico = ServicoDeDependencias.MontarUsuarioServico();
                Usuario usuario = Mapper.Map<UsuarioModel, Usuario>(usuarioModel);
                Usuario usuarioAutenticado = usuarioServico.BuscarPorAutenticacao(usuario);

                if (usuarioAutenticado != null)
                {
                    ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(
                        usuarioAutenticado.Email));
                    return RedirectToAction("Listar", "Produto");
                }
            }

            ModelState.AddModelError("", "Usuário/Senha inválida");
            return View("Index");
        }
    }
}