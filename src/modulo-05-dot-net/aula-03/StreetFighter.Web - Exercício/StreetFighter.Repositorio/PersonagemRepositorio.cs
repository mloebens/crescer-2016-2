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
            @"D:\Crescer\crescer-2016-2\src\modulo-05-dot-net\aula-03\StreetFighter.Web - Exercício\personagens.csv";


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
            string personagemCSV = personagem.ToString();
            File.AppendAllText(ArquivoDePersonagens, Environment.NewLine + personagemCSV);
        }

        //Editar Personagem
        public void EditarPersonagem(Personagem personagem)
        {
            List<Personagem> listaDePersonagens = this.ListarPersonagens();
            List<Personagem> personagemASerRemovido = listaDePersonagens.Where(personagemDaLista => personagemDaLista.Id == personagem.Id).ToList();

            bool personagemExiste = personagemASerRemovido.Count == 1;

            if(personagemExiste)
            {
                listaDePersonagens.Remove(personagemASerRemovido[0]);
                listaDePersonagens.Add(personagem);
                IncluirListaDePersonagens(listaDePersonagens);
            }
        }

        //Excluir Personagem
        public void ExcluirPersonagem(Personagem personagem)
        {
            List<Personagem> listaDePersonagens = this.ListarPersonagens();
            listaDePersonagens.Remove(personagem);
        }

        private void IncluirListaDePersonagens(List<Personagem> personagens)
        {
            //Remove o primeiro personagem da lista e insere no arquivo de texto sem quebra de linha.
            File.AppendAllText(ArquivoDePersonagens, personagens[0].ToString() );
            personagens.Remove(personagens[0]);

            foreach (Personagem personagem in personagens)
            {
                File.AppendAllText(ArquivoDePersonagens, Environment.NewLine + personagem.ToString());
            }
        }
    }
}
