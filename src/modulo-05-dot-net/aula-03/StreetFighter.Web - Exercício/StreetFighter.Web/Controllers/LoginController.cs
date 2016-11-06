using StreetFighter.Aplicacao;
using StreetFighter.Dominio;
using StreetFighter.Filters;
using StreetFighter.Models;
using StreetFighter.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Controllers
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
        public ActionResult FazerLogin(string usuario, string senha)
        {

            ServicoDeUsuarioAplicativo servicoDeUsuarioAplicativo = new ServicoDeUsuarioAplicativo();

            Usuario usuarioAutenticado = servicoDeUsuarioAplicativo.BuscarUsuarioAutenticado(
                    usuario, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(
                    usuarioAutenticado.Nome, usuarioAutenticado.Permissoes));
                return RedirectToAction("ListaDePersonagens","StreetFighter");
            }


            ModelState.AddModelError("", "Usuário/Senha inválida");
            return View("Index");
        }
    }
}