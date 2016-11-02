using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public abstract class Kart
    {

        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; set; }

        public List<IEquipamento> Equipamentos { get; }

        private int velocidade;
        public virtual int Velocidade
        {
            get
            {
                int bonusDosEquipamentos = 0;

                foreach (IEquipamento equipamento in this.Equipamentos)
                {
                    bonusDosEquipamentos += equipamento.BonusDeVelocidade;
                }

                int velocidadeTotal = 3 + bonusDosEquipamentos + BonusPorNivelDeHabilidade;

                return velocidadeTotal;
            }
            protected set
            {
                this.velocidade = value;
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        //Retorna o bônus de velocidade dependendo da habilidade do corredor
        //Caso o corredor seja Profissional, deve acrescentar 1 ponto de velocidade para cada equipamento.
        protected int BonusPorNivelDeHabilidade
        {
            get
            {
                switch (this.Corredor.NivelDeHabilidade)
                {
                    // usamos números fixos aqui ao invés de atribuir valores
                    // ao enum diretamente para evitar que, se o enum mudar os valores,
                    // este código passe a funcionar de forma errônea.
                    case NivelDeHabilidade.Noob:
                        return 3;
                    case NivelDeHabilidade.Mediano:
                        return 5;
                    case NivelDeHabilidade.Profissional:
                        return 6 + this.Equipamentos.Count;
                    default:
                        return 3;
                }
            }
        }
    }
}