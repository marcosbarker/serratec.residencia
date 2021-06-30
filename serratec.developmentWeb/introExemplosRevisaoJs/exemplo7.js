let pessoas = [
  {id: 1, nome: "Arthur", sobreNome: "Ranquine", alimento: "Churrasco" },
  {id: 2, nome: "Tatiane", sobreNome: "Costa", alimento: "Escondidinho" },
  {id: 3, nome: "Cristopher", sobreNome: "Costa", alimento: "Escalopinho" },
  {id: 4, nome: "Arthur", sobreNome: "Vinagre", alimento: "Macarronada" },
  {id: 5, nome: "Mariana", sobreNome: "Rodrigues", alimento: "Nhoque" }
  ];
 
  let filtro = pessoas.filter((pessoa) => {
    return (pessoa.nome === "Arthur" && pessoa.alimento === "Churrasco")
          
        });

        console.log(filtro);