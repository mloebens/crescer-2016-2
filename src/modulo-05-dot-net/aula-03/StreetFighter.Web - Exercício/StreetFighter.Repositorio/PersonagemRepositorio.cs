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
            @"D:\Crescer\github\crescer20162\src\modulo-05-dot-net\aula-03\StreetFighter.Web - Exercício\personagens.csv";


        //Listar Personagens
        //Caso nenhum parametro seja passado no filtroNome, retorna todos os personagens
        //Se não, retorna os personagens que contenham o nome passado pelo filtro
        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            List<Personagem> listaDePersonagens = new List<Personagem>();

            string linha;
            using (var streamReader = new StreamReader(ArquivoDePersonagens))
            {
                while ((linha = streamReader.ReadLine()) != null)
                {
                    string[] dadosPersonagem = linha.Split(';');

                    string nomePersonagem = dadosPersonagem[1];

                    bool personagemValido = filtroNome == null || 
                        nomePersonagem.ToUpperInvariant().Contains(filtroNome.ToUpperInvariant());

                    if (personagemValido)
                    {
                        listaDePersonagens.Add(new Personagem(dadosPersonagem));
                    }
                }
            }
                return listaDePersonagens;
        }

        //Incluir Personagem
        //Realiza a persistencia do objeto personagem dentro de um arquivo CSV
        public void IncluirPersonagem(Personagem personagem)
        {

            List<Personagem> listaDePersonagens = this.ListarPersonagens();

            int novoId = listaDePersonagens.Last().Id + 1;

            string personagemCSV = personagem.ToString();
            File.AppendAllText(ArquivoDePersonagens, Environment.NewLine + $"{novoId};{personagemCSV}");
        }

        //Editar Personagem
        public void EditarPersonagem(Personagem personagem)
        {
            List<Personagem> listaDePersonagens = this.ListarPersonagens();

            for(int i = 0; i < listaDePersonagens.Count; i++)
            {
                if (listaDePersonagens[i].Id == personagem.Id)
                {
                    listaDePersonagens.RemoveAt(i);
                    listaDePersonagens.Insert(i, personagem);
                    break;

                }
            }
        }

        //Excluir Personagem
        public bool ExcluirPersonagem(Personagem personagem)
        {
            List<Personagem> listaDePersonagens = this.ListarPersonagens();
            Personagem personagemEcontradoNaLista = listaDePersonagens.FirstOrDefault(p => p.Id == personagem.Id);

            bool removeu = listaDePersonagens.Remove(personagemEcontradoNaLista);

            this.IncluirListaDePersonagens(listaDePersonagens);

            return removeu;
        }

        private void IncluirListaDePersonagens(List<Personagem> personagens)
        {
            File.WriteAllLines(ArquivoDePersonagens, personagens.Select(p => p.ToString()));
        }
    }
}
