//Exercício 1
var gerarPiramide = function(niveis){
  var texto = 'R$';
  for(var i = 1; i <= niveis; i++){
    console.log(texto);
    texto += 'R$';
  }
}
gerarPiramide(5);


//Exercício 2
var diglettDig = function(){
  for(var i = 1; i <= 100; i++){

    var divisivelPor3 = i%3 === 0;
    var divisivelPor5 = i%5 === 0;

    if(divisivelPor3 && divisivelPor5){
      console.log('Diglett dig, trio trio trio');
    } else {
      if(divisivelPor3){
        console.log('Diglett dig');
      }

      if(divisivelPor5){
        console.log('trio trio trio');
      }

      if(!divisivelPor5 && !divisivelPor3){
        console.log(i);
      }
    }
  }
};
diglettDig();

//Exercício 3
var find = function(arrayDeElementos, funcao){
  if(typeof funcao !== 'function'){
    return;
  }
  var resultado = Array();
  for(var i = 0, len = arrayDeElementos.length; i < len ; i++){
    if (funcao(arrayDeElementos[i])){
      resultado.push(arrayDeElementos[i]);
    }
  }
  return resultado;
}

var maiorIgualADois = function(elemento) {
  return elemento >= 2;
};

console.log(find([ 1, 2, 3 ], maiorIgualADois));

console.log(find([ 'a', 5, null, false, 'false' ], function(elem) {
  return typeof elem === 'string';
}));
// [ 'a', 'false' ]

console.log(find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
  return typeof elem.nome === 'c';
}));
// []
var maiorIgualADois = 'maior igual ou a dois';
console.log(find([ 1, 2, 3 ], maiorIgualADois));

//Exercício 4
var subtrair = function(valor){
  
}

console.log(subtrair(2)(1)); // 1
console.log(subtrair(0)(0)); // 0
console.log(subtrair(-1)(-2)); // -3
