using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            var personagem = new PersonagemModel();

            personagem.Nome = "Blanka";
            personagem.Nascimento = new DateTime(1966, 2, 12);
            personagem.Altura = 192;
            personagem.Peso = 96;
            personagem.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia)";
            personagem.GolpesEspeciais = "Electric Thunder, Rolling Attack";
            personagem.PersonagemOculto = false;
            personagem.Imagem = "/Content/imagens/blanka.png";

            return View(personagem);
        }


        public ActionResult ListaDePersonagens()
        {


            return View();
        }



        public ActionResult Sobre()
        {
            var sobre = new SobreModel();

            sobre.Nome = "Fulano de Tal";
            sobre.Altura = 190;
            sobre.Peso = 90;
            sobre.Idade = 29;
            sobre.Email = "fulanodetal@talcorp.com";
            sobre.Imagem = "/Content/imagens/akuma.png";

            return View(sobre);
        }

        public ActionResult Cadastro()
        {

            PopularPaises();
            return View();
        }

        public ActionResult CadastroSalvar(PersonagemModel model)
        {

            PopularPaises();

            if (ModelState.IsValid)
            {
                var aplicativo = new PersonagemAplicativo();
                var personagem = new Personagem(model.Nome, model.Origem);
                aplicativo.Salvar(personagem);

                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Da uma olhada aí pls :(");
                return View("Cadastro", model);
            }

            
            
        }



        private void PopularPaises()
        {
            //ViewBag.ListaPersonagens
            ViewBag.ListaPaises = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "EUA", Text = "Estados Unidos" },
                new SelectListItem() { Value = "FR", Text = "França" },
                new SelectListItem() { Value = "JP", Text = "Japão" }
            };
        }
    }
}