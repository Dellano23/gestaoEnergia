# Gestão Energia API

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar o consumo de energia, alinhada aos temas de ESG (Environmental, Social and Governance), conforme proposta da atividade Microsserviços com Spring - Rest com Spring Boot feita pela FIAP, durante curso de Análise e Desenvolvimento de sistemas. 

A aplicação permite operações CRUD para registros de consumo de energia de aparelhos domésticos, com documentação interativa via Swagger.

Este repositório contém o código-fonte da API.

**Conteúdo**

- [Estrutura do Projeto](#estrutura-do-projeto)
- [Stacks Utilizadas](#stacks-utilizadas)
- [Instalar e rodar o projeto](#instalar-e-rodar-o-projeto)
  - [Dependências globais](#dependências-globais)
  - [Dependências locais](#dependências-locais)
  - [Rodar o projeto](#rodar-o-projeto)
- [Acessar a API](#acessar-a-api)

## Estrutura do Projeto

A organização do código segue o padrão arquitetural em camadas, facilitando a manutenção e a separação de responsabilidades:

```text
src/main/java/br/com/fiap/gestaoEnergia
├── advice      # Tratamento global de erros e exceções da API (ex: ApplicationExceptionHandler)
├── config      # Classes de configuração geral (ex: Swagger/OpenAPI)
├── controller  # Endpoints REST (exposição da API para o cliente)
├── dto         # Data Transfer Objects (camada de transferência planejada)
├── model       # Entidades JPA que mapeiam as tabelas no banco de dados (ex: ConsumoEnergia)
├── repository  # Interfaces Spring Data JPA para comunicação com o banco
└── service     # Regras de negócio e intermediação entre Controller e Repository
```

**Diretórios Relevantes:**
* **`src/main/resources/db/migration`**: Scripts SQL do **Flyway** (ex: `V1__criar-tabela-gestao.sql`) para controle de versão do esquema do banco de dados.
* **`src/test/java`**: Classes de testes automatizados.
* **`Dockerfile`**: Receita para a criação da imagem e execução da aplicação via containers.

*Nota técnica: Atualmente, os controllers estão manipulando diretamente as Entidades JPA (`ConsumoEnergia`). A pasta `dto` foi estruturada para futuras evoluções de abstração de dados.*

## Stacks Utilizadas

- **Java 17**: Linguagem principal
- **Spring Boot 3.4.5**: Framework para desenvolvimento da API
- **Spring Data JPA**: Para persistência de dados
- **H2 Database**: Banco de dados em memória para desenvolvimento local
- **Flyway**: Migrações de banco de dados
- **Docker**: Containerização da aplicação
- **Maven**: Gerenciamento de dependências e build
- **Springdoc OpenAPI**: Documentação da API com Swagger UI

## Instalar e rodar o projeto

Rodar a aplicação em sua máquina local é simples.

### Dependências globais

Você precisa ter instaladas:

- Java 17 (ou superior)
```bash
java -version
```
- Maven 3.6+ (ou use o wrapper incluído)
- Docker Engine 17.12+ com Docker Desktop
```bash
docker -v
```

### Dependências locais

Clone o repositório e acesse o diretório do projeto:

```bash
git clone <url-do-repositorio>
cd gestaoEnergia
```

As dependências são gerenciadas pelo Maven, não há necessidade de instalação manual.

### Rodar o projeto

Para rodar localmente via Docker:

```bash
# Compilar o projeto
./mvnw package -DskipTests

# Construir a imagem Docker
docker build -t gestao-energia .

# Rodar o container
docker run --rm -p 8080:8080 gestao-energia
```

Para rodar sem Docker (desenvolvimento):

```bash
./mvnw spring-boot:run
```

## Acessar a API

Após iniciar, acesse:

- **Swagger UI**: http://localhost:8080 (documentação interativa da API)
- **Endpoints**: Todos sob `/api/gestao/*`

Exemplo de endpoints:
- GET `/api/gestao` - Listar todos os consumos
- POST `/api/gestao` - Criar novo consumo
- PUT `/api/gestao` - Atualizar consumo
- DELETE `/api/gestao/{id}` - Excluir consumo

Observações:
- Para parar o container, use `docker stop <container-id>`
- O banco H2 é em memória, dados são perdidos ao reiniciar
```
