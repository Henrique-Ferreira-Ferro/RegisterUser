### Projeto com Spring boot para estudos

Objetivo:

Desenvolver um sistema CRUD (Create, Read, Update, Delete) para gerenciar um cadastro de usuários utilizando Spring Boot e o banco de dados H2.
Requisitos:

1. Configuração do Projeto:
    - Crie um novo projeto Spring Boot utilizando uma ferramenta como Spring Initializr.
    - Adicione as seguintes dependências:
        - Spring Web
        - Spring Data JPA
        - H2 Database
2. Modelo de Dados:
    - Crie uma entidade `User` com os seguintes atributos:
      - `id` (Long, auto-incremento)
      - `name` (String)
      - `email` (String)
3. Operações CRUD:
    - Implemente um repositório `UserRepository` utilizando Spring Data JPA.
    - Implemente um controlador `UserController` com métodos para realizar as seguintes operações:
      - Create: Adicionar um novo usuário.
      - Read: Buscar um usuário pelo seu `id`.
      - Read All: Listar todos os usuários.
      - Update: Atualizar as informações de um usuário existente.
      - Delete: Remover um usuário pelo seu `id`.
4. Interface de Usuário:
- Utilize endpoints REST para realizar as operações CRUD.

### Especificações Adicionais:

- Utilize o banco de dados H2 em modo memória para facilitar os testes.
- Garanta que a aplicação seja executável através do comando `mvn spring-boot:run` ou equivalente no Gradle.
- Documente os endpoints da API utilizando Swagger ou uma documentação em texto no README do projeto.
- Trate exceções adequadamente e forneça respostas significativas ao usuário da API.
  Estrutura de Projeto Sugerida:
- Pacote `model`: Contém a classe `User`.
- Pacote `repository`: Contém a interface `UserRepository` que estende `JpaRepository`.
- Pacote `controller`: Contém a classe `UserController` que expõe os endpoints REST.
- Pacote `config`: Contém configurações adicionais, se necessário.

----------------------------------------------------------------------------------------------------------------

### Como usar a aplicação e seus End-Points?

#### Abaixo as etapas:

1. Baixe o Postman para testar a aplicação
2. Crie as requisições com base no controller

- Criar um usuario:

```
    http://localhost:8080/user/create
```

![image](https://github.com/Henrique-Ferreira-Ferro/RegisterUser/assets/92760541/4c387d65-0fa0-4e4b-9022-010eec716c95)

- Encontrar usuario por ID

```
    http://localhost:8080/user/1
```

![image](https://github.com/Henrique-Ferreira-Ferro/RegisterUser/assets/92760541/ddf54f3d-2d9d-4bc9-965f-30f65d26bfee)

- Encontrar todos os Usuarios

```
    http://localhost:8080/user
```
![image](https://github.com/Henrique-Ferreira-Ferro/RegisterUser/assets/92760541/94f19b55-89c2-40ae-97ab-f2355f1b47a3)

- Atualizar usuario por ID

```
    http://localhost:8080/update/2
```

![image](https://github.com/Henrique-Ferreira-Ferro/RegisterUser/assets/92760541/59d4913e-e4d1-4b94-af05-cee8735a5f32)

- Deleter usuario por ID

```
    http://localhost:8080/user/2
```

![image](https://github.com/Henrique-Ferreira-Ferro/RegisterUser/assets/92760541/98c58dbe-5caf-46a1-bd1e-e3f04ad3d035)

