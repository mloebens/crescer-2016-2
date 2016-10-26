//Exercício 4
describe('mediaPaginas', function() {
  it('Deve retornar 25', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", comics: {items: {0: {pageCount: 20}, 1: {pageCount: 30}}}}];
    let herois = new Herois(heroi);
    expect(herois.mediaPaginas).toEqual(25);
  });

  it('Deve retornar 41', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", comics: {items: {0: {pageCount: 20}, 1: {pageCount: 30}}}},
                 {name: "Iron Man", comics: {items: {0: {pageCount: 40}, 1: {pageCount: 77}}}}];

    let herois = new Herois(heroi);
    expect(herois.mediaPaginas).toEqual(41);
  });

  it('Deve retornar 119', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", comics: {items: {0: {pageCount: 20}, 1: {pageCount: 30}}}},
                 {name: "Iron Man", comics: {items: {0: {pageCount: 40}, 1: {pageCount: 77}}}},
                 {name: "Homem Formiga", comics: {items: {0: {pageCount: 430}}}}];

    let herois = new Herois(heroi);
    expect(herois.mediaPaginas).toEqual(119);
  });

  it('Deve retornar 0', function() {


    let herois = new Herois();
    expect(herois.mediaPaginas).toEqual(0);
  });

});










