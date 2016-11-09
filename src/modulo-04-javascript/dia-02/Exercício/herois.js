class Herois {

  constructor(array) {
    this.herois = array;
  }

  foraDaGuerraCivil() {

    return this.herois.filter(heroi =>
      heroi.events.items.filter(e => e.name.contem('CiVIl war', true)).length === 0
    )

  }

  maisPublicado() {
    return this.herois.sort((h1, h2) => h2.comics.available - h1.comics.available)[0];
  }

  mediaPaginas() {
    let totalPaginas =
      this.herois
        .map(heroi =>
          heroi.comics.items.reduce((acum, comic) => acum + comic.pageCount, 0)
        )
        .reduce((acum, paginas) => acum + paginas, 0);
    return totalPaginas / this.herois.length;
  }

  seriesPorLongevidade() {

    let todasSeries = []
    this.herois.forEach(heroi => {
      todasSeries = todasSeries.concat(heroi.series.items);
    });

    let diff = serie => serie.endYear - serie.startYear;

    return todasSeries.sort((serie1, serie2) => diff(serie2) - diff(serie1));

  }

  comicMaisCara() {
    let todasComics = []
    this.herois.forEach(heroi => {
      todasComics = todasComics.concat(heroi.comics.items);
    });

    let totalizarPrecos = comic => comic.prices.reduce(
      (acc, objetoPreco) => acc + objetoPreco.price
    , 0);

    return todasComics.sort(
      (comic1, comic2) => totalizarPrecos(comic2) - totalizarPrecos(comic1)
    )[0]
  }









}
