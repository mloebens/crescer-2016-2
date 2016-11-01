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
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        // GET: FichaTecnica
        public ActionResult FichaTecnica()
        {
            var personagem = new PersonagemModel();

            personagem.Nome = "Blanka";
            personagem.PrimeiraAparicao = "Street Fighter II The World Warrior (1991)";
            personagem.Nascimento = new DateTime(1966, 2, 12);
            personagem.Altura = 192;
            personagem.Peso = 96;
            personagem.Medidas = "B198, C120, Q172";
            personagem.TipoSanguineo = "B";
            personagem.HabilidadesEspeciais = "Caçar, Eletricidade";
            personagem.Gosta = "Frutas tropicais, Pirarucu, Sua mãe";
            personagem.Desgosta = "Army ants (espécie de formiga)";
            personagem.EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira";
            personagem.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia)";
            personagem.FalaDaVitoria = "Ver você em ação é uma piada!";
            personagem.SFF2Nickname = "A selvagem criança da natureza";
            personagem.SFA3Nickname = "A animal pessoa amazônica";
            personagem.SF4Nickname = "Guerreiro da selva";
            personagem.SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?)";
            personagem.SF2Stage = "Bacia do rio Amazonas (Brasil)";
            personagem.GolpesEspeciaisFamosos = "Electric Thunder, Rolling Attack";

            return View(personagem);
        }


        // GET: Sobre
        public ActionResult Sobre()
        {
            var personagem = new PersonagemModel();

            personagem.Nome = "Akuma";
            personagem.PrimeiraAparicao = "Super Street Fighter II Turbo (1993)";
            personagem.Altura = 178;
            personagem.Peso = 80;
            personagem.Medidas = "B118, C84, Q86";
            personagem.TipoSanguineo = "Desconhecido";
            personagem.HabilidadesEspeciais = "Desconhecida";
            personagem.Gosta = "Desconhecido";
            personagem.Desgosta = "Desconhecido";
            personagem.EstiloDeLuta = "Desconhecido (Goutetsu’s Ansatsuken maximizando Satsui no Hadou)";
            personagem.Origem = "Japão";
            personagem.FalaDaVitoria = "Agora, permaneça deitado!";
            personagem.SFF2Nickname = "Desconhecido";
            personagem.SFA3Nickname = "Desconhecido";
            personagem.SF4Nickname = "Desconhecido";
            personagem.SFA3Stage = "A Caverna de Kiga (Japão)";
            personagem.SF2Stage = "Desconhecido";
            personagem.GolpesEspeciaisFamosos = "Desconhecido";

            return View("FichaTecnica", personagem);
        }
    }
}