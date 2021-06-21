<h2>Para tratar a segurança na Aplicação Spring, habilitada pela dependência spring-boot-starter-security
no pom.xml, os seguintes passos deverão ser seguidos:</h2>

1. No arquivo application.properties inserir as seguintes linhas:

#Parâmetros de segurança <br/>
spring.security.user.name=nomedousuario <br/>
spring.security.user.password=123456 <br/>

2. Criar um novo package no projeto chamado config e incluir a classe constante no link abaixo:

https://github.com/aopaixao/residencia_api_restful/tree/main/biblioteca/seguranca

<br/><br/>

<h2>Para fazer requisições para a API deverão ser incluídas, além dos dados da requisição, os dados de autenticação do tipo básico.
Nesses, incluir o name e password setados acima.</h2>

<br/><br/>
<h3>Caso não deseje utilizar segurança em sua API, basta remover a dependência spring-boot-starter-security do pom.xml</h3>
