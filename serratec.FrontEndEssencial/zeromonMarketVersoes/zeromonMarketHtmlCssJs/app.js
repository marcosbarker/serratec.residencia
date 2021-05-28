//inicio chamada PokeAPI 
const getPokemonUrl = id => `https://pokeapi.co/api/v2/pokemon/${id}`

const generatePokemonPromises = () => Array(150).fill().map((_, index) =>
  fetch(getPokemonUrl(index + 1)).then(response => response.json()))

const generateHTML = pokemons => pokemons.reduce((accumulator, { name, id, types }) => {
  const elementTypes = types.map(typeInfo => typeInfo.type.name)
  accumulator += `
        <li class="card ${elementTypes[0]}">
          <img class="card-image alt="${name}" src="./assets/pokemonsID/${id}.png" /><br>
          <h2 class="card-title">${id}.${name}</h2>
          <p class="card-subtitle">${elementTypes.join(' | ')}</p><br>
          <h3><button class="buttonCompra" type="button" id="btnCompra" onclick="comprar()">Comprar</button></h3>
        </li>`
  return accumulator
}, '')

const insertPokemonsIntoPage = pokemons => {
  const ul = document.querySelector('[data-js="pokedex"]')
  ul.innerHTML = pokemons
}

const pokemonPromises = generatePokemonPromises()

Promise.all(pokemonPromises)
  .then(generateHTML)
  .then(insertPokemonsIntoPage)
//fim chamada PokeAPI 

function comprar() {
  var comprar = document.getElementById('btnCompra')
  console.log("estou comprando")
}