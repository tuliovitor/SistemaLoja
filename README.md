# SistemaLoja — JDBC com Java e MySQL

Projeto desenvolvido para a disciplina de Laboratório de Software.

## Tecnologias
- Java 21
- MySQL
- JDBC (mysql-connector-j-9.6.0)

## Como executar
1. Crie o banco com o script em `database/loja.sql`
2. Configure usuário e senha em `ConnectionFactory.java`
3. Execute a classe `Main.java`

## Estrutura
src/
├── connection/ConnectionFactory.java
├── dao/FuncionarioDAO.java
├── main/Main.java
└── model/Funcionario.java
