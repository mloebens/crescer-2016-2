//Exercício 3
describe('maisPublicado', function() {
  it('Deve retornar objeto do Captain Marvel', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", comics: {available: 200}}];

    let herois = new Herois(heroi);
    expect(herois.maisPublicado).toEqual({name: "Captain Marvel (Carol Danvers)", comics: {available: 200}});
  });

  it('Deve retornar array com o obj do heroi Iron Man', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", comics: {available: 200}},
                 {name: "Iron Man", comics: {available: 300 }}];

    let herois = new Herois(heroi);
    expect(herois.maisPublicado).toEqual({name: "Iron Man", comics: {available: 300 }});
  });

  it('Deve retornar array com o obj dos herois Iron Man', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", comics: {available: 200}},
                 {name: "Iron Man", comics: {available: 300 }},
                 {name: "Homem Formiga", comics: {available: 40}}];

    let herois = new Herois(heroi);
    expect(herois.maisPublicado).toEqual({name: "Iron Man", comics: {available: 300 }});

  });
});