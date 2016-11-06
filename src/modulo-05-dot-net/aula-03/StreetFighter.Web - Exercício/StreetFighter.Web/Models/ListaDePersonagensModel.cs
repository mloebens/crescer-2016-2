using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class ListaDePersonagensModel
    {
        public ListaDePersonagensModel(List<PersonagemModel> personagens)
        {
            this.Personagens = personagens;
        }

        public List<PersonagemModel> Personagens { get;}
    }
}