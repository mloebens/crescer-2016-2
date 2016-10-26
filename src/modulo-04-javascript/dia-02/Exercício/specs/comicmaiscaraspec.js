//Exercício 6
describe('comicMaisCara', function() {
  it('Deve retornar a comic Volume 2', function() {

    let heroi = [{name: "Captain Marvel (Carol Danvers)",
                      comics:  {
                        items: [
                          {name: 'Volume 1', prices: [{price: 1.20}]},
                          {name: 'Volume 2', prices: [{price: 5.40}]}
                        ]
                      }
                    }];
    let herois = new Herois(heroi);
    expect(herois.comicMaisCara).toEqual({name: 'Volume 2',prices: [{price: 5.40}]});
  });

  it('Deve retornar a comic Volume 1 Especial', function() {

     let heroi = [{name: "Captain Marvel (Carol Danvers)",
                       comics:  {
                         items: [
                           {name: 'Volume 1', prices: [{price: 1.20}]},
                           {name: 'Volume 2', prices: [{price: 5.40}]}
                         ]
                       }
                     },
                     {name: "Iron Man",
                          comics:  {
                             items: [
                                {name: 'Volume 1 Especial', prices: [{price: 10.20}]},
                                {name: 'Volume 2 Limitada', prices: [{price: 7.40}]}
                             ]
                           }
                       }
                   ];

     let herois = new Herois(heroi);
     expect(herois.comicMaisCara).toEqual({name: 'Volume 1 Especial',prices: [{price: 10.20}]});
   });

   it('Deve retornar undefined', function() {

     let herois = new Herois();
     expect(herois.comicMaisCara).toEqual(undefined);
   });

});
