//Exercício 5
describe('seriesPorLongevidade', function() {
  it('Deve retornar a serie Perdidos no Espaço', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", series: {items: {0: {name: 'Perdidos no Espaço', endYear: 2001, startYear: 2000}}}}];
    let herois = new Herois(heroi);
    expect(herois.seriesPorLongevidade).toEqual([{name: 'Perdidos no Espaço', endYear: 2001, startYear: 2000}]);
  });


    it('Deve retornar as series Game of Thrones, Perdidos no Espaço', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", series: {items: {0: {name: 'Perdidos no Espaço', endYear: 2001, startYear: 2000}}}},
                 {name: "Iron Man", series: {items: {0: {name: 'Game of Thrones', endYear: 2010, startYear: 2000}}}}];
    let herois = new Herois(heroi);
    expect(herois.seriesPorLongevidade).toEqual([{name: 'Game of Thrones', endYear: 2010, startYear: 2000},
                                                 {name: 'Perdidos no Espaço', endYear: 2001, startYear: 2000}]);
  });
});
