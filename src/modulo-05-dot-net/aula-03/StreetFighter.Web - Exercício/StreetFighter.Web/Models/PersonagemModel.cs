using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class PersonagemModel
    {
        public string Nome { get; set; }
        public string PrimeiraAparicao { get; set; }
        public DateTime Nascimento { get; set; }
        public int Altura { get; set; }
        public double Peso { get; set; }
        public string Medidas { get; set; }
        public string TipoSanguineo { get; set; }
        public string HabilidadesEspeciais { get; set; }
        public string Gosta { get; set; }
        public string Desgosta { get; set; }
        public string EstiloDeLuta { get; set; }
        public string Origem { get; set; }
        public string FalaDaVitoria { get; set; }
        public string SFF2Nickname { get; set; }
        public string SFA3Nickname { get; set; }
        public string SF4Nickname { get; set; }
        public string SFA3Stage { get; set; }
        public string SF2Stage { get; set; }
        public string GolpesEspeciaisFamosos { get; set; }
        public string Imagem { get; set; }
    }
}