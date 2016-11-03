using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {


        private const string ArquivoDePersonagens = 
            @"C:\Users\maicon.loebens\Documents\Crescer\github\crescer-2016-2\src\modulo-05-dot-net\aula-03\StreetFighter.Web - Exercício\personagem.csv";

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> listaDePersonagens = new List<Personagem>();
            string linha;

            using (var streamReader = new StreamReader(ArquivoDePersonagens))
            {
                linha = streamReader.ReadLine();
                string[] dadosPersonagem = linha.Split(';');

                Personagem personagem = new Personagem(
                    Convert.ToInt32(dadosPersonagem[0]),
                    dadosPersonagem[1],
                    Convert.ToDateTime(dadosPersonagem[2]),
                    Convert.ToInt32(dadosPersonagem[3]),
                    Convert.ToDecimal(dadosPersonagem[4]),
                    dadosPersonagem[5],
                    dadosPersonagem[6],
                    Convert.ToBoolean(dadosPersonagem[7]),
                    dadosPersonagem[8]
                    );


                

                listaDePersonagens.Add(personagem);

            }



                return personagens;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}
