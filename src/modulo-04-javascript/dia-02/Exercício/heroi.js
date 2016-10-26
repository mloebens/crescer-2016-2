class Herois {
	constructor(arrayDeHerois){
		this.herois = arrayDeHerois;
	}

	get foraDaGuerraCivil(){

		let resultado = this.herois.filter(heroi =>
				heroi.events.items.filter(e => e.name.indexOf('Civil War') !== -1
				).length === 0
		);

		return resultado;
	}

	get maisPublicado(){

		return this.herois.sort((h1, h2) => {
			return h2.comics.available - h1.comics.available
		})[0];
	}

	get mediaPaginas(){
		let totalPaginas =
		this.herois
			.map(heroi =>
				heroi.comics.items.reduce((acum, comic) => acum + comic.pageCount, 0)
			 )
			.reduce((acum, paginas) => acum + paginas, 0);

			return totalPaginas / this.herois.length;
	}

	get seriesPorLongevidade(){
		let arraySeries = [];

		this.herois.forEach(heroi => {
			arraySeries = arraySeries.concat(heroi.series.items);
		})

		let diff = serie => serie.endYear - serie.startYear;

		arraySeries.sort(function(serie2,serie1){
			return diff(serie2) - diff(serie1);
		});
	}

	get comicMaisCara(){

		let todasComics = [];

		this.herois.forEach(heroi => {
			todasComics = todasComics.concat(heroi.comics.items);
		})

		let totalizarPrecos = comic => comic.prices.reduce((acc, chavePreco) => acc + chavePreco.price, 0);

		return todasComics
			.sort((comic1, comic2) => totalizarPrecos(comic2) - totalizarPrecos(comic1));
	}

}
