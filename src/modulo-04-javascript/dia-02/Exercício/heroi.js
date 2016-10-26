class Herois {
	constructor(arrayDeHerois){
		this._herois = arrayDeHerois;
	}

	get foraDaGuerraCivil(){
		let heroisForaDaGuerra = new Array();

		for (let chaveHeroi in this._herois){
			let heroi = this._herois[chaveHeroi];
			let eventos = this._herois[chaveHeroi]['events']['items'];
			let estaNaGuerra = false;

			for(let chaveEvento in eventos ){
				let evento = eventos[chaveEvento];

				if(evento.name === 'Civil War'){
					estaNaGuerra = true;
				}
			}

			if(!estaNaGuerra){
				heroisForaDaGuerra.push(heroi);
			}
		}
		return heroisForaDaGuerra;
	}

	get maisPublicado(){
		let heroiMaisPublicado;

		for (let chaveHeroi in this._herois){
			let heroi = this._herois[chaveHeroi];
			let publicacoes = this._herois[chaveHeroi]['comics']['available'];

			if(!heroiMaisPublicado || publicacoes > heroiMaisPublicado['comics']['available'] ){
				heroiMaisPublicado = heroi;
			}
		}
		return heroiMaisPublicado;
	}

	get mediaPaginas(){
		let totalPaginas = 0;
		let quantidadeComics = 0;

		for (let chaveHeroi in this._herois){
			let heroi = this._herois[chaveHeroi];
			let comics = this._herois[chaveHeroi]['comics']['items'];
			let estaNaGuerra = false;

			for(let chaveComic in comics ){

				let paginas = comics[chaveComic]['pageCount'];

				totalPaginas += paginas;
				quantidadeComics++;

			}
		}

		let resultadosZerados = totalPaginas === 0 || quantidadeComics === 0 ;
		return resultadosZerados ? 0 : parseInt(totalPaginas / quantidadeComics);
	}

	get seriesPorLongevidade(){
		let arraySeries = [];

		for (let chaveHeroi in this._herois){
			let series = this._herois[chaveHeroi]['series']['items'];

			for(let chaveSerie in series ){
				arraySeries.push(series[chaveSerie]);
			}
		}

		arraySeries.sort(function(a,b){
			let aTempo = a['endYear'] - a['startYear'];
			let bTempo = b['endYear'] - b['startYear'];
			return aTempo > bTempo ? -1 : 1;
		});

		return arraySeries;
	}

	get comicMaisCara(){

		let comicMaisCara;

		for (let chaveHeroi in this._herois){
			let heroi = this._herois[chaveHeroi];
			let comics = this._herois[chaveHeroi]['comics']['items'];

			for(let chaveComic in comics ){

				let comicAtual = comics[chaveComic];
				let comicAtualValor = comicAtual['prices'][0]['price'];
				let comicMaisCaraValor = !!comicMaisCara ? comicMaisCara['prices'][0]['price'] : 0;

				comicMaisCara = comicAtualValor > comicMaisCaraValor ? comicAtual : comicMaisCara;
			}
		}

		return comicMaisCara;
	}

}
