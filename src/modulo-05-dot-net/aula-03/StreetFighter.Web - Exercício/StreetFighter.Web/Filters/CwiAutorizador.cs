using StreetFighter.Models;
using StreetFighter.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace StreetFighter.Filters
{
    public class CwiAutorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogadoModel usuario = ServicoDeAutenticacao.UsuarioLogado;
            
            if (usuario == null) return false;

            string[] permissoesRequidas = this.Roles.Split(',')
                                                    .Where(p => !String.IsNullOrEmpty(p))
                                                    .ToArray();

            foreach (string permissao in permissoesRequidas)
            {
                if(!usuario.Permissoes.Any(p => p.Equals(permissao)))
                {
                    return false;
                }
            }

            return true;
        }

        //Redirecionar para pagina de autenticação caso não autenticado
        protected override void HandleUnauthorizedRequest(AuthorizationContext contextoFiltro)
        {
            if (!contextoFiltro.HttpContext.User.Identity.IsAuthenticated)
            {
                contextoFiltro.Result = new RedirectToRouteResult(new
                    RouteValueDictionary(new { controller = "Login" }));
            }
        }
    }
}