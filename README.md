# becaDesafioFabioLuiz

# Sobre o projeto
- Sistema para loja de vedas

## Modelo conceitual
<img width="536" alt="diagramaDb" src="https://user-images.githubusercontent.com/98011084/151227453-619f3106-711f-4ef0-bf84-da9be93145dd.png">


# Tecnologias utilizadas

- Java
- Spring Boot
- Maven

# Endpoints

Para testes da API é necessário que uma aplicação cliente que faça requisições aos *endpoints* da ferramenta ou mesmo uma aplicação como o [Postman](https://www.getpostman.com/downloads/) (uma ferramenta que tem como objetivo testar serviços RESTful (Web APIs) por meio do envio de requisições HTTP e da análise do seu retorno.).

| Requisições                                  | Descrição                                                    |
| -------------------------------------------- | ------------------------------------------------------------ |
| POST `/produto/criar`                        | Cadastra produtos novos.                                     |
| PACHT `/produto/atualizar`                   | Retorna os dados atulaizados.                                |
| DELETE `/produto/deletar`                    | Retorna o produto deletado pelo id.                          |
| GET `/produto`                               | Retona uma lista de produtos cadastrados.                    |
| GET `/produto/obter`                         | Retorna o produto obtido pelo id                             |
| POST `/pedido/criar`                         | Cadastra um pedido.                                          |
| PACHT `/pedido/atualizar`                    | Atualiza os dados do pedido pelo id.                         |
| DELETE `/pedido/deletar`                     | Deleta pedido pelo id.                                       |
| GET `/pedido`                                | Retona uma lista de pedidos.                                 |
| GET `/produto/obter`                         | Retorna o pedido obtido pelo id.                             |
| POST `/item/criar`                         | Cadastra um item.                                              |
| PACHT `/item/atualizar`                    | Atualiza os dados do item pelo id.                             |
| DELETE `/item/deletar`                     | Deleta item pelo id.                                           |
| GET `/item`                                | Retona uma lista de items.                                     |
| GET `/item/obter`                          | Retorna o item obtido pelo id.                                 |
| POST `/cliente/criar`                         | Cadastra um cliente.                                        |
| PACHT `/cliente/atualizar`                    | Atualiza os dados do cliente pelo id.                       |
| DELETE `/cliente/deletar`                     | Deleta cliente pelo id.                                     |
| GET `/cliente`                                | Retona uma lista de cliente.                                |
| GET `/cliente/obter`                         | Retorna o cliente obtido pelo id.                            |

Exemplo de JSON para requisição POST `/pedidos`:


```json
{
  "id": 1,
  "data": "2022-01-26",
  "items": [
    {
      "id": 1,
      "preco": 15.55,
      "quantidade": 3,
      "produto": {
        "id": 2,
        "descricao": "Café",
        "preco": 15.55
      }
    }
  ],
  "cliente": {
    "id": 3,
    "nome": "Osvaldo",
    "cpf": "111.222.333-88",
    "endereco": "Rua Acre"
  }
}
```

