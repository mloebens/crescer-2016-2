//Exercício 1
let gerarPiramide = function(niveis){
  for(let i = 1; i <= niveis; i++){
    console.log(Array(i+1).join('R$'));
  }
}
gerarPiramide(5);

//Exercício 2
let diglettDig = function(){
  for(let i = 1; i <= 100; i++){

    let divisivelPor3 = i%3 === 0;
    let divisivelPor5 = i%5 === 0;
    let texto;

    if(divisivelPor3 && divisivelPor5){
      texto = 'Diglett dig, trio trio trio';
    } else if(divisivelPor3){
      texto = 'Diglett dig';
    } else if(divisivelPor5){
      texto = 'trio trio trio';
    } else {
      texto = i;
    }
    console.log(texto);
  }
};
diglettDig();

//Exercício 3
let find = function(arrayDeElementos, fnFiltro){
  if(typeof fnFiltro !== 'function'){
    return;
  }
  let resultado = Array();
  for(let i = 0, len = arrayDeElementos.length; i < len ; i++){
    let encontrou = fnFiltro(arrayDeElementos[i]);
    if (encontrou){
      resultado.push(arrayDeElementos[i]);
    }
  }
  return resultado;
}

//Exercício 4
let subtrair = function(valor1){
  return function(valor2){
    return valor1 - valor2;
  }
}


//Exercício 5
function ehObjeto(obj) {
  return typeof obj === 'object';
}

function iguais(obj1, obj2) {

  if (ehObjeto(obj1) && ehObjeto(obj2)) {
    // se tiverem quantidades de campos diferentes, já retorna falso
    if (Object.keys(obj1).length !== Object.keys(obj2).length) {
      return false;
    }

    // comparando recursivamente propriedades;
    for (let prop in obj1) {
      let saoIguais = iguais(obj1[prop], obj2[prop]);
      if (!saoIguais) return false;
    }
    return true;
  }

  return obj1 === obj2;
}

//Exercício 6
let ctrlC = function(valor){
  let copia = Object.assign({},valor);
  return copia;
}

//Exercício 6
let mesclar = function(objeto1, objeto2, recursivo){

    for (let indice in objeto2){
      let atributoDoobjeto2EObjeto = typeof objeto2[indice] === "object";
      if(!!recursivo && atributoDoobjeto2EObjeto){
          mesclar(objeto1[indice], objeto2[indice], true);
      }
      else {
        objeto1[indice] = objeto2[indice];
      }
  }
}
