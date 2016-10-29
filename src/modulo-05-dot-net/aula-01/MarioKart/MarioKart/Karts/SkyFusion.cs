using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamento
    {

        public SkyFusion(Corredor corredor) : base(corredor)
        {
        }

        public int BonusDeVelocidade
        {
            get
            {
                int velocidadeMinimaParaBonus = 13;
                int bonusExtra = 5;
                int bonusVelocidade = this.bonusDeEquipamento() + this.bonusDeNivelDeCorredor();
                bool adicionarBonusExtra = bonusVelocidade >= velocidadeMinimaParaBonus;

                if (adicionarBonusExtra)
                {
                    bonusVelocidade += bonusExtra;
                }

                return bonusVelocidade;
            }
        }


        private int bonusDeEquipamento()
        {
            int umPontoDeBonusPorEquipamento = this.Equipamentos.Count;
            return umPontoDeBonusPorEquipamento;
        }

        private int bonusDeNivelDeCorredor()
        {
            int bonusNoob = 1;
            int bonusMediano = 2;
            int bonusProfissional = 3;
            bool nivelDeHabilidadeNoob = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Noob;
            bool nivelDeHabilidadeMediano = this.Corredor.NivelDeHabilidade == NivelDeHabilidade.Mediano;

            if (nivelDeHabilidadeNoob)
            {
                return bonusNoob;
            }

            if (nivelDeHabilidadeMediano)
            {
                return bonusMediano;
            }

            return bonusProfissional;
        }
    }
}
