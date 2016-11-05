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

        public ActionResult FichaTecnica(int id)
        {

            List<PersonagemModel> listaDePersonagens = ListarPersonagens();
            PersonagemModel personagem = listaDePersonagens.Where(p => p.Id == id).ToList()[0];

            return View(personagem);
        }

        public ActionResult Excluir(int id)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            List<Personagem> personagens = aplicativo.ListarPersonagens();

            Personagem personagem = personagens.FirstOrDefault(p => p.Id == id);

            bool personagemExcluido = aplicativo.Exluir(personagem);
            if (personagemExcluido)
            {
                TempData["Mensagem"] = "<script>alert('Personagem excluido com sucesso!')</script>";
            }
            return RedirectToAction("ListaDePersonagens");
        }


        [HttpGet]
        public ActionResult ListaDePersonagens(string filtro)
        {
            ListaDePersonagensModel listaDePersonagens = new ListaDePersonagensModel(ListarPersonagens(filtro));
            return View("ListaDePersonagens", listaDePersonagens);
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

        [HttpPost]
        public ActionResult CadastroSalvar(PersonagemModel model)
        {
            PopularPaises();

            if (ModelState.IsValid)
            {
                var aplicativo = new PersonagemAplicativo();
                try
                {
                    var personagem = new Personagem(model.ToString().Split(';'));
                    aplicativo.Salvar(personagem);
                } catch (RegraNegocioException e)
                {
                    ViewBag.Message = $"<script>alert('{e.Message}')</script>";
                    return View("Cadastro", model);
                }


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
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "MP", Text = "Morro da Pedra" }
            };
        }

        private List<PersonagemModel> ListarPersonagens(string filtro = null)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            List<Personagem> personagens = aplicativo.ListarPersonagens(filtro);
            List<PersonagemModel> listaDePersonagens = new List<PersonagemModel>();

            foreach (Personagem personagem in personagens)
            {
                listaDePersonagens.Add(new PersonagemModel(personagem.ToString().Split(';')));
            }

            return listaDePersonagens;
        }
    }
}