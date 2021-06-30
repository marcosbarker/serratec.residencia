let elementos = ['1', '2', '3']

function convertInteiros(elemento){
    return parseInt(elemento, 10);
}

// console.log(elementos)

console.log( elementos.map(convertInteiros) )

console.log( ['4', '5', '6'].map(convertInteiros) )