using StreetFighter.Dominio;
using StreetFighter.Aplicativo;
using StreetFighter.Web.Models;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using StreetFighter.Filters;
using System;
using AutoMapper;

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
            PersonagemModel personagemModel = this.BuscarPersonagemModel(id);

            return View(personagemModel);
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
        [CwiAutorizador()]
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

        [CwiAutorizador]
        public ActionResult Cadastro()
        {
            PopularPaises();
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        [CwiAutorizador]
        public ActionResult CadastroSalvar(PersonagemModel model)
        {
            PopularPaises();
            
            if (ModelState.IsValid)
            {
                var aplicativo = new PersonagemAplicativo();
                try
                {
                    var personagem = new Personagem(
                        Convert.ToInt32(model.Id),
                        model.Nome,
                        model.Nascimento,
                        Convert.ToInt32(model.Altura),
                        model.Peso,
                        model.Origem,
                        model.GolpesEspeciais,
                        model.PersonagemOculto,
                        model.Imagem
                        );
                    aplicativo.Salvar(personagem);
                } catch (RegraNegocioException e)
                {
                    ModelState.AddModelError("", e.Message);
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


        [CwiAutorizador]
        public ActionResult Editar(int id)
        {
            PersonagemModel personagem = this.BuscarPersonagemModel(id);
            PopularPaises();

            return View("Cadastro", personagem);
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

        //Busca os personagens a partir de um filtro de Nome.
        private List<PersonagemModel> ListarPersonagens(string filtro = null)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            List<Personagem> personagens = aplicativo.ListarPersonagens(filtro);
            List<PersonagemModel> listaDePersonagens = new List<PersonagemModel>();

            foreach (Personagem personagem in personagens)
            {
                listaDePersonagens.Add(PersonagemRepositorioParaPersonagemModel(personagem));
            }

            return listaDePersonagens;
        }

        //Transforma o personagem vindo do repositório para o model usado pela camada mvc
        private PersonagemModel PersonagemRepositorioParaPersonagemModel(Personagem personagem)
        {
            return Mapper.Map<Personagem, PersonagemModel>(personagem);
        }

        //Busca um personagem por id
        private PersonagemModel BuscarPersonagemModel(int id)
        {
            PersonagemAplicativo aplicativo = new PersonagemAplicativo();
            Personagem personagem = aplicativo.BuscarPersonagem(id);
            return PersonagemRepositorioParaPersonagemModel(personagem);
        }
    }
}