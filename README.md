# trello-rest-api-test

Este projeto contém testes automatizados para a [API REST do Trello](https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/).
 
### Tecnologias utilizadas:
  * Java
  * Maven
  * Rest Assured
  * Junit
  * Cucumber
  * Cluecumber Report
 
## Execução

### Pré-requisitos
* Clonar o repositório do projeto: `git clone https://github.com/pablobedoya/trello-rest-api-test.git`
* Rodar o comando Maven para resolver as dependências: `mvn clean install -DskipTests`

### Rodar os testes
* Rodar o comando Maven: `mvn test`

### Gerar relatório de execução dos testes
* Após a execução dos testes, rodar o comando Maven: `mvn cluecumber-report:reporting`

**Nota:** Após a execução do comando de geração do relatório de execução dos testes, o relatório estará acessível dentro do projeto, no caminho `/target/generated-report/index.html`.
