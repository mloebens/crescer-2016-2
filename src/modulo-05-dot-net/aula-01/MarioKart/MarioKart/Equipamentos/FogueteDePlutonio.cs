using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio(int nivel = 2)
        {
            this.Nivel = nivel;
        }

        private int nivel;
        public int Nivel
        {
            get
            {
                return this.nivel;
            }
            private set
            {
                bool nivelValido = value >= 1 || value <= 5;
                int nivelPadrao = 2;

                if (nivelValido)
                {
                    this.nivel = value;
                    this.BonusDeVelocidade = value;
                } else
                {
                    this.nivel = nivelPadrao;
                    this.BonusDeVelocidade = nivelPadrao;
                }
            }
        }

        public int BonusDeVelocidade { get; private set; }
    }
}
