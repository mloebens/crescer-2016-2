using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {

        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento;   
        }

        public IEquipamento Equipamento { get; }

        public int BonusDeVelocidade
        {
            get
            {
                double bonus = 1.2; // 20%
                int bonusEquipamento = this.Equipamento.BonusDeVelocidade;

                int novoBonusDeVelocidade = (int) Math.Ceiling(bonusEquipamento * bonus);

                return novoBonusDeVelocidade;
            }
        }
    }
}
