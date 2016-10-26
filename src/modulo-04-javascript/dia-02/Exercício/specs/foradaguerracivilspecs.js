//Exercício 2
describe('foraDaGuerraCivil', function() {
  it('Deve retornar um array vazio', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", events: {items: {0: {name: 'Civil War'}}}}];

    let herois = new Herois(heroi);
    expect(herois.foraDaGuerraCivil).toEqual([]);
  });

  it('Deve retornar array com o obj do heroi Capitain Marvel', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", events: {items: {0: {name: 'Guerra do Afeganistão'}}}},
                 {name: "Iron Man", events: {items: {0: {name: 'Batalha de NY'},1: {name: 'Civil War'}}}}];

    let herois = new Herois(heroi);
    expect(herois.foraDaGuerraCivil).toEqual([{name: "Captain Marvel (Carol Danvers)", events: {items: {0: {name: 'Guerra do Afeganistão'}}}}]);
  });

  it('Deve retornar array com o obj dos herois Iron Man e Homem Formiga', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)", events: {items: {0: {name: 'Guerra do Afeganistão'}}}},
                 {name: "Iron Man", events: {items: {0: {name: 'Batalha de NY'}}}},
                 {name: "Homem Formiga", events: {items: {0: {name: 'Civil War'}}}}];

    let herois = new Herois(heroi);
    expect(herois.foraDaGuerraCivil).toEqual([{name: "Captain Marvel (Carol Danvers)", events: {items: {0: {name: 'Guerra do Afeganistão'}}}},
                                              {name: "Iron Man", events: {items: {0: {name: 'Batalha de NY'}}}}]);

  });
});