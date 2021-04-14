# Restcountries
O projecto consiste no desenvolvimento de uma API Restful para gestão de informações de paises.

## Tecnologias usadas
A API foi desenvolvida em java, usando as seguintes tecnologias:
* Spring boot 2.4.4 - Criação da API
* Mysql - Sistema gerenciador de banco de dados
* Flyway - Migração da base de dados

## Descrição
A API está hospedada na **Heroku** e ela permite-nos:
* Listar todos os paises [GET]: https://restcountries-api.herokuapp.com/countries
* Buscar um pais específico através do **id** [GET]: https://restcountries-api.herokuapp.com/countries/1
* Editar um pais específico através do **id** [PUT]: https://restcountries-api.herokuapp.com/countries/1
* Cadastrar um pais [POST]: https://restcountries-api.herokuapp.com/countries
* Remover um pais específico através do **id** [DELETE]: https://restcountries-api.herokuapp.com/countries/1
* Ordenar a listagem dos países por uma das propriedades (id, name, capital, area), podendo ser de forma ascendente ou descendente [GET]: https://restcountries-api.herokuapp.com/countries?sort=name,desc
* Exemplo de cadastro de um pais:
```
  {
    "name": "Chile",
    "capital": "Santiago",
    "subRegion": {"id": 9},
    "area": 750102.0
  }
```
