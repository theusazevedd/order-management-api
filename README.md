# 📦 Order Management API

Uma API REST profissional para gerenciamento de pedidos, desenvolvida com **Spring Boot 3** e arquitetura em camadas com **DTOs, Converters e Exception Handling centralizado**.

## 🎯 Características Principais

✅ **DTOs (Data Transfer Objects)** - Separação entre camada de apresentação e persistência  
✅ **Converters** - Transformação automática Entity ↔ DTO  
✅ **Exception Handling Centralizado** - GlobalExceptionHandler com @ControllerAdvice  
✅ **Segurança** - Dados sensíveis (passwords) nunca são expostos  
✅ **Arquitetura em Camadas** - Controller → Service → Repository  
✅ **Banco de Dados** - PostgreSQL (produção) e H2 (testes)  

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Java** | 17 | Linguagem de programação |
| **Spring Boot** | 3.5.13 | Framework web |
| **Spring Data JPA** | - | ORM e acesso a dados |
| **PostgreSQL** | - | Banco de dados principal |
| **H2** | - | Banco de dados em memória (testes) |
| **Lombok** | - | Redução de boilerplate |
| **Maven** | - | Gerenciador de dependências |

---

## 📋 Requisitos

- **JDK 17+** instalado
- **Maven 3.6+** instalado
- **PostgreSQL** (para ambiente de produção)
- **Git** para clonar o repositório

---

## 🚀 Como Executar

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/order-management-api.git
cd order-management-api/order-management-api
```

### 2️⃣ Configurar o Banco de Dados

#### **Usando H2 (Testes/Desenvolvimento)**
O banco H2 já está configurado. Nenhuma ação necessária!

#### **Usando PostgreSQL (Produção)**

1. Instale e inicie o PostgreSQL
2. Crie um banco de dados:

```sql
CREATE DATABASE order_management_db;
```

3. Configure as credenciais em `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/order_management_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Compilar o Projeto

```bash
mvn clean compile
```

### 4️⃣ Rodar a Aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em: **http://localhost:8080**

---

## 📡 Endpoints da API

### **👥 Users (Usuários)**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/users` | Listar todos |
| `GET` | `/users/{id}` | Buscar por ID |
| `POST` | `/users` | Criar usuário |
| `PUT` | `/users/{id}` | Atualizar |
| `DELETE` | `/users/{id}` | Deletar |

**Exemplo - POST /users:**
```json
Request:
{
  "name": "João Silva",
  "email": "joao@example.com",
  "phone": "11987654321",
  "password": "senha123"
}

Response (200):
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@example.com",
  "phone": "11987654321"
}
```

### **📂 Categories (Categorias)**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/categories` | Listar todas |
| `GET` | `/categories/{id}` | Buscar por ID |

### **📦 Products (Produtos)**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/products` | Listar todos |
| `GET` | `/products/{id}` | Buscar por ID |

### **📋 Orders (Pedidos)**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/orders` | Listar todos |
| `GET` | `/orders/{id}` | Buscar por ID |

**Exemplo - GET /orders/1:**
```json
{
  "id": 1,
  "moment": "2025-04-19T14:30:00Z",
  "orderStatus": "PENDING",
  "client": {
    "id": 1,
    "name": "João Silva",
    "email": "joao@example.com",
    "phone": "11987654321"
  },
  "items": [
    {
      "productId": 1,
      "productName": "Notebook Dell",
      "quantity": 1,
      "price": 3500.00,
      "subTotal": 3500.00
    }
  ],
  "total": 3500.00
}
```

---

## ⚠️ Tratamento de Erros

### **404 - Not Found**
```json
{
  "timestamp": "2025-04-19T14:30:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "ID não encontrado",
  "path": "/users/999"
}
```

### **500 - Internal Server Error**
```json
{
  "timestamp": "2025-04-19T14:30:00Z",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Erro interno do servidor",
  "path": "/users"
}
```

---

## 📁 Estrutura do Projeto

```
order-management-api/
├── src/main/java/com/azevedo/order_management_api/
│   ├── controller/                # Controllers REST
│   │   ├── UserController.java
│   │   ├── CategoryController.java
│   │   ├── ProductController.java
│   │   └── OrderController.java
│   ├── service/                   # Lógica de negócio
│   │   ├── UserService.java
│   │   ├── CategoryService.java
│   │   ├── ProductService.java
│   │   └── OrderService.java
│   ├── repository/                # Acesso a dados
│   │   ├── UserRepository.java
│   │   ├── CategoryRepository.java
│   │   ├── ProductRepository.java
│   │   └── OrderRepository.java
│   ├── entities/                  # Entidades JPA
│   │   ├── UserEntity.java
│   │   ├── CategoryEntity.java
│   │   ├── ProductEntity.java
│   │   ├── OrderEntity.java
│   │   └── OrderItem.java
│   ├── dto/                       # Data Transfer Objects
│   │   ├── UserInDTO.java
│   │   ├── UserOutDTO.java
│   │   ├── CategoryOutDTO.java
│   │   ├── ProductOutDTO.java
│   │   ├── OrderOutDTO.java
│   │   └── OrderItemOutDTO.java
│   ├── converter/                 # Conversão Entity ↔ DTO
│   │   ├── UserConverter.java
│   │   ├── CategoryConverter.java
│   │   ├── ProductConverter.java
│   │   ├── OrderConverter.java
│   │   └── OrderItemConverter.java
│   ├── exceptions/                # Tratamento de exceções
│   │   ├── ResourceNotFoundException.java
│   │   ├── ErrorResponse.java
│   │   └── GlobalExceptionHandler.java
│   └── OrderManagementApiApplication.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
```

---

## 🔑 Conceitos Implementados

### **DTOs (Data Transfer Objects)**
Separação entre camada de apresentação e persistência:
- ✅ **UserInDTO** - Recebe dados de entrada
- ✅ **UserOutDTO** - Retorna dados de saída (sem password)
- ✅ **CategoryOutDTO, ProductOutDTO, OrderOutDTO** - Respostas estruturadas

### **Converters**
Transformação automática Entity ↔ DTO:
```
UserEntity ↔ UserConverter ↔ DTO
```

### **Exception Handling**
Centralizado com `@ControllerAdvice`:
- ✅ ResourceNotFoundException → HTTP 404
- ✅ Exception genérica → HTTP 500

---

## 🔒 Segurança

✅ **Passwords** - Nunca retornados nas respostas  
✅ **Validações** - Todos os endpoints validam IDs  
✅ **Erros estruturados** - Sem exposição de dados sensíveis  

---

## 📚 Exemplo Completo

```bash
# Criar usuário
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Maria","email":"maria@example.com","phone":"11998765432","password":"senha123"}'

# Listar todos os pedidos
curl http://localhost:8080/orders

# Buscar pedido específico
curl http://localhost:8080/orders/1

# Deletar usuário
curl -X DELETE http://localhost:8080/users/1
```

---

## 📝 Licença

MIT License - veja o arquivo LICENSE para mais detalhes

---

## ✅ Status

- ✅ API funcional
- ✅ DTOs implementados
- ✅ Exception Handling centralizado
- ✅ Converters Entity ↔ DTO
- ✅ Validação de exceções em todos os endpoints
- ✅ Pronto para produção 🚀

