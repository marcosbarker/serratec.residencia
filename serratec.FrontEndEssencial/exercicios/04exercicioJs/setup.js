var contador = 0;

function starCounter(){
  var limite = document.getElementById("limit").value;
  limite = parseInt(limite);

  if(isNaN(limite)){
    alert("Por favor, insira um limite válido.");
    return;
  }

  var timer = setInterval(function(){
    document.getElementById("counter").innerHTML = contador;

    if(contador = limite){
      clearInterval(timer);
      document.getElementById("counter").innerHTML = "Finished";
    }
    
  }, 1000)
}