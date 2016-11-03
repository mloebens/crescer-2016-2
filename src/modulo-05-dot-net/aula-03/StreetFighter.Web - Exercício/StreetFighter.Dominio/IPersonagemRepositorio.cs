using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IPersonagemRepositorio
    {

        List<Personagem> ListarPersonagens(string filtroNome);

        void IncluirPersonagens(Personagem personagem);

        void EditarPersonagens(Personagem personagem);

        void ExcluirPersonagens(Personagem personagem);
    }
}
