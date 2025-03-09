<h1 align="center">
    <img alt="Gobarber" src="DecolaTech.png" width="250px" />
</h1>

Este repositório é utilizado para o bootcamp DeCola Tech Avanade para a criação de uma API REST Documentada com Spring Web e Swagger.

# API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

<p align="center">
  <a href="#authors">Autor</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#about">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#tech_utilizadas">Tecnologias utilizadas</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#installd">Tecnologias utilizadas</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#app">Acesso à aplicação</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#app">Planejamento</a>
</p>


### Fluxograma
```mermaid
classDiagram
    class Person {
        +Long id
        +String name
        +String email
        +String password
    }

    class Author {
        +Long id
        +String name
    }

    class Publisher {
        +Long id
        +String name
        +String address
    }

    class Book {
        +Long id
        +String title
        +String description
        +List<Author> authors
        +Publisher publisher
    }

    class BookStatus {
        +Long id
        +Enum status
        +Date registrationDate
        +Integer rating
        +String comment
        +Integer priority
        +String reason
        +Person person
        +Book book
    }

    Person "1" -- "0..*" BookStatus : registers
    Book "1" -- "0..*" BookStatus : is associated with
    Author "1" -- "0..*" Book : writes
    Book "1" -- "1" Publisher : published by


```
