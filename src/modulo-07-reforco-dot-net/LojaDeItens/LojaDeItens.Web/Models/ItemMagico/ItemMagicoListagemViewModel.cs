using LojaDeItens.Dominio.ItemMagico;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Models.ItemMagico
{
    public class ItemMagicoListagemViewModel
    {
        public ItemMagicoListagemViewModel(IList<ItemMagicoEntidade> itens)
        {
            this.Itens = this.ConverterEmListagemDeItens(itens);
        }

        public string GridId { get; set; }

        public int PaginaAtual { get; set; }
        public int QuantidadeDeItensPorPagina { get; set; }

        public int QuantidadeTotalDeItens { get; set; }

        public bool UltimaPagina
        {
            get
            {
                return QuantidadeTotalDeItens - (this.QuantidadeDeItensPorPagina * (this.PaginaAtual+1) ) <= 0;
            }
        }

        public IList<ItemMagicoParaListaViewModel> Itens { get; set; }

        private IList<ItemMagicoParaListaViewModel> ConverterEmListagemDeItens(IList<ItemMagicoEntidade> itens)
        {
            IList<ItemMagicoParaListaViewModel> model = new List<ItemMagicoParaListaViewModel>();

            foreach (var item in itens)
            {
                model.Add(new ItemMagicoParaListaViewModel(item));
            }

            return model;
        }
    }

    
}