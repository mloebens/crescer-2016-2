using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioArquivo : IPersonagemRepositorio
    {


        private const string ArquivoDePersonagens =
            @"D:\Crescer\crescer-2016-2\src\modulo-05-dot-net\aula-03\StreetFighter.Web - Exercício\personagens.csv";


        //Listar Personagens
        //Caso nenhum parametro seja passado no filtroNome, retorna todos os personagens
        //Se não, retorna os personagens que contenham o nome passado pelo filtro
        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            return this.LePersonagensDoArquivo()
                    .Where(personagem => 
                        String.IsNullOrEmpty(filtroNome) || 
                        personagem.Nome.ToUpperInvariant().Contains(filtroNome.ToUpperInvariant()))
                    .ToList();
        }



        //Incluir Personagem
        //Realiza a persistencia do objeto personagem dentro de um arquivo CSV
        public void IncluirPersonagem(Personagem personagem)
        {

            List<Personagem> listaDePersonagens = this.LePersonagensDoArquivo();

            //cria o proximo Id
            int novoId = listaDePersonagens.Last().Id + 1;

            string personagemCSV = personagem.ToString();
            File.AppendAllText(ArquivoDePersonagens, Environment.NewLine + $"{novoId};{personagemCSV}");
        }

        //Editar Personagem
        public void EditarPersonagem(Personagem personagem)
        {
            List<Personagem> listaDePersonagens = this.LePersonagensDoArquivo();

            for (int i = 0; i < listaDePersonagens.Count; i++)
            {
                if (listaDePersonagens[i].Id == personagem.Id)
                {
                    listaDePersonagens.RemoveAt(i);
                    listaDePersonagens.Insert(i, personagem);
                    break;

                }
            }
            IncluirListaDePersonagens(listaDePersonagens);
        }

        //Excluir Personagem
        public bool ExcluirPersonagem(Personagem personagem)
        {
            List<Personagem> listaDePersonagens = this.LePersonagensDoArquivo();
            Personagem personagemEcontradoNaLista = listaDePersonagens.FirstOrDefault(p => p.Id == personagem.Id);

            bool removeu = listaDePersonagens.Remove(personagemEcontradoNaLista);

            this.IncluirListaDePersonagens(listaDePersonagens);

            return removeu;
        }

        //Buscar personagem pelo Id
        public Personagem BuscarPersonagem(int id)
        {
            return LePersonagensDoArquivo().FirstOrDefault(personagem => personagem.Id == id);
        }

        //Grava uma lista de personagens em um arquivo CSV
        private void IncluirListaDePersonagens(List<Personagem> personagens)
        {
            File.WriteAllLines(ArquivoDePersonagens, personagens.Select(p => p.ToString()));
        }

        //Le o arquivo de texto CSV e retorna lista de personagens
        private List<Personagem> LePersonagensDoArquivo()
        {
            return File.ReadAllLines(ArquivoDePersonagens)
                    .Select(personagem => this.StringParaPersonagem(personagem))
                    .ToList();
        }

        private Personagem StringParaPersonagem(string texto)
        {
            string[] personagemArray = texto.Split(';');


            return new Personagem(
                        personagemArray[0],
                        Convert.ToDateTime(personagemArray[1]),
                        Convert.ToInt32(personagemArray[2]),
                        Convert.ToDecimal(personagemArray[3]),
                        personagemArray[4],
                        personagemArray[5],
                        Convert.ToBoolean(personagemArray[6]),
                        personagemArray[7]);

        }
    }
}
