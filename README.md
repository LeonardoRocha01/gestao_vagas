# 🚀 Gestão de Vagas – Sistema Completo

Sistema completo para gerenciamento de vagas de emprego desenvolvido em **Java** utilizando **Spring Boot**. O projeto é dividido em duas aplicações:

- 🔙 **Back-end (API REST)** responsável pelas regras de negócio, autenticação e persistência dos dados.
- 🖥️ **Front-end (Spring Boot + Thymeleaf)** responsável pela interface web do sistema.

---

# 🛠️ Tecnologias Utilizadas

### Back-end

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL
- JWT (JSON Web Token)
- Swagger / OpenAPI
- Maven
- Lombok

### Front-end

- Java 21
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Security
- HTML5
- CSS3
- Bootstrap
- Maven

---

# 📌 Funcionalidades

## API (Back-end)

✅ Cadastro de candidatos

✅ Cadastro de empresas

💼 Cadastro de vagas

🔐 Autenticação com JWT

🔒 Criptografia de senhas com BCrypt

🔍 Busca de vagas

✏️ Atualização de dados

📄 Documentação da API com Swagger

🐘 Persistência em PostgreSQL

---

## Interface Web (Front-end)

🖥️ Tela de Login

👤 Cadastro de usuários

📋 Listagem de vagas

🔍 Consulta de vagas

📝 Cadastro através da interface

🔐 Controle de acesso com Spring Security

📱 Interface responsiva utilizando Bootstrap

---

# 📂 Estrutura do Projeto

```
gestao_vagas/
│
├── backend/
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   ├── service
│   ├── security
│   └── config
│
└── frontend/
    ├── controller
    ├── templates
    ├── static
    │   ├── css
    │   ├── js
    │   └── images
    └── config
```

---

# ▶️ Executando o projeto

## 1️⃣ Clone o repositório

```bash
git clone https://github.com/LeonardoRocha01/gestao_vagas.git
```

## 2️⃣ Execute o Back-end

```bash
cd gestao_vagas
./mvnw spring-boot:run
```

## 3️⃣ Execute o Front-end

```bash
cd front_gestao
./mvnw spring-boot:run
```

---

# 📚 Documentação da API

Após iniciar o Back-end:

```
http://localhost:8080/swagger-ui/index.html
```

---

# 💡 Arquitetura

```
          Front-end (Thymeleaf)
                  │
                  │ HTTP
                  ▼
          API REST (Spring Boot)
                  │
                  ▼
             PostgreSQL
```

---

# 👨‍💻 Autor

**Leonardo Rocha Vieira**

💼 Desenvolvedor Java Backend

📎 GitHub: https://github.com/LeonardoRocha01

🚀 Estudando Java, Spring Boot, Spring Security, PostgreSQL, Docker e desenvolvimento de APIs REST.
