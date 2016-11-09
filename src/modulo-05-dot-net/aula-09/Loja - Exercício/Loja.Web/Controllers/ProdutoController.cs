using Loja.Filters;
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
        public ActionResult Listar()
        {


            return View();
        }
    }
}