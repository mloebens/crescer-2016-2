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

//Exercício 4
var subtrair = function(valor1){
  return function(valor2){
    return valor1 - valor2;
  }
}


//Exercício 5
var iguais = function(x, y){
  if(x === y) return true;

  if( !(x instanceof Object) || !(y instanceof Object )) return false;

  for(var indice in x) {
    if (!x.hasOwnProperty(indice)) continue;

    if (!y.hasOwnProperty(indice)) return false;

    if (x[indice] === y[indice]) continue;

    if (typeof(x[indice]) !== "object") return false;

    if (!iguais(x[indice],  y[indice])) return false;
  }

  for ( indice in y ) {
    if (y.hasOwnProperty(indice) && !x.hasOwnProperty(indice)) return false;
  }
  return true;
}

//Exercício 6
var ctrlC = function(valor){
  var copia = Object.assign({},valor);
  return copia;
}


//Exercício 6
var mesclar = function(objeto1, objeto2, recursivo){
  
    for (var indice in objeto2){
      var objeto2TemAtributo = objeto2.hasOwnProperty(indice);
      var atributoDoobjeto2EObjeto = typeof objeto2[indice] === "object";
      if(!!recursivo){
        if (objeto2TemAtributo) {

          if(atributoDoobjeto2EObjeto){
              mesclar(objeto1[indice], objeto2[indice], true);
          }
        }
      }
      if(!recursivo || !atributoDoobjeto2EObjeto ){
        objeto1[indice] = objeto2[indice];
      }
  }
}

