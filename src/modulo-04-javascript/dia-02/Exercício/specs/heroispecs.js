//Exercício 1
describe('Herois', function() {
  it('Deve retornar a mesma lista cadastrada', function() {
    let herois = new Herois(marvel)
    expect(herois._herois).toEqual(marvel);
  });

  it('Deve retornar undefined pois não foi passado nada de parametro', function() {
    let herois = new Herois()
    expect(herois._herois).toBeUndefined();
  });
});
