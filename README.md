<h1 align="center">Acesso a banco de dados com JDBC </h1>

<h2 align="center">Curso: Programação Orientada a Objetos com Java - Udemy </h2>

Este repositório contém os exercícios e exemplos do curso de JDBC (Java Database Connectivity), abrangendo a teoria e prática da conexão de bancos de dados com Java, utilizando MySQL e o padrão de projeto DAO (Data Access Object).

## Objetivos do Curso

- Conhecer os principais recursos do JDBC na teoria e prática.
- Elaborar a estrutura básica de um projeto com JDBC.
- Implementar o padrão DAO manualmente com JDBC.

## Visão Geral do JDBC

### O que é JDBC?

JDBC é uma API padrão do Java para acessar dados em bancos de dados relacionais. A API fornece interfaces e classes para realizar operações de banco de dados como consulta, atualização e inserção de dados.

### Páginas Oficiais

- [Documentação do JDBC - Oracle](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
- [API do JDBC - Oracle](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)

### Pacotes

- **java.sql**: Contém as interfaces e classes fundamentais para JDBC.
- **javax.sql**: API suplementar, utilizada principalmente em servidores.

## Instalação das Ferramentas

1. **MySQL Server** e **MySQL Workbench**:
   - Instale o MySQL Server para rodar o banco de dados.
   - Utilize o MySQL Workbench para interagir com o banco de dados.

2. **MySQL Java Connector**:
   - Baixe o MySQL Java Connector para permitir a conexão entre o Java e o MySQL.
     
3. **Criação do Banco de Dados**:
   - Usando o MySQL Workbench, crie o banco de dados chamado `coursejdbc`.
  
# Estrutura de Pacotes do Projeto

```plaintext
demo_dao_jdbc/
├── application/
│   └── (classes principais da aplicação)
├── db/
│   └── (manipulação da conexão com o banco de dados)
├── model/
│   ├── dao/
│   │   ├── impl/
│   │   │   ├── DaoFactory.java
│   │   │   ├── DepartmentDao.java
│   │   │   └── SellerDao.java
│   └── entities/
│       └── (entidades e modelos do projeto)
└── db.properties (arquivo de configuração do banco de dados)

jdbc/
├── application/
│   └── (classes principais da aplicação)
├── db/
│   └── (manipulação da conexão com o banco de dados)
└── db.properties (arquivo de configuração do banco de dados)

