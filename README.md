# User API - JSON Serialization & Content Negotiation

## Sobre o Projeto

API REST desenvolvida com o objetivo de praticar e aprofundar conceitos de:

- Serialização e desserialização de JSON
- Content Negotiation
- Definição explícita de Media Types
- Arquitetura em camadas com Spring Boot

A aplicação suporta oficialmente os formatos:

- application/json
- application/xml

---

## Arquitetura

O projeto segue padrão de separação de responsabilidades:

- Controller → Camada de exposição da API e negociação de conteúdo
- Service → Regras de negócio
- Repository → Persistência com Spring Data JPA
- DTO (Request / Response) → Controle de dados expostos
- Mapper → Conversão entre Entity e DTO
- Flyway → Versionamento de banco de dados

---

## Content Negotiation

A API define explicitamente os media types suportados utilizando:

- produces
- consumes

A negociação é baseada no header:

Accept

Exemplos:

Accept: application/json → Retorna JSON  
Accept: application/xml → Retorna XML  
Accept: application/pdf → 406 Not Acceptable

Se o Content-Type enviado não for suportado → 415 Unsupported Media Type

---

## Banco de Dados

Versionamento realizado com Flyway:

- V1__create_table_user.sql → Criação da tabela
- V2__populate_table_user.sql → Inserção inicial
- V3__rename_birth_date.sql → Alteração estrutural
- V4__add_column_gender.sql → Nova coluna adicionada

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Flyway
- Apache Maven

---

## Objetivo Técnico

Este projeto foi criado para consolidar conhecimento sobre:

- Funcionamento interno da serialização no Spring
- HttpMessageConverters
- Content Negotiation baseada em Header
- Definição de contrato explícito em APIs REST