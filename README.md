# Spring Robot Json

API usando Spring Boot para controle de movimentos e usando arquivo JSON como banco de dados

### Swagger

`http://localhost:8080/swagger-ui/index.html`

### Run

`mvn spring-boot:run`

### Cenário

O controle do robô se passa em um plano cartesiano, começando no ponto 0 eixo horizontal, 
eixo 0 vertical e direcionado para o norte (0, 0, N).

![Plano cartesiano](cartesian-plan.png?raw=true)

### Armazenamento

Foi usado um arquivo JSON para armazenamento das coordenadas, armazenado dentro do diretório 'resources'. 
O arquivo mantem o registro mesmo após reinicialização da aplicação.