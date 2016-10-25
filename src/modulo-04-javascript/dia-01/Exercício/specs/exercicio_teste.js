//Exercício 3
describe('find()', function() {
  it('Deve retornar valores maiores ou igual a 2', function() {

    var maiorIgualADois = function(elemento) {
      return elemento >= 2;
    };

    var resultado = find([ 1, 2, 3 ], maiorIgualADois);
    expect(resultado).toEqual([2,3]);
  });

  it('Deve retornar valores "String"', function() {

    var resultado = find([ 'a', 5, null, false, 'false' ], function(elem) {
      return typeof elem === 'string';
    });
    expect(resultado).toEqual([ 'a', 'false' ]);
  });

  it('Deve retornar obj vazio', function() {

    var resultado = find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
      return typeof elem.nome === 'c';
    });
    expect(resultado).toEqual([]);
  });
});

//Exercício 4
describe('subtrair()', function() {
  it('2 - 1 = Deve retornar 1', function() {
    var resultado = subtrair(2)(1);
    expect(resultado).toEqual(1);
  });

  it('0 - 0 = Deve retornar 0', function() {
    var resultado = subtrair(0)(0);
    expect(resultado).toEqual(0);
  });

  it('-1 - 2 = Deve retornar -3', function() {
    var resultado = subtrair(-1)(2);
    expect(resultado).toEqual(-3);
  });
});

//Exercício 5
describe('iguais()', function() {
  it('obj = { a: { a: \'a\' } é igual a ele mesmo', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais(obj,obj);
    expect(resultado).toEqual(true);
  });

  it('obj = { a: { a: \'a\' } não é igual a { a: 1, b: 2 }', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais(obj, { a: 1, b: 2 });
    expect(resultado).toEqual(false);
  });

  it('obs = { a: { a: \'a\' }, b: 2 } é igual a { a: { a: \'a\' }, b: 2 }', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais(obj, { a: { a: 'a' }, b: 2 });
    expect(resultado).toEqual(true);
  });

  it('{ a: 1 } não é igual a { b: 1 }', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais({ a: 1 }, { b: 1 });
    expect(resultado).toEqual(false);
  });

  it('{ a: 1 } não é igual a { a: 1, b: 2 }', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais({ a: 1 }, { a: 1, b: 2 });
    expect(resultado).toEqual(false);
  });  
});

//Exercício 6
describe('ctrlC()', function() {
  it('{ a: \'1\' } = Deve retornar { a: \'1\' }', function() {
    var resultado = ctrlC({ a: '1' });
    expect(resultado).toEqual({ a: '1' });
  });

  it('origem = { a: \'1\' }, destino = ctrlC(origem) = Deve retornar true utilizando iguais() e diferente utilizando ===', function() {
    var origem = { a: '1' };
    var destino = ctrlC({ a: '1' });
    var resultado = iguais(origem, destino);
    expect(resultado).toEqual(true);
    expect(origem === destino).toEqual(false);
  });

  it('Retornar valor de acordo com a posição especificada', function() {
    var resultado = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
    expect(resultado.a[0]).toEqual({ b: '1', c: '2' });
    expect(resultado.a[1]).toEqual({ d: false });
    expect(resultado.a[2].e()).toEqual(3);
  });
});

//Exercício 7
describe('mesclar()', function() {
  it('Mesclar dois objetos', function() {
    var objeto1 = {
      abacaxi: 0,
      banana: { peso: 52, preco: 100 },
      cereja: 97
    };
    var objeto2 = {
      banana: { preco: 200 },
      damasco: 100
    };
    mesclar(objeto1, objeto2);
    expect(objeto1).toEqual({ abacaxi: 0, banana: { preco: 200 }, cereja: 97, damasco: 100 });
  });

   it('Mesclar dois objetos utilizando terceiro parametro como true', function() {
    var objeto1 = {
      abacaxi: 0,
      banana: { peso: 52, preco: 100, origem: { cidade: 'taquari', estado: 'rs' } },
      cereja: 97
    };
    var objeto2 = {
      banana: { preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
      damasco: 100
    };
    mesclar(objeto1, objeto2, true);
    expect(objeto1).toEqual({ 
        abacaxi: 0,  
        banana: { 
          peso: 52, 
          preco: 200, 
          origem: {  
            cidade: 'cachoeira do sul', 
            estado: 'rs'
          }
        },
        cereja: 97,
        damasco: 100
    });
  });
});
