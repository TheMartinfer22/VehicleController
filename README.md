![image](https://user-images.githubusercontent.com/66142507/120044598-8d5c0980-bfe4-11eb-87f9-d53213ded695.png)**Controlador de Veículos**

O objetivo deste projeto é a implementação de um sistema de controlador de carros que possui um sistema de lógica diária de rodízio e um sistema de cadastro de usuários, onde é preciso criar uma API REST que possui um consumo em uma API externa, foi necessário utilizar IntelliJ IDEA na qual é uma IDE muito utilizada no mercado por facilitar o usuário em muitas questões de código, foi necessário a utilização de uma ferramenta para realizar testes de métodos GET, POST, PUT, DELETE na qual foi utilizado o Insomnia sem demais argumentos sobre, por fim o projeto em si foi criado utilizado Spring, uma Framework que é muito utilizada em projetos pela sua segurança e sua modularidade que atraí diversas empresas pela sua questão de otimizações de projetos, sendo assim, foi utilizado o Spring pelo modelo do projeto que teve necessidade dos seguintes módulos:

- **DATA-JPA** (Para aumentar a produtividade da aplicação sem precisar executar querry's avançadas, ele implementa anotações que facilitam)
- **Validation** (Muito importe na questão de validações de formulários, com ele podemos definir regras ou utilizar suas anotações por padrão)
- **Web** (Foi utilizado para manusear aplicações WEB, na qual teve utilização os métodos GET, POST, PUT, DELETE)
- **OpenFeign** (Para a questão de consumo em uma API externa, o Feign foi a melhor escolha pela sua facilidade de implementação e lógica)
- **DevTools** (Útil em questões de auxiliar no desenvolvimento)
- **PostgreSQL** (Foi escolhido por uma questão pessoal de adquirir conhecimento com bancos em PostgreSQL)

![image](https://user-images.githubusercontent.com/66142507/120044624-964cdb00-bfe4-11eb-9ee8-e421f1587992.png)**Features**

- Controle de Usuários.
- Controle de Carros.
- Sistema de Rodizio baseado na data/dia do sistema.
